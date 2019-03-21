package task.db;

import org.springframework.jdbc.core.JdbcTemplate;
import task.work.TaskString;

import javax.sql.DataSource;

public class TaskStringDB {
    public static final String SQL_INSERT =
            "insert into " + TaskString.TABLE_NAME + " (" +
                    TaskString.DATE_COLUMN + ", " +
                    TaskString.LATIN_STRING_COLUMN + ", " +
                    TaskString.RUSSIAN_STRING_COLUMN + ", " +
                    TaskString.INTEGER_NUMBER_COLUMN + ", " +
                    TaskString.REAL_NUMBER_COLUMN +
                    ") values (?, ?, ?, ?, ?)";

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    public void insert(TaskString taskString) {
        jdbcTemplateObject.update(SQL_INSERT,
                taskString.getSQLDate(),
                taskString.getLatinString(),
                taskString.getRussianString(),
                taskString.getIntNumber(),
                taskString.getRealNumber());
    }
}
