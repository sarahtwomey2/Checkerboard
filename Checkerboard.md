This retrospective is reflecting on the work I did and compare it to the solution.

1. Reflect on (think about) the work you did for the challenge. How did you do? What did you get right? What did you get wrong? 
   What did you do differently (and possibly better) than what was posted in the solution? What was hard to do?
   *  I think I did well but I did not do perfect. The main thing I did wrong was creating instances of the Checkerboard class outside of the refresh function. I correctly created the checkerboard and it worked as it was supposed to. 

2. How well did you understand the programming concepts and foundational knowledge needed to complete the challenge?
   *  I believe that I understand the programming concepts and knowledge needed to complete the challenge. 

3. How well did you meet the requirements as set out in the challenge? What requirements did you not meet correctly (if any)?
   *  I met all of the requirements. But one problem in my code is when I change the color of board and then try to make it bigger, 
     the bottom of the board does not resize and it looks funky. 

4. How well does your solution match the posted solution? What is different?
   *  My solution mostly matches the teachers solution with the exception of a few things: 
     1. I initialized my Rectangles like this:
              
            Rectangle rectangle = new Rectangle(col * rectangleWidth, row * rectangleHeight, 
                                  rectangleWidth, rectangleHeight);
           
         Dale initialized his like this: 
               
                   Rectangle square = new Rectangle();
                       square.setWidth(squareWidth);
                       square.setHeight(squareHeight);
                       square.setX(squareWidth * col);
                       square.setY(squareHeight * row);
     
     2. Dale created a function called renderBoard() that initialized the boardwidth and height and created the checkers while I 
          initialized it inside the lambda change listener.
       
      3. When I would change the size of the board or the colors, I would completely create a new checkerboard by calling:
                
             checkerboard = new Checkerboard(checkerboard.getNumRows(), checkerboard.getNumCols(), 
                            checkerboard.getWidth(), checkerboard.getHeight(), Color.SKYBLUE, Color.DARKBLUE);
          
          While Dale did it by updating just the thing he was changing i.e. the color of the checkers and called renderBoard() each time 
          somethigin was changed using the lambda change listener.


5. How could you improve going forward? What don't you still understand that was required for the challenge?
   *  to improve going forward I am going to focus on the way I use functions and classes. Creating a function to create the checkerboard that is called whenever a change occurs makes much more sense than calling the class each time a change occurs. I understand everything that was required for the challenge. 

