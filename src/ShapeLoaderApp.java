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
 * SE1021 - 032
 * Winter 2016
 * Lab
 * Name: Ian Guswiler
 * Created: 1/28/2016
 */
public class ShapeLoaderApp extends WinPlotter {
    private Scanner input;
    private Logger logger;
    private String title;
    private String windowDimensions;
    private String backgroundColor;
    private List<Shape> shapes;

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

    public ShapeLoaderApp(Scanner fileScanner, Logger logger){
        input = fileScanner;
        this.logger = logger;
        title = input.nextLine();
        windowDimensions =input.nextLine();
        backgroundColor = input.nextLine();
    }

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

    public void readShapes(){
        shapes = new ArrayList<>();
        try{
            while(input.hasNextLine()){
                shapes.add(parseShape(input.nextLine()));
            }
        } catch (IllegalArgumentException e){
            JOptionPane.showMessageDialog(null, "There was an unrecognized shape line and it was ignored.", "Unknown Shape", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void drawShapes(WinPlotter plotter){
        for(Shape shape: shapes){
            shape.draw(plotter);
        }
    }

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
                color = Color.decode(shapes.next());
                readShape = new Point(x_origin, y_origin, color);
                break;
            case "C:":
                x_origin = shapes.nextInt();
                y_origin = shapes.nextInt();
                color = Color.decode(shapes.next());
                radius = shapes.nextInt();
                readShape = new Circle(x_origin, y_origin, radius, color);
                break;
            case "T:":
                x_origin = shapes.nextInt();
                y_origin = shapes.nextInt();
                color = Color.decode(shapes.next());
                base = shapes.nextInt();
                height = shapes.nextInt();
                readShape = new Triangle(x_origin, y_origin, base, height, color);
                break;
            case "R:":
                x_origin = shapes.nextInt();
                y_origin = shapes.nextInt();
                color = Color.decode(shapes.next());
                width = shapes.nextInt();
                height = shapes.nextInt();
                readShape = new Rectangle(x_origin, y_origin, width, height, color);
                break;
            case "LT:":
                x_origin = shapes.nextInt();
                y_origin = shapes.nextInt();
                color = Color.decode(shapes.next());
                base = shapes.nextInt();
                height = shapes.nextInt();
                while(shapes.hasNext()){label += shapes.next() + " ";}
                readShape = new LabeledTriangle(x_origin, y_origin, base, height, color, label);
                break;
            case "LR:":
                x_origin = shapes.nextInt();
                y_origin = shapes.nextInt();
                color = Color.decode(shapes.next());
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

    private static Color stringToColor(String hexTriplet){
        Color conversion;
        /*
        if(hexTriplet.length() < 7){
            throw new InputMismatchException("hexTriplet string input was less than seven characters; therefor it was in an incorrect format");
        } else if(hexTriplet.charAt(0) != '#'){
            throw new InputMismatchException("hexTriplet string input does not start with the # character");
        }else{
            try{
                Scanner readHex = new Scanner(hexTriplet);
                while(readHex.hasNextByte(6)){

                }
            }catch(InputMismatchException e){

            }
        }*/
        try{
            conversion = Color.decode(hexTriplet);
        }catch (InputMismatchException e){
            throw new InputMismatchException("hexTriplet string input was not in the correct format");
        }
        return conversion;
    }
}
