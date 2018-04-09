# Wi-Fi Direct File Sharing Android Application

Install the app on two seperate Android devices.
Once installed, click on the 'Connect' button and then hit 'Discover' on both devices.
Once both devices have found each other, click on any device to establish a connection.
Click 'Accept' on the recieving device.

Once connected, you can click on 'Open Storage' to explore your device storage and choose an image to send.
Once the 'send' button is clicked, the 'server' device will recieve the file.

'Server' device must have default applications on device to open different file formats e.g. to open a PDF file, you must have a PDF viewer app.

If you wish for another device to become the 'server'.  Both devices must disconnect from each other and both must
hit the 'Forget all groups' button and re-connect.  I.e. the client sends a request to the server, the server accepts.
So make sure if you wish to send a file, you must initiate the connection first.

This app contains other useful features for you to explore but the core feature is as explained above.

# Run on a real device

## Set up your device as follows:

Connect your device to your development machine with a USB cable. If you're developing on Windows, you might need to install the appropriate USB driver for your device.

Enable USB debugging in the Developer options as follows.

    First, you must enable the developer options:
        Open the Settings app.
        (Only on Android 8.0 or higher) Select System.
        Scroll to the bottom and select About phone.
        Scroll to the bottom and tap Build number 7 times.
        Return to the previous screen to find Developer options near the bottom.

    Open Developer options, and then scroll down to find and enable USB debugging.

Run the app on your device as follows:

    In Android Studio, click the app module in the Project window and then select Run > Run (or click Run in the toolbar).
    In the Select Deployment Target window, select your device, and click OK.

Android Studio installs the app on your connected device and starts it. You should now see "Hello World!" displayed in the app running on your device.


# Optional
## Generating APK File
## Android Studio
    Click the dropdown menu in the toolbar at the top
    Select "Edit Configurations"
    Click the "+"
    Select "Gradle"
    Choose your module as Gradle project
    In Tasks: enter assemble
    Press Run

Your unsigned apk is now located in:
  ProjectName\app\build\outputs\apk
  
See below link on how to install APK file directly:
  https://www.wikihow.com/Install-APK-Files-from-a-PC-on-Android
