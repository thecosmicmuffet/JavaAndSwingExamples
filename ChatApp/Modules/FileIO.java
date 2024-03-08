package Modules;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JFileChooser;

public class FileIO
{
  // Chat message log is stored in an ArrayList of strings while the program is running
  private static ArrayList<String> chatLog = new ArrayList<String>();
  
  // Name of the file the log is saved to
  private static final String chatLogFileName = "chatLog.txt";
  
  // Get the full path to the the default log file
  private static String GetDefaultLogFileName() {
    return System.getProperty("user.dir") + "\\ChatApp\\data\\" + chatLogFileName;
  }

  // Choose a file to read/write the log file to.  Returns null if the user chose to cancel.
  private static String ChooseLogFilePath() {
    // First see if the default file exists
    String filePath = GetDefaultLogFileName();
    File defaultFile = new File(filePath);
    if (!defaultFile.exists() || !defaultFile.isFile()) {
      System.out.println("Default file does not exist: " + filePath);

      // The file doesn't exist - ask the user to choose a file
      JFileChooser fileChooser = new JFileChooser();
      fileChooser.setDialogTitle("Select chat log File");
      fileChooser.setFileFilter(new FileNameExtensionFilter("Text Files", "txt"));
      fileChooser.setSelectedFile(new File(chatLogFileName));
      int userSelection = fileChooser.showOpenDialog(null);
      if (userSelection == JFileChooser.APPROVE_OPTION) {
        filePath = fileChooser.getSelectedFile().getAbsolutePath();
      } else {
        filePath = null;
      }
    }

    return filePath;
  }

  // Load the chat message log from the file into the chatLog list.
  // Returns true if a log was loaded, false if not.
  public static boolean LoadLogFromFile() {
    String filePath = ChooseLogFilePath();
    System.out.println("Attempting to load file: " + filePath);
    if (filePath != null) {
      try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
        String line;
        while ((line = reader.readLine()) != null) {
          chatLog.add(line);
        }
        System.out.println("Chat log loaded successfully.");
        return true;

      } catch (IOException e) {
        System.out.println("Error loading file: " + e.getMessage());
      }
    }

    System.out.println("Log file not loaded. Starting fresh chat log.");
    return false;
  }

  // Returns the current log
  public static final ArrayList<String> ChatLog() {
    return chatLog;
  }

  // Write the log from chatLog out to a file
  private static boolean SaveLogToFile() {
    String filePath = ChooseLogFilePath();
    System.out.println("Attempting to save file: " + filePath);
    if (filePath != null) {
      try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
        for (int i = 0; i < chatLog.size(); i++) {
          writer.write(chatLog.get(i));
          writer.newLine();
        }
        System.out.println("Log saved successfully.");
        return true;

      } catch (IOException e) {
        System.out.println("Error saving: " + e.getMessage());
      }
    }
    return false;
  }

  public enum ChatCommand
  {
    None,
    Load,
    Save,
    Quit
  }

  // Convenience class for recognizing commands such as Load and Save when entered in Chat
  static class ChatCommands
  {
    private static final String Load = "Load";
    private static final String Save = "Save";
    private static final String Quit = "Quit";

    public static ChatCommand GetCommand(String chat)
    {
      if (chat.equalsIgnoreCase(ChatCommands.Load))
      {
        return ChatCommand.Load;
      }
      else if(chat.equalsIgnoreCase(ChatCommands.Save))
      {
        return ChatCommand.Save;
      }
      else if(chat.equalsIgnoreCase(ChatCommands.Quit))
      {
        return ChatCommand.Quit;
      }
      else
      {
        return ChatCommand.None;
      }
    }
  }

  // Take a chat message the user typed, check if it's a command (and process it if so),
  // or add the message to the chatLog.
  public static int ProcessChat(String chat)
  {
    if(chat == null || chat.isEmpty())
    {
      return 0;
    }

    // Check for chat commands with a switch
    ChatCommand cmd = ChatCommands.GetCommand(chat);
    switch(cmd)
    {
      case Load:
        LoadLogFromFile();
        return 0;
      case Save:
        SaveLogToFile();
        return 0;
      case Quit:
        SaveLogToFile();
        System.exit(0);
        break;
      default:
        // It's not a command - add it to the chatLog
        chatLog.add(chat);
        break;
    }

    return chatLog.size();
  }
}
