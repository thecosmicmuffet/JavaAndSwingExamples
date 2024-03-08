import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;

import Cave.Cave;

// The main reason this code is here, is to show you how your test code might be structured in a
// directory with the rest of your team's wumpus project.  This file is a mockup of your wumpus game UI.
// It is calling the mock cave object, but does not interact at all with the cave test code.
//
// This example also shows how to add an image (icon) to a JButton, and how to play a sound when
// the button is clicked.

class WumpusUI {
    // Load the icon, scaled to the given size
    private static ImageIcon loadIcon(String iconFilePath, int width, int height) {
        ImageIcon origIcon = new ImageIcon(iconFilePath);
        Image img = origIcon.getImage();  
        Image resizedImage = img.getScaledInstance(width, height,  java.awt.Image.SCALE_SMOOTH);  
        return new ImageIcon(resizedImage);
    }

    // Play a sound
    private static void playSound() {
        // This path should also work
        // String wavFilePath = "C:\\Windows\\Media\\tada.wav";
        String wavFilePath = System.getProperty("user.dir") + "\\SampleTestApp\\data\\" + "tada.wav";
        File wavFile = new File(wavFilePath);
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(wavFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            // This would cause the sound to loop 1000 times
            //clip.loop(1000);
            clip.start();
        } catch (Exception e) {
        }
    }

    public static void main(String args[]){

        JFrame frame = new JFrame("My Wumpus GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);

        // Create a basic menu and add it to the top
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("File");
        menuBar.add(menu);

        JMenuItem menuItem = new JMenuItem("Exit");
        menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                System.exit(0);
            }
        });
        menu.add(menuItem);

        frame.getContentPane().add(BorderLayout.NORTH, menuBar);

        // Add a test button with an image on it
        JButton button = new JButton();
        frame.getContentPane().add(button);

        String imagePath = System.getProperty("user.dir") + "\\SampleTestApp\\data\\" + "Dungeon.jpg";
        button.setIcon(loadIcon(imagePath, 600, 600));

        button.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                // Play a sound when the button is clicked
                playSound();
                
                // Call the mock cave object, to simulate the wumpus game code calling into the cave code
                Cave myCave = new Cave();
                int result = myCave.DoStuff(0);

                String message = "Cave DoStuff returned " + result;
                System.out.println(message);
                JOptionPane.showMessageDialog(frame, message, "My popup dialog", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        frame.setVisible(true);
    }
}