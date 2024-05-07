package we.cod.bnz.team;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MessageTeamRepository extends JpaRepository<MessageTeam, Long> {

  @Query(value = "SELECT *   FROM message M   JOIN room R   ON R.id = M.room_id   WHERE room_id = :id", nativeQuery = true)
  List<MessageTeam> findMessageByRoomId(@Param("id") Long roomId);
}
