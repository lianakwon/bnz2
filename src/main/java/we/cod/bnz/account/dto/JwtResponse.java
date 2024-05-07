package we.cod.bnz.account.dto;

import lombok.Data;

@Data
public class JwtResponse {

  private String accessToken;
  private String refreshToken;
}
