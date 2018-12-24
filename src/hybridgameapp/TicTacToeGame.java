/*
 * 
 */
package hybridgameapp;

import java.util.ArrayList;
import java.util.Random;
import java.lang.*;
/**
 *
 * @author Syed Yousuf
 */
public class TicTacToeGame 
{
    // Instance variables
    protected int score; // If , then the player won, else if 1 then the opponent won or if 4 then its a tie.
    protected Grid GameGrid;
    protected int gridLength;
    protected ArrayList<Integer> usedLocation = new ArrayList<Integer>();// Keeps track of what locations have been taken up on the board.
    protected int playerNum; // Refers to if the player is O or X, If playerNum is 0, player is O. Else X
    private String oppositionValue;
    private int oppositionLocation;
    
    
    /*
    * A constructor that creates a new game with a specified grid length.
    *
    * @param gridLength The length of the grid 
    */
    public TicTacToeGame(int gridLength)
    {
       score = 2; 
        
       // Initialize the values.
        GameGrid = Grid.Grid(gridLength);
        this.gridLength = gridLength;
        
        
    }
    
    /*
    * Checks if the location has already been taken up on the board.
    *
    * @param locationTest The test location
    * @return if it exists
    */
    private boolean testThisLocation(int locationTest)
    {
        // Local Variable
        boolean isEqual = false;
        int counter;
        
        // Check if the location exists in the arraylist.
        for(counter = 0; counter < usedLocation.size(); counter++)
        {
            if(usedLocation.get(counter) == locationTest)
            {
                isEqual = true;
            }
        }
        
        return isEqual;
    }  
    
    /*
    * Checks if the game is over.
    *
    *@param checkValue the value that will be check to see if the game ends.
    * @return if the game is over
    */
    private boolean isOver(String checkValue)
    {
        /*
        * Need to check six areas on the board, the top right, bottom right, right down, left down, and two diagonals.
        * The is true for every type of tictactoe board, 3*3, 4*4, 5*5, etc
        */
        
        // Local variables
        int counter;
        int counter2;
        int score = 0;
        boolean isOver = false;
        
        // Check the top right. 
        for(counter = 0; counter < gridLength; counter ++)
        {
            if(GameGrid.getBoxValue(counter).equals(checkValue))
            {
                score++;
            }
        }
        if(score == gridLength)
        {
            isOver = true;
        }
        
        // Check the bottom right.
        score = 0;
        for(counter = (gridLength * (gridLength - 1)); counter < (gridLength*gridLength); counter ++)
        {
            if(GameGrid.getBoxValue(counter).equals(checkValue))
            {
                score++;
            }
        }
        
        if(score == gridLength)
        {
            isOver = true;
        }
        
        // Check the left down.
        score = 0;
        for(counter = 0; counter < ((gridLength*gridLength) - (gridLength - 1)); counter = counter + gridLength)
        {
            if(GameGrid.getBoxValue(counter).equals(checkValue))
            {
                score++;
            }
        }
        
        if(score == gridLength)
        {
            isOver = true;
        }
        
        // Check the right down.
        score = 0;
        for(counter = (gridLength - 1); counter < (gridLength*gridLength); counter = counter + gridLength)
        {
            if(GameGrid.getBoxValue(counter).equals(checkValue))
            {
                score++;
            }
        }
        
        if(score == gridLength)
        {
            isOver = true;
        }
        
        // Check the diagonal to up. 
        score  = 0;
        for(counter = (gridLength * (gridLength - 1)); counter > (gridLength - 2); counter = counter - (gridLength - 1))
        {
            if(GameGrid.getBoxValue(counter).equals(checkValue))
            {
                score++;
            }
        }
        
        if(score == gridLength)
        {
            isOver = true;
        }
        
        // Check the diagonal to down. 
        score = 0;
        for(counter = 0; counter < (gridLength * gridLength); counter = counter + (gridLength + 1))
        {
            if(GameGrid.getBoxValue(counter).equals(checkValue))
            {
                score++;
            }
        }
        
        if(score == gridLength)
        {
            isOver = true;
        }
        
        for(counter2 = 0; counter2 < (gridLength * (gridLength - 2)); counter2 = counter2 + gridLength) 
        {
            // Check middle to right.
            score = 0;
            for(counter = gridLength + counter2; counter < ((gridLength + gridLength) + counter2); counter++)
            {
                if(GameGrid.getBoxValue(counter).equals(checkValue))
                {
                    score++;
                }
            }
            if(score == gridLength)
            {
                isOver = true;
            }
        
        }
        
        for(counter2 = 0; counter2 < (gridLength - 2) ; counter2++)    
        {
            // Check middle downwards.
            score = 0;
            for(counter = 1 + counter2; counter < (((gridLength * gridLength) - (gridLength - 2)) + counter2); counter = counter + gridLength)
            {
                if(GameGrid.getBoxValue(counter).equals(checkValue))
                {
                    score++;
                }
            }
            if(score == gridLength)
            {
                isOver = true;
            }
        }
        
        return isOver;
    }
    
    /*
    * Performing the player's turn by setting the value that the user
    * specified into the correct box.
    *
    * @param userValue the value that the user specified (either x or o)
    * @param location the location of the value on the grid specified by the user.
    * @param isCPU if the opponent is controlled by the computer or not.
    */
    public void performPlayerTurn(int location, String userValue, boolean isCPU) throws IllegalArgumentException
    {
        // Local Variable
        int randomNum; // Stores the temporary random number for the opponenet's turn.
        boolean locationExists;
        boolean isOver;
        
        // Check if the location already exists
        locationExists = testThisLocation(location);
        
        if(locationExists)
        {
            throw new IllegalArgumentException("The location is already taken up.");
        }
        else
        {
            GameGrid.setBoxValue(location, userValue);
            usedLocation.add(location);
        }
        
        // Check if the game is over or not. or if it is a tie.
       isOver = isOver(userValue);
        if(isOver)
        {
            this.score = 0;
            return;
        }
        else
        if(usedLocation.size() == (gridLength * gridLength))
        {
            this.score = 4;
            return;
        }
        
        // Now the opponents turn should commence immediately. 
        // The input value for the opponent will be opposite to that of the player.
        if(userValue.equals("x"))
        {
            oppositionValue = "o";
        }
        else
        {
            oppositionValue = "x";
        }
        
        if(isCPU)
        {    
            do
            {
                // Obtain a random number between 1 and the number of boxes in the game.
                randomNum = (int)(Math.random()*((gridLength * gridLength)  - 1) + 2);

                 // Perform opponents turn.
                // Check if the location already exists
                locationExists = testThisLocation(randomNum);
            }
            while(locationExists);
            GameGrid.setBoxValue(randomNum, oppositionValue);
            usedLocation.add(randomNum);
            oppositionLocation = randomNum;
        

            // Check if the game is over.
              isOver = isOver(oppositionValue);
              if(isOver)
              {
                 this.score = 1;
                 return;

              }
              else
             if(usedLocation.size() == (gridLength * gridLength))
             {
                this.score = 4;
                return;
             }
        }
    }
    
    /*
    *   Performing the oppponent's turn by setting the value that the user
    *   specified into the correct box.
    *
    * @param location The location of the opponents turn.
    */
    public void performOpponentsTurn(int location)
    {
        // Local variables
        boolean isOver;
        
        GameGrid.setBoxValue(location, oppositionValue);
        usedLocation.add(location);
        oppositionLocation = location;
        
        
        // Check if the game is over.
        isOver = isOver(oppositionValue);
        if(isOver)
        {
            this.score = 1;
            return;

        }
        else
        if(usedLocation.size() == (gridLength * gridLength))
        {
            this.score = 4;
            return;
             
        }
        
    }
    
    /*
    * Prints out the tictactoe board.
    *
    */
    public void print()
    {
        // Local Variable
        int counter;
        int counter2;
        int boxNum = 0;
        
        for(counter  = 0; counter < gridLength; counter++)
        {
            for(counter2 = 0; counter2 < gridLength; counter2++)
            {
                System.out.print(GameGrid.getBoxValue(boxNum));
                boxNum++;
            }
            
            System.out.println("");
    
        }
    }
    
    /*
    * Returns the value of the score - 0 means the player won and 1 means the opponent won
    *
    * @return the value of the score.
    */
    public int getScore()
    {
        return score;
    }
    
    /*
    * Get the opposition location.
    *
    * @return the location of the opposition's turn
    */
    public int getOppositionLocation()
    {
        return oppositionLocation;
    }
    
    /*
    * Get the opposition value
    *
    * @return the value of opposition
    */
    public String getOppositionValue()
    {
        return oppositionValue;
    }
    
    /*
    * The toString representation of this class.
    *
    * @return the string representation of this class.
    */
    @Override
    public String toString()
    {
        return "" + GameGrid;
    }
    
    /*
    * The test main method 
    */
    public static void main(String[]args)
    {
        TicTacToeGame g1 = new TicTacToeGame(3);
        g1.performPlayerTurn(1, "x",true);
        g1.print();
        //System.out.println(g1);
    }
    
}


