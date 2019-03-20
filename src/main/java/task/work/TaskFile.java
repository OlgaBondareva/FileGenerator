package task.work;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TaskFile {

    public final static int numberOfStrings = 100000;

    public void createFile(int fileNumber) {
        var fileName = Utils.getFilesFolder() + File.separator + fileNumber + ".txt";
        var string = new TaskString();

        try (FileWriter file = new FileWriter(fileName, true)) {
            for (var i = 0; i < numberOfStrings; i++) {
                file.write(string.getFullString());
                file.write("\n");
            }
        } catch (IOException io) {
            System.out.println("Cannot create file! Check the error message:");
            System.out.println(io.getMessage());
        }
    }
}
