package we.cod.bnz.member;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import we.cod.bnz.account.Account;
import we.cod.bnz.account.AccountRepository;
import we.cod.bnz.team.Team;
import we.cod.bnz.team.TeamRepository;

import java.security.Principal;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

  private final TeamRepository repoT;
  private final AccountRepository repoA;
  private final MemberRepository repoM;
  private final MemberPreRepository repoMP;

  public MemberPre getMembers(Long id, Principal principal) {
    return null;
  }

  // putInTeam 팀 초대
  // 예비멤버(TeamMemberPre) 엔티티 생성
  public MemberPre putInTeam(Long id,
                             MemberRequestDTO req,
                             Principal principal) {
    // req 와 일치하는 팀이 존재하는가 + 있다면 team 으로 선언
    Optional<Team> teamOpt = repoT.findById(req.getTeam().getId());
    if (teamOpt.isEmpty()) throw new RuntimeException("team not exist");
    Team team = teamOpt.get();
    // req 와 일치하는 어카운트가 존재하는가 + 있다면 target 으로 선언
    Optional<Account> targetOpt = repoA.findById(req.getAccount().getId());
    if (targetOpt.isEmpty()) throw new RuntimeException("target not exist");
    Account target = targetOpt.get();

    // principal 과 일치하는 어카운트가 존재하는가 + 있다면 account 으로 선언
    Optional<Account> accountOpt = repoA.findByUsername(principal.getName());
    if (accountOpt.isEmpty()) throw new RuntimeException("account not exist");
    Account account = accountOpt.get();
    // team, account 와 일치하는 member 가 존재하는가 + 있다면 member 으로 선언
    Optional<Member> memberOpt = repoM.findMemberByAccountIdAndTeamId(account.getId(), team.getId());
    if (memberOpt.isEmpty()) throw new RuntimeException("member not found");
    Member member = memberOpt.get();
    // member 의 권한이 매니저인가
    if (member.getMemberRole() != MemberRole.MANAGER) throw new RuntimeException("no authorization");

    // target 을 새로운 예비멤버 엔티티로 만들어라
    MemberPre memberPre = new MemberPre(null, team, target);
    return memberPre;
  }

  // getInTeam 팀 초대 수락
  // 예비멤버(TeamMemberPre) 엔티티 삭제
  // 멤버(TeamMember) 엔티티 생성
  public Member getInTeam(Long id,
                          MemberRequestDTO req,
                          Principal principal) {
    // req 와 일치하는 팀이 존재하는가 + 있다면 team 으로 선언
    Optional<Team> teamOpt = repoT.findById(req.getTeam().getId());
    if (teamOpt.isEmpty()) throw new RuntimeException("team not exist");
    Team team = teamOpt.get();
    // req 와 일치하는 어카운트가 존재하는가 + 있다면 target 으로 선언
    Optional<Account> targetOpt = repoA.findById(req.getAccount().getId());
    if (targetOpt.isEmpty()) throw new RuntimeException("target not exist");
    Account target = targetOpt.get();
    // principal 와 target 이 일치하는가
    if (!target.getUsername().equals(principal.getName()))
      throw new RuntimeException("principal and target not correct");

    // team, target 정보가 일치하는 memberPre 가 존재하는가 + 있다면 memberPre 으로 선언
    Optional<MemberPre> memberPreOpt = repoMP.findMemberPreByAccountIdAndTeamId(target.getId(), team.getId());
    if (memberPreOpt.isEmpty()) throw new RuntimeException("member not found");
    MemberPre memberPre = memberPreOpt.get();
    // memberPre 정보로 새로운 member 객체 생성, memberPre 를 memberPreList 에서 삭제
    Member member = new Member(null, team, memberPre.getAccount(), MemberRole.MEMBER);
    repoMP.delete(memberPre);
    return member;
  }

  // getInTeam 채팅방 초대 거절
  // 예비멤버(TeamMemberPre) 엔티티 삭제
  public void getInTeamNot(Long id,
                           MemberRequestDTO req,
                           Principal principal) {
    // req 와 일치하는 팀이 존재하는가 + 있다면 team 으로 선언
    Optional<Team> teamOpt = repoT.findById(req.getTeam().getId());
    if (teamOpt.isEmpty()) throw new RuntimeException("team not exist");
    Team team = teamOpt.get();
    // req 와 일치하는 어카운트가 존재하는가 + 있다면 target 으로 선언
    Optional<Account> targetOpt = repoA.findById(req.getAccount().getId());
    if (targetOpt.isEmpty()) throw new RuntimeException("target not exist");
    Account target = targetOpt.get();
    // principal 와 target 이 일치하는가
    if (!target.getUsername().equals(principal.getName()))
      throw new RuntimeException("principal and target not correct");

    // team, target 정보가 일치하는 memberPre 가 존재하는가 + 있다면 memberPre 으로 선언
    Optional<MemberPre> memberPreOpt = repoMP.findMemberPreByAccountIdAndTeamId(target.getId(), team.getId());
    if (memberPreOpt.isEmpty()) throw new RuntimeException("member not found");
    MemberPre memberPre = memberPreOpt.get();
    // memberPre 정보로 새로운 member 객체 생성, memberPre 를 memberPreList 에서 삭제
    repoMP.delete(memberPre);
  }

  // putOutTeam 멤버 강퇴
  // 멤버(TeamMember) 엔티티 삭제
  public void putOutTeam(Long id,
                         MemberRequestDTO req,
                         Principal principal) {
    // req 와 일치하는 팀이 존재하는가 + 있다면 team 으로 선언
    Optional<Team> teamOpt = repoT.findById(req.getTeam().getId());
    if (teamOpt.isEmpty()) throw new RuntimeException("team not exist");
    Team team = teamOpt.get();
    // req 와 일치하는 어카운트가 존재하는가 + 있다면 targetOpt 으로 선언
    Optional<Account> targetOpt = repoA.findById(req.getAccount().getId());
    if (targetOpt.isEmpty()) throw new RuntimeException("target not exist");
    // team, targetOpt 와 일치하는 member 가 존재하는가 + 있다면 target 으로 선언
    Optional<Member> targetMemberOpt = repoM.findMemberByAccountIdAndTeamId(targetOpt.get().getId(), team.getId());
    if (targetMemberOpt.isEmpty()) throw new RuntimeException("member not found");
    Member target = targetMemberOpt.get();

    // principal 과 일치하는 어카운트가 존재하는가 + 있다면 account 으로 선언
    Optional<Account> accountOpt = repoA.findByUsername(principal.getName());
    if (accountOpt.isEmpty()) throw new RuntimeException("account not exist");
    Account account = accountOpt.get();
    // team, account 와 일치하는 member 가 존재하는가 + 있다면 member 으로 선언
    Optional<Member> memberOpt = repoM.findMemberByAccountIdAndTeamId(account.getId(), team.getId());
    if (memberOpt.isEmpty()) throw new RuntimeException("member not found");
    Member member = memberOpt.get();
    // member 의 권한이 매니저인가
    if (member.getMemberRole() != MemberRole.MANAGER) throw new RuntimeException("no authorization");

    // target 을 member 에서 삭제
    repoM.delete(target);
  }

  // getOutTeam 채팅방 탈퇴
  // 멤버(TeamMember) 엔티티 삭제
  public void getOutTeam(Long id,
                         MemberRequestDTO req,
                         Principal principal) {
    // req 와 일치하는 팀이 존재하는가 + 있다면 team 으로 선언
    Optional<Team> teamOpt = repoT.findById(req.getTeam().getId());
    if (teamOpt.isEmpty()) throw new RuntimeException("team not exist");
    Team team = teamOpt.get();
    // req 와 일치하는 어카운트가 존재하는가 + 있다면 account 으로 선언
    Optional<Account> targetOpt = repoA.findById(req.getAccount().getId());
    if (targetOpt.isEmpty()) throw new RuntimeException("target not exist");
    Account account = targetOpt.get();
    // principal 와 account 가 일치하는가
    if (!account.getUsername().equals(principal.getName()))
      throw new RuntimeException("principal and target not correct");

    // team, account 와 일치하는 member 가 존재하는가 + 있다면 target 으로 선언
    Optional<Member> memberOpt = repoM.findMemberByAccountIdAndTeamId(account.getId(), team.getId());
    if (memberOpt.isEmpty()) throw new RuntimeException("member not found");
    Member target = memberOpt.get();
    // target 을 member 에서 삭제
    repoM.delete(target);
  }
}
