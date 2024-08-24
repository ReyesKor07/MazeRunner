/**
 *
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
//import javax.swing.border.BevelBorder;

public class App extends JFrame implements ActionListener {
    private JButton nuevo, resuelveAmp, resuelvePro;
    private JPanel panel;
    // variables para el tamaño del laberinto
    private int f, c;
    // declaración y definición del laberinto
    int[][]lab= { // /*
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
          //{-1,00,00,00,00,00,00,-1,-1,00,-1,-1,00,-1,00,-1,00,-1,-1,00,-1,-1,00,00,00,-1,-1,-1,00,-1,00,00,00,00,00,00,-1,-1,00,-1,-1,00,-1,00,-1,00,-1,-1,00,-1,-1,00,00,00,-1,-1,-1,00,-1,-1},
          //{-1,-1,-1,00,-1,-1,00,-1,00,00,-1,-1,00,-1,00,00,00,00,00,00,-1,-1,00,-1,00,00,00,00,00,00,-1,-1,00,-1,-1,00,-1,00,00,-1,-1,00,-1,00,00,00,00,00,00,-1,-1,00,-1,00,00,00,00,00,00,-1},
          //{-1,00,00,00,-1,-1,-1,-1,-1,00,00,00,00,-1,00,-1,00,-1,-1,-1,-1,-1,00,-1,00,-1,-1,00,-1,00,00,00,00,-1,-1,-1,-1,-1,00,00,00,00,-1,00,-1,00,-1,-1,-1,-1,-1,00,-1,00,-1,-1,00,-1,00,-1},
          //{-1,00,-1,00,-1,00,00,-1,-1,00,-1,-1,00,-1,00,-1,00,-1,00,00,00,-1,00,-1,-1,-1,-1,00,-1,00,00,-1,00,-1,00,00,-1,-1,00,-1,-1,00,-1,00,-1,00,-1,00,00,00,-1,00,-1,-1,-1,-1,00,-1,00,-1},
          //{-1,00,-1,00,00,00,00,00,-1,00,-1,-1,00,-1,-1,00,00,-1,00,-1,00,-1,00,-1,00,00,00,00,-1,00,00,-1,00,00,00,00,00,-1,00,-1,-1,00,-1,-1,00,00,-1,00,-1,00,-1,00,-1,00,00,00,00,-1,00,-1},
          //{-1,00,-1,-1,-1,-1,-1,00,-1,00,00,-1,00,00,-1,00,-1,00,-1,-1,00,-1,00,-1,-1,00,-1,-1,-1,00,00,-1,-1,-1,-1,-1,00,-1,00,00,-1,00,00,-1,00,-1,00,-1,-1,00,-1,00,-1,-1,00,-1,-1,-1,00,-1},
          //{-1,00,-1,00,00,00,-1,00,-1,00,-1,-1,00,-1,-1,00,-1,00,-1,-1,00,-1,00,00,00,00,00,-1,00,00,00,-1,00,00,00,-1,00,-1,00,-1,-1,00,-1,-1,00,-1,00,-1,-1,00,-1,00,00,00,00,-1,-1,00,00,-1},
          //{-1,00,00,00,-1,00,-1,00,-1,00,-1,00,00,00,-1,00,00,00,-1,-1,00,00,00,-1,-1,-1,00,-1,00,-1,00,00,00,-1,00,-1,00,-1,00,-1,00,00,00,-1,00,-1,00,-1,-1,00,-1,00,-1,-1,-1,00,-1,00,-1,-1},
            {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
        }; 
        // */
         /*
        
            {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
            {-1,00,-1,-1,-1,-1,-1,00,00,00,00,00,00,00,00,00,00,00,00,00,-1,00,00,00,00,00,00,00,00,00,-1},
            {-1,00,00,00,00,00,00,00,-1,00,-1,-1,-1,-1,-1,-1,-1,00,-1,00,-1,-1,-1,-1,00,-1,00,-1,00,-1,-1},
            {-1,00,-1,00,00,-1,-1,00,-1,00,-1,00,00,-1,00,00,-1,00,-1,00,-1,-1,-1,00,-1,-1,00,-1,00,-1,-1},
            {-1,00,-1,-1,00,00,-1,00,-1,00,-1,00,-1,-1,00,-1,-1,00,-1,00,-1,00,00,00,00,00,00,00,00,00,-1},
            {-1,00,00,00,-1,-1,-1,-1,-1,-1,-1,00,-1,00,00,-1,00,00,-1,00,-1,-1,-1,00,-1,-1,-1,-1,00,-1,-1},
            {-1,00,-1,-1,-1,00,00,-1,00,00,-1,00,00,-1,00,-1,00,-1,-1,00,-1,-1,00,00,00,00,00,00,00,00,-1},
            {-1,00,-1,-1,-1,00,-1,-1,-1,00,-1,00,-1,-1,00,00,00,-1,00,00,00,-1,00,-1,00,-1,00,-1,00,-1,-1},
            {-1,00,-1,-1,-1,00,-1,-1,-1,00,-1,00,00,-1,00,-1,00,-1,-1,-1,00,-1,-1,-1,00,-1,00,00,00,-1,-1},
            {-1,00,00,00,00,00,00,-1,-1,00,-1,-1,00,-1,00,-1,00,-1,00,-1,00,-1,-1,-1,00,-1,00,-1,-1,00,-1},
            {-1,-1,-1,00,-1,-1,00,-1,00,00,-1,-1,00,-1,00,00,00,00,00,-1,00,-1,-1,00,00,-1,00,-1,-1,00,-1},
            {-1,00,-1,00,-1,-1,00,-1,-1,00,-1,00,00,-1,00,-1,00,-1,-1,-1,00,-1,-1,00,-1,-1,00,00,00,00,-1},
            {-1,00,-1,00,-1,-1,00,00,00,00,-1,-1,00,-1,00,-1,00,-1,00,00,00,-1,00,00,-1,-1,-1,-1,-1,00,-1},
            {-1,00,-1,00,00,00,00,-1,-1,00,-1,-1,00,-1,-1,00,00,-1,-1,-1,00,-1,-1,00,00,-1,-1,-1,-1,00,-1},
            {-1,00,-1,-1,-1,-1,-1,00,-1,00,00,-1,00,00,-1,00,-1,00,-1,00,-1,-1,00,-1,00,-1,-1,-1,00,00,-1},
            {-1,00,-1,00,00,00,-1,00,00,00,-1,-1,00,-1,-1,00,-1,00,-1,00,-1,-1,00,-1,00,-1,00,00,00,-1,-1},
            {-1,00,00,00,-1,00,00,00,-1,00,-1,00,00,00,-1,00,-1,00,-1,00,00,00,00,00,00,-1,-1,-1,00,-1,-1},
            {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
        };  */
    
    public static void main(String [] args) {
        // Se instancia un objeto de la clase Laberinto
        App demo = new App();
        // Se establece el tamaño de la ventana
        demo.setSize(1100,1200);
        // Se establece la ubicación de la ventana en el centro de la pantalla
        demo.setLocationRelativeTo(null);
        // Se establece que la ventana se maximice a toda la pantalla
        demo.setExtendedState(JFrame.MAXIMIZED_BOTH);
        // Se crea la interfaz gráfica de usuario
        demo.createGUI();
        // Se hace visible la ventana
        demo.setVisible(true);
    }
    
    //Crea la interfaz gráfica de usuario
    private void createGUI() {        
        // Configura la acción por defecto al cerrar la ventana
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Obtiene el contenedor principal de la ventana
        Container window = getContentPane();

        // Crea un panel vacío y lo agrega al contenedor principal en la parte izquierda
        JPanel emptyPanel = new JPanel();
        emptyPanel.setPreferredSize(new Dimension(350, 740));
        emptyPanel.setBackground(Color.WHITE);
        window.add(emptyPanel, BorderLayout.WEST);

        // Crea un panel para los botones y lo agrega al contenedor principal en la parte inferior
        JPanel buttonPanel = new JPanel(new GridLayout(1, 3, 20, 20));
        buttonPanel.setBackground(Color.DARK_GRAY);
        window.add(buttonPanel, BorderLayout.SOUTH);

        // Crea un panel para mostrar la imagen del laberinto y lo agrega al contenedor
        panel = new JPanel();
        panel.setPreferredSize(new Dimension(620, 650));
        panel.setBackground(Color.WHITE);
        window.add(panel, BorderLayout.CENTER);

        // Crea un botón "Nuevo" y lo agrega al panel de botones
        nuevo = new JButton("Nuevo Juego");
        nuevo.setPreferredSize(new Dimension(200, 80));
        nuevo.setFont(new Font("Times New Roman", Font.BOLD, 20));
        nuevo.setBackground(Color.RED.darker());
        nuevo.setForeground(Color.WHITE);
        nuevo.setOpaque(true);
        nuevo.setBorderPainted(false);
        buttonPanel.add(nuevo);

        // Configurar el listener del botón "Nuevo Juego"
        nuevo.addActionListener(this);

        // Crea un botón "Resuelve Amplitud" y lo agrega al panel de botones
        resuelveAmp = new JButton("Resolver con \n Amplitud");
        resuelveAmp.setPreferredSize(new Dimension(200, 80));
        resuelveAmp.setFont(new Font("Times New Roman", Font.BOLD, 20));
        resuelveAmp.setBackground(Color.BLUE.darker());
        resuelveAmp.setForeground(Color.WHITE);
        resuelveAmp.setOpaque(true);
        resuelveAmp.setBorderPainted(false);
        buttonPanel.add(resuelveAmp);

        // Configurar el listener del botón "Resolver con Amplitud"
        resuelveAmp.addActionListener(this);

        // Crea un botón "Resuelve Profundidad" y lo agrega al panel de botones
        resuelvePro = new JButton("Resolver con \n Profundidad");
        resuelvePro.setPreferredSize(new Dimension(200, 80));
        resuelvePro.setFont(new Font("Times New Roman", Font.BOLD, 20));
        resuelvePro.setBackground(Color.GREEN.darker());
        resuelvePro.setForeground(Color.WHITE);
        resuelvePro.setOpaque(true);
        resuelvePro.setBorderPainted(false);
        buttonPanel.add(resuelvePro);

        // Configurar el listener del botón "Resolver con Profundidad"
        resuelvePro.addActionListener(this);

        // Establece la fuente y color de fondo para todo el contenido del contenedor principal
        window.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        window.setBackground(Color.DARK_GRAY);

        // Configura el tamaño, posición y visibilidad de la ventana
        setTitle("Mi Laberinto");
        setLocationRelativeTo(null);
        pack();
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        // Obtiene un objeto Graphics del panel para dibujar sobre él
        Graphics paper = panel.getGraphics();
        
        // Si se presionó el botón "Nuevo"
        if(e.getSource() == nuevo)
        {
            // Limpia el panel con el color blanco.
            paper.setColor(Color.white);
            paper.fillRect(10, 10, lab[0].length*10-20, lab.length*10-20);
            
            // Reinicia las posiciones del laberinto.
            for(int i=1;i<lab.length-1;i++)
            {
                for(int j=1;j<lab[0].length-1;j++)
                {
                    if(lab[i][j]!=00 && lab[i][j] !=-1)
                    {
                        lab[i][j]=00; }
                }
            }
            
            // Coloca dos puntos rojos aleatorios en el laberinto.
            for(int i =1;i<=2;i++)
            {
                do
                {
                    f= ThreadLocalRandom.current().nextInt(0,lab.length);
                    c= ThreadLocalRandom.current().nextInt(0,lab[0].length); }
                while(lab[f][c]!=00);
                lab[f][c]=-2;
            }

            // Dibuja el laberinto en el panel.
            for(int i=0;i<lab[0].length;i++){
                for(int j=0;j<lab.length;j++){
                    if(lab[j][i]==-1){
                        paper.setColor(Color.black);
                        paper.fillRect(i*10,j*10,10,10);
                    }else if(lab[j][i]==-2){
                        paper.setColor(Color.red);
                        paper.fillRect(i*10,j*10,10,10); }
                }
            }
        }

        //------------------------------------ B U S Q U E D A    A M P L I T U D ---------------------------------------------------------------
        
        // Si el evento es del botón "ResuelveAmp", encuentra la solución del laberinto.
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
                    lab[f-1][c]=(lab[f][c])-1; }
                if(lab[f][c-1]==0)
                {
                    cola.offer(f+","+(c-1));
                    lab[f][c-1]=(lab[f][c])-1; }
                if (lab[f+1][c]==0)
                {
                    cola.offer((f+1)+","+c);
                    lab[f+1][c]=(lab[f][c])-1; }
                if (lab[f][c+1]==0)
                {
                    cola.offer(f+","+(c+1));
                    lab[f][c+1]=(lab[f][c])-1; }
                if (lab[f-1][c]==-2)
                {
                    lab[f-1][c]=(lab[f][c])-1;
                    break; }
                else if ( lab[f][c-1]==-2)
                {
                    lab[f][c-1]=(lab[f][c])-1;
                    break; }
                else if (lab[f+1][c]==-2)
                {
                    lab[f+1][c]=(lab[f][c])-1;
                    break; }
                else if (lab[f][c+1]==-2)
                {
                    lab[f][c+1]=(lab[f][c])-1;
                    break; }
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
                    Thread.sleep(8); }
                catch(InterruptedException pu) 
                {
                    Thread.currentThread().interrupt(); } 
            }
            
            if (cola.isEmpty()) {
                // -------------------------- S I N   S O L U C I ÓN ----- A M P L I T U D ------------------------------------------------
                UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Times New Roman", Font.PLAIN, 18)));
                UIManager.put("OptionPane.background", new ColorUIResource(Color.decode("#8B0000")));
                UIManager.put("Panel.background", new ColorUIResource(Color.decode("#8B0000")));

                JLabel message = new JLabel("<html><center>¡Oh no! Parece que no se ha encontrado una solución.<br> ¡No te preocupes, "
                        + "intentémoslo de nuevo!</center></html>");
                message.setFont(new Font("Times New Roman", Font.BOLD, 22));
                message.setForeground(Color.decode("#FFFFFF"));

                JOptionPane.showMessageDialog(null, message, "Sin solución - Búsqueda en Amplitud"
                        , JOptionPane.INFORMATION_MESSAGE);
                
                nuevo.doClick(); // Genera un nuevo laberinto al dar clic en "OK"
                return; }
 
            else {
                paper.setColor(Color.blue);
                while(lab[f][c]!=-3)
                {
                    try 
                    {
                        Thread.sleep(8); } 
                    catch(InterruptedException pu) 
                    {
                        Thread.currentThread().interrupt(); }
                    
                    paper.fillRect(c*10,f*10,10,10);
                    
                    if (lab[f-1][c]==lab[f][c]+1)
                    {
                        f=f-1; }
                    else if (lab[f][c-1]==lab[f][c]+1 )
                    {
                        c=c-1; }
                    else if (lab[f+1][c]==lab[f][c]+1)
                    {
                        f=f+1; }
                    else if (lab[f][c+1]==lab[f][c]+1)
                    {
                        c=c+1; }
                }
                // ----------------------------------   S O L U C I Ó N ---- A M P L I T U D ---------------------------------------------------- 
                UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Times New Roman", Font.PLAIN, 18)));
                UIManager.put("OptionPane.background", new ColorUIResource(Color.decode("#0000FF")));
                UIManager.put("Panel.background", new ColorUIResource(Color.decode("#0000FF")));

                
                JLabel message = new JLabel("<html><center>¡¡Se ha encontrado una solución!!<br> Haz clic en OK para comenzar un nuevo juego."
                        + "</center></html>");
                message.setFont(new Font("Times New Roman", Font.BOLD, 22));
                message.setForeground(Color.decode("#FFFFFF"));

                JOptionPane.showMessageDialog(null, message, "Solución - Búsqueda en Amplitud", 
                        JOptionPane.INFORMATION_MESSAGE);
                
                nuevo.doClick(); // Genera un nuevo laberinto al dar clic en "OK"
                return;
            }
        }
        
        //------------------------------------------- B U S Q U E D A    P R O F U N D I D A D ----------------------------------------------------

        // Si el evento es del botón "ResuelvePro", encuentra la solución del laberinto.
        else if(e.getSource() == resuelvePro)
        {
            // Se crea una pila para guardar las posiciones del camino.
            Stack<String> pila = new Stack<String>();
            String[] dato;
            while(true)
            {
                // Se colorea el camino de azul
                paper.setColor(Color.blue);
                // Se guarda la posición actual en la pila
                pila.push(f+","+c);
                // Si la posición actual no es la salida, se marca como visitada
                if(lab[f][c]!=-2)
                {
                    lab[f][c]=-4;
                    paper.fillRect(c*10,f*10,10,10); }
                // Si la posición actual es la salida, se marca como visitada y se detiene el recorrido
                else
                {
                    lab[f][c]=-3; }
                // Se busca la dirección hacia donde se puede avanzar en el laberinto
                if (f-1>=0 && lab[f-1][c]==0)
                {
                    f=f-1; }
                else if(c-1>=0 && lab[f][c-1]==0)
                {
                    c=c-1; }
                else if (lab[f+1][c]==0)
                {
                    f=f+1; }
                else if (lab[f][c+1]==0)
                {
                    c=c+1; }
                // Si no se puede avanzar en ninguna dirección, se retrocede hasta encontrar una posición sin visitar
                else if(pila.size()!=0)
                {
                    // Se saca la última posición de la pila y se retrocede a ella
                    pila.pop();
                    paper.setColor(Color.white);
                    paper.fillRect(c*10,f*10,10,10);
                    try
                    {
                        if(pila.isEmpty()) { break; }
                        dato = pila.pop().split(",");
                        lab[f][c]=-5;
                        f   = Integer.parseInt(dato[0]);
                        c   = Integer.parseInt(dato[1]); }
                    // Si la pila está vacía, se ha llegado al inicio sin encontrar la salida
                    catch(java.util.EmptyStackException od){ } 
                }
                // Se pinta la celda actual
                paper.fillRect(c*10,f*10,10,10);
                // Si la celda actual es una celda de destino (-2), se rompe el ciclo while
                if (f-1>=0 && lab[f-1][c]==-2 ||
                    c-1>=0 && lab[f][c-1]==-2 ||
                    lab[f+1][c]==-2 || lab[f][c+1]==-2)
                {
                    break; }
                // Se hace una pequeña pausa para ralentizar la velocidad de la animación
                try 
                {
                    Thread.sleep(5); } 
                catch(InterruptedException pu) 
                {
                    Thread.currentThread().interrupt(); }
            }
            
            if (pila.size()!=0)
            {
                // ----------------------------------   S O L U C I Ó N ---- P R O F U N D I D A D ---------------------------------------------- 
                UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Times New Roman", Font.PLAIN, 18)));
                UIManager.put("OptionPane.background", new ColorUIResource(Color.decode("#0000FF")));
                UIManager.put("Panel.background", new ColorUIResource(Color.decode("#0000FF")));
                
                JLabel message = new JLabel("<html><center>¡¡Se ha encontrado una solución!!<br> Haz clic en OK para comenzar un nuevo juego."
                        + "</center></html>");
                message.setFont(new Font("Times New Roman", Font.BOLD, 22));
                message.setForeground(Color.decode("#FFFFFF"));

                JOptionPane.showMessageDialog(null, message, "Solución - Búsqueda en Profundidad", 
                        JOptionPane.INFORMATION_MESSAGE);
                
                nuevo.doClick(); // Genera un nuevo laberinto al dar clic en "OK"
                return;
            }
            
            if (pila.isEmpty()) 
            {
                // -------------------------- S I N   S O L U C I ÓN ----- A M P L I T U D ------------------------------------------------
                UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Times New Roman", Font.PLAIN, 18)));
                UIManager.put("OptionPane.background", new ColorUIResource(Color.decode("#8B0000")));
                UIManager.put("Panel.background", new ColorUIResource(Color.decode("#8B0000")));

                JLabel message = new JLabel("<html><center>¡Oh no! Parece que no se ha encontrado una solución."
                        + "<br> ¡No te preocupes, intentémoslo de nuevo!</center></html>");
                message.setFont(new Font("Times New Roman", Font.BOLD, 22));
                message.setForeground(Color.decode("#FFFFFF"));

                JOptionPane.showMessageDialog(null, message, "Sin solución - Búsqueda en Profundidad", 
                        JOptionPane.INFORMATION_MESSAGE);
                
                nuevo.doClick(); // Genera un nuevo laberinto al dar clic en "OK"
                return; }   
        }
    }
} 