
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
 * This class represents a Rectangle
 *
 * @author Ian Guswiler
 * @version 12/20/2015
 */
public class Rectangle extends Shape{
    protected double height;
    protected double width;


    /**
     * Creates the Rectangle
     * @param x_origin cartesian x-origin of this Rectangle
     * @param y_origin cartesian y-origin of this Rectangle
     * @param w base (along x-axis) of this Rectangle
     * @param h height (along y-axis) of this Rectangle
     * @param c the java.awt.Color for this Rectangle
     */
    public Rectangle(double x_origin, double y_origin, double w, double h, Color c){
        super(x_origin,y_origin,c);
        if (h > 0 && w > 0) {
            this.width = w;
            this.height = h;
        } else {
            throw new IllegalArgumentException("The rectangle height or width is a negative number");
        }
    }


    /**
     * Draws te Rectangle
     * @param plotter reference to a WinPlotter object used for drawing
     */
    public void draw(WinPlotter plotter){
        setPenColor(plotter);
        plotter.moveTo(xo,yo);
        plotter.drawTo(xo + width, yo);
        plotter.drawTo(xo + width, yo + height);
        plotter.drawTo(xo, yo + height);
        plotter.drawTo(xo,yo);
    }
}
