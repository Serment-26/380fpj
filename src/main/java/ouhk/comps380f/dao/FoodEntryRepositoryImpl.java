package ouhk.comps380f.dao;

import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.SqlLobValue;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.jdbc.support.lob.DefaultLobHandler;
import org.springframework.jdbc.support.lob.LobHandler;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import ouhk.comps380f.model.FoodEntry;

@Repository
public class FoodEntryRepositoryImpl implements FoodEntryRepository{

    private JdbcOperations jdbcOp;

    private static final String SQL_INSERT_ENTRY
            = "insert into food (name, message, date) values (?, ?, ?)";
    private static final String SQL_UPDATE_ENTRY
            = "update food set name = ?, message = ?, date = ? where id = ?";
    private static final String SQL_SELECT_ALL_ENTRY
            = "select * from food";
    private static final String SQL_SELECT_ENTRY
            = "select * from food where id = ?";
    private static final String SQL_DELETE_ENTRY
            = "delete from fppd where id = ?";

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
            entry.setPhoto(rs.getInt("photo"));
            entry.setPrice(rs.getDouble("price"));
            entry.setSelling(rs.getBoolean("selling"));
            return entry;
        }
    }

    @Override
    @Transactional(readOnly = true)
    public FoodEntry getEntryById(Integer id) {
        return jdbcOp.queryForObject(SQL_SELECT_ENTRY, new EntryRowMapper(), id);
    }

    @Override
    @Transactional
    public void removeEntryById(Integer id) {
        jdbcOp.update(SQL_DELETE_ENTRY, id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<FoodEntry> listEntries() {
        return jdbcOp.query(SQL_SELECT_ALL_ENTRY, new EntryRowMapper());
    }

    @Override
    @Transactional
    public void updateEntry(FoodEntry entry) {
        jdbcOp.update(SQL_UPDATE_ENTRY,entry.getItemid());
                
    }
//need to bbe updated.
    @Override
    @Transactional
    public void addEntry(FoodEntry entry) {
        jdbcOp.update(SQL_INSERT_ENTRY,entry.getItemname());
    }

}
