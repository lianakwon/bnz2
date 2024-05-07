package we.cod.bnz.team;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import we.cod.bnz.account.Account;
import we.cod.bnz.account.AccountRepository;
import we.cod.bnz.member.Member;
import we.cod.bnz.member.MemberRepository;
import we.cod.bnz.member.MemberRole;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class TeamService {

  private final TeamRepository repoT;
  private final AccountRepository repoA;
  private final MemberRepository repoM;

  // getTeams 채팅방 목록
  public List<Team> getTeams() {
    return repoT.findAll();
  }

  // makeTeam 채팅방 생성
  public Team createTeam(TeamDTO dto,
                         String username) {
    Optional<Account> accountOpt = repoA.findByUsername(username);
    if (accountOpt.isEmpty()) throw new RuntimeException("creator not found");
    Account member = accountOpt.get();
    Member manager = member.saveManager(dto);
    repoM.save(manager);
    Team team = new Team().makeTeam(dto);
    repoT.save(team);
    return team;
  }

  // editTeam 채팅방 이름 수정
  public Team updateTeam(Long id,
                         TeamDTO dto,
                         String username) {
    Optional<Account> accountOpt = repoA.findByUsername(username);
    if (accountOpt.isEmpty()) throw new RuntimeException("account not found");
    Account account = accountOpt.get();

    Optional<Team> teamOpt = repoT.findById(id);
    if (teamOpt.isEmpty()) throw new RuntimeException("team not exist");
    Team team = teamOpt.get();

    // 요청받은 팀과 어카운트의 정보가 일치하는 멤버가 존재하는가
    Optional<Member> memberOpt = repoM.findMemberByAccountIdAndTeamId(account.getId(), team.getId());
    if (memberOpt.isEmpty()) throw new RuntimeException("member not found");
    Member member = memberOpt.get();
    // 해당 멤버의 권한이 매니저인가
    if (member.getMemberRole() != MemberRole.MANAGER) throw new RuntimeException("no authorization");

    team.editTeam(dto.getTitle());
    repoT.save(team);
    return team;
  }

  // deleteTeam 채팅방 삭제
  public void deleteTeam(Long id,
                         String username) {
    // 받아온 아이디와 일치하는 아이디를 가진 팀이 존재하는가
    Optional<Team> teamOpt = repoT.findById(id);
    if (teamOpt.isEmpty()) throw new RuntimeException("team not exist");
    Team team = teamOpt.get();
    // 받아온 요청자 정보와 일치하는 어카운트가 존재하는가
    Optional<Account> accountOpt = repoA.findByUsername(username);
    if (accountOpt.isEmpty()) throw new RuntimeException("account not exist");
    Account account = accountOpt.get();
    Long accountId = account.getId();
    // 요청받은 팀과 어카운트의 정보가 일치하는 멤버가 존재하는가
    Optional<Member> memberOpt = repoM.findMemberByAccountIdAndTeamId(accountId, id);
    if (memberOpt.isEmpty()) throw new RuntimeException("member not found");
    Member member = memberOpt.get();
    // 해당 멤버의 권한이 매니저인가
    if (member.getMemberRole() != MemberRole.MANAGER) throw new RuntimeException("no authorization");

    repoT.delete(team);
  }

}
