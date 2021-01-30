# TimeCalculator

This Repo contains code that adds minutes to the input time and returns the final time. The Business Logic of adding minutes to given time
resides in the `TimeCalculator.java` file. Within the above mentioned
file the logic resides in the method `addMinutes`. 

## Requirments Of the System to Run The Project
1. Java 8
2. Maven

## Assumptions made
When we add minutes to the input time, its assumed that we only output
the time of the resulting output not the days. Example is If we add 1 day 10 minutes ( 1450 minutes) to 9:40 PM, the output
shows only the time component which would be 9:50 PM though effectivelys its 9:50 PM of next day. 
## Exception Handling
As Part of the Prject, I have created two custom classes that extend `Exception` class namely 
1) `NullEmptyCheckException`  - This exception handles null or empty input time
2) `TimeFormatException` - This exception handles if the input time is as per the format mentioned in the doc ``[H]H:MM {AM|PM}``

## How to run the program
1. Clone the Project into your local repo and run  `mvn clean install`. This will create the executable jar
2. Now run `java -jar target/AddMinutes-1.0-SNAPSHOT.jar argument1(input time) argument2(minutes to add) eg: java -jar target/AddMinutes-1.0-SNAPSHOT.jar "10:30 AM" 120`
3. The output will be displayed in the command line argument `eg: 12:30 PM`
## Code coverage

I have written the unit tests in the test class that covers all the scenarios. The unit
test coverage stands at 100% for all the classes and 91% line coverage. Below screenshot shows
the same.
![Unit Test Coverage](src/main/resources/CodeCoverage_screenshot.png?raw=true )