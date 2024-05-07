package we.cod.bnz.account.services;

import we.cod.bnz.account.dto.JwtResponse;
import we.cod.bnz.account.dto.TokenRequest;
import we.cod.bnz.account.dto.LoginRequest;
import we.cod.bnz.account.dto.SignupRequest;
import we.cod.bnz.account.Account;

public interface AuthenticationService {

  Account signup(SignupRequest req);

  JwtResponse login(LoginRequest req);

  JwtResponse refreshToken(TokenRequest req);

  boolean check(String username);
}
