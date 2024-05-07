package we.cod.bnz.member;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberPreRepository extends JpaRepository<MemberPre, Long> {
//  Optional<MemberPre> findMemberPreByUsername(String username);

  Optional<MemberPre> findMemberPreByAccountIdAndTeamId(Long accountId, Long teamId);
}
