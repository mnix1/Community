package community.friend;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
class FriendRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    FriendRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    void save(Friend friend) {
        String query = "INSERT INTO friend.friend (id, friend_id, created) VALUES (:id, :friendId, :created)";
        MapSqlParameterSource params = new MapSqlParameterSource("id", friend.getId())
                .addValue("friendId", friend.getFriendId())
                .addValue("created", Timestamp.from(friend.getCreated()));
        jdbcTemplate.update(query, params);
    }

    List<Friend> getByIdOrFriendId(String id) {
        String query = "SELECT id, friend_id, created FROM friend.friend WHERE id=:id OR friend_id=:id";
        MapSqlParameterSource params = new MapSqlParameterSource("id", id);
        return jdbcTemplate.query(
                query,
                params,
                (row, i) -> new Friend(row.getString("id"), row.getString("friend_id"), row.getTimestamp("created").toInstant())
        );
    }
}
