
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
 * This class represents a Triangle
 * @author Ian Guswiler
 * @version 12/20/2015
 */
public class Triangle extends Shape{
    protected double base;
    protected double height;


    /**
     * Creates the Triangle
     * @param x_origin cartesian x-origin of this Triangle
     * @param y_origin cartesian y-origin of this Triangle
     * @param b base (along x-axis) of this Triangle
     * @param h height (along y-axis) of this Triangle
     * @param c the java.awt.Color for this Triangle
     */
    public Triangle(double x_origin, double y_origin, double b, double h, Color c){
        super(x_origin, y_origin, c);
        if (b > 0 && h > 0) {
            this.base = b;
            this.height = h;
        } else {
            throw new IllegalArgumentException("Triangle base or height is a negative number.");
        }
    }


    /**
     * Draws the Triangle
     * @param plotter reference to a WinPlotter object used for drawing
     */
    public void draw(WinPlotter plotter){
        setPenColor(plotter);
        plotter.moveTo(xo,yo);
        plotter.drawTo(xo + base, yo);
        plotter.drawTo(xo + base/2, yo + height);
        plotter.drawTo(xo,yo);
    }
}
