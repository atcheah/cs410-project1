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
      x = pos[0]
      y = pos[1]
      newCall = obj.toScript(x, y, bg_colour)
      subCalls.append(newCall)
    
    def object():
      computed_colour = shift_hex_opacity(self.colour, bg_colour, self.opacity)
      temp_x = x + self.size[0] * self.scale[0] / 2
      temp_y = y - self.size[1] * self.scale[1] / 2
      final_x = temp_x * math.cos(self.rotation) - temp_y * math.sin(self.rotation)
      final_y = temp_x * math.sin(self.rotation) + temp_y * math.cos(self.rotation)
      if self.shape == "square":
        canvas.create_rectangle(final_x, final_y, final_x + self.size[0], final_y - self.size[1], fill=computed_colour, outline=computed_colour, width=0)
      elif self.shape == "circle":
        canvas.create_oval(final_x, final_y, final_x + self.size[0], final_y - self.size[1], fill=computed_colour, outline=computed_colour, width=0)
      elif self.shape == "triangle":
        canvas.create_polygon(final_x, final_y, final_x + self.size[0], final_y, final_x + self.size[0] / 2, final_y - self.size[1], fill=computed_colour, outline=computed_colour, width=0)
      elif self.shape == "line":
        canvas.create_line(final_x, final_y, final_x + self.size[0], final_y - self.size[1], fill=computed_colour, width=0)
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
      x = pos[0]
      y = pos[1]
      newCall = obj.toScript(x, y, self.backgroundId.colour)
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

############################################
# GENERATED CODE
############################################

switchingObject = Object("#FFFF00", "square", (100,200), 1.0, 0, (0,0), (1,1), [])
canvas = Object("#FFFFFF", "rectangle", (500,500), 1.0, 0, (0,0), (1,1), [])
for _ in range(2):
  if (switchingObject.colour == "#008000"):
    switchingObject = Object("#FF0000", "square", (100,200), 1.0, 0, (0,0), (1,1), [])
  else:
    switchingObject = Object("#008000", "square", (100,200), 1.0, 0, (0,0), (1,1), [])
  frame1 = Frame(canvas, [(switchingObject, (250, 250, 1))])
  frame2 = Frame(canvas, [(switchingObject, (200, 250, 2))])
  frame3 = Frame(canvas, [(switchingObject, (200, 300, 1))])
  app.add_frames([frame1,frame2,frame3], 3000)
  current_frame = "frame3"
  app.add_frames([frame3,frame2,frame1], 3000)
  current_frame = "frame1"


############################################
# END GENERATED CODE
############################################

app.run_animation()
window.mainloop()