
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
 * This class represents a LabeledTriangle
 * @author Ian Guswiler
 * @version 12/20/2015
 */
public class LabeledTriangle extends Triangle{
    private String name;


    /**
     * creates the labeledTriangle
     * @param x_origin cartesian x-origin of this LabeledTriangle
     * @param y_origin cartesian y-origin of this LabeledTriangle
     * @param b base (along the x-axis) of this LabeledTriangle
     * @param h height (along the y-axis) of this LabeledTriangle
     * @param c java.awt.Color for this LabeledTriangle
     * @param name descriptive name for this LabeledTriangle
     */
    public LabeledTriangle(double x_origin, double y_origin, double b, double h, Color c, String name){
        super(x_origin,y_origin,b,h,c);
        this.name = name;
    }


    /**
     * Draws the LabeledTriangle
     * @param plotter reference to a WinPlotter object used for drawing
     */
    public void draw(WinPlotter plotter){
        setPenColor(plotter);
        plotter.printAt(xo + base / 3, yo + height / 3, name);
        super.draw(plotter);
    }
}
