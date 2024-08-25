/**
 * @author Brandon Reyes De La Cruz
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.FontUIResource;

public class App extends JFrame implements ActionListener {
    private JButton NewGame, resuelveAmp, resuelvePro;
    private JPanel panel;
    private int f, c;
    int[][]lab= 
    {
        {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
        {-1,00,-1,-1,-1,-1,-1,00,00,00,00,00,00,00,00,00,00,00,00,00,-1,00,00,00,00,00,00,00,00,00,00,-1,-1,-1,-1,-1,-1,00,00,00,00,00,00,00,00,00,00,00,00,00,-1,00,00,00,00,00,00,00,00,-1},
        {-1,00,00,00,00,00,00,00,-1,00,-1,-1,-1,-1,-1,-1,-1,00,-1,00,-1,-1,-1,-1,00,-1,00,-1,00,-1,00,00,00,00,00,00,00,00,-1,00,-1,-1,-1,-1,-1,-1,-1,00,-1,00,-1,-1,-1,-1,00,00,00,00,00,-1},
        {-1,00,-1,00,00,-1,-1,00,-1,00,-1,00,00,-1,00,00,-1,00,-1,00,-1,-1,-1,00,-1,-1,00,-1,00,-1,00,-1,00,00,-1,-1,00,-1,00,-1,00,00,-1,00,00,-1,00,-1,00,-1,-1,-1,00,-1,-1,00,-1,00,-1,-1},
        {-1,00,-1,-1,00,00,-1,00,-1,00,-1,00,-1,-1,00,-1,-1,00,-1,00,-1,00,00,00,00,00,00,00,00,00,00,-1,-1,00,00,-1,00,-1,00,-1,00,-1,-1,00,-1,-1,00,-1,00,-1,00,00,00,00,00,00,00,00,00,-1},
        {-1,00,00,00,-1,-1,-1,-1,-1,-1,-1,00,-1,00,00,-1,00,00,-1,00,-1,-1,-1,00,-1,-1,-1,-1,00,-1,00,00,00,-1,-1,-1,-1,-1,-1,-1,00,-1,00,00,-1,00,00,-1,00,-1,-1,-1,00,-1,-1,-1,-1,00,-1,-1},
        {-1,00,-1,-1,-1,00,00,-1,00,00,-1,00,00,-1,00,-1,00,-1,-1,00,-1,-1,00,00,00,00,00,00,00,00,00,-1,-1,-1,00,00,-1,00,00,-1,00,00,-1,00,-1,00,-1,-1,00,-1,-1,00,00,00,00,00,00,00,00,-1},
        {-1,00,-1,-1,-1,00,-1,-1,-1,00,-1,00,-1,-1,00,00,00,-1,00,00,00,-1,00,-1,00,-1,00,-1,00,-1,00,-1,-1,-1,00,-1,-1,-1,00,-1,00,-1,-1,00,00,00,-1,00,00,00,-1,00,-1,00,-1,00,-1,00,-1,-1},
        {-1,00,-1,-1,-1,00,-1,-1,-1,00,-1,00,00,-1,00,-1,00,-1,-1,-1,00,-1,-1,-1,00,-1,00,00,00,-1,00,-1,-1,-1,00,-1,-1,-1,00,-1,00,00,-1,00,-1,00,-1,-1,-1,00,-1,-1,-1,00,-1,00,00,00,-1,-1},
        {-1,00,00,00,00,00,00,-1,-1,00,-1,-1,00,-1,00,-1,00,-1,00,-1,00,-1,-1,-1,00,-1,00,-1,-1,00,00,00,00,00,00,00,-1,-1,00,-1,-1,00,-1,00,-1,00,-1,00,-1,00,-1,-1,-1,00,-1,00,-1,-1,00,-1},
        {-1,-1,-1,00,-1,-1,00,-1,00,00,-1,-1,00,-1,00,00,00,00,00,-1,00,-1,-1,00,00,-1,00,-1,-1,00,-1,-1,00,-1,-1,00,-1,00,00,-1,-1,00,-1,00,00,00,00,00,-1,00,-1,-1,00,00,-1,00,-1,-1,00,-1},
        {-1,00,-1,00,-1,-1,00,-1,-1,00,-1,00,00,-1,00,-1,00,-1,-1,-1,00,-1,-1,00,-1,-1,00,00,00,00,00,-1,00,-1,-1,00,-1,-1,00,-1,00,00,-1,00,-1,00,-1,-1,-1,00,-1,-1,00,-1,-1,00,00,00,00,-1},
        {-1,00,-1,00,-1,-1,00,00,00,00,-1,-1,00,-1,00,-1,00,-1,00,00,00,-1,00,00,-1,-1,-1,-1,-1,00,00,-1,00,-1,-1,00,00,00,00,-1,-1,00,-1,00,-1,00,-1,00,00,00,-1,00,00,-1,-1,-1,-1,-1,00,-1},
        {-1,00,-1,00,00,00,00,-1,-1,00,-1,-1,00,-1,-1,00,00,-1,-1,-1,00,-1,-1,00,00,-1,-1,-1,-1,00,00,-1,00,00,00,00,-1,-1,00,-1,-1,00,-1,-1,00,00,-1,-1,-1,00,-1,-1,00,00,-1,-1,-1,-1,00,-1},
        {-1,00,-1,-1,-1,-1,-1,00,-1,00,00,-1,00,00,-1,00,-1,00,-1,00,-1,-1,00,-1,00,-1,-1,-1,00,00,00,-1,-1,-1,-1,-1,00,-1,00,00,-1,00,00,-1,00,-1,00,-1,00,-1,-1,00,-1,00,-1,-1,-1,00,00,-1},
        {-1,00,-1,00,00,00,-1,00,00,00,-1,-1,00,-1,-1,00,-1,00,-1,00,-1,-1,00,-1,00,-1,00,00,00,-1,00,-1,00,00,00,-1,00,00,00,-1,-1,00,-1,-1,00,-1,00,-1,00,-1,-1,00,-1,00,-1,00,00,00,-1,-1},
        {-1,00,00,00,-1,00,00,00,-1,00,-1,00,00,00,-1,00,-1,00,-1,00,00,00,00,00,00,-1,-1,-1,00,-1,00,00,00,-1,00,00,00,-1,00,-1,00,00,00,-1,00,-1,00,-1,00,00,00,00,00,00,-1,-1,-1,00,-1,-1},
        {-1,-1,00,-1,00,00,-1,00,-1,00,-1,00,-1,00,-1,00,00,00,-1,-1,00,-1,00,-1,00,-1,00,-1,00,-1,00,-1,00,00,-1,00,-1,00,-1,00,-1,00,-1,00,00,00,-1,-1,00,-1,00,-1,00,-1,00,-1,-1,00,-1,-1},
        {-1,-1,00,00,00,-1,-1,-1,-1,-1,-1,00,-1,00,-1,00,-1,-1,-1,-1,00,-1,00,-1,00,-1,00,-1,00,00,00,00,00,-1,-1,-1,-1,-1,-1,00,-1,00,-1,00,-1,-1,-1,-1,00,-1,00,-1,00,-1,00,-1,00,00,-1,-1},
        {-1,00,-1,-1,-1,-1,-1,00,00,00,00,00,-1,00,00,00,00,00,-1,00,00,00,00,00,00,00,00,-1,00,-1,00,-1,-1,-1,-1,-1,00,00,00,00,00,-1,00,00,00,00,00,-1,00,00,00,00,00,00,00,00,-1,00,-1,-1},
        {-1,00,00,00,00,00,00,00,-1,00,-1,-1,-1,-1,-1,-1,-1,00,-1,00,-1,00,-1,-1,-1,-1,00,-1,-1,-1,00,00,00,00,00,00,00,-1,00,-1,-1,-1,-1,-1,-1,-1,00,-1,00,-1,00,-1,-1,-1,-1,00,-1,-1,-1,-1},
        {-1,00,-1,00,00,-1,-1,00,-1,00,-1,00,00,-1,00,00,-1,00,-1,00,-1,00,-1,-1,00,-1,00,-1,-1,00,00,-1,00,00,-1,-1,00,-1,00,-1,00,00,-1,00,00,-1,00,-1,00,-1,00,-1,-1,00,-1,00,-1,-1,00,-1},
        {-1,00,-1,-1,00,00,-1,00,-1,00,-1,00,-1,-1,00,-1,-1,00,-1,00,-1,00,00,-1,00,00,00,00,00,00,00,-1,-1,00,00,-1,00,-1,00,-1,00,-1,-1,00,-1,-1,00,-1,00,-1,00,00,-1,00,00,00,00,00,00,-1},
        {-1,00,00,00,-1,-1,-1,-1,-1,-1,-1,00,00,00,00,-1,00,00,-1,00,-1,-1,-1,-1,-1,-1,-1,00,-1,-1,00,00,00,-1,-1,-1,-1,-1,-1,-1,00,00,00,00,-1,00,00,-1,00,-1,-1,-1,-1,-1,-1,-1,00,-1,-1,-1},
        {-1,-1,-1,00,-1,00,00,00,00,00,-1,00,00,-1,00,-1,00,-1,-1,00,00,00,-1,00,00,-1,-1,00,-1,-1,-1,-1,00,-1,00,00,00,00,00,-1,00,00,-1,00,-1,00,-1,-1,00,00,00,00,00,00,-1,-1,00,-1,-1,-1},
        {-1,00,-1,00,-1,00,-1,-1,-1,00,-1,00,-1,-1,00,-1,00,-1,-1,-1,-1,00,-1,-1,00,00,00,00,-1,-1,00,-1,00,-1,00,-1,-1,-1,00,-1,00,-1,-1,00,-1,00,-1,-1,-1,-1,00,-1,-1,00,00,00,00,-1,-1,-1},
        {-1,00,-1,00,-1,00,-1,-1,-1,00,-1,00,00,-1,00,-1,00,-1,-1,00,00,00,00,-1,-1,-1,-1,00,00,-1,00,-1,00,-1,00,-1,-1,-1,00,-1,00,00,-1,00,-1,00,-1,-1,00,00,00,00,-1,-1,-1,-1,00,00,-1,-1},
        {-1,00,00,00,00,00,00,-1,-1,00,-1,-1,00,-1,00,-1,00,-1,-1,00,-1,-1,00,00,00,-1,-1,-1,00,-1,00,00,00,00,00,00,-1,-1,00,-1,-1,00,-1,00,-1,00,-1,-1,00,-1,-1,00,00,00,-1,-1,-1,00,-1,-1},
        {-1,-1,-1,00,-1,-1,00,-1,00,00,-1,-1,00,-1,00,00,00,00,00,00,-1,-1,00,-1,00,00,00,00,00,00,-1,-1,00,-1,-1,00,-1,00,00,-1,-1,00,-1,00,00,00,00,00,00,-1,-1,00,-1,00,00,00,00,00,00,-1},
        {-1,00,00,00,-1,-1,-1,-1,-1,00,00,00,00,-1,00,-1,00,-1,-1,-1,-1,-1,00,-1,00,-1,-1,00,-1,00,00,00,00,-1,-1,-1,-1,-1,00,00,00,00,-1,00,-1,00,-1,-1,-1,-1,-1,00,-1,00,-1,-1,00,-1,00,-1},
        {-1,00,-1,00,-1,00,00,-1,-1,00,-1,-1,00,-1,00,-1,00,-1,00,00,00,-1,00,-1,-1,-1,-1,00,-1,00,00,-1,00,-1,00,00,-1,-1,00,-1,-1,00,-1,00,-1,00,-1,00,00,00,-1,00,-1,00,-1,-1,00,-1,00,-1},
        {-1,00,-1,00,00,00,00,00,-1,00,-1,-1,00,-1,-1,00,00,-1,00,-1,00,-1,00,-1,00,00,00,00,-1,00,00,-1,00,00,00,00,00,-1,00,-1,-1,00,-1,-1,00,00,-1,00,-1,00,-1,00,-1,00,00,00,00,-1,00,-1},
        {-1,00,-1,-1,-1,-1,-1,00,-1,00,00,-1,00,00,-1,00,-1,00,-1,-1,00,-1,00,-1,-1,00,-1,-1,-1,00,00,-1,-1,-1,-1,-1,00,-1,00,00,-1,00,00,-1,00,-1,00,-1,-1,00,-1,00,-1,-1,00,-1,-1,-1,00,-1},
        {-1,00,-1,00,00,00,-1,00,-1,00,-1,-1,00,-1,-1,00,-1,00,-1,-1,00,-1,00,00,00,00,-1,-1,00,00,00,-1,00,00,00,-1,00,-1,00,-1,-1,00,-1,-1,00,-1,00,-1,-1,00,-1,00,00,00,00,-1,-1,00,00,-1},
        {-1,00,00,00,-1,00,-1,00,-1,00,-1,00,00,00,-1,00,-1,00,-1,-1,00,-1,00,-1,-1,-1,00,-1,00,-1,00,00,00,-1,00,-1,00,-1,00,-1,00,00,00,-1,00,-1,00,-1,-1,00,-1,00,-1,-1,-1,00,-1,00,-1,-1},
        {-1,00,-1,-1,-1,-1,-1,00,00,00,00,00,00,00,00,00,00,00,00,00,-1,00,00,00,00,00,00,00,00,00,00,-1,-1,-1,-1,-1,-1,00,00,00,00,00,00,00,00,00,00,00,00,00,-1,00,00,00,00,00,00,00,00,-1},
        {-1,00,00,00,00,00,00,00,-1,00,-1,-1,-1,-1,-1,-1,-1,00,-1,00,-1,-1,-1,-1,00,-1,00,-1,00,-1,00,00,00,00,00,00,00,00,-1,00,-1,-1,-1,-1,-1,-1,-1,00,-1,00,-1,-1,-1,-1,00,-1,00,-1,00,-1},
        {-1,00,-1,00,00,-1,-1,00,-1,00,-1,00,00,-1,00,00,-1,00,-1,00,-1,-1,-1,00,-1,-1,00,-1,00,-1,00,-1,00,00,-1,-1,00,-1,00,-1,00,00,-1,00,00,-1,00,-1,00,-1,-1,-1,00,-1,-1,00,-1,00,-1,-1},
        {-1,00,-1,-1,00,00,-1,00,-1,00,-1,00,-1,-1,00,-1,-1,00,-1,00,-1,00,00,00,00,00,00,00,00,00,00,-1,-1,00,00,-1,00,-1,00,-1,00,-1,-1,00,-1,-1,00,-1,00,-1,00,00,00,00,00,00,00,00,00,-1},
        {-1,00,00,00,-1,-1,-1,-1,-1,-1,-1,00,-1,00,00,-1,00,00,-1,00,-1,-1,-1,00,-1,-1,-1,-1,00,-1,00,00,00,-1,-1,-1,-1,-1,-1,-1,00,-1,00,00,-1,00,00,-1,00,-1,-1,-1,00,-1,-1,-1,-1,00,-1,-1},
        {-1,00,-1,-1,-1,00,00,-1,00,00,-1,00,00,-1,00,-1,00,-1,-1,00,-1,-1,00,00,00,00,00,00,00,00,00,-1,-1,-1,00,00,-1,00,00,-1,00,00,-1,00,-1,00,-1,-1,00,-1,-1,00,00,00,00,00,00,00,00,-1},
        {-1,00,-1,-1,-1,00,-1,-1,-1,00,-1,00,-1,-1,00,00,00,-1,00,00,00,-1,00,-1,00,-1,00,-1,00,-1,00,-1,-1,-1,00,-1,-1,-1,00,-1,00,-1,-1,00,00,00,-1,00,00,00,-1,00,-1,00,-1,00,-1,00,-1,-1},
        {-1,00,-1,-1,-1,00,-1,-1,-1,00,-1,00,00,-1,00,-1,00,-1,-1,-1,00,-1,-1,-1,00,-1,00,00,00,-1,00,-1,-1,-1,00,-1,-1,-1,00,-1,00,00,-1,00,-1,00,-1,-1,-1,00,-1,-1,-1,00,-1,00,00,00,-1,-1},
        {-1,00,00,00,00,00,00,-1,-1,00,-1,-1,00,-1,00,-1,00,-1,00,-1,00,-1,-1,-1,00,-1,00,-1,-1,00,00,00,00,00,00,00,-1,-1,00,-1,-1,00,-1,00,-1,00,-1,00,-1,00,-1,-1,-1,00,-1,00,-1,-1,00,-1},
        {-1,-1,-1,00,-1,-1,00,-1,00,00,-1,-1,00,-1,00,00,00,00,00,-1,00,-1,-1,00,00,-1,00,-1,-1,00,-1,-1,00,-1,-1,00,-1,00,00,-1,-1,00,-1,00,00,00,00,00,-1,00,-1,-1,00,00,-1,00,-1,-1,00,-1},
        {-1,00,-1,00,-1,-1,00,-1,-1,00,-1,00,00,-1,00,-1,00,-1,-1,-1,00,-1,-1,00,-1,-1,00,00,00,00,00,-1,00,-1,-1,00,-1,-1,00,-1,00,00,-1,00,-1,00,-1,-1,-1,00,-1,-1,00,-1,-1,00,00,00,00,-1},
        {-1,00,-1,00,-1,-1,00,00,00,00,-1,-1,00,-1,00,-1,00,-1,00,00,00,-1,00,00,-1,-1,-1,-1,-1,00,00,-1,00,-1,-1,00,00,00,00,-1,-1,00,-1,00,-1,00,-1,00,00,00,-1,00,00,-1,-1,-1,-1,-1,00,-1},
        {-1,00,-1,00,00,00,00,-1,-1,00,-1,-1,00,-1,-1,00,00,-1,-1,-1,00,-1,-1,00,00,-1,-1,-1,-1,00,00,-1,00,00,00,00,-1,-1,00,-1,-1,00,-1,-1,00,00,-1,-1,-1,00,-1,-1,00,00,-1,-1,-1,-1,00,-1},
        {-1,00,-1,-1,-1,-1,-1,00,-1,00,00,-1,00,00,-1,00,-1,00,-1,00,-1,-1,00,-1,00,-1,-1,-1,00,00,00,-1,-1,-1,-1,-1,00,-1,00,00,-1,00,00,-1,00,-1,00,-1,00,-1,-1,00,-1,00,-1,-1,-1,00,00,-1},
        {-1,00,-1,00,00,00,-1,00,00,00,-1,-1,00,-1,-1,00,-1,00,-1,00,-1,-1,00,-1,00,-1,00,00,00,-1,00,-1,00,00,00,-1,00,00,00,-1,-1,00,-1,-1,00,-1,00,-1,00,-1,-1,00,-1,00,-1,00,00,00,-1,-1},
        {-1,00,00,00,-1,00,00,00,-1,00,-1,00,00,00,-1,00,-1,00,-1,00,00,00,00,00,00,-1,-1,-1,00,-1,00,00,00,-1,00,00,00,-1,00,-1,00,00,00,-1,00,-1,00,-1,00,00,00,00,00,00,00,-1,00,00,-1,-1},
        {-1,-1,00,-1,00,00,-1,00,-1,00,-1,00,-1,00,-1,00,00,00,-1,-1,00,-1,00,-1,00,-1,00,-1,00,-1,00,-1,00,00,-1,00,-1,00,-1,00,-1,00,-1,00,00,00,-1,-1,00,-1,00,-1,00,-1,00,-1,00,-1,-1,-1},
        {-1,-1,00,00,00,-1,-1,-1,-1,-1,-1,00,-1,00,-1,00,-1,-1,-1,-1,00,-1,00,-1,00,-1,00,-1,00,00,00,00,00,-1,-1,-1,-1,-1,-1,00,-1,00,-1,00,-1,-1,-1,-1,00,-1,00,-1,00,-1,00,-1,00,00,-1,-1},
        {-1,00,-1,-1,-1,-1,-1,00,00,00,00,00,-1,00,00,00,00,00,-1,00,00,00,00,00,00,00,00,-1,00,-1,00,-1,-1,-1,-1,-1,00,00,00,00,00,-1,00,00,00,00,00,-1,00,00,00,00,00,00,00,00,00,00,-1,-1},
        {-1,00,00,00,00,00,00,00,-1,00,-1,-1,-1,-1,-1,-1,-1,00,-1,00,-1,00,-1,-1,-1,-1,00,-1,-1,-1,00,00,00,00,00,00,00,-1,00,-1,-1,-1,-1,-1,-1,-1,00,-1,00,-1,00,-1,-1,-1,-1,00,-1,-1,-1,-1},
        {-1,00,-1,00,00,-1,-1,00,-1,00,-1,00,00,-1,00,00,-1,00,-1,00,-1,00,-1,-1,00,-1,00,-1,-1,00,00,-1,00,00,-1,-1,00,-1,00,-1,00,00,-1,00,00,-1,00,-1,00,-1,00,-1,-1,00,-1,00,-1,-1,00,-1},
        {-1,00,-1,-1,00,00,-1,00,-1,00,-1,00,-1,-1,00,-1,-1,00,-1,00,-1,00,00,-1,00,00,00,00,00,00,00,-1,-1,00,00,-1,00,-1,00,-1,00,-1,-1,00,-1,-1,00,-1,00,-1,00,00,-1,00,00,00,00,00,00,-1},
        {-1,00,00,00,-1,-1,-1,-1,-1,-1,-1,00,00,00,00,-1,00,00,-1,00,-1,-1,-1,-1,-1,-1,-1,00,-1,-1,00,00,00,-1,-1,-1,-1,-1,-1,-1,00,00,00,00,-1,00,00,-1,00,-1,-1,-1,-1,-1,-1,-1,00,-1,-1,-1},
        {-1,-1,-1,00,-1,00,00,00,00,00,-1,00,00,-1,00,-1,00,-1,-1,00,00,00,-1,00,00,-1,-1,00,-1,-1,-1,-1,00,-1,00,00,00,00,00,-1,00,00,-1,00,-1,00,-1,-1,00,00,00,-1,00,00,-1,-1,00,-1,-1,-1},
        {-1,00,-1,00,-1,00,-1,-1,-1,00,-1,00,-1,-1,00,-1,00,-1,-1,-1,-1,00,-1,-1,00,00,00,00,-1,-1,00,-1,00,-1,00,-1,-1,-1,00,-1,00,-1,-1,00,-1,00,-1,-1,-1,-1,00,-1,-1,00,00,00,00,-1,-1,-1},
        {-1,00,-1,00,-1,00,-1,-1,-1,00,-1,00,00,-1,00,-1,00,-1,-1,00,00,00,00,-1,-1,-1,-1,00,00,-1,00,-1,00,-1,00,-1,-1,-1,00,-1,00,00,-1,00,-1,00,-1,-1,00,00,00,00,-1,-1,-1,-1,00,00,-1,-1},
        {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
    }; 
    
    public static void main(String [] args) 
    {
        App demo = new App();
        demo.setSize(1100,1200);
        demo.setLocationRelativeTo(null);
        demo.setExtendedState(JFrame.MAXIMIZED_BOTH);
        demo.createGUI();
        demo.setVisible(true);
    }
    
    public void createGUI() 
    {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        // Creates an empty panel and adds it to the parent container on the left side
        JPanel emptyPanel = new JPanel();
        emptyPanel.setPreferredSize(new Dimension(350, 740));
        emptyPanel.setBackground(Color.WHITE);
        window.add(emptyPanel, BorderLayout.WEST);
        // Creates a panel for the buttons and adds it to the main container at the bottom
        JPanel buttonPanel = new JPanel(new GridLayout(1, 3, 20, 20));
        buttonPanel.setBackground(Color.DARK_GRAY);
        window.add(buttonPanel, BorderLayout.SOUTH);
        // Creates a panel to display the maze image and adds it to the container
        panel = new JPanel();
        panel.setPreferredSize(new Dimension(620, 650));
        panel.setBackground(Color.WHITE);
        window.add(panel, BorderLayout.CENTER);
        // Creates a "Nuevo Juego" button and adds it to the buttons panel
        NewGame = new JButton("Nuevo Juego");
        NewGame.setPreferredSize(new Dimension(200, 80));
        NewGame.setFont(new Font("Times New Roman", Font.BOLD, 20));
        NewGame.setBackground(Color.RED.darker());
        NewGame.setForeground(Color.WHITE);
        NewGame.setOpaque(true);
        NewGame.setBorderPainted(false);
        buttonPanel.add(NewGame);
        NewGame.addActionListener(this);
        // Creates a "Resuelve Amplitud" button and adds it to the button panel
        resuelveAmp = new JButton("Resolver con \n Amplitud");
        resuelveAmp.setPreferredSize(new Dimension(200, 80));
        resuelveAmp.setFont(new Font("Times New Roman", Font.BOLD, 20));
        resuelveAmp.setBackground(Color.BLUE.darker());
        resuelveAmp.setForeground(Color.WHITE);
        resuelveAmp.setOpaque(true);
        resuelveAmp.setBorderPainted(false);
        buttonPanel.add(resuelveAmp);
        resuelveAmp.addActionListener(this);
        // Create a "Resuelve Profundidad" button and add it to the button panel
        resuelvePro = new JButton("Resolver con \n Profundidad");
        resuelvePro.setPreferredSize(new Dimension(200, 80));
        resuelvePro.setFont(new Font("Times New Roman", Font.BOLD, 20));
        resuelvePro.setBackground(Color.GREEN.darker());
        resuelvePro.setForeground(Color.WHITE);
        resuelvePro.setOpaque(true);
        resuelvePro.setBorderPainted(false);
        buttonPanel.add(resuelvePro);
        resuelvePro.addActionListener(this);
        // Sets the font and background color for all content in the parent container
        window.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        window.setBackground(Color.DARK_GRAY);
        setTitle("Mi Laberinto");
        setLocationRelativeTo(null);
        pack();
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        Graphics paper = panel.getGraphics();
        // If the "Nuevo Juego" button is pressed
        if(e.getSource() == NewGame)
        {
            // Clear the panel with white color.
            paper.setColor(Color.white);
            paper.fillRect(10, 10, lab[0].length*10-20, lab.length*10-20);
            // Reset the maze positions.
            for(int i=1;i<lab.length-1;i++)
            {
                for(int j=1;j<lab[0].length-1;j++)
                {
                    if(lab[i][j]!=00 && lab[i][j] !=-1)
                    {
                        lab[i][j]=00; 
                    }
                }
            }
            // Place two random red dots in the maze.
            for(int i =1;i<=2;i++)
            {
                do
                {
                    f= ThreadLocalRandom.current().nextInt(0,lab.length);
                    c= ThreadLocalRandom.current().nextInt(0,lab[0].length); 
                }
                while(lab[f][c]!=00);
                lab[f][c]=-2;
            }
            // Draw the maze on the panel.
            for(int i=0;i<lab[0].length;i++)
            {
                for(int j=0;j<lab.length;j++)
                {
                    if(lab[j][i]==-1)
                    {
                        paper.setColor(Color.black);
                        paper.fillRect(i*10,j*10,10,10);
                    }
                    else if(lab[j][i]==-2)
                    {
                        paper.setColor(Color.red);
                        paper.fillRect(i*10,j*10,10,10); 
                    }
                }
            }
        }
        
        /* Breadth Search */ 
        // If the event is from the "ResolveAmp" button, find the solution to the maze.
        else if(e.getSource() == resuelveAmp) 
        {
            Queue<String> cola = new LinkedList<String>();
            String[] dato;
            lab[f][c]=-3;
            paper.setColor(Color.green);
            while(true)
            {
                if (lab[f-1][c]==0)
                {
                    cola.offer((f-1)+","+c);
                    lab[f-1][c]=(lab[f][c])-1; 
                }
                if(lab[f][c-1]==0)
                {
                    cola.offer(f+","+(c-1));
                    lab[f][c-1]=(lab[f][c])-1; 
                }
                if (lab[f+1][c]==0)
                {
                    cola.offer((f+1)+","+c);
                    lab[f+1][c]=(lab[f][c])-1; 
                }
                if (lab[f][c+1]==0)
                {
                    cola.offer(f+","+(c+1));
                    lab[f][c+1]=(lab[f][c])-1; 
                }
                if (lab[f-1][c]==-2)
                {
                    lab[f-1][c]=(lab[f][c])-1;
                    break; 
                }
                else if ( lab[f][c-1]==-2)
                {
                    lab[f][c-1]=(lab[f][c])-1;
                    break; 
                }
                else if (lab[f+1][c]==-2)
                {
                    lab[f+1][c]=(lab[f][c])-1;
                    break; 
                }
                else if (lab[f][c+1]==-2)
                {
                    lab[f][c+1]=(lab[f][c])-1;
                    break; 
                }
                else 
                {
                    if(cola.isEmpty()) { break; }
                    dato = cola.poll().split(",");
                    f   = Integer.parseInt(dato[0]);
                    c   = Integer.parseInt(dato[1]); 
                }
                paper.fillRect(c*10,f*10,10,10);
                try 
                {
                    Thread.sleep(8); 
                }
                catch(InterruptedException pu) 
                {
                    Thread.currentThread().interrupt(); 
                } 
            }
            
            // Breadth Search - No Solution Message
            if (cola.isEmpty()) 
            {
                UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Times New Roman", Font.PLAIN, 18)));
                UIManager.put("OptionPane.background", new ColorUIResource(Color.decode("#8B0000")));
                UIManager.put("Panel.background", new ColorUIResource(Color.decode("#8B0000")));
                JLabel message = new JLabel("<html><center>¡Oh no! Parece que no se ha encontrado una solución.<br> ¡No te preocupes, intentémoslo de NewGame!</center></html>");
                message.setFont(new Font("Times New Roman", Font.BOLD, 22));
                message.setForeground(Color.decode("#FFFFFF"));
                JOptionPane.showMessageDialog(null, message, "Sin solución - Búsqueda en Amplitud", JOptionPane.INFORMATION_MESSAGE);
                NewGame.doClick(); // Generates a NewGame maze by clicking "OK"
                return; 
            }
            else 
            {
                paper.setColor(Color.blue);
                while(lab[f][c]!=-3)
                {
                    try 
                    {
                        Thread.sleep(8); 
                    } 
                    catch(InterruptedException pu) 
                    {
                        Thread.currentThread().interrupt(); 
                    }
                    paper.fillRect(c*10,f*10,10,10);
                    if (lab[f-1][c]==lab[f][c]+1)
                    {
                        f=f-1; 
                    }
                    else if (lab[f][c-1]==lab[f][c]+1 )
                    {
                        c=c-1; 
                    }
                    else if (lab[f+1][c]==lab[f][c]+1)
                    {
                        f=f+1; 
                    }
                    else if (lab[f][c+1]==lab[f][c]+1)
                    {
                        c=c+1; 
                    }
                }
                // Breadth Search - Solution Message
                UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Times New Roman", Font.PLAIN, 18)));
                UIManager.put("OptionPane.background", new ColorUIResource(Color.decode("#0000FF")));
                UIManager.put("Panel.background", new ColorUIResource(Color.decode("#0000FF")));
                JLabel message = new JLabel("<html><center>¡¡Se ha encontrado una solución!!<br> Haz clic en OK para comenzar un NewGame juego.</center></html>");
                message.setFont(new Font("Times New Roman", Font.BOLD, 22));
                message.setForeground(Color.decode("#FFFFFF"));
                JOptionPane.showMessageDialog(null, message, "Solución - Búsqueda en Amplitud", JOptionPane.INFORMATION_MESSAGE);
                NewGame.doClick();
                return;
            }
        }

        /* Depth Search */ 
        // If the event is from the "ResuelvePro" button, find the solution to the maze.
        else if(e.getSource() == resuelvePro)
        {
            // A stack is created to store the path positions.
            Stack<String> pila = new Stack<String>();
            String[] dato;
            while(true)
            {
                // The path is colored blue
                paper.setColor(Color.blue);
                // The current position in the stack is saved
                pila.push(f+","+c);
                // If the current position is not the exit, it is marked as visited
                if(lab[f][c]!=-2)
                {
                    lab[f][c]=-4;
                    paper.fillRect(c*10,f*10,10,10); 
                }
                // If the current position is the exit, it is marked as visited and the tour is stopped.
                else
                {
                    lab[f][c]=-3; 
                }
                // The direction in which you can advance in the labyrinth is sought
                if (f-1>=0 && lab[f-1][c]==0)
                {
                    f=f-1; 
                }
                else if(c-1>=0 && lab[f][c-1]==0)
                {
                    c=c-1; 
                }
                else if (lab[f+1][c]==0)
                {
                    f=f+1; 
                }
                else if (lab[f][c+1]==0)
                {
                    c=c+1; 
                }
                // If you cannot advance in any direction, you retreat until you find an unvisited position.
                else if(pila.size()!=0)
                {
                    // The last position is taken from the stack and moved back to it.
                    pila.pop();
                    paper.setColor(Color.white);
                    paper.fillRect(c*10,f*10,10,10);
                    try
                    {
                        if(pila.isEmpty()) { break; }
                        dato = pila.pop().split(",");
                        lab[f][c]=-5;
                        f   = Integer.parseInt(dato[0]);
                        c   = Integer.parseInt(dato[1]); 
                    }
                    // If the stack is empty, the start has been reached without finding the exit.
                    catch(java.util.EmptyStackException od){ } 
                }
                // The current cell is painted
                paper.fillRect(c*10,f*10,10,10);
                // If the current cell is a destination cell (-2), the while loop breaks
                if (f-1>=0 && lab[f-1][c]==-2 || c-1>=0 && lab[f][c-1]==-2 || lab[f+1][c]==-2 || lab[f][c+1]==-2)
                {
                    break; 
                }
                // A short pause is made to slow down the speed of the animation
                try 
                {
                    Thread.sleep(5); 
                } 
                catch(InterruptedException pu) 
                {
                    Thread.currentThread().interrupt(); 
                }
            }
            
            // Depth Search - Solution Message
            if (pila.size()!=0)
            {
                UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Times New Roman", Font.PLAIN, 18)));
                UIManager.put("OptionPane.background", new ColorUIResource(Color.decode("#0000FF")));
                UIManager.put("Panel.background", new ColorUIResource(Color.decode("#0000FF")));
                JLabel message = new JLabel("<html><center>¡¡Se ha encontrado una solución!!<br> Haz clic en OK para comenzar un NewGame juego. </center></html>");
                message.setFont(new Font("Times New Roman", Font.BOLD, 22));
                message.setForeground(Color.decode("#FFFFFF"));
                JOptionPane.showMessageDialog(null, message, "Solución - Búsqueda en Profundidad", JOptionPane.INFORMATION_MESSAGE);
                NewGame.doClick();
                return;
            }
            // Depth Search - No Solution Message
            if (pila.isEmpty()) 
            {
                UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Times New Roman", Font.PLAIN, 18)));
                UIManager.put("OptionPane.background", new ColorUIResource(Color.decode("#8B0000")));
                UIManager.put("Panel.background", new ColorUIResource(Color.decode("#8B0000")));
                JLabel message = new JLabel("<html><center>¡Oh no! Parece que no se ha encontrado una solución. <br> ¡No te preocupes, intentémoslo de NewGame!</center></html>");
                message.setFont(new Font("Times New Roman", Font.BOLD, 22));
                message.setForeground(Color.decode("#FFFFFF"));
                JOptionPane.showMessageDialog(null, message, "Sin solución - Búsqueda en Profundidad", JOptionPane.INFORMATION_MESSAGE);
                NewGame.doClick();
                return; 
            }   
        }
    }
} 