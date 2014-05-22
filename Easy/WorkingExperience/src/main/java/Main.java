import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/*
  Author: Robert Stern (lexandro2000@gmail.com)
  All of my solutions are available from https://github.com/lexandro/codeeval
 */
public class Main {

    private static final Calendar calendar1 = Calendar.getInstance();
    private static final Calendar calendar2 = Calendar.getInstance();

    public static void main(String[] args) throws Throwable {
        solveChallenge(args);
    }

    private static void solveChallenge(String[] args) throws Throwable {
        BufferedReader reader = new BufferedReader(new FileReader(new File(args[0])));
        String fileLine;
        //
        while ((fileLine = reader.readLine()) != null) {
            System.out.println(workingExperience(fileLine));
        }
    }

    private static int workingExperience(String fileLine) throws ParseException {
        String[] intervalsString = fileLine.split("; ");
        //
        List<Interval> intervalList = convertToSortedIntervalList(intervalsString);
        //
        int diff = calculateSumOfMonths(intervalList);
        //
        return diff / 12;
    }

    private static List<Interval> convertToSortedIntervalList(String[] intervalsString) throws ParseException {
        List<Interval> result = convertToIntervalList(intervalsString);
        //
        Collections.sort(result);
        //
        return convertToMergedIntervalList(result);
    }


    private static int calculateSumOfMonths(List<Interval> intervalList) {
        int diff = 0;
        for (Main.Interval interval : intervalList) {
            diff += differenceInMonths(interval.startDate, interval.endDate);
        }
        return diff;
    }

    private static List<Interval> convertToMergedIntervalList(List<Interval> intervals) throws ParseException {
        //
        List<Interval> result = new LinkedList<>();
        Iterator<Interval> iterator = intervals.iterator();
        Interval interval = iterator.next();
        Date startDate = interval.startDate;
        Date endDate = interval.endDate;

        while (iterator.hasNext()) {
            interval = iterator.next();
            if (endDate.before(interval.startDate)) {
                Interval newInterval = new Interval(startDate, endDate);
                result.add(newInterval);
                startDate = interval.startDate;
                endDate = interval.endDate;

            } else if (endDate.before(interval.endDate)) {
                endDate = interval.endDate;
            }
        }
        result.add(new Interval(startDate, endDate));
        return result;
    }

    private static List<Interval> convertToIntervalList(String[] intervalsString) throws ParseException {
        List<Interval> result = new LinkedList<>();
        for (String intervalString : intervalsString) {
            result.add(new Interval(intervalString.split("-")));
        }
        return result;
    }

    private static int differenceInMonths(Date d1, Date d2) {
        calendar1.setTime(d1);
        calendar2.setTime(d2);
        //
        int diff = 1;
        while (calendar2.after(calendar1)) {
            calendar1.add(Calendar.MONTH, 1);
            if (calendar2.after(calendar1)) {
                diff++;
            }
        }
        return diff;
    }

    /* ******************************************************************************************************************************** */
    private static class Interval implements Comparable {

        private Date startDate;
        private Date endDate;
        //
        private static Calendar calendar = Calendar.getInstance();
        private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM yyyy");

        private Interval(String[] dateStrings) throws ParseException {
            startDate = firstDayOfTheMonth(simpleDateFormat.parse(dateStrings[0]));
            endDate = lastDayOfTheMonth(simpleDateFormat.parse(dateStrings[1]));
        }

        public Interval(Date startDate, Date endDate) {
            this.startDate = startDate;
            calendar.setTime(endDate);
            calendar.add(Calendar.DATE, -2);
            this.endDate = calendar.getTime();
        }

        private Date lastDayOfTheMonth(Date endDate) {
            calendar.setTime(endDate);
            calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
            calendar.add(Calendar.DATE, 2);
            return calendar.getTime();
        }

        private Date firstDayOfTheMonth(Date startDate) {
            Calendar result = Calendar.getInstance();
            new GregorianCalendar();
            result.setTime(startDate);
            calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
            return result.getTime();
        }

        @Override
        public int compareTo(Object o) {
            Interval otherInterval = (Interval) o;
            if (otherInterval.equals(this)) {
                return 0;
            } else if (otherInterval.startDate.before(this.startDate)) {
                return 1;
            }
            return -1;
        }
    }

}
