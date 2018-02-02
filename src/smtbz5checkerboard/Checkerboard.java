/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smtbz5checkerboard;

import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author sarahtwomey
 */
public class Checkerboard {
    private int numRows;
    private int numCols;
    private double boardWidth;
    private double boardHeight;
    
    private Color lightColor;
    private Color darkColor;
    private AnchorPane anchorPane;
    
    public Checkerboard(int numRows, int numCols, double boardWidth, double boardHeight){
        this(numRows, numCols, boardWidth, boardHeight, Color.RED, Color.BLACK);
    }
    
    public Checkerboard(int numRows, int numCols, double boardWidth, double boardHeight, 
            Color lightColor, Color darkColor) {
        this.numRows = numRows;
        this.numCols = numCols;
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
        this.lightColor = lightColor;
        this.darkColor = darkColor;
    }
    
    //build UI & return an anchor pane
    public AnchorPane build(){
        double squareWidth = (boardWidth/numCols);
        double squareHeight = (boardHeight/numRows);
        
        anchorPane = new AnchorPane();
        
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                Rectangle square = new Rectangle();
                square.setWidth(squareWidth);
                square.setHeight(squareHeight);
                square.setX(squareWidth * col);
                square.setY(squareHeight * row);
                
                if ((col % 2 == 0 && row % 2 != 0) || (col % 2 != 0 && row % 2 == 0)) {
                    square.setFill(darkColor);
                }
                else {
                    square.setFill(lightColor);
                }
                anchorPane.getChildren().add(square);
            }
        }
        return anchorPane;
    }
    
    public AnchorPane getBoard() {
        return anchorPane;
    }
    
    public int getNumRows(){
        return numRows;
    }
    public int getNumCols(){
        return numCols;
    }
    public double getWidth(){
        return boardWidth;
     
    }
    public double getHeight(){
        return boardHeight;
    }
    public Color getLightColor(){
        return lightColor;
    }
    public Color getDarkColor(){
        return darkColor;
    }
    public double getRectangleWidth() {
        return boardWidth;
    }
            
    public double getRectangleHeight() {
        return boardHeight;
    }
}
