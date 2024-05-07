package we.cod.bnz.talk;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import we.cod.bnz.account.Account;
//import we.cod.bnz.account.Account;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "talks")
public class Talk {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  // 보내는 사람 (본인)
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "from_id")
  private Account from;

  // 받는 사람 (상대방)
  // 1:1 채팅방 이름 : username of to
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "to_id")
  private Account to;

}
