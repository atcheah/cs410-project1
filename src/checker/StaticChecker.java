package checker;

import ast.*;
import ast.Object;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StaticChecker implements GraphicalParserVisitor<Set<String>, String> {

    // Min value for numeric inputs that are non-negative.
    public static final Number NON_NEGATIVE_MIN_VALUE = 0;
    public static final Number MAX_OPACITY_VALUE = 1;
    public static final Number MAX_RGB_VALUE = 255;
    public static final Number MAX_ALPHA_VALUE = 1.0;

    // Could change these to make them cover a bigger range.
    public static final Number MAX_ROTATION_VALUE = 1280;
    public static final Number MIN_ROTATION_VALUE = -1280;


    public String checkProgram(Program p) {
        Set<String> checked = new HashSet<>();
        return p.accept(checked, this);
    }

    @Override
    public String visit(Set<String> context, Program p) {
        StringBuilder errors = new StringBuilder();
        for (Expression exp : p.getExpressions()) {
            errors.append(exp.accept(context, this));
        }
        return errors.toString();
    }

    @Override
    public String visit(Set<String> context, Id i) {
        if (context.contains(i.getName())) {
            return "";
        } else {
            return i.getName() + " was not declared\n";
        }
    }

    @Override
    public String visit(Set<String> context, If i) {
        return "";
    }

    @Override
    public String visit(Set<String> context, Let l) {
        Config config = l.getConfigExpr();
        StringBuilder errors = new StringBuilder();
        if (config instanceof Statement) {
            context.add(l.getId().getName());
        } else {
            errors.append(l.getId().accept(context, this));
        }
        errors.append(l.getConfigExpr().accept(context, this));
        return errors.toString();
    }

    @Override
    public String visit(Set<String> context, Animate a) {
        StringBuilder errors = new StringBuilder();
        for (Id id : a.getIds()) {
            errors.append(id.accept(context, this));
        }
        return errors.toString();
    }

    @Override
    public String visit(Set<String> context, Draw d) {
        if (!context.contains(d.getId().getName())) {
            return "Tried to draw " + d.getId().getName() + " when it was not declared\n";
        } else {
            return "";
        }
    }

    @Override
    public String visit(Set<String> context, Repeat r) {
        StringBuilder errors = new StringBuilder();
        for (Expression exp: r.getRepeatExpressions()) {
            errors.append(exp.accept(context, this));
        }
        return errors.toString();
    }

    @Override
    public String visit(Set<String> context, Assert a) {
        return "";
    }

    @Override
    public String visit(Set<String> context, Image i) {
        StringBuilder errors = new StringBuilder();
        for (Position p : i.getPositions()) {
            errors.append(p.accept(context, this));
        }
        return errors.toString();
    }

    @Override
    public String visit(Set<String> context, Object o) {
        StringBuilder errors = new StringBuilder();
        for (ObjectField of: o.getObject()) {
            errors.append(of.accept(context, this));
        }
        return errors.toString();
    }

    @Override
    public String visit(Set<String> context, Opacity o) {
        return validateNumericInput(o.getOpacity(), NON_NEGATIVE_MIN_VALUE, MAX_OPACITY_VALUE, "Opacity value" +
                " not in required range. ");
    }

    @Override
    public String visit(Set<String> context, Ownership o) {
        StringBuilder errors = new StringBuilder();
        for (Position p : o.getPositions()) {
            errors.append(p.accept(context, this));
        }
        return errors.toString();
    }

    @Override
    public String visit(Set<String> context, Colour c) {
        return c.accept(context, this);
    }

    @Override
    public String visit(Set<String> context, ColourText c) {

        return "";
    }

    @Override
    public String visit(Set<String> context, Hex h) {
        return "";
    }

    @Override
    public String visit(Set<String> context, RGB r) {
        StringBuilder res = new StringBuilder();
        res.append(validateNumericInput(r.getRedValue(), NON_NEGATIVE_MIN_VALUE, MAX_RGB_VALUE, "R Colour input is " +
                "invalid."));
        res.append(validateNumericInput(r.getGreenValue(), NON_NEGATIVE_MIN_VALUE, MAX_RGB_VALUE, "G Colour input is " +
                "invalid."));
        res.append(validateNumericInput(r.getBlueValue(), NON_NEGATIVE_MIN_VALUE, MAX_RGB_VALUE, "B Colour input is " +
                "invalid."));

        return res.toString();
    }

    @Override
    public String visit(Set<String> context, RGBA ra) {
        StringBuilder res = new StringBuilder();
        res.append(validateNumericInput(ra.getRedValue(), NON_NEGATIVE_MIN_VALUE, MAX_RGB_VALUE, "R Colour input is " +
                "invalid."));
        res.append(validateNumericInput(ra.getGreenValue(), NON_NEGATIVE_MIN_VALUE, MAX_RGB_VALUE, "G Colour input is" +
                " " +
                "invalid."));
        res.append(validateNumericInput(ra.getBlueValue(), NON_NEGATIVE_MIN_VALUE, MAX_RGB_VALUE, "B Colour input is " +
                "invalid."));
        res.append(validateNumericInput(ra.getAlphaValue(), NON_NEGATIVE_MIN_VALUE, MAX_ALPHA_VALUE, "Alpha Colour " +
                "input is invalid."));
        return res.toString();
    }

    @Override
    public String visit(Set<String> context, Position p) {
        if (!context.contains(p.getId().getName())) {
            return "Tried to set position of " + p.getId().getName() + " when it was not declared\n";
        } else if (p.getValues().size() < 3) {
            // Not enough inputs in position.
            return "Invalid position input! Need 3 values.";
        }
        else {
            return "";
        }
    }

    @Override
    public String visit(Set<String> context, Rotation r) {
        return validateNumericInput(r.getRotation(), MIN_ROTATION_VALUE, MAX_ROTATION_VALUE, "Invalid rotation input." +
                " ");
    }

    @Override
    public String visit(Set<String> context, Scale s) {
        return "";
    }

    @Override
    public String visit(Set<String> context, Shape s) {
        if (s.getShape() == Shape.Shapes.invalid) {
            return "Invalid Shape Input";
        }
        return "";
    }

    @Override
    public String visit(Set<String> context, Shear s) {
        return "";
    }

    @Override
    public String visit(Set<String> context, Size s) {
        for (int size : s.getSize_tuple()) {
            if (size <= 0) {
                return "Invalid Size Input\n";
            }
        }
        return "";
    }

    @Override
    public String visit(Set<String> context, Tuple tuple) {
        return "";
    }

    @Override
    public String visit(Set<String> context, FrameAssert frameAssert) {
        return "";
    }


    /**
     * Helper that validates numeric inputs of users. Ensures that input is within a certain range.
     * If value is valid return "". Otherwise, return errorMsg + some detailed explanation about error.
     * Eg. Opacity value not in required range. Inputted n, valid values in range of: [min, max].
     * @param n the number to validate
     * @param min the (inclusive) min that the number can be.
     * @param max the (inclusize) max that the number can be.
     * @param errorMsg message to return when validation fails.
     */
    private String validateNumericInput(Number n, Number min, Number max, String errorMsg) {
        return (n.doubleValue() >= min.doubleValue() && n.doubleValue() <= max.doubleValue()) ? "" :
                errorMsg + " Inputted n, valid values should be in range of: [" + min + ", " + max + "].";
    }
}
