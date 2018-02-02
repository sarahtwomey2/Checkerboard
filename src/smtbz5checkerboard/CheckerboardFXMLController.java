/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smtbz5checkerboard;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author sarahtwomey
 */
public class CheckerboardFXMLController implements Initializable, Startable {
    private Stage stage; 
    private int numRows;
    private int numCols;
    private double anchorWidth;
    private double anchorHeight;
    private Color color1 = Color.RED;
    private Color color2 = Color.BLACK;
    
    @FXML 
    private AnchorPane anchorPane;
    @FXML
    private MenuItem sixteen;
    @FXML
    private MenuItem ten;
    @FXML
    private MenuItem eight;
    @FXML
    private MenuItem three;
    @FXML
    private MenuBar menu;
    Checkerboard checkerboard;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println(menu.getHeight());
    }  
    //look for row and column to know its color 
    public void start(Stage stage){
        this.stage = stage;
        anchorWidth = stage.getWidth();
        anchorHeight = (stage.getHeight() - menu.getHeight());
        checkerboard = new Checkerboard(8, 8, anchorWidth, anchorHeight);
        
        ChangeListener<Number> lambdaChangeListener = (ObservableValue<? extends Number> observable, Number oldValue, final Number newValue) -> {
            checkerboard = new Checkerboard(checkerboard.getNumRows(), checkerboard.getNumCols(), stage.getWidth(), (stage.getHeight()-menu.getHeight()), checkerboard.getLightColor(), checkerboard.getDarkColor());
            refresh();
        };
        
        this.stage.heightProperty().addListener(lambdaChangeListener);
        this.stage.widthProperty().addListener(lambdaChangeListener);
        
        refresh();
       
    }
    
    private void refresh() {
        clearAnchorPane();
        anchorPane.setPrefSize(stage.getWidth(), (stage.getHeight()-menu.getHeight()));
        anchorPane.getChildren().addAll(checkerboard.build());
        
    }
    
    private void clearAnchorPane(){
        anchorPane.getChildren().clear();
    } 
    
    @FXML
    private void changeSize(ActionEvent event) {
        MenuItem menuItem = (MenuItem)(event.getSource());
        //clearAnchorPane();

        switch(menuItem.getId()) {
            case "sixteen":
                checkerboard = new Checkerboard(16, 16, checkerboard.getWidth(), checkerboard.getHeight(), checkerboard.getLightColor(), checkerboard.getDarkColor());
                break;
            case "ten":
                checkerboard = new Checkerboard(10, 10, checkerboard.getWidth(), checkerboard.getHeight(), checkerboard.getLightColor(), checkerboard.getDarkColor());
                break;
            case "eight":
                checkerboard = new Checkerboard(8, 8, checkerboard.getWidth(), checkerboard.getHeight(), checkerboard.getLightColor(), checkerboard.getDarkColor());
                break;
            case "three":
                checkerboard = new Checkerboard(3, 3, checkerboard.getWidth(), checkerboard.getHeight(), checkerboard.getLightColor(), checkerboard.getDarkColor());
                break;
        } 
        refresh();
    }
    
    @FXML
    private void changeColor(ActionEvent event) {
        MenuItem menuItem = (MenuItem)(event.getSource());
        //numRows = checkerboard.getNumRows();
        //numCols = checkerboard.getNumCols();
        switch(menuItem.getId()) {
            case "red":
                checkerboard = new Checkerboard(checkerboard.getNumRows(), checkerboard.getNumCols(), checkerboard.getWidth(), checkerboard.getHeight(), Color.RED, Color.BLACK);
                break;
            case "blue":
                checkerboard = new Checkerboard(checkerboard.getNumRows(), checkerboard.getNumCols(), checkerboard.getWidth(), checkerboard.getHeight(), Color.SKYBLUE, Color.DARKBLUE);
                break;
                
        } 
        refresh();
    }
    
}
