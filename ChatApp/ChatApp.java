import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import Modules.FileIO;

public class ChatApp {

  static String userInput = "";
  static JTextArea terminalArea = new JTextArea();

  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
      JFrame frame = new JFrame("Terminal App");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(800, 300);

      terminalArea.setEditable(false); // Make it read-only
      terminalArea.setFont(new Font("Monospaced", Font.PLAIN, 12)); // Use a monospaced font

      loadLogFile();

      // Create an input field
      JTextField inputField = new JTextField();
      inputField.addKeyListener(
        new java.awt.event.KeyAdapter() {
          public void keyPressed(java.awt.event.KeyEvent evt) {
            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
              userInput = inputField.getText();
              // Clear the input field
              inputField.setText("");
              // focus the input field
              update();
            }
          }
        }
      );
      inputField.setFont(new Font("Monospaced", Font.PLAIN, 12)); // Use a monospaced font

      frame.add(new JScrollPane(terminalArea), BorderLayout.CENTER);
      frame.add(inputField, BorderLayout.SOUTH);
      frame.setVisible(true);
      inputField.requestFocus();

      update();
    });
  }

  public static void loadLogFile() {
    // Load chat log from file and display it in the terminal area
    if(FileIO.LoadLogFromFile() == true) {

      terminalArea.setText("");
      terminalArea.append("Welcome to Chat.\n");
      terminalArea.append("Write messages here to chat, or type 'load', 'save', or 'quit'.\n");

      System.out.println("Loaded chat log.");

      int currentLine = 1;
      for (String line : FileIO.ChatLog()) {
        terminalArea.append(currentLine + ": " + line + "\n");
        currentLine++;
      }
    }
    else {
      System.out.println("Chat log not loaded.");
    }
  }

  public static void update() {
    String input = userInput;
    int chatSize = FileIO.ProcessChat(input);
    if (chatSize > 0) {
      terminalArea.append(chatSize + ": " + input + "\n");
    }
  }
}
