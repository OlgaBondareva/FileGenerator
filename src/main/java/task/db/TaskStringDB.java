package task.db;

import org.springframework.jdbc.core.JdbcTemplate;
import task.work.TaskString;

import javax.sql.DataSource;

public class TaskStringDB implements ITaskStringDB {
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
