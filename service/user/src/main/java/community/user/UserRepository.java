package community.user;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

@Repository
class UserRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    UserRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    void save(User user) {
        String query = "INSERT INTO user.user (id, created, last_sign_in, sign_in_count) VALUES (:id, :lastSignIn, :lastSignIn, 1) ON DUPLICATE KEY UPDATE " +
                "last_sign_in=:lastSignIn, sign_in_count=sign_in_count+1";
        MapSqlParameterSource params = new MapSqlParameterSource("id", user.getId())
                .addValue("lastSignIn", Timestamp.from(user.getLastSignIn()));
        jdbcTemplate.update(query, params);
    }
}
