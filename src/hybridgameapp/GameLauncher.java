/*
 * Launches the tictactoe game. Gives the option of single player or multiplayer as well as grid selection. 
 *
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
public class GameLauncher 
{
    /*
    * The main method to run the game.
    */
    public static void main(String[]args)
    {
        JFrame frame1 = new JFrame("TicTacToe game - select the mode/grid size");

        // Get the screen size
        Dimension ScreenSize = Toolkit.getDefaultToolkit().getScreenSize();
        
        // Set up the frame.
        frame1.setSize((short)ScreenSize.getWidth(), (short)ScreenSize.getHeight());
        frame1.setLayout(null);

        // Create the neccesary pictures for options.
        ImageIcon singlePlayer = new ImageIcon("singleplayer.png");
        ImageIcon multiPlayer = new ImageIcon("multiplayer.png");
        ImageIcon threebythreegrid = new ImageIcon("3.png");
        ImageIcon fourbyfourgrid = new ImageIcon("4.png");
        ImageIcon fivebyfivegrid = new ImageIcon("5.png");
        ImageIcon x = new ImageIcon("x.png");
        ImageIcon o = new ImageIcon("o.png");
        
        

        // Now create the neccessary buttons. - first the single player and multiplayer button.
        JButton singlePlayerB = new JButton(singlePlayer);
        singlePlayerB.setBounds(10,50,400,400);
        
        JButton multiPlayerB = new JButton(multiPlayer);
        multiPlayerB.setBounds(500,50,400,400);
        
        // Implement the correct functionality for the button and add the buttons to the frame.
        frame1.add(singlePlayerB);
        
        class ActionListener1 implements ActionListener
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                singlePlayerB.setEnabled(false);
                singlePlayerB.setVisible(false);
                multiPlayerB.setEnabled(false);
                multiPlayerB.setVisible(false);
                frame1.setVisible(false);
                
                JButton three = new JButton(threebythreegrid);
                three.setBounds(10,50,400,400);
                
                JButton four = new JButton(fourbyfourgrid);
                four.setBounds(500,50,400,400);
                
                JButton five = new JButton(fivebyfivegrid);
                five.setBounds(900,50,400,400);
                
                // Add the new buttons.
                frame1.add(three);
                
                class Action3 implements ActionListener
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        three.setEnabled(false);
                        three.setVisible(false);
                        four.setEnabled(false);
                        four.setVisible(false);
                        five.setEnabled(false);
                        five.setVisible(false);
                        
                        // Create new button
                        JButton xB = new JButton(x);
                        JButton oB = new JButton(o);
                        xB.setBounds(10,50,400,400);
                        oB.setBounds(500,50,400,400);
                        
                        frame1.add(xB);
                        frame1.add(oB);
                        class xO implements ActionListener
                        {
                            @Override
                            public void actionPerformed(ActionEvent e)
                            {
                                // check which button it is.
                                if((JButton)e.getSource() == xB)
                                {
                                    // Close x and o buttons
                                    xB.setEnabled(false);
                                    xB.setVisible(false);
                                    oB.setEnabled(false);
                                    oB.setVisible(false);
                                    
                                    // Create a new game.
                                    GraphicHybridGameApp game1 = new GraphicHybridGameApp(3,"x",true);
                                }
                                else
                                {
                                    // Close x and o buttons
                                    xB.setEnabled(false);
                                    xB.setVisible(false);
                                    oB.setEnabled(false);
                                    oB.setVisible(false);
                                    
                                    // Create a new game.
                                    GraphicHybridGameApp game2 = new GraphicHybridGameApp(3,"o",true);
                               
                                    
                                    
                                }
                            }
                        }
                        xB.addActionListener(new xO());
                        oB.addActionListener(new xO());
                    }
                }
                three.addActionListener(new Action3());
                
                frame1.add(four);
                
                class Action4 implements ActionListener
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        three.setEnabled(false);
                        three.setVisible(false);
                        four.setEnabled(false);
                        four.setVisible(false);
                        five.setEnabled(false);
                        five.setVisible(false);
                        
                        // Create new button
                        JButton xB = new JButton(x);
                        JButton oB = new JButton(o);
                        xB.setBounds(10,50,400,400);
                        oB.setBounds(500,50,400,400);
                        
                        frame1.add(xB);
                        frame1.add(oB);
                        class xO implements ActionListener
                        {
                            @Override
                            public void actionPerformed(ActionEvent e)
                            {
                                // check which button it is.
                                if((JButton)e.getSource() == xB)
                                {
                                    // Close x and o buttons
                                    xB.setEnabled(false);
                                    xB.setVisible(false);
                                    oB.setEnabled(false);
                                    oB.setVisible(false);
                                    
                                    // Create a new game.
                                    GraphicHybridGameApp game1 = new GraphicHybridGameApp(4,"x",true);
                                }
                                else
                                {
                                    // Close x and o buttons
                                    xB.setEnabled(false);
                                    xB.setVisible(false);
                                    oB.setEnabled(false);
                                    oB.setVisible(false);
                                    
                                    // Create a new game.
                                    GraphicHybridGameApp game2 = new GraphicHybridGameApp(4,"o",true);
                               
                                    
                                    
                                }
                            }
                        }
                        xB.addActionListener(new xO());
                        oB.addActionListener(new xO());
                        
                        
                    }
                }
                four.addActionListener(new Action4());
                
                
                frame1.add(five);
                
                class Action5 implements ActionListener
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        three.setEnabled(false);
                        three.setVisible(false);
                        four.setEnabled(false);
                        four.setVisible(false);
                        five.setEnabled(false);
                        five.setVisible(false);
                        
                        // Create new button
                        JButton xB = new JButton(x);
                        JButton oB = new JButton(o);
                        xB.setBounds(10,50,400,400);
                        oB.setBounds(500,50,400,400);
                        
                        frame1.add(xB);
                        frame1.add(oB);
                        class xO implements ActionListener
                        {
                            @Override
                            public void actionPerformed(ActionEvent e)
                            {
                                // check which button it is.
                                if((JButton)e.getSource() == xB)
                                {
                                    // Close x and o buttons
                                    xB.setEnabled(false);
                                    xB.setVisible(false);
                                    oB.setEnabled(false);
                                    oB.setVisible(false);
                                    
                                    // Create a new game.
                                    GraphicHybridGameApp game1 = new GraphicHybridGameApp(5,"x",true);
                                }
                                else
                                {
                                    // Close x and o buttons
                                    xB.setEnabled(false);
                                    xB.setVisible(false);
                                    oB.setEnabled(false);
                                    oB.setVisible(false);
                                    
                                    // Create a new game.
                                    GraphicHybridGameApp game2 = new GraphicHybridGameApp(5,"o",true);
                               
                                    
                                    
                                }
                            }
                        }
                        xB.addActionListener(new xO());
                        oB.addActionListener(new xO());
                    }
                }
                five.addActionListener(new Action5());
                
                
                frame1.setVisible(true);
            }
        }
        singlePlayerB.addActionListener(new ActionListener1());
        
        frame1.add(multiPlayerB);
        
        class ActionListener2 implements ActionListener
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                singlePlayerB.setEnabled(false);
                singlePlayerB.setVisible(false);
                multiPlayerB.setEnabled(false);
                multiPlayerB.setVisible(false);
                
                singlePlayerB.setEnabled(false);
                singlePlayerB.setVisible(false);
                multiPlayerB.setEnabled(false);
                multiPlayerB.setVisible(false);
                frame1.setVisible(false);
                
                JButton three = new JButton(threebythreegrid);
                three.setBounds(10,50,400,400);
                
                JButton four = new JButton(fourbyfourgrid);
                four.setBounds(500,50,400,400);
                
                JButton five = new JButton(fivebyfivegrid);
                five.setBounds(900,50,400,400);
                
                // Add the new buttons.
                frame1.add(three);
                
                class Action3 implements ActionListener
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        three.setEnabled(false);
                        three.setVisible(false);
                        four.setEnabled(false);
                        four.setVisible(false);
                        five.setEnabled(false);
                        five.setVisible(false);
                        
                        // Create new button
                        JButton xB = new JButton(x);
                        JButton oB = new JButton(o);
                        xB.setBounds(10,50,400,400);
                        oB.setBounds(500,50,400,400);
                        
                        frame1.add(xB);
                        frame1.add(oB);
                        class xO implements ActionListener
                        {
                            @Override
                            public void actionPerformed(ActionEvent e)
                            {
                                // check which button it is.
                                if((JButton)e.getSource() == xB)
                                {
                                    // Close x and o buttons
                                    xB.setEnabled(false);
                                    xB.setVisible(false);
                                    oB.setEnabled(false);
                                    oB.setVisible(false);
                                    
                                    // Create a new game.
                                    GraphicHybridGameApp game1 = new GraphicHybridGameApp(3,"x",false);
                                }
                                else
                                {
                                    // Close x and o buttons
                                    xB.setEnabled(false);
                                    xB.setVisible(false);
                                    oB.setEnabled(false);
                                    oB.setVisible(false);
                                    
                                    // Create a new game.
                                    GraphicHybridGameApp game2 = new GraphicHybridGameApp(3,"o",false);
                               
                                    
                                    
                                }
                            }
                        }
                        xB.addActionListener(new xO());
                        oB.addActionListener(new xO());
                    }
                }
                three.addActionListener(new Action3());
                
                frame1.add(four);
                
                class Action4 implements ActionListener
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        three.setEnabled(false);
                        three.setVisible(false);
                        four.setEnabled(false);
                        four.setVisible(false);
                        five.setEnabled(false);
                        five.setVisible(false);
                        
                        // Create new button
                        JButton xB = new JButton(x);
                        JButton oB = new JButton(o);
                        xB.setBounds(10,50,400,400);
                        oB.setBounds(500,50,400,400);
                        
                        frame1.add(xB);
                        frame1.add(oB);
                        class xO implements ActionListener
                        {
                            @Override
                            public void actionPerformed(ActionEvent e)
                            {
                                // check which button it is.
                                if((JButton)e.getSource() == xB)
                                {
                                    // Close x and o buttons
                                    xB.setEnabled(false);
                                    xB.setVisible(false);
                                    oB.setEnabled(false);
                                    oB.setVisible(false);
                                    
                                    // Create a new game.
                                    GraphicHybridGameApp game1 = new GraphicHybridGameApp(4,"x",false);
                                }
                                else
                                {
                                    // Close x and o buttons
                                    xB.setEnabled(false);
                                    xB.setVisible(false);
                                    oB.setEnabled(false);
                                    oB.setVisible(false);
                                    
                                    // Create a new game.
                                    GraphicHybridGameApp game2 = new GraphicHybridGameApp(4,"o",false);
                               
                                    
                                    
                                }
                            }
                        }
                        xB.addActionListener(new xO());
                        oB.addActionListener(new xO());
                        
                        
                    }
                }
                four.addActionListener(new Action4());
                
                
                frame1.add(five);
                
                class Action5 implements ActionListener
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        three.setEnabled(false);
                        three.setVisible(false);
                        four.setEnabled(false);
                        four.setVisible(false);
                        five.setEnabled(false);
                        five.setVisible(false);
                        
                        // Create new button
                        JButton xB = new JButton(x);
                        JButton oB = new JButton(o);
                        xB.setBounds(10,50,400,400);
                        oB.setBounds(500,50,400,400);
                        
                        frame1.add(xB);
                        frame1.add(oB);
                        class xO implements ActionListener
                        {
                            @Override
                            public void actionPerformed(ActionEvent e)
                            {
                                // check which button it is.
                                if((JButton)e.getSource() == xB)
                                {
                                    // Close x and o buttons
                                    xB.setEnabled(false);
                                    xB.setVisible(false);
                                    oB.setEnabled(false);
                                    oB.setVisible(false);
                                    
                                    // Create a new game.
                                    GraphicHybridGameApp game1 = new GraphicHybridGameApp(5,"x",false);
                                }
                                else
                                {
                                    // Close x and o buttons
                                    xB.setEnabled(false);
                                    xB.setVisible(false);
                                    oB.setEnabled(false);
                                    oB.setVisible(false);
                                    
                                    // Create a new game.
                                    GraphicHybridGameApp game2 = new GraphicHybridGameApp(5,"o",false);
                               
                                    
                                    
                                }
                            }
                        }
                        xB.addActionListener(new xO());
                        oB.addActionListener(new xO());
                    }
                }
                five.addActionListener(new Action5());
                
                
                frame1.setVisible(true);
                
                
            }
        }
        
        multiPlayerB.addActionListener(new ActionListener2());
        
        frame1.setVisible(true);

    }
}
