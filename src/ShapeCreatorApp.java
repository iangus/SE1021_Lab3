
/*
 * SE1021 Lab 3
 * Shape Creator Application main class
 * December 12, 2011
 */

// Change this import to match the package where you have your shapes,
//  i.e., your MSOE username.
import java.awt.Color;
import edu.msoe.se1010.winPlotter.WinPlotter;

/**
 * @author taylor
 * This class creates shapes and "tells" them to draw
 *  themselves in a provided WinPlotter window.
 *
 * Based on work done by Dr. Mark Hornick
 */
public class ShapeCreatorApp {
    /**
     * Use shapes to draw a Christmas scene.
     * @param args Ignored
     */
    public static void main2(String[] args) {
        WinPlotter plotter = new WinPlotter();

        // Initialize WinPlotter
        initWinPlotter(plotter);

        // Draw scene
        drawTree(plotter);
        drawPresents(plotter);
    }

    /**
     * This method initializes the WinPlotter object
     * @param plotter The WinPlotter to be initialized
     */
    public static void initWinPlotter(WinPlotter plotter) {
        plotter.setWindowTitle("A Christmas Wish...");
        plotter.setWindowSize(800, 600);		// set window size
        plotter.setPlotBoundaries(-5, -5, 105, 75);	// set logical boundaries
        plotter.setGrid(true, 10, 10, Color.GRAY);	// setup a grid
        // set the background to black
        plotter.setBackgroundColor(Color.black.getRed(), Color.black.getGreen(), Color.black.getBlue());
    }

    /**
     * Draws a Christmas tree out of a rectangle and
     *  a bunch of triangles.
     * @param plotter where the tree should be drawn
     */
    public static void drawTree(WinPlotter plotter) {
        // Draw tree trunk
        Shape rect = new Rectangle(70, 0, 10, 20, Color.ORANGE);
        rect.draw(plotter);

        // Create some triangles to form the tree branches
        Shape triangle1 = new Triangle(50, 10, 50, 25, Color.green);
        triangle1.draw(plotter);
        Shape triangle2 = new Triangle(55, 20, 40, 20, Color.green);
        triangle2.draw(plotter);
        Shape triangle3 = new Triangle(60, 30, 30, 15, Color.green);
        triangle3.draw(plotter);
        Shape triangle4 = new Triangle(65, 40, 20, 10, Color.green);
        triangle4.draw(plotter);

        // Draw ornaments and top decoration on the tree
        drawOrnaments(plotter);
        drawHeadPiece(plotter);
    }

    /**
     * Draw ornaments.
     * @param plotter where the tree should be drawn
     */
    public static void drawOrnaments(WinPlotter plotter) {
        // For ornaments, create some generic shapes and draw them
        Shape shape = new Point(60, 15, Color.orange);
        shape.draw(plotter);
        shape = new Point(88, 18, Color.red);
        shape.draw(plotter);
        shape = new Point(85, 23, Color.blue);
        shape.draw(plotter);
        shape = new Point(77, 29, Color.yellow);
        shape.draw(plotter);
        shape = new Point(70, 35, Color.magenta);
        shape.draw(plotter);
        shape = new Point(72, 42, Color.cyan);
        shape.draw(plotter);
    }

    /**
     * Draw head piece for the top of the tree
     * @param plotter where the tree should be drawn
     */
    public static void drawHeadPiece(WinPlotter plotter) {
        new Circle(75, 55, 5, Color.red).draw(plotter);
        new Circle(75, 55, 4, Color.orange).draw(plotter);
        new Circle(75, 55, 3, Color.yellow).draw(plotter);
        new Circle(75, 55, 2, Color.white).draw(plotter);
    }

    /**
     * Draw Christmas presents
     * @param plotter where the tree should be drawn
     */
    public static void drawPresents(WinPlotter plotter) {
        Shape present1 = new LabeledRectangle(0, 0, 48, 20, Color.BLUE, "To: Mark");
        Shape present2 = new LabeledRectangle(5, 20, 20, 20, Color.CYAN, "To: Mark");
        Shape present3 = new LabeledTriangle(27, 20, 20, 10, Color.YELLOW, "To: Mark");
        present3.draw(plotter);
        present2.draw(plotter);
        present1.setColor(Color.red); // reset the color to red
        present1.draw(plotter);
    }
}