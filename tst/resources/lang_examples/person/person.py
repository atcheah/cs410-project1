import math
import tkinter as tk
# tkinter coordinates are (0,0) at the top left corner of the window
# it places objects on the window by specifying the x and y coordinates of the top left corner of the object

# Create the main window
window = tk.Tk()
window.title("Graphical Person Animation")

# Create the canvas
# Let canvas be an object with shape = rectangle, size = (160, 100), colour = white
canvas = tk.Canvas(window, width=160, height=100, bg="#ffffff")
canvas.pack()


# Define the eyeball1
# Let eyeball1 be an object with shape = circle, size = 4, colour = black
def eyeball1(x, y):
    canvas.create_oval(x, y, x+4, y-4, fill="black")
eyeball1.size = 4
eyeball1.colour = "black"
eyeball1.shape = "circle"

# Define the eyeball2
# Let eyeball2 be an eyeball1
def eyeball2(x, y):
    eyeball1(x, y)
    pass
eyeball2.size = eyeball1.size
eyeball2.colour = eyeball1.colour
eyeball2.shape = eyeball1.shape

# Define the mouth
# Let mouth be an object with shape = rectangle, size = (12, 2), colour = red
def mouth(x, y):
    canvas.create_rectangle(x, y, x+12, y-2, fill="red")
mouth.size = (12, 2)
mouth.colour = "red"
mouth.shape = "rectangle"

# Define the head
# Let head be an object with shape = circle, size = 20, colour = yellow
# Let head own eyeball1 at (4, 10), own eyeball2 at (12, 10), and own mouth at (4, 4)
def head(x, y):
    canvas.create_oval(x, y, x+20, y-20, fill="yellow")
    eyeball1(x+4, y-10)
    eyeball2(x+12, y-10)
    mouth(x+4, y-4)
head.size = 20
head.colour = "yellow"
head.owns = [(eyeball1, (4, 10)), (eyeball2, (12, 10)), (mouth, (4, 4))]
head.shape = "circle"

# Define the torso
# Let torso be an object with shape = triangle, size = (40, 50), colour = purple
def torso(x, y):
    canvas.create_polygon(x, y, x+40, y, x+20, y-50, fill="purple")
torso.size = (40, 50)
torso.colour = "purple"

# Define the leg1
# Let leg1 be an object with shape = line, size = (4, 10)
def leg1(x, y):
    canvas.create_line(x, y, x, y-10)
leg1.shape = "line"
leg1.size = (4, 10)

# Define the leg2
# Let leg2 be an object with shape = line, size = (4, -10)
def leg2(x, y):
    canvas.create_line(x, y, x, y-10)
leg2.shape = "line"
leg2.size = (4, 10)

# Let frame be an image on canvas with head at (70, 66) and torso at (60, 24) and leg1 at (66, 14) and leg2 at (90, 14)
def frame1():
    canvas.delete("all")
    head(70, 100-66)
    torso(60, 100-24)
    leg1(66, 100-14)
    leg2(90, 100-14)

frame1()

# Start the main loop
window.mainloop()
