package we.cod.bnz.member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

  @Query(value = "SELECT * " +
          "FROM Member m " +

          "JOIN Account a " +
          "ON a.id = m.account_id " +

          "JOIN Team t " +
          "ON t.id = m.team_id " +

          "WHERE m.team_id = :team_id " +
          "AND m.account_id = :account_id",

          nativeQuery = true)
  Optional<Member> findMemberByAccountIdAndTeamId(
          @Param("account_id") Long accountId,
          @Param("team_id") Long teamId);
}
