<img src="http://i.imgur.com/6GWQNtr.png">

# Team 19 - WeatherApp

Made for the second-year CS2212b: Introduction to Software Engineering course in the Department of Computer Science at Western University in London, Ontario, Canada

## Synopsis

WeatherApp is a weather-viewing program that allows users to view the current, short- and long-term forecasts in their current location.

WeatherApp was developed in Java and has a Swing graphical user interface. The program obtains its weather data by connecting to [openweathermap.org](http://openweathermap.org/api)'s API. Data from openweathermap.org's API is obtained in JSON format and handled using [json.org](http://www.json.org/java/index.html)'s source code.

## Installation

Downloading and running the application is simple!
Simply download the JAR from our repository (Visible directly above this readme)
Next, navigate to the JAR's folder and run the following command:
```
$ java -jar weatherapp-0.0.1-SNAPSHOT-jar-with-dependencies.jar
```
As soon as you run that command, the application will launch!
As well, the data save file will be automatically created if it does not already exist.

## Build
If you would like to package/build the application yourself, you would use the following:
```
$ git clone https://github.com/UWO-2212-W2015/team19.git
$ cd weatherapp/
$ mvn package
```
You will need Java 7 or later.

#### Dependencies
- org.json (20090211)
- junit (3.8.1)

## Usage Example

A narrated video demonstrating the use and various features of the WeatherApp program can be viewed by clicking the thumbnail below.

<a href="http://www.youtube.com/watch?feature=player_embedded&v=-uPnkzjPZyQ
" target="_blank"><img src="http://img.youtube.com/vi/-uPnkzjPZyQ/0.jpg" 
alt="Youtube Video Link" width="240" height="180" border="10" /></a>

## Documentation

Full documentation for this program can be found [here](https://github.com/UWO-2212-W2015/team19/tree/master/weatherapp/doc).
To view, simply download the files and open the index.html file.
