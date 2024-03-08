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
  // chat message log ArrayList
  public static ArrayList<String> chatLog = new ArrayList<String>();
  static final String chatLogFileName = "chatLog.txt";

  public static int LoadLogFromFile(String defaultName) {
    JFileChooser fileChooser = new JFileChooser();
    fileChooser.setDialogTitle("Select chat log File");
    fileChooser.setFileFilter(new FileNameExtensionFilter("Text Files", "txt"));
    if(defaultName == null || defaultName.isEmpty())
    {
      defaultName = chatLogFileName;
    }
    // set the default file name to defaultName
    fileChooser.setSelectedFile(new File(defaultName));

    int userSelection = fileChooser.showOpenDialog(null);
    if (userSelection == JFileChooser.APPROVE_OPTION) {
      String filePath = fileChooser.getSelectedFile().getAbsolutePath();
      try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
        String line;
        while ((line = reader.readLine()) != null) {
          chatLog.add(line);
        }
        System.out.println("Chat log loaded successfully.");
      } catch (IOException e) {
        System.out.println("Error loading file: " + e.getMessage());
      }
    } else if(userSelection == JFileChooser.CANCEL_OPTION){
      System.out.println("Log file not loaded. Starting fresh chat log.");
    }

    return userSelection;
  }

  public static final ArrayList<String> ChatLog() {
    return chatLog;
  }

  static void SaveLogToFile(String defaultName) {
    JFileChooser fileChooser = new JFileChooser();
    fileChooser.setDialogTitle("Save Log File");
    fileChooser.setFileFilter(new FileNameExtensionFilter("Text Files", "txt"));
    fileChooser.setApproveButtonText("Save");
    if(defaultName == null || defaultName.isEmpty())
    {
      defaultName = chatLogFileName;
    }
    fileChooser.setSelectedFile(new File(defaultName));

    int userSelection = fileChooser.showSaveDialog(null);
    if (userSelection == JFileChooser.APPROVE_OPTION) {
      String filePath = fileChooser.getSelectedFile().getAbsolutePath();
      try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
        for (int i = 0; i < chatLog.size(); i++) {
          writer.write(chatLog.get(i));
          writer.newLine();
        }
        System.out.println("Log saved successfully.");
      } catch (IOException e) {
        System.out.println("Error saving: " + e.getMessage());
      }
    }
  }

  public enum ChatCommand
  {
    None,
    Load,
    Save,
    Quit
  }

  // convenience class for recognizing commands such as Load and Save when entered in Chat
  static class ChatCommands
  {
    static final String Load = "Load";
    static final String Save = "Save";
    static final String Quit = "Quit";

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

  public static int ProcessChat(String chat)
  {
    if(chat == null || chat.isEmpty())
    {
      return 0;
    }

    // check for chat commands with a switch
    ChatCommand cmd = ChatCommands.GetCommand(chat);
    switch(cmd)
    {
      case Load:
        LoadLogFromFile(null);
        return 0;
      case Save:
        SaveLogToFile(null);
        return 0;
      case Quit:
        SaveLogToFile(null);
        System.exit(0);
        break;
      default:
        chatLog.add(chat);
        break;
    }

    return chatLog.size();
  }
}
