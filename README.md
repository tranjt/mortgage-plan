# Mortgage plan
This project is made with Sping boot back-end and Angular front-end. Gradle is used as build tool.

## Running app locally
You can run the app with Gradle via command line or with an IDE

### Running with IDE
In your IDE `Import Project` or `Open...` and navigate to `build.gradle` file.

### Running via command line
`Java` and `Gradle` installed.

You might need to configure path to `tools.jar` if not found
create/edit `gradle.properties` configure this java path to where your `tool.jar` file is located on your system.

In windows it might look like this

`org.gradle.java.home=C:\Program Files\Java\jdk1.8.0_221`

#### Run commands
Navigate to the root of the project via command line and execute the command

`./gradlew bootRun`

for windows

`gradlew.bat bootRun`

Once the application is running navigate to http://localhost:8080

#### Test commands

`./gradlew test`

for windows

`gradlew.bat test`

Generated HTML test report can be found at

`mortgage-plan\build\reports\tests\test`

