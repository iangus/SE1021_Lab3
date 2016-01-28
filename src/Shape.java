
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
 * This class represents a generic graphical assault.
 *
 * @author Ian Guswiler
 * @version 12/20/2015
 */
public abstract class Shape {
    private Color color;
    protected double xo;
    protected double yo;


    /**
     * Sets the color of the shape
     * @param color the color to set
     */
    public void setColor(Color color){
        this.color = color;
    }

    /**
     * Set the pen color on the WinPlotter object to match the current color of the shape
     * @param plotter reference to a WinPlotter whose pen color should be set
     */
    public void setPenColor(WinPlotter plotter){
        plotter.setPenColor(this.color.getRed(), this.color.getGreen(), this.color.getBlue());
    }


    /**
     * Constructor initializes Shape attributes
     * @param x_origin cartesian x-origin of this shape
     * @param y_origin cartesian y-origin of this shape
     * @param color the java.awt.Color for this shape
     */
    public Shape(double x_origin, double y_origin, Color color){
        this.xo = x_origin;
        this.yo = y_origin;
        this.setColor(color);
    }


    /**
     * Draws the shape
     * @param plotter reference to a WinPlotter object used for drawing
     */
    public abstract void draw(WinPlotter plotter);
}
