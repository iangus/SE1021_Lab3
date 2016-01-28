
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
 * This class represents a point
 * @author Ian Guwiler
 * @version 12/20/2015
 */
public class Point extends Shape {

    /**
     * Creates the point
     * @param x_origin cartesian x-origin of this Point
     * @param y_origin cartesian y-origin of this Point
     * @param c java.awt.Color for this Point
     */
    public Point(double x_origin, double y_origin, Color c){
        super(x_origin, y_origin, c);
    }


    /**
     * Draws the point
     * @param plotter reference to a WinPlotter object used for drawing
     */
    public void draw(WinPlotter plotter){
        setPenColor(plotter);
        plotter.drawPoint(xo, yo);
    }
}
