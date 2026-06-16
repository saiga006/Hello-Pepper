## Hello Pepper !!
Sample implementation of android app which invokes Pepper Robot (Softbank Robotics) to say "Hello Pepper" **using QiSdk v1.7.5 and Android Studio Bumblebee | 2021.1.1 Patch 3.** 

## Directory Structure

The repository is split into the following sub-directories:

```text
'app'           application-related files
'app/libs'      jar files for libraries used by the application
'app/src/main'  source code for the application
'settings.gradle'        build configuration files necessary to download qisdk from maven to the project
'app/build.gradle'        build configuration files necessary to link qisdk plugin to the app    
```
This application is split into the following subdirectories:

```text
'assets'    data and miscellaneous files used in the application contains qisdk config and version details
'java'      Java source code for the application
'res'       media files used in the application
'AndroidManifest.xml'      contains app configuration, permissions required, features required for functioning
```

The source code of the application itself is in the directory './java/com/pepper/helloapp'.

For more information on the syntax of these files, read [this Pepper tutorial by TU/e](https://dsdwiki.wtb.tue.nl/wiki/Pepper_Tutorial).

Here are the links to the official documentation for the QiChat module and QiSdk setup:
- http://doc.aldebaran.com/2-1/naoqi/audio/dialog/aldialog_syntax_cheat_sheet.html
- http://doc.aldebaran.com/2-1/naoqi/audio/dialog/dialog-syntax_full.html#qichat-syntax
- https://android.aldebaran.com/sdk/doc/pepper-sdk/ch1_gettingstarted/installation.html
- https://qisdk.softbankrobotics.com/sdk/doc/pepper-sdk/ch1_gettingstarted/starting_project.html

QiSdk troubleshooting link:
- https://stackoverflow.com/questions/59566621/pepper-robot-emulator-is-not-starting
- https://stackoverflow.com/questions/69723789/connecting-to-pepper-robot
- https://www.perplexity.ai/search/c12f9940-4f9c-438e-84b9-d4992f516bde
- https://github.com/softbankrobotics-labs/additional-documentation-pepper-running-naoqi-2-9-android-version/tree/master

## ADB Connection to Pepper Robot

Pepper runs on Android, so the connection can be established via **ADB (Android Debug Bridge)** to run commands directly on the robot. You need to [install](https://developer.android.com/tools/releases/platform-tools) android platform tools to access adb.

### 1. Setting up ADB and connecting to Pepper

#### A. Get the IP address of Pepper
#### B. Connect to Pepper via adb
Move to the location of platform tools
```bash
./adb connect <IP address of Pepper>
```
#### C. Check the list of attached devices

```bash
./adb devices
```
Once connected, the device name will also pop up in the android sudio.
 
For more general instructions follow the link here:

[ADB Setup Guide for Pepper Robot](https://gist.github.com/Pulimet/5013acf2cd5b28e55036c82c91bd56d8)

Once connected, you can execute ADB commands on Pepper.

---

### 2. Example: Reaching the home screen

For example, to make Pepper return to the **home screen**, you can use:

```bash
./adb shell input keyevent 3
```
OR

```bash
./adb shell input keyevent KEYCODE_HOME
```

>[!NOTE]
When Pepper is not speaking while running the App, check if the NaoQi is active. In case NaoQi is not active in Pepper, disconnect from WiFi and reconnect.
