-----------------------
Application Name : "The Werewolves of Millers Hollow"
Version : "1.0" ?
Author : Tiffany Dumaire, Aaron Lazaroo, Clarence Rouvel
-----------------------
Preparation before launching the application : 

1 - Download the jar file named : "The_Werewolves_Of_Millers_Hollow.jar" on the link : https://drive.google.com/file/d/1rPDIqVYCB5FEyLI4uGleGjvjXK_4VIjR/view?usp=sharing
2 - Download the jar file named : "mysql-connector-java-8.0.18.jar" on the link : https://drive.google.com/file/d/196bCdApOQ6xIWjmWg67RoahTI28Sog-j/view?usp=sharing
3 - Download the rar file named : "javafx-sdk-13.0.1.rar" on the link : https://drive.google.com/file/d/1dCYnTJ0zdjWc08N3GEAScvAJU7xQo19b/view?usp=sharing

Step by step : 
-> Place the first jar file in the root of the project.
-> Place the other file in a new folder "sources" in the root of the project.
-----------------------
Command to launch the application : 
java --module-path ".\sources\javafx-sdk-13.0.1\lib" --add-modules javafx.controls,javafx.fxml -Dfile.encoding=Cp1252 -classpath ".\bin;.\sources\mysql-connector-java-8.0.18.jar" application.TheWerewolvesOfMillersHollow -Dfile.encoding=Cp1252 -jar -Xmx1024m The_Werewolves_Of_Millers_Hollow.jar
