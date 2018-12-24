/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hybridgameapp;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


/**
 *
 * @author Syed Yousuf
 */
public class GraphicHybridGameApp 
{
    // Instance fields.
    private JFrame j1;
    private int boardLength; // The length of the tictactoe board. e.g: 3*3 4*4 5*5 etc
    private JButton boxButton[];
    private TicTacToeGame game;
    private String playerIcon;
    private JLabel winOrLoseLabel;
    private boolean isPressed; // If any button is pressed.
    private boolean isOver; // if the game is over or not.
    private boolean isCPU; // does the cpu the opponent or not.
    private int whoseTurn; // 1 if its player 1's turn and 2 if its player 2's turn.
    
    public GraphicHybridGameApp(int boardLength, String playerIcon, boolean isCPU)
    {
        // Initialize the instance variables.
        this.boardLength = boardLength;
        this.playerIcon = playerIcon;
        winOrLoseLabel = new JLabel();
        isPressed = false;
        isOver = false;
        this.isCPU = isCPU;
        whoseTurn = 1;
        
        // Set the win or lose label.
        winOrLoseLabel.setBounds(1000,100,300,300);
        winOrLoseLabel.setFont(new Font("Courier New", Font.ITALIC, 25));
        
        // Set up a new tictactow game.
        game = new TicTacToeGame(boardLength);
        
        // Create a new frame.
        j1 = new JFrame("TicTacToe game.");
        
        // Get the screen size
        Dimension ScreenSize = Toolkit.getDefaultToolkit().getScreenSize();
        
        // Set up the frame.
        j1.setSize((short)ScreenSize.getWidth(), (short)ScreenSize.getHeight());
        j1.setLayout(null);
        j1.setVisible(true);
        j1.add(winOrLoseLabel);
        
        // Set the background colour.
        j1.getContentPane().setBackground( Color.BLACK );
        
        // Create the correct number of board boxes.
        boxButton = new JButton[(boardLength * boardLength)];
        
        paint();
        
        
       
        
        
    }
    
    
    /*
    * Paints the box buttons
    */
    private void paint()
    {
        // Local Variables,
        int counter;
        int counter2;
        int temp2 = 0; // Use it to keep track of the buttons
        short width;
        short height;
        int temp1 = 0; // Use it to keep track of the buttons
        
        // Get the screen size
        Dimension ScreenSize = Toolkit.getDefaultToolkit().getScreenSize();
        
        // Now set the value of the width and height of each button
        //width = (short)(ScreenSize.getWidth() / (boardLength) + 40);
        //height = (short)(ScreenSize.getHeight() / (boardLength) + 40);
        width = 100;
        height = 100;
        
        // reset temp1
        temp1 = 0;
        
        for(counter = 0; counter < boardLength; counter++)
        {
            for(counter2 = 0; counter2 < boardLength; counter2++)
            {
                boxButton[temp1] = new JButton("");
                boxButton[temp1].setBounds(100 + (counter2 * width), 100 + (counter * height), width, height);
                j1.add(boxButton[temp1]);
                                            
                boxButton[temp1].addActionListener(new MyActionListener());
                
                temp1++;
            }
            temp2++;
        }
        
        
        
    }
    
    /*
    * Manages the action listener for the tictactoe grid buttons.
    */
    private class MyActionListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            // local variables.
            int counter;            
            int buttonNumber = 0;

            // First determine which button was clicked 
            for(counter = 0; counter < (boardLength * boardLength); counter++)
            {
                if((JButton)e.getSource() == boxButton[counter])
                {
                    buttonNumber = counter;
                }
            }
            
            // Check if the turn can be made.
            try
            {
                // Determine which players turn it is - 1 or 2 and then perform the according action.
                
                if(whoseTurn == 1)
                {
                    game.performPlayerTurn(buttonNumber + 1, playerIcon, isCPU);

                    // Set player button value.
                    ((JButton)e.getSource()).setText(playerIcon);

                    if(isCPU)
                    {
                        // Set opponent button value.
                        boxButton[game.getOppositionLocation() - 1].setText(game.getOppositionValue());
                    }
                    else
                    {
                        // Change turn.
                        whoseTurn = 2;
                    }    
                    
                }
                else
                if(whoseTurn == 2)
                {
                    game.performOpponentsTurn(buttonNumber + 1);
                    
                    // Set player button value.
                    ((JButton)e.getSource()).setText(game.getOppositionValue());
                    
                    // Change turn.
                    whoseTurn = 1;
                    
                }
     
                        
            }
            catch(IllegalArgumentException exception1)
            {
                // do nothing
                            
            }
                        
                        
            // Now check if the game is over.
            if(game.getScore() == 0)
            {
                if(isCPU)
                {
                    winOrLoseLabel.setText("You win!");
                }
                else
                {
                    winOrLoseLabel.setText("Player 1 wins!");
                }
                winOrLoseLabel.setForeground(Color.GREEN);
                endsGame();
            }
            else
            if(game.getScore() == 1)    
            {
                if(isCPU)
                {
                    winOrLoseLabel.setText("You lose");
                }
                else
                {
                    winOrLoseLabel.setText("Player 2 wins!");
                }
                winOrLoseLabel.setForeground(Color.RED);
                endsGame();
            }
            else
            if(game.getScore() == 4)
            {
                winOrLoseLabel.setText("Its a tie!"); 
                winOrLoseLabel.setForeground(Color.BLUE);
                endsGame();
            }

        }
    }

    /*
    * Sets up the ending of the game.
    */
    private void endsGame()
    {
            // Local variables
            int counter;
            
            
            for(counter = 0; counter < (boardLength * boardLength); counter++)
            {
                boxButton[counter].setEnabled(false);
            }

            
              
            // Make a new button for exiting
            JButton exit =  new JButton("exit");
            exit.setBounds(800,500, 80, 80);
            j1.add(exit);
            exit.setVisible(true);
            class ActionListener2 implements ActionListener
            {
                @Override    
                public void actionPerformed(ActionEvent e)
                {
                       // Exit the game.                     
                       System.exit(0);
                }
            }
            
            exit.addActionListener(new ActionListener2());
            
            
    }
    
    
    
    public static void main(String[]args)
    {
        GraphicHybridGameApp g1 = new GraphicHybridGameApp(3,"x",false);
    }
    
    
}
