package ouhk.comps380f.dao;
import ouhk.comps380f.model.FoodEntry;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

public class FoodEntryRepositoryImpl implements FoodEntryRepository{

    private final JdbcOperations jdbcOp;
    private static final String SQL_INSERT_ENTRY
            = "insert into guestbook (name, message, date) values (?, ?, ?)";
    private static final String SQL_UPDATE_ENTRY
            = "update guestbook set name = ?, message = ?, date = ? where id = ?";
    private static final String SQL_SELECT_ALL_ENTRY
            = "select id, name, message, date from guestbook";
    private static final String SQL_SELECT_ENTRY
            = "select id, name, message, date from guestbook where id = ?";
    private static final String SQL_DELETE_ENTRY
            = "delete from guestbook where id = ?";
    @Autowired
    public FoodEntryRepositoryImpl(DataSource dataSource) {
        jdbcOp = new JdbcTemplate(dataSource);
    }
    private static final class EntryRowMapper implements RowMapper<FoodEntry> {
        @Override
        public FoodEntry mapRow(ResultSet rs, int i) throws SQLException {
            FoodEntry entry = new FoodEntry();
            entry.setItemid(rs.getInt("itemid"));
            entry.setItemname(rs.getString("itemname"));
            entry.setPhoto(rs.getString("photo"));
            entry.setPrice(rs.getDouble("price"));
            entry.setSelling(rs.getBoolean("selling"));
            return entry;
        }
    }
    public FoodEntry getEntryById(Integer id) {
        return jdbcOp.queryForObject(SQL_SELECT_ENTRY, new EntryRowMapper(), id);
    }
    public void removeEntryById(Integer id) {
        jdbcOp.update(SQL_DELETE_ENTRY, id);
    }
    public List<FoodBookEntry> listEntries() {
        return jdbcOp.query(SQL_SELECT_ALL_ENTRY, new EntryRowMapper());
    }
//need to be updated
    public void updateEntry(FoodEntry entry) {
        jdbcOp.update(SQL_UPDATE_ENTRY,
                entry.getName(),
                entry.getMessage(),
                new Timestamp(entry.getDate().getTime()),
                entry.getId());
    }
//need to bbe updated
    public void addEntry(GuestBookEntry entry) {
        jdbcOp.update(SQL_INSERT_ENTRY,
                entry.getName(),
                entry.getMessage(),
                new Timestamp(entry.getDate().getTime())
        );
    }

}
