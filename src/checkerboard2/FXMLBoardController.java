/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkerboard2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author crm4g3
 */
public class FXMLBoardController implements Initializable, Startable {
        
    private Stage stage;
    
    private CheckerBoardMaker board;
    
    private boolean isDefaultColor = true;
    
    private int numCols;
    private int numRows;
    
    @FXML
    private VBox vBox;
    
    @FXML
    private AnchorPane anchorPane;
    
    @Override
    public void start(Stage stage) {
        this.stage = stage;
        
        ChangeListener<Number> lambdaChangeListener = (ObservableValue<? extends Number> observable, Number oldValue, final Number newValue) -> {
            updateGrid(board.getNumRows(),board.getNumCols());
            System.out.println(stage.getHeight() + " " + stage.getWidth());
        };
        
        this.stage.widthProperty().addListener(lambdaChangeListener);
        this.stage.heightProperty().addListener(lambdaChangeListener);
    }
    
    @FXML
    private void handleGridChange(ActionEvent event) {
        MenuItem item = (MenuItem)event.getSource();
        switch (item.getText()) {
            case "16x16":
                updateGrid(16,16);
                break;
            case "10x10":
                updateGrid(10,10);
                break;
            case "8x8":
                updateGrid(8,8);
                break;
            case "3x3":
                updateGrid(3,3);
                break;
        }
    }
    
    @FXML
    private void handleColorChange(ActionEvent event) {
        MenuItem item = (MenuItem)event.getSource();
        switch (item.getText()) {
            case "Default":
                isDefaultColor = true;
                updateGrid(board.getNumRows(),board.getNumCols());
                break;
            case "Blue":
                isDefaultColor = false;
                updateGrid(board.getNumRows(),board.getNumCols());
                break;
        }
    }

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    private void updateGrid(int numRows, int numCols){
        anchorPane.getChildren().clear();
        
        if(isDefaultColor == true){
        board = new CheckerBoardMaker(numRows, numCols, stage.getWidth(), stage.getHeight() -55);
        }else{
            board = new CheckerBoardMaker(numRows, numCols, stage.getWidth(), stage.getHeight() -55, Color.SKYBLUE,Color.DARKBLUE);
        }
        
        AnchorPane temp = board.build();
        
        anchorPane.getChildren().addAll(temp.getChildren());
    }
}
