/*
 * Creating a box which is of a specified value(X , O, or null). 
 */
package hybridgameapp;

/**
 *
 * @author Syed Yousuf
 */
public class Box 
{
    // Instance Variables
    private static int idCount = 0; // The id value of the box.(Id number starts from 1 and onwards)
    private String value; // The value can be either "X" or "O" or nothng
    private int id = 0;
    
    /*
    * A constructor initialized the value of the Box.
    *
    * @param Value The Value of the box (either x or o)
    */
    public Box(String value)
    {
        // Increment the id count first
        idCount++;
        
        // Now set the instance variables. 
        id += idCount;
        this.value = value;
    }
    
    /*
    * Get the value.
    *
    * @return value of the box
    */
    public String getValue()
    {
        return value;
    }
    
    
    /*
    * Get the id number.
    *
    * @return id of the box
    */
    public int getId()
    {
        return id;
    }
    
    /*
    * Set the value
    *
    * @param value The value that the box should be set to.
    */
    public void setValue(String value)
    {
        this.value = value;
    }
    
    /*
    * A toString method that returns the toString representation of this class.
    * 
    * @return A toString representation of this class
    */
    @Override 
    public String toString()
    {
        return "id: " + id + " with value of " + value;
    }
    
    public static void main(String[]args)
    {
        Box box1 = new Box("X");
        Box box2 = new Box("O");
        
        System.out.println(box1);
        System.out.println(box2);
        
        
    }
}
