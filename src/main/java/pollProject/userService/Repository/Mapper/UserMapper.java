package pollProject.userService.Repository.Mapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import pollProject.userService.Model.User;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class UserMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new User (
                rs.getLong("id"),
                rs.getString("first_name"),
                rs.getString("last_name"),
                rs.getString("email"),
                rs.getInt("age"),
                rs.getString("address"),
                rs.getDate("joined_date"),
                rs.getBoolean("is_registered")
        );
    }
}
