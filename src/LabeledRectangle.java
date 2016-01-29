
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
 * This class represents a LabeledRectangle
 * @author Ian Guswiler
 * @version 12/20/2015
 */
public class LabeledRectangle extends Rectangle{
    private String name;


    /**
     * creates the LabeledRectangle
     * @param x_origin cartesian x-origin of this LabeledRectangle
     * @param y_origin cartesian y-origin of this LabeledRectangle
     * @param w base (along the x-axis) of this LabeledRectangle
     * @param h height (along y-axis) of this LabeledRectangle
     * @param c java.awt.Color for this LabeledRectangle
     * @param name descriptive name for this LabeledRectangle
     */
    public LabeledRectangle(double x_origin, double y_origin, double w, double h, Color c, String name){
        super(x_origin, y_origin, w, h, c);
        this.name = name;
    }


    /**
     * Draws the LabeledRectangle
     * @param plotter reference to a WinPlotter object used for drawing
     */
    public void draw(WinPlotter plotter){
        setPenColor(plotter);
        plotter.printAt(xo + height / 2, yo + height / 2, name);
        super.draw(plotter);
    }
}
