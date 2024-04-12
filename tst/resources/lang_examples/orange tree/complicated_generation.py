 Let head be an object with shape = circle, size = 40, colour = yellow
            Let eyeball be an object with shape = circle, size = 8, colour = black
            Let mouth be an object with shape = rectangle, size = (14, 4), colour = red
            Let head own eyeball at (26, 20, 0), and own mouth at (24, 8, 0)
 
            Let frame1_torso be an object with shape = triangle, size = (60, 100), colour = purple
            Let frame1_arm1 be an object with shape = line,  size = (28, 18), colour = black
            Let frame1_arm2 be an object with shape = line,  size = (28, -18), colour = black
            Let frame1_leg1 be an object with shape = line, size = (12, 30), colour = black
            Let frame1_leg2 be an object with shape = line, size = (12, -30), colour = black
            Let frame1_torso own frame1_arm1 at (-9, 44, -1), own frame1_arm2 at (42,62,-1), own frame1_leg1 at (5,-30, 0), own frame1_leg2 at (43, 0, 0)
 
            Let frame2_torso be an object with shape = triangle, size = (60, 100), colour = purple
            Let frame2_arm1_seg1 be an object with shape = line,  size = (12, 13), colour = black
            Let frame2_arm1_seg2 be an object with shape = line,  size = (14, 4), colour = black
            Let frame2_arm2_seg1 be an object with shape = line,  size = (9, -12), colour = black
            Let frame2_arm2_seg2 be an object with shape = line,  size = (17, -2), colour = black
            Let frame2_arm1_seg1 own frame2_arm1_seg2 at (12, 13, 0)
            Let frame2_arm2_seg1 own frame2_arm2_seg2 at (9, -12, 0)
            Let frame2_leg1_seg1 be an object with shape = line, size = (15, 18), colour = black
            Let frame2_leg1_seg2 be an object with shape = line, size = (0, 12), colour = black
            Let frame2_leg2_seg1 be an object with shape = line, size = (10, -9), colour = black
            Let frame2_leg2_seg2 be an object with shape = line, size = (2, 21), colour = black
            Let frame2_leg1_seg1 own frame2_leg1_seg2 at (15, 18, 0)
            Let frame2_leg2_seg1 own frame2_leg2_seg2 at (8, -30, 0)
            Let frame2_torso own frame2_arm1_seg1 at (-7, 45, -1), own frame2_arm2_seg1 at (42,62,-1), own frame2_leg1_seg1 at (0,-30, 0), own frame2_leg2_seg1 at (50, 0, 0)
 
 
            Let frame3_torso be an object with shape = triangle, size = (60, 100), colour = purple
            Let frame3_arm1_seg1 be an object with shape = line,  size = (13, 12), colour = black
            Let frame3_arm1_seg2 be an object with shape = line,  size = (14, -2), colour = black
            Let frame3_arm2_seg1 be an object with shape = line,  size = (13, -12), colour = black
            Let frame3_arm2_seg2 be an object with shape = line,  size = (14, 0), colour = black
            Let frame3_arm1_seg1 own frame3_arm1_seg2 at (13, 12, 0)
            Let frame3_arm2_seg1 own frame3_arm2_seg2 at (13, -12, 0)
            Let frame3_leg1_seg1 be an object with shape = line, size = (19, 9), colour = black
            Let frame3_leg1_seg2 be an object with shape = line, size = (2, 12), colour = black
            Let frame3_leg2_seg1 be an object with shape = line, size = (8, -9), colour = black
            Let frame3_leg2_seg2 be an object with shape = line, size = (4, -28), colour = black
            Let frame3_leg1_seg1 own frame3_leg1_seg2 at (19, 9, 0)
            Let frame3_leg2_seg1 own frame3_leg2_seg2 at (8, -9, 0)
            Let frame3_torso own frame3_arm1_seg1 at (-7, 52, -1), own frame3_arm2_seg1 at (42,62,-1), own frame3_leg1_seg1 at (-3,-21, 0), own frame3_leg2_seg1 at (50, 0, 0)
 
            Let frame4_torso be an object with shape = triangle, size = (60, 100), colour = purple
            Let frame4_arm1_seg1 be an object with shape = line,  size = (13, 12), colour = black
            Let frame4_arm1_seg2 be an object with shape = line,  size = (15, -6), colour = black
            Let frame4_arm2_seg1 be an object with shape = line,  size = (11, -9), colour = black
            Let frame4_arm2_seg2 be an object with shape = line,  size = (16, 7), colour = black
            Let frame4_arm1_seg1 own frame4_arm1_seg2 at (13, 12, 0)
            Let frame4_arm2_seg1 own frame4_arm2_seg2 at (11, -9, 0)
            Let frame4_leg1_seg1 be an object with shape = line, size = (25, -5), colour = black
            Let frame4_leg1_seg2 be an object with shape = line, size = (4, 10), colour = black
            Let frame4_leg2_seg1 be an object with shape = line, size = (8, -9), colour = black
            Let frame4_leg2_seg2 be an object with shape = line, size = (13, -21), colour = black
            Let frame4_leg1_seg1 own frame4_leg1_seg2 at (25, -5, 0)
            Let frame4_leg2_seg1 own frame4_leg2_seg2 at (8, -9, 0)
            Let frame4_torso own frame4_arm1_seg1 at (-7, 52, -1), own frame4_arm2_seg1 at (42,62,-1), own frame4_leg1_seg1 at (-12,-5, 0), own frame4_leg2_seg1 at (50, 0, 0)
 
 
            Let canvas be an object with shape = rectangle, size = (600, 200), colour = white
            Let frame1 be an image on canvas placing head at (82, 132, 1), placing frame1_torso at (72, 48, 0)
            Let frame2 be an image on canvas placing head at (214, 132, 1), placing frame2_torso at (204, 48, 0)
            Let frame3 be an image on canvas placing head at (346, 132, 1), placing frame3_torso at (336, 48, 0)
            Let frame4 be an image on canvas placing head at (478, 132, 1), placing frame4_torso at (468, 48, 0)
 
 
 
            REPEAT
                ANIMATE frame1 -> frame2 -> frame3 -> frame4 FOR 1 seconds
            FOR 5