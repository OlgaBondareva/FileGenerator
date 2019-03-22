package task.db;

import org.springframework.jdbc.core.JdbcTemplate;
import task.work.TaskString;

import javax.sql.DataSource;

public class TaskStringDB {
    public static final String SQL_INSERT =
            "INSERT INTO " + TaskString.TABLE_NAME + " (" +
                    TaskString.DATE_COLUMN + ", " +
                    TaskString.LATIN_STRING_COLUMN + ", " +
                    TaskString.RUSSIAN_STRING_COLUMN + ", " +
                    TaskString.INTEGER_NUMBER_COLUMN + ", " +
                    TaskString.REAL_NUMBER_COLUMN +
                    ") VALUES (?, ?, ?, ?, ?)";

    public static final String SQL_SUM =
            "SELECT SUM(" + TaskString.INTEGER_NUMBER_COLUMN +
                    ") FROM " + TaskString.TABLE_NAME + ";";
    public static final String SQL_MEDIAN =
            "SELECT AVG(aa." + TaskString.REAL_NUMBER_COLUMN + ")" +
                    "FROM ( SELECT a." + TaskString.REAL_NUMBER_COLUMN + ", @row_num := @row_num + 1 AS 'row_number', @total_rows := @row_num " +
                    "FROM " + TaskString.TABLE_NAME + " a, " +
                    "(SELECT @row_num := 0) r ORDER BY a." + TaskString.REAL_NUMBER_COLUMN + ")" + " AS aa " +
                    "WHERE aa.row_number IN (FLOOR((@total_rows + 1) / 2), FLOOR((@total_rows + 2) / 2));";

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

    public long getSum() {
        return jdbcTemplateObject.queryForObject(SQL_SUM, Long.class);
    }

    public double getMedian() {
        return jdbcTemplateObject.queryForObject(SQL_MEDIAN, Double.class);
    }
}
