package task.db;

import task.work.TaskString;

import javax.sql.DataSource;

public interface ITaskStringDB {
    String SQL_INSERT =
            "insert into " + TaskString.TABLE_NAME + " (" +
                    TaskString.DATE_COLUMN + ", " +
                    TaskString.LATIN_STRING_COLUMN + ", " +
                    TaskString.RUSSIAN_STRING_COLUMN + ", " +
                    TaskString.INTEGER_NUMBER_COLUMN + ", " +
                    TaskString.REAL_NUMBER_COLUMN +
                    ") values (?, ?, ?, ?, ?)";

    void setDataSource(DataSource dataSource);

    void insert(TaskString taskString);
}
