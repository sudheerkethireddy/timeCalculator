# timeCalculator

This Repo contains code that adds minutes to the input time and returns the final time. The Business Logic of adding minutes to given time
resides in the `TimeCalculator.java` file. Within the above mentioned
file the logic resides in the method `addMinutes`. 

## Requirments Of the System to Run The Project
1. Java 8
2. Maven

## Exception Handling
As Part of the Prject, I have created two custom classes that extend `Exception` class namely 
1) `NullEmptyCheckException`  - This exception handles null or empty input time
2) `TimeFormatException` - This exception handles if the input time is as per the format mentioned in the doc ``[H]H:MM {AM|PM}``

## Code coverage

I have written the unit tests in the test class that covers all the scenarios. The unit
test coverage stands at 100% for all the classes that are created. Below screenshot shows
the same.
![Unit Test Coverage](src/main/resources/CodeCoverage_screenshot.png?raw=true )