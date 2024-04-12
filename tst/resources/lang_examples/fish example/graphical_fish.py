import tkinter as tk

# Create the main window
window = tk.Tk()
window.title("Graphical Fish Animation")

# Create the canvas
# Let canvas be an object with shape = rectangle, colour = (173, 216, 230), size = (100,100) // rgb(173, 216, 230) = #add8e6.
canvas = tk.Canvas(window, width=100, height=100, bg="#add8e6")
canvas.pack()

# Define the fish tail
# Let fishtail be an object with shape = rectangle, size = (6, 13), colour = blue 
def fishtail(x , y):
    canvas.create_rectangle(x, y, x+6, y+13, fill="blue")
fishtail.size = (6, 13)
fishtail.colour = "blue"
fishtail.shape = "rectangle"

# Define the fish 
# Let fish be an object with shape = circle, size = 9, colour = orange, owns fishtail at (-6, -2) // size = diameter of circle
def fish(x, y):
    canvas.create_oval(x, y, x+9, y+9, fill="orange")
    fishtail(x-6, y-2)
fish.size = 9
fish.colour = "orange"
fish.owns = [(fishtail, (-6, -2))]
fish.shape = "circle"

# Let frame1 be an image on canvas with fish at (50,50) and fish at (70,80)
frame1_fish1_xy = (50, 50)
frame1_fish2_xy = (70, 20)
def frame1():
    canvas.delete("all")
    fish(frame1_fish1_xy[0], frame1_fish1_xy[1])
    fish(frame1_fish2_xy[0], frame1_fish2_xy[1])
frame1.has = [(fish, (50, 50)), (fish, (70, 80))]

# Let frame2 be an image on canvas with fish at (60,50) and fish at (90,90)
frame2_fish1_xy = (60, 50)
frame2_fish2_xy = (90, 10)
def frame2():
    canvas.delete("all")
    fish(frame2_fish1_xy[0], frame2_fish1_xy[1])
    fish(frame2_fish2_xy[0], frame2_fish2_xy[1])
frame2.has = [(fish, (60, 50)), (fish, (90, 90))]

# Start the main loop
window.mainloop()
