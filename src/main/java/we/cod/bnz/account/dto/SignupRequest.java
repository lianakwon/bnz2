package we.cod.bnz.account.dto;

import lombok.Data;

@Data
public class SignupRequest {

  private String username;
  private String email;
  private String password1;
  private String password2;
  private String nickname;
  private String phone1;
  private String phone2;
  private String phone3;
}
