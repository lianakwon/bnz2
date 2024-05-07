package we.cod.bnz.mate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import we.cod.bnz.account.Account;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MateDTO {

  private String title; // 제목

  private String content; // 내용

  private Account author; // 작성자

}