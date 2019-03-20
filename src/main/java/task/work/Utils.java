package task.work;

import java.io.File;

public class Utils {

    public static final long fiveYearsInMillis = 157766400000L;
    public static final String englishAlphabet
            = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String russianAlphabet
            = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяФБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";

    public static char getLatinSymbol() {
        var alphabetLength = 52;

        return englishAlphabet.toCharArray()[(int) (Math.random() * alphabetLength)];
    }

    public static char getRussianSymbol() {
        var alphabetLength = 66;

        return russianAlphabet.toCharArray()[(int) (Math.random() * alphabetLength)];
    }

    public static boolean createFileFolder() {
        File folder = new File(System.getProperty("user.dir") + File.separator + "files");
        if (!folder.exists()) {
            return folder.mkdir();
        } else {
            return false;
        }
    }

    public static String getFilesFolder() {
        return System.getProperty("user.dir") + File.separator + "files";
    }

}
