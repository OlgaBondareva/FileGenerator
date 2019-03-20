package task.work;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TaskString {
    public static final String TABLE_NAME = "all_files";
    public static final String DATE_COLUMN = "date";
    public static final String LATIN_STRING_COLUMN = "latin_string";
    public static final String RUSSIAN_STRING_COLUMN = "russian_string";
    public static final String INTEGER_NUMBER_COLUMN = "integer_number";
    public static final String REAL_NUMBER_COLUMN = "real_number";

    private Date date;
    private String latinString;
    private String russianString;
    private long intNumber;
    private double realNumber;
    private String outputString;

    public Date getDate() {
        return date;
    }

    public java.sql.Date getSQLDate() {
        return new java.sql.Date(date.getTime());
    }

    public String getLatinString() {
        return latinString;
    }

    public String getRussianString() {
        return russianString;
    }

    public long getIntNumber() {
        return intNumber;
    }

    public double getRealNumber() {
        return realNumber;
    }

    public TaskString() {
        this.date = null;
        this.latinString = "";
        this.russianString = "";
        this.intNumber = 0;
        this.realNumber = 0;
        this.outputString = "";
    }

    public TaskString(String fullString) {
        String[] parts = fullString.split("//");

        DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        try {
            this.date = formatter.parse(parts[0]);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.latinString = parts[1];
        this.russianString = parts[2];
        this.intNumber = Integer.parseInt(parts[3]);
        this.realNumber = Double.parseDouble(parts[4]);
    }

    private void setDate() {
        long currentDate = new Date().getTime();
        long minDate = currentDate - Utils.fiveYearsInMillis;
        long maxDate = currentDate - minDate;

        long randomDate = minDate + (long) (Math.random() * (maxDate + 1));
        this.date = new Date(randomDate);
    }

    private void setLatinString() {
        var stringLength = 10;
        StringBuilder outputString = new StringBuilder(stringLength);

        while (stringLength-- > 0) {
            outputString.append(Utils.getLatinSymbol());
        }

        this.latinString = outputString.toString();
    }

    private void setRussianString() {
        var stringLength = 10;
        StringBuilder outputString = new StringBuilder(stringLength);

        while (stringLength-- > 0) {
            outputString.append(Utils.getRussianSymbol());
        }

        this.russianString = outputString.toString();
    }

    private void setIntNumber() {
        var rightLimit = 100000000;
        var leftLimit = 1;
        var max = rightLimit - leftLimit;
        int number;

        number = leftLimit + (int) (Math.random() * (max + 1));
        if (number % 2 != 0) {
            number += 1;
        }
        this.intNumber = number;
    }

    private void setDoubleNumber() {
        StringBuilder number = new StringBuilder();
        var leftLimit = 1;
        var rightLimit = 20;
        var max = rightLimit - leftLimit;
        var fractionLength = 8;

        number.append(leftLimit + (int) ((Math.random()) * (max + 1)));
        number.append(".");

        while (fractionLength-- > 0) {
            number.append((int) (Math.random() * 10));
        }

        this.realNumber = Double.parseDouble(number.toString());
    }

    private void setOutputString() {
        String separator = "//";

        setDate();
        setLatinString();
        setRussianString();
        setIntNumber();
        setDoubleNumber();

        StringBuilder tmp = new StringBuilder();
        var formatForDate = new SimpleDateFormat("dd.MM.yyyy");
        tmp.append(formatForDate.format(this.date))
                .append(separator)
                .append(this.latinString)
                .append(separator)
                .append(this.russianString)
                .append(separator)
                .append(this.intNumber)
                .append(separator)
                .append(this.realNumber)
                .append(separator);

        this.outputString = tmp.toString();
    }

    public String getFullString() {
        setOutputString();

        return this.outputString;
    }

}
