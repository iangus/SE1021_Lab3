
/**
 * SE1021 - 032
 * Winter 2016
 * Lab
 * Name: Ian Guswiler
 * Created: 1/28/2016
 */

import edu.msoe.se1010.winPlotter.WinPlotter;
import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Class to load shapes from a text document and use a WinPlotter to sketch them
 *
 * @author Ian Guswiler
 * @version 2/3/2016
 */
public class ShapeLoaderApp extends WinPlotter {
    private Scanner input;
    private Logger logger;
    private String title;
    private String windowDimensions;
    private String backgroundColor;
    private List<Shape> shapes;

    /**
     * Main functions of the program
     * @param args Ignored
     */
    public static void main(String[] args) {
        Scanner inputScanner = null;
        String uiFile;
        while(inputScanner == null){
            uiFile = JOptionPane.showInputDialog(null, "Input a text file name without the .txt append");
            try{
                inputScanner = new Scanner(new File(uiFile + ".txt"));
            } catch(FileNotFoundException e){
                JOptionPane.showMessageDialog(null, "Error: The file " + uiFile + ".txt was not found.");
            }
        }
        ShapeLoaderApp loader = new ShapeLoaderApp(inputScanner, Logger.getLogger(ShapeLoaderApp.class.getName()));
        WinPlotter plotter = new WinPlotter();
        loader.buildWindow(plotter);
        loader.readShapes();
        loader.drawShapes(plotter);
    }

    /**
     * Constructor reads the first 3 lines of the document
     *
     * @param fileScanner Scanner already associated with the input document
     * @param logger exception logger already configured for the class
     */
    public ShapeLoaderApp(Scanner fileScanner, Logger logger){
        input = fileScanner;
        this.logger = logger;
        title = input.nextLine();
        windowDimensions =input.nextLine();
        backgroundColor = input.nextLine();
    }

    /**
     * sets up the WinPlotter window based off of the first tree lines of the input document
     * @param plotter WinPlotter object to be set up
     */
    public void buildWindow(WinPlotter plotter){
        Scanner dimensions = new Scanner(windowDimensions);
        int red = Integer.valueOf(backgroundColor.substring(1, 3), 16);
        int green = Integer.valueOf(backgroundColor.substring(3, 5), 16);
        int blue = Integer.valueOf(backgroundColor.substring(5, 7), 16);
        int x_dimension = dimensions.nextInt();
        int y_dimension = dimensions.nextInt();
        plotter.setWindowTitle(title);
        plotter.setWindowSize(x_dimension, y_dimension);
        plotter.setPlotBoundaries(0,0,x_dimension,y_dimension);
        plotter.setBackgroundColor(red, green, blue);
    }

    /**
     * reads in the rest of the lines of the input document and adds the shapes to an array list
     */
    public void readShapes(){
        shapes = new ArrayList<>();
        while(input.hasNextLine()) {
            try {
                shapes.add(parseShape(input.nextLine()));
            } catch (InputMismatchException e1) {
                JOptionPane.showMessageDialog(null, e1.getMessage() + " The line was ignored", "Incorrect input", JOptionPane.ERROR_MESSAGE);
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, "There was an unrecognized shape line and it was ignored.", "Unknown Shape", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * Draws the read shapes onto the winplotter
     * @param plotter WinPlotter object to be drawn with
     */
    public void drawShapes(WinPlotter plotter){
        for(Shape shape: shapes){
            shape.draw(plotter);
        }
    }

    /**
     * Takes in a line from the input document and creates a shape object based on its specifications
     * @param line line of text from the input document
     * @return returns a shape object that was read from the input line
     */
    private static Shape parseShape(String line){
        Scanner shapes = new Scanner(line);
        Shape readShape;
        int x_origin;
        int y_origin;
        Color color;
        int radius;
        int base;
        int height;
        int width;
        String label = "";
        switch(shapes.next()){
            case "P:":
                x_origin = shapes.nextInt();
                y_origin = shapes.nextInt();
                color = stringToColor(shapes.next());
                readShape = new Point(x_origin, y_origin, color);
                break;
            case "C:":
                x_origin = shapes.nextInt();
                y_origin = shapes.nextInt();
                color = stringToColor(shapes.next());
                radius = shapes.nextInt();
                readShape = new Circle(x_origin, y_origin, radius, color);
                break;
            case "T:":
                x_origin = shapes.nextInt();
                y_origin = shapes.nextInt();
                color = stringToColor(shapes.next());
                base = shapes.nextInt();
                height = shapes.nextInt();
                readShape = new Triangle(x_origin, y_origin, base, height, color);
                break;
            case "R:":
                x_origin = shapes.nextInt();
                y_origin = shapes.nextInt();
                color = stringToColor(shapes.next());
                width = shapes.nextInt();
                height = shapes.nextInt();
                readShape = new Rectangle(x_origin, y_origin, width, height, color);
                break;
            case "LT:":
                x_origin = shapes.nextInt();
                y_origin = shapes.nextInt();
                color = stringToColor(shapes.next());
                base = shapes.nextInt();
                height = shapes.nextInt();
                while(shapes.hasNext()){label += shapes.next() + " ";}
                readShape = new LabeledTriangle(x_origin, y_origin, base, height, color, label);
                break;
            case "LR:":
                x_origin = shapes.nextInt();
                y_origin = shapes.nextInt();
                color = stringToColor(shapes.next());
                width = shapes.nextInt();
                height = shapes.nextInt();
                while(shapes.hasNext()){label += shapes.next() + " ";}
                readShape = new LabeledRectangle(x_origin, y_origin, width, height, color, label);
                break;
            default:
                throw new IllegalArgumentException("A known shape was not specified");
        }

        return readShape;
    }

    /**
     * converts the hextriple input into a color
     * @param hexcode Hextriple input string to be converted to a color
     * @return returns the color created from the input string
     */
    private static Color stringToColor(String hexcode){
        Color colorConvert;
        try{
            colorConvert = Color.decode(hexcode);
        }catch(InputMismatchException e){
            throw new InputMismatchException("Color input was not in the correct hextriple format.");
        }
        return colorConvert;
    }
}
