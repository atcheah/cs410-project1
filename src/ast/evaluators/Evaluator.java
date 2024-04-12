package ast.evaluators;

import ast.*;
import ast.Object;
import ast.evaluators.util.*;

import java.util.*;

public class Evaluator implements GraphicalParserVisitor<StringBuilder, String> {

    enum DataTypes {
        OBJECT,
        FRAME,
    }

    private final boolean dynamicChecks;
    private final Map<Id, Integer> environment = new HashMap<>(); // maps ids to loc
    private final Map<Integer, DataTypes> typeMap = new HashMap<>(); // maps ids to what kind of object they are
    private final Map<Integer, ObjectFieldsHelper> objectFieldsMap = new HashMap<>();
    private final Map<Integer, ImageFieldsHelper> imageFieldsMap = new HashMap<>();
    private int memptr = 0;
    private final String tab = "  ";

    public Evaluator() {
        dynamicChecks = true;
    }

    public Evaluator(boolean dynamicChecks) {
        this.dynamicChecks = dynamicChecks;
    }

    private Integer getFreshLocation() {
        Integer loc = memptr;
        memptr = memptr + 1;
        return loc;
    }

    @Override
    public String visit(StringBuilder errors, Program p) {

        // make script with necessary imports and class declarations
        StringBuilder outputScript = new StringBuilder(
                """
                        import math
                        import tkinter as tk
                        canvas = None
                        current_frame = None

                        class AnimationApp:
                          def __init__(self, master, functions, durations):
                            self.master = master
                            self.functions = functions
                            self.durations = durations

                          # add new frames to the animation with their own duration
                          def add_frames(self, frames, duration):
                            for frame in frames:
                              self.functions.extend([frame.toScript()])
                            self.durations.extend([duration] * len(frames))

                          def run_animation(self):
                            print("running animation")
                            if self.functions:
                              func = self.functions.pop(0)
                              duration = self.durations.pop(0)
                              func()
                              if (duration != -1):
                                self.master.after(duration, self.run_animation)

                        def create_new_canvas(w, h, bg_colour):
                          global canvas
                          if isinstance(canvas, tk.Canvas):
                            canvas.destroy()  # Destroy previous canvas if it exists
                          canvas = tk.Canvas(window, width=w, height=h, bg=bg_colour)
                          canvas.pack()

                        def shift_hex_opacity(foreground_colour, background_colour, opacity):
                          # foreground_colour and background_colour are strings in the format "#RRGGBB", opacity is a float between 0 and 1
                          # returns a hex string shifted by the opacity towards the background_colour
                          # if opacity is 1, the function returns the foreground_colour
                          # if opacity is 0, the function returns the background_colour
                          fg_r = int(foreground_colour[1:3], 16)
                          fg_g = int(foreground_colour[3:5], 16)
                          fg_b = int(foreground_colour[5:7], 16)
                          bg_r = int(background_colour[1:3], 16)
                          bg_g = int(background_colour[3:5], 16)
                          bg_b = int(background_colour[5:7], 16)
                          new_r = int(fg_r * opacity + bg_r * (1 - opacity))
                          new_g = int(fg_g * opacity + bg_g * (1 - opacity))
                          new_b = int(fg_b * opacity + bg_b * (1 - opacity))
                          return "#{:02x}{:02x}{:02x}".format(new_r, new_g, new_b)

                        def check_has_pos(ownerid, childid, x, y, z):
                          for i in range(len(ownerid.owns)):
                            if ownerid.owns[i][0] == childid:
                              if ownerid.owns[i][1] == (x, y, z):
                                return True
                          return False

                        class Object:
                          def __init__(self, colour, shape, size, opacity, rotation, shear, scale, owns):
                            self.colour = colour
                            self.shape = shape
                            self.size = size
                            self.opacity = opacity
                            self.rotation = rotation
                            self.shear = shear
                            self.scale = scale
                            self.owns = owns
                                                
                          def toScript(self, x, y, bg_colour):
                            subCalls = []
                                                
                            sortedOwns = sorted(self.owns, key=lambda x: x[1][2])
                            for obj, pos in sortedOwns:
                              newCall = obj.toScript(x+pos[0], y-pos[1], bg_colour)
                              subCalls.append(newCall)
                                                
                            def object():
                              computed_colour = shift_hex_opacity(self.colour, bg_colour, self.opacity)
                              temp_x = (self.size[0] + self.shear[0]) * self.scale[0]
                              temp_y = (self.size[1] + self.shear[1]) * self.scale[1]
                              rotation_radians = math.radians(self.rotation)
                              final_x = (temp_x * math.cos(rotation_radians)) - (temp_y * math.sin(rotation_radians))
                              final_y = (temp_x * math.sin(rotation_radians)) + (temp_y * math.cos(rotation_radians))
                              if self.shape == "circle":
                                canvas.create_oval(x, y, x + final_x, y - final_y, fill=computed_colour, outline=computed_colour, width=0)
                              elif self.shape == "rectangle" or self.shape == "square":
                                canvas.create_rectangle(x, y, x + final_x, y - final_y, fill=computed_colour, outline=computed_colour, width=0)
                              elif self.shape == "triangle":
                                canvas.create_polygon(x, y, x + final_x, y, x + (final_x / 2), y - final_y, fill=computed_colour, outline=computed_colour, width=0)
                              elif self.shape == "line":
                                canvas.create_line(x, y, x + final_x, y - final_y, fill=computed_colour, width=2)
                                                
                              for call in subCalls:
                                call()
                                                
                            return object

                        class Frame:
                          def __init__(self, backgroundId, owns):
                            self.backgroundId = backgroundId
                            self.owns = owns

                          def toScript(self):
                            subCalls = []

                            # sort owns based on z value of position
                            sortedOwns = sorted(self.owns, key=lambda x: x[1][2])
                            for obj, pos in sortedOwns:
                              newCall = obj.toScript(pos[0], self.backgroundId.size[1]-pos[1], self.backgroundId.colour)
                              subCalls.append(newCall)

                            def frame():
                              create_new_canvas(self.backgroundId.size[0], self.backgroundId.size[1], self.backgroundId.colour)
                              canvas.delete("all")
                              for call in subCalls:
                                call()

                            return frame

                        window = tk.Tk()
                        app = AnimationApp(window, [], [])
                        window.title('Graphical Language')
                            """);

        for (Expression expression : p.getExpressions()) {
            outputScript.append(expression.accept(errors, this));
            if (!errors.isEmpty()) {
                return null;
            }
        }

        outputScript.append("\napp.run_animation()\nwindow.mainloop()\n");

        return outputScript.toString();
    }

    @Override
    public String visit(StringBuilder errors, Id i) {
        return "setCopy;" + i.getName(); // Pretty sure this is only called when you set id to an id
    }

    @Override
    public String visit(StringBuilder errors, If i) {
        BoolClause predicate = i.getBoolClause();
        List<Expression> thenClauses = i.getThenExpr();
        List<Expression> elseClauses = i.getElseExpr();

        String predRet = predicate.accept(errors, this);
        if (!errors.isEmpty()) {
            errors.append("Predicate failed to evaluate\n");
            return null;
        }

        StringBuilder thenBlock = new StringBuilder();
        for (Expression expr : thenClauses) {
            String[] output = expr.accept(errors, this).split("\n");
            if (!errors.isEmpty()) {
                errors.append("Then clause failed to evaluate\n");
                return null;
            }
            for (String str : output) {
                thenBlock.append(tab).append(str).append("\n");
            }
        }
        thenBlock.append(tab).append("pass\n");

        StringBuilder elseBlock = new StringBuilder();
        for (Expression expr : elseClauses) {
            String[] output = expr.accept(errors, this).split("\n");
            if (!errors.isEmpty()) {
                errors.append("Else clause failed to evaluate\n");
                return null;
            }
            for (String str : output) {
                elseBlock.append(tab).append(str).append("\n");
            }
        }
        elseBlock.append(tab).append("pass\n");

        return "if (" + predRet + "):\n" + thenBlock + "else:\n" + elseBlock;
    }

    @Override
    public String visit(StringBuilder errors, Let l) {
        Id id = l.getId();
        Config configExpr = l.getConfigExpr();

        String ret = configExpr.accept(errors, this);

        if (!errors.isEmpty()) {
            errors.append("Failed to evaluate let statement\n");
            return null;
        } else if (ret.contains("ObjectFieldsHelper;")) {
            Integer location;
            if (environment.containsKey(id)) {
                location = environment.get(id);
            } else {
                location = getFreshLocation();
                environment.put(id, location);
            }

            ObjectFieldsHelper fields = new ObjectFieldsHelper(ret);
            typeMap.put(location, DataTypes.OBJECT);
            if (objectFieldsMap.containsKey(location)) {
                ObjectFieldsHelper pastFields = objectFieldsMap.get(location);
                fields = new ObjectFieldsHelper(pastFields, fields);
                objectFieldsMap.put(location, fields);
                return fields.toScript(id, pastFields);
            } else {
                objectFieldsMap.put(location, fields);
                return fields.toScript(id);
            }


        } else if (ret.contains("FrameFieldsHelper;")) {
            Integer location;
            if (environment.containsKey(id)) {
                location = environment.get(id);
            } else {
                location = getFreshLocation();
                environment.put(id, location);
            }

            ImageFieldsHelper fields = new ImageFieldsHelper(ret);
            typeMap.put(location, DataTypes.FRAME);
            imageFieldsMap.put(location, fields); // Not additive, new frame fields replace

            if (dynamicChecks && !environment.containsKey(fields.getBackgroundId())) {
                errors.append("ERROR: Background id: ").append(fields.getBackgroundId().getName())
                        .append(" was not initialized\n");
                return null;
            }

            Integer backgroundIdloc = environment.get(fields.getBackgroundId());

            if (dynamicChecks && !typeMap.get(backgroundIdloc).equals(DataTypes.OBJECT)) {
                errors.append("ERROR: Background id: ").append(fields.getBackgroundId().getName())
                        .append(" was not an object\n");
                return null;
            }

            return fields.toScript(id, fields.getBackgroundId());

        } else if (ret.contains("setCopy;")) {
            String otherIdName = ret.split(";")[1];
            Id otherId = new Id(otherIdName);
            if (dynamicChecks && !environment.containsKey(otherId)) {
                errors.append("ERROR: Tried to set id: ").append(id.getName())
                        .append(" , to uninitialized id: ").append(otherIdName).append("\n");
                return null;
            }
            Integer location = environment.get(new Id(otherIdName));
            environment.put(id, location);
            return id.getName() + " = " + otherIdName + "\n";
//            return switch (typeMap.get(location)) {
//                case OBJECT -> objectFieldsMap.get(location).toScript(id);
//                case FRAME -> imageFieldsMap.get(location).toScript(id, imageFieldsMap.get(location).getBackgroundId());
//                case COPY -> otherIdName + " = " + id;
//            };
        } else {
            errors.append("Evaluator error unknown statement.\n");
            return null;
        }
    }

    @Override
    public String visit(StringBuilder errors, Animate a) {
        int duration_ms = a.getDuration() * 1000; // default seconds
        if (a.isMinutes()) {
            duration_ms *= 60;
        }

        StringBuilder ret = new StringBuilder("app.add_frames([");
        for (Id id : a.getIds()) {
            if (dynamicChecks) {
                if (!environment.containsKey(id)) {
                    errors.append("ERROR: Animation call referenced uninitialized id: ")
                            .append(id.getName()).append("\n");
                }
                if (!(typeMap.get(environment.get(id)) == DataTypes.FRAME)) {
                    errors.append("ERROR: Animation call can only be used on images. The offender was: ")
                            .append(id.getName()).append("\n");
                }
            }
            ret.append(id.getName()).append(","); // god bless flexible python syntax
        }
        ret.append("], ").append(duration_ms).append(")\n");
        ret.append("current_frame = \"").append(a.getIds().getLast().getName()).append("\"\n");

        return ret.toString();
    }

    @Override
    public String visit(StringBuilder errors, Draw d) {
        if (dynamicChecks && !environment.containsKey(d.getId())) {
            errors.append("ERROR: Draw call referenced uninitialized id: ")
                    .append(d.getId()).append("\n");
            return null;
        }
        Integer location = environment.get(d.getId());
        if (dynamicChecks && !(typeMap.get(location) == DataTypes.FRAME)) {
            errors.append("ERROR: Draw call on non-image object id:")
                    .append(d.getId()).append("\n");
            return null;
        }
        StringBuilder ret = new StringBuilder("app.add_frames([" + d.getId().getName()).append("], ").append(-1)
                .append(")\n");
        ret.append("current_frame = \"").append(d.getId().getName()).append("\"\n");
        return ret.toString();
    }

    @Override
    public String visit(StringBuilder errors, Repeat r) {
        int duration = r.getDuration();

        StringBuilder ret = new StringBuilder("for _ in range(" + duration + "):\n");
        for (Expression expression : r.getRepeatExpressions()) {
            String[] scriptExpr = expression.accept(errors, this).split("\n");
            if (!errors.isEmpty()) {
                return null; // exit control flow
            }
            for (String expr : scriptExpr) {
                ret.append(tab).append(expr).append("\n");
            }
        }

        return ret.toString();
    }

    @Override
    public String visit(StringBuilder errors, Assert a) {
        Id id = a.getId();

        if (dynamicChecks && !environment.containsKey(id)) {
            errors.append("ERROR: Assertion clause referenced uninitialized id: ").append(id.getName()).append("\n");
        }

        ObjectField objectField = a.getObjectAssignment();
        String ret = objectField.accept(errors, this);

        if (!errors.isEmpty()) {
            return null;
        }

        switch (ret.split(":")[0]) {
            case "colour":
                if (dynamicChecks && !typeMap.get(environment.get(id)).equals(DataTypes.OBJECT)) {
                    errors.append("ERROR: Colour assertion clause can only be used on objects. The offender was: ")
                            .append(id.getName()).append("\n");
                }
                // convert to hex
                return id.getName() + ".colour == \"" + ObjectFieldsHelper.convertColour(ret.split(":")[1]) + "\"";
            case "hex":
                if (dynamicChecks && !typeMap.get(environment.get(id)).equals(DataTypes.OBJECT)) {
                    errors.append("ERROR: Hex assertion clause can only be used on objects. The offender was: ")
                            .append(id.getName()).append("\n");
                }
                // no translation needed
                return id.getName() + ".colour == \"" + ret.split(":")[1] + "\"";
            case "rgb":
                if (dynamicChecks && !typeMap.get(environment.get(id)).equals(DataTypes.OBJECT)) {
                    errors.append("ERROR: RGB assertion clause can only be used on objects. The offender was: ")
                            .append(id.getName()).append("\n");
                }
                return id.getName() + ".colour == \"" + ObjectFieldsHelper.convertRGBColour(ret.split(":")[1]) + "\"";
            case "rgba":
                if (dynamicChecks && !typeMap.get(environment.get(id)).equals(DataTypes.OBJECT)) {
                    errors.append("ERROR: RGBA assertion clause can only be used on objects. The offender was: ")
                            .append(id.getName()).append("\n");
                }
                Pair<String, Double> rgbaValues = ObjectFieldsHelper.convertRGBAColour(ret.split(":")[1]);

                return id.getName() + ".colour == \"" + rgbaValues.getA() + "\"" +
                        "&" + id.getName() + ".opacity == " + rgbaValues.getB();
            case "position":
                if (dynamicChecks && !typeMap.get(environment.get(id)).equals(DataTypes.OBJECT)) {
                    errors.append("ERROR: Position assertion clause can only be used on objects. The offender was: ")
                            .append(id.getName()).append("\n");
                }
                // check_has_pos(ownerid, childid, x, y, z): sadly sublist params are not
                // allowed in python 3.x
                // ret = "position:(childid,(x,y,z))"
                String childid = ret.split(":")[1].split(",")[0].split("\\(")[1];
                String x = ret.split(":")[1].split(",")[1].split("\\(")[1];
                String y = ret.split(":")[1].split(",")[2];
                String z = ret.split(":")[1].split(",")[3].split("\\)")[0];
                return "check_has_pos(" + id.getName() + ", " + childid + ", " + x + ", " + y + ", " + z + ")";

            case "rotation":
                if (dynamicChecks && !typeMap.get(environment.get(id)).equals(DataTypes.OBJECT)) {
                    errors.append("ERROR: Rotation assertion clause can only be used on objects. The offender was: ")
                            .append(id.getName()).append("\n");
                }
                switch (ret.split(",")[1]) {
                    case "degrees":
                        return id.getName() + ".rotation == " + ret.split(":")[1];
                    case "radians":
                        return id.getName() + ".rotation == " + (Math.toDegrees(Integer.parseInt(ret.split(":")[1])));
                }
            case "scale":
                if (dynamicChecks && !typeMap.get(environment.get(id)).equals(DataTypes.OBJECT)) {
                    errors.append("ERROR: Scale assertion clause can only be used on objects. The offender was: ")
                            .append(id.getName()).append("\n");
                }
                return id.getName() + ".scale == " + ret.split(":")[1];
            case "shape":
                if (dynamicChecks && !typeMap.get(environment.get(id)).equals(DataTypes.OBJECT)) {
                    errors.append("ERROR: Shape assertion clause can only be used on objects. The offender was: ")
                            .append(id.getName()).append("\n");
                }
                return id.getName() + ".shape == \"" + ret.split(":")[1] + "\"";
            case "shear":
                if (dynamicChecks && !typeMap.get(environment.get(id)).equals(DataTypes.OBJECT)) {
                    errors.append("ERROR: Shear assertion clause can only be used on objects. The offender was: ")
                            .append(id.getName()).append("\n");
                }
                return id.getName() + ".shear == " + ret.split(":")[1];
            case "size":
                if (dynamicChecks && !typeMap.get(environment.get(id)).equals(DataTypes.OBJECT)) {
                    errors.append("ERROR: Size assertion clause can only be used on objects. The offender was: ")
                            .append(id.getName()).append("\n");
                }
                return id.getName() + ".size == " + ret.split(":")[1];
            case "tuple":
                if (dynamicChecks && !typeMap.get(environment.get(id)).equals(DataTypes.OBJECT)) {
                    errors.append("ERROR: Tuple assertion clause can only be used on objects. The offender was: ")
                            .append(id.getName()).append("\n");
                }
                // TODO i have no idea what this case is for
                errors.append("ERROR: Unknown assertion clause\n");
                return "SUPER SPECIAL TUPLE CASE\n";
            default:
                errors.append("ERROR: Unknown assertion clause\n");
                return null;
        }
    }

    @Override
    public String visit(StringBuilder errors, Image i) {
        Id backgroundId = i.getId();
        List<Position> objectPositions = i.getPositions();

        List<Pair<Id, Triple<Integer, Integer, Integer>>> relativePositions = new ArrayList<>(); // Maps object-id to
                                                                                                 // <x,y,z>
        // coords

        for (Position position : objectPositions) {
            Id objectId = position.getId();
            List<Integer> coordinates = position.getValues();
            relativePositions.add(
                    new Pair<>(objectId, new Triple<>(coordinates.get(0), coordinates.get(1), coordinates.get(2))));
        }

        ImageFieldsHelper imageFields = new ImageFieldsHelper(backgroundId, relativePositions);

        return imageFields.toString();
    }

    @Override
    public String visit(StringBuilder errors, Object o) {
        ObjectFieldsHelper fields = new ObjectFieldsHelper();
        for (ObjectField field : o.getObject()) {
            if (field == null) {
                errors.append("ERROR: Object Field was null, parser error\n");
                break;
            }
            String fieldRet = field.accept(errors, this);
            if (!errors.isEmpty()) {
                return null;
            }

            switch (fieldRet.split(":")[0]) {
                case "colour":
                    fields.setColour(fieldRet.split(":")[1]);
                    break;
                case "hex":
                    fields.setHexColour(fieldRet.split(":")[1]);
                    break;
                case "rgb":
                    fields.setRGBColour(fieldRet.split(":")[1]);
                    break;
                case "rgba":
                    fields.setRGBAColour(fieldRet.split(":")[1]);
                    break;
                case "rotation":
                    fields.setRotation(fieldRet.split(":")[1]);
                    break;
                case "scale":
                    fields.setScale(fieldRet.split(":")[1]);
                    break;
                case "shape":
                    fields.setShape(fieldRet.split(":")[1]);
                    break;
                case "shear":
                    fields.setShear(fieldRet.split(":")[1]);
                    break;
                case "size":
                    fields.setSize(fieldRet.split(":")[1]);
                    break;
                case "opacity":
                    fields.setOpacity(fieldRet.split(":")[1]);
                    break;
                default:
                    errors.append("ERROR: Unknown object field\n");
                    return null;
            }
        }

        return fields.toString();
    }

    @Override
    public String visit(StringBuilder errors, Opacity o) {
        return "opacity:" + o.getOpacity();
    }

    @Override
    public String visit(StringBuilder errors, Ownership o) {
        ObjectFieldsHelper objectFieldsHelper = new ObjectFieldsHelper();
        List<Pair<Id, Triple<Integer, Integer, Integer>>> newOwnership = new ArrayList<>();
        List<Position> positions = o.getPositions();

        for (Position position : positions) {
            Triple<Integer, Integer, Integer> relative_coords = new Triple<>(position.getValues().get(0),
                    position.getValues().get(1), position.getValues().get(2));
            newOwnership.add(new Pair<>(position.getId(), relative_coords));
        }
        objectFieldsHelper.setOwnershipList(newOwnership);

        return objectFieldsHelper.toString();
    }

    @Override
    public String visit(StringBuilder errors, Colour c) {
        return c.accept(errors, this);
    }

    @Override
    public String visit(StringBuilder errors, ColourText ct) {
        return "colour:" + ct.getColourText();
    }

    @Override
    public String visit(StringBuilder errors, Hex h) {
        return "hex:" + h.getHexValue();
    }

    @Override
    public String visit(StringBuilder errors, RGB r) {
        return "rgb:" + r.toString();
    }

    @Override
    public String visit(StringBuilder errors, RGBA ra) {
        return "rgba:" + ra.toString();
    }

    @Override
    public String visit(StringBuilder errors, Position p) {
        return "position:" + p.toString();
    }

    @Override
    public String visit(StringBuilder errors, Rotation r) {
        return "rotation:" + r.toString();
    }

    @Override
    public String visit(StringBuilder errors, Scale s) {
        return "scale:" + s.toString();
    }

    @Override
    public String visit(StringBuilder errors, Shape s) {
        return "shape:" + s.toString();
    }

    @Override
    public String visit(StringBuilder errors, Shear s) {
        return "shear:" + s.toString();
    }

    @Override
    public String visit(StringBuilder errors, Size s) {
        return "size:" + s.toString();
    }

    @Override
    public String visit(StringBuilder errors, Tuple tuple) {
        return "tuple:" + tuple.toString();
    }


    @Override
    public String visit(StringBuilder context, FrameAssert frameAssert) {
        return "current_frame == \"" + frameAssert.getId().getName() + "\"";
    }
}
