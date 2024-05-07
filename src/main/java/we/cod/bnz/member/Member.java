package we.cod.bnz.member;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import we.cod.bnz.account.Account;
import we.cod.bnz.team.Team;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "members")
public class Member {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  // 팀 테이블 연결
  @JoinColumn(name = "team_id")
  @ManyToOne(fetch = FetchType.LAZY)
  private Team team;

  // 어카운트 테이블 연결
  @JoinColumn(name = "account_id")
  @ManyToOne(fetch = FetchType.LAZY)
  private Account account;

  // 멤버 계정 권한 세팅
  // : 팀 멤버(참여자) / 매니저(관리자)
  @Column
  @Enumerated(EnumType.STRING)
  private MemberRole memberRole;


  public boolean isManager() {
    return this.memberRole.equals(MemberRole.MANAGER);
  }

  public boolean isNotManager() {
    return !this.memberRole.equals(MemberRole.MANAGER);
  }

  public boolean isMember() {
    return this.memberRole.equals(MemberRole.MEMBER) || this.memberRole.equals(MemberRole.MANAGER);
  }

}


