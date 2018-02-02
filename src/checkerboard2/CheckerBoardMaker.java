/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkerboard2;

import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author codyioslaptop
 */
public class CheckerBoardMaker {
    
    private AnchorPane anchorPane;
    
    private int numRows;
    private int numCols;
    private double anchorWidth;
    private double anchorHeight;
    private double rectWidth;
    private double rectHeight;
    private Color lightColor;
    private Color darkColor;

    public CheckerBoardMaker(int numRows, int numCols, double boardWidth, double boardHeight){
        this.numRows = numRows;
        this.numCols = numCols;
        this.anchorWidth = boardWidth;
        this.anchorHeight = boardHeight;
        this.lightColor = Color.RED;
        this.darkColor = Color.BLACK;
    }
    
    public CheckerBoardMaker(int numRows, int numCols, double boardWidth, double boardHeight, Color lightColor, Color darkColor){
        this(numRows, numCols, boardWidth, boardHeight);
        this.lightColor = lightColor;
        this.darkColor = darkColor;
    }
    
    public AnchorPane build(){
        System.out.println("anchorWidth: " + anchorWidth + " anchorHeight: " + anchorHeight);
        rectWidth = Math.ceil(anchorWidth / numCols);
        rectHeight = Math.ceil(anchorHeight / numRows);
        double x = 0;
        double y = 0;
        
        anchorPane = new AnchorPane();
                        int i = 0;

        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                
                Color color = darkColor;
                if((row+col) % 2 == 0){
                    color = lightColor;
                }
                                
                Rectangle rect = new Rectangle(rectWidth, rectHeight, color);
                
                rect.setLayoutX(x);
                rect.setLayoutY(y);
                
                anchorPane.getChildren().add(rect);
                
                y += rectHeight;
                i++;
            }
            y = 0;
            x += rectWidth;
        }        
        return anchorPane;
    }
    
    public AnchorPane getBoard(){
        return anchorPane;
    }
    
    public int getNumRows(){return numRows;};
    public int getNumCols(){return numCols;};
    
    public double getWidth(){return anchorWidth;};
    public double getHeight(){return anchorHeight;};
    public Color getLightColor(){return lightColor;};
    public Color getDarkColor(){return darkColor;};
    public Double getRectangleWidth(){return rectWidth;};
    public Double getRectangleHeight(){return rectHeight;};

}
