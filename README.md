# Java Wumpus Samples

This project is a sample of how to build Java apps, that demonstrates many of the concepts that will be needed for building a Hunt the Wumpus game. This readme shows how you can contribute to the project.

## Content overview

This repo contains two sample projects, with three apps in them.
* The ChatApp project demonstrates basic file I/O, reading and writing strings to a text file.
* The SampleTestApp project demonstrates how a team might structure their code with test app code located next to the Wumpus object code and Wumpus game code.  There are two executable apps:
  * The WumpusUI is a mock Wumpus game UI that calls a mock Cave object, as well as shows how to load an image on a button and play a sound.
  * The CaveTest is a sample test UI that tests the methods on the mock Cave object.

## Prerequisites

### Install Java runtime (Windows offline 64-bit)
* https://www.java.com/en/download/windows_manual.jsp

### Install awt/swing
Or maybe those just come with the JDK?
* https://docs.oracle.com/javase/8/docs/technotes/guides/awt/index.html
* https://www.oracle.com/java/technologies/downloads/

### Install Visual Studio Code

Visit the [Visual Studio Code website](https://code.visualstudio.com) and install Visual Studio Code.

Launch VSCode and install Microsoft Java debugging extension to run/debug directly from VSCode.

## Getting Started

Open the project in Visual Studio Code:

```powershell
code .
```

## Running the Samples in VSCode

Right-click a java file in VSCode and "Run Java".  The following files should be runnable:
* ChatApp\ChatApp.java
* SampleTestApp\WumpusUI.java
* SampleTestApp\CaveTest\CaveTest.java 

## Running the Samples on the command line

```powershell
java filename.java
```
