import exception.NullEmptyCheckException;
import exception.NullEmptyCheckException;
import exception.TimeFormatException;


import static java.util.Objects.isNull;

public class TimeCalculator {

    // variable that holds number of minutes in a day
    private static  final int NUMBER_OF_MINUTES_IN_DAY = 1440;


    public static void main(String[] args) throws NullEmptyCheckException, TimeFormatException {
        TimeCalculator obj = new TimeCalculator();
        System.out.println(obj.addMinutes(args[0], Integer.valueOf(args[1])));
    }

    /**
     * This method adds the minutes to the given time and returns the resulting time back.
     * @param time                 - time represented as string in format [H]H:MM {AM|PM}
     * @param minutesToAdd         - signed int that represents number of minutes to be added to the time
     * @return                     - return the resulting time formed as string
     * @throws NullEmptyCheckException  - if the time string is empty or null
     * @throws TimeFormatException - if the time string is not in the format ([H]H:MM {AM|PM}
     */
    public String addMinutes(String time, int minutesToAdd) throws NullEmptyCheckException, TimeFormatException {

        /* check if the time string is empty or null */
        if(isNull(time) || time.length() == 0) {
            throw new NullEmptyCheckException("Time String cannot be null or empty");
        }

        /* check if the input time string is as per the format mentioned in the doc ([H]H:MM {AM|PM})*/
        String[] timeString = time.split("\\s+");
        if(timeString.length != 2) {
            throw new TimeFormatException("Input timeString should be in the the the format \"[H]H:MM {AM|PM}\" but found "+time);
        }

        // extract the minutes, hour and meridian indicators from the time string
        int currentHourMinutes = Integer.valueOf(timeString[0].split(":")[1]);
        int currentHour = Integer.valueOf(timeString[0].split(":")[0]);
        String meridianIndicator = timeString[1];

        // if effective minutes after adding the incoming minutes to input is less than 59 than only minutes will change
        if(minutesToAdd+currentHourMinutes < 60 && (minutesToAdd+currentHourMinutes) >= 0) {
            return formatTimeToString(currentHour, currentHourMinutes + minutesToAdd, meridianIndicator);
        }
        else {
            if(meridianIndicator.equalsIgnoreCase("PM")) {
                currentHour = currentHour+12;
            }
            int totalMinutes = currentHour * 60 + minutesToAdd + currentHourMinutes;
            totalMinutes = totalMinutes % NUMBER_OF_MINUTES_IN_DAY;

            if(totalMinutes < 60) {  // time is b/w 12:00 AM and 12:59 AM
                return formatTimeToString(12, totalMinutes, "AM");
            }
            else if(totalMinutes > 60 && totalMinutes <= 719) { // time is b/w 1:00 AM and 11:59 AM
                return formatTimeToString(totalMinutes / 60, totalMinutes % 60, "AM" );
            }
            else if(totalMinutes >= 720 && totalMinutes < 780) { // time is b/w 12:00 PM and 12:59 PM
                return formatTimeToString(12, totalMinutes % 60, "PM" );
            }
            else { // time is b/w 1:00 PM and 11:59 PM
                return formatTimeToString(totalMinutes/60 - 12, totalMinutes % 60, "PM");
            }
        }
    }

    /**
     * util method that formats the input hours, minutes and meridianIndicator to the required format and returns
     * @param hour                - hour of the time (0 - 12)
     * @param minutes             - minutes of the time (0-59)
     * @param meridianIndicator   - meridian Indicator (AM/PM)
     * @return                    - String formed with the given inputs
     */
    private String formatTimeToString(int hour, int minutes, String meridianIndicator) {
        StringBuffer resultingTime = new StringBuffer();
        resultingTime.append(hour);
        resultingTime.append(":");
        resultingTime.append(String.format("%02d", minutes));
        resultingTime.append(" ");
        resultingTime.append(meridianIndicator);
        return resultingTime.toString();
    }
}