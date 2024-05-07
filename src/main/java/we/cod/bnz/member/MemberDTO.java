package we.cod.bnz.member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import we.cod.bnz.account.Account;
import we.cod.bnz.team.Team;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberDTO {

  private Team team;

  private Account account;

  private MemberRole memberRole;

}


