/*
 * The class will run the commandline version of tictactoe.
 */
package hybridgameapp;
import java.util.Scanner;
/**
 *
 * @author Syed Yousuf
 */
public class HybridGameApp 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Scanner scan = new Scanner(System.in);
        String response;
        String playerChar; // The character value of the player - if the player is x or o
        boolean isOver = false;
        
        // Prompt the user for which size board they want to play in.
        System.out.println("Board size: ");
        response = scan.nextLine();
        
        // Create the board
        TicTacToeGame newGame = new TicTacToeGame(Integer.parseInt(response));
        
        newGame.print();
        
        
        // Ask the user if they want to be x or o
        System.out.println("x or o?: ");
        playerChar = scan.nextLine();
        
        // Starts the game.
        while(isOver == false)
        {
            // Ask the player to perform their turn.
            System.out.println("Perform your turn: (location on the grid): ");
            response = scan.nextLine();
            
            newGame.performPlayerTurn(Integer.parseInt(response), playerChar,true);
            newGame.print();
            if(newGame.getScore() == 0)
            {
                // The player won
                System.out.println("You win!");
                isOver = true;
            }
            else
            if(newGame.getScore() == 1)
            {
                // The opponenet
                System.out.println("You lose!!");
                isOver = true;
            }
            else
            if(newGame.getScore() == 4)
            {
                System.out.println("Its a tie!");
                isOver = true;
            }
        }
        
        
        
    }
    
}
