/*
 * Create a grid with a sepcified number of boxes.
 */
package hybridgameapp;

/**
 *
 * @author Syed Yousuf
 */
public class Grid 
{
    
    // Static variable singleInstance of Grid type.
    private static Grid singleInstance = null;
    
    // Instance variables
    private int gridNumber; // The number boxes row. For example, 3 means the grid is 3x3.
    private Box boxes[];
    
    /*
    * A private constructor restricted to this class itself.
    *
    * @param gridNumber The grid number for this Grid.
    */
    private Grid(int gridNumber) 
    {
        // Local variable
        int counter;
        
        // Initilize the grid number
        this.gridNumber = gridNumber;
        
        // Create a specified number of boxes, equivalent to the square of the grid number.
        boxes = new Box[gridNumber * gridNumber];
       
        for(counter = 0; counter < (gridNumber * gridNumber); counter++)
        {
            boxes[counter] = new Box("."); // Initially, keep it at blank
        }
    }
    
    /*
    * A static method to ensure that only instance of this class is created.
    *
    * @param gridNumber The grid number that the grid should be made of.
    */
    public static Grid Grid(int gridNumber)
    {
        // To ensure that only one instance is created.
        if(singleInstance == null)
        {
            singleInstance = new Grid(gridNumber);
        }
        
        return singleInstance;
    }
    
    /*
    * Set the value of a specified box within the grid.
    *
    * @param gridNumber The location of the box in the grid
    * @param newValue The new value that is to be set.
    */
    public void setBoxValue(int gridNumber, String newValue)
    {
        // First check if the grid number is within possible rnage, if not throw an exception.
        if(gridNumber > (this.gridNumber*this.gridNumber))
        {
            throw new IllegalArgumentException("Grid location does not exist!");
        }
        else
        {
            // Set the value of the box at the specified location
            boxes[gridNumber - 1].setValue(newValue);
        
        }
        
    }
    
    /*
    * Get the value of the specified box.
    *
    * @param boxNumber The box value that is needed.
    * @return The value of that box
    */
    public String getBoxValue(int boxNumber)
    {
        return boxes[boxNumber].getValue();
    }
    
    
    /*
    * A toString Representation of this class.
    *
    * @return a string representation of this class
    */
    public String toString()
    {
        String representation = "";
        int counter;
        
        representation = "The grid #: " + (gridNumber*gridNumber) + " ...";
        for(counter = 0; counter < (gridNumber*gridNumber); counter++)
        {
            representation += " " + (counter + 1) + " ";
            
            representation += boxes[counter];
        }
        
        return representation;
    }
    
    public static void main(String[]args)
    {
        Grid x = Grid.Grid(3);
        System.out.println(x);
        x.setBoxValue(1,"X");
        System.out.println(x);
        x.setBoxValue(8,"O");
        System.out.println(x);
        System.out.println(x.getBoxValue(0));
    }
    
}
