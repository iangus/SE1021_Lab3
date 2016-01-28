
/**
 * SE1021 - 032
 * Winter 2016
 * Lab 3
 * Name: Ian Guswiler
 * Created: 12/17/2015
 */

import edu.msoe.se1010.winPlotter.WinPlotter;
import java.awt.Color;

/**
 * This class represents a Circle
 * @author Ian Guswiler
 * @version 12/20/2015
 */
public class Circle extends Shape{
    private double radius;


    /**
     * creates the Circle
     * @param x_origin cartesian x-origin of this Circle
     * @param y_origin cartesian y-origin of this Circle
     * @param r radius of this Circle
     * @param c the java.awt.Color for this Circle
     */
    public Circle(double x_origin, double y_origin, double r, Color c){
        super(x_origin, y_origin, c);
        this.radius = r;
    }


    /**
     * Draws the Circle
     * @param plotter reference to a WinPlotter object used for drawing
     */
    public void draw(WinPlotter plotter){
        int segments = 360;
        setPenColor(plotter);
        plotter.moveTo(xo + radius,yo);
        for(double i = 0; i <= (2 * Math.PI); i += (2*Math.PI)/segments){
            plotter.drawTo(xo + Math.cos(i) * radius, yo + Math.sin(i) * radius);
        }
    }
}
