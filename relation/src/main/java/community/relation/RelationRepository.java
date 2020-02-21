package community.relation;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Repository
class RelationRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    RelationRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    void save(Relation relation) {
        String query = "INSERT INTO friend.friend (requester_id, target_id, created) VALUES (:requesterId, :targetId, :created)";
        MapSqlParameterSource params = new MapSqlParameterSource("requesterId", relation.getRequesterId())
                .addValue("targetId", relation.getTargetId())
                .addValue("created", Timestamp.from(relation.getCreated()));
        jdbcTemplate.update(query, params);
    }

    Set<Relation> find(String id) {
        String query = "SELECT requester_id, target_id, created FROM relation.relation WHERE requester_id=:id OR target_id=:id";
        MapSqlParameterSource params = new MapSqlParameterSource("id", id);
        return new HashSet<>(jdbcTemplate.query(
                query,
                params,
                (row, i) -> new Relation(row.getString("requester_id"), row.getString("target_id"), row.getTimestamp("created").toInstant())
        ));
    }
}
