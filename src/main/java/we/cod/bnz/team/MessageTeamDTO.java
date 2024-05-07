package we.cod.bnz.team;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import we.cod.bnz.account.Account;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MessageTeamDTO {

  private String text;
  private Account sendAccount;

}
