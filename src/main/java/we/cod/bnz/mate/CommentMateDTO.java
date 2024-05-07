package we.cod.bnz.mate;

import lombok.*;
import we.cod.bnz.account.Account;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommentMateDTO {

  private String content; // 내용

  private Account writer; // 작성자

}
