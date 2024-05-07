package we.cod.bnz.account.services.impl;

import we.cod.bnz.account.dto.JwtResponse;
import we.cod.bnz.account.dto.TokenRequest;
import we.cod.bnz.account.dto.LoginRequest;
import we.cod.bnz.account.dto.SignupRequest;
import we.cod.bnz.account.AccountRole;
import we.cod.bnz.account.Account;
import we.cod.bnz.account.AccountRepository;
import we.cod.bnz.account.services.AuthenticationService;
import we.cod.bnz.account.services.JWTService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

  private final AccountRepository repoA;
  private final PasswordEncoder encoder;
  private final AuthenticationManager authManager;
  private final JWTService serviceJWT;

  public Account signup(SignupRequest req) {
    System.out.println("we.cod.bnz.account : AuthenticationServiceImpl : signup");
    Account a = new Account();
    a.setEmail(req.getEmail());
    a.setUsername(req.getUsername());
    a.setNickname(req.getNickname());
    a.setAccountRole(AccountRole.USER);
    a.setPassword(encoder.encode(req.getPassword1()));
    a.setPhone(req.getPhone1() + req.getPhone2() + req.getPhone3());
    a.setProfile("Default" + "Green" + "Normal" + "Smile" + ".jpg");
    return repoA.save(a);
  }

  public JwtResponse login(LoginRequest req) {
    System.out.println("we.cod.bnz.account : AuthenticationServiceImpl : login");

    authManager.authenticate(new UsernamePasswordAuthenticationToken(req.getUsername(), req.getPassword()));

    var a = repoA.findByUsername(req.getUsername()).orElseThrow(() -> new IllegalArgumentException("invalid username or password"));

    if (!req.getPassword().isEmpty() && !a.getPassword().equals(req.getPassword()))
      throw new IllegalArgumentException("invalid username or password");

    var jwt = serviceJWT.generateToken(a);
    var rft = serviceJWT.generateRefreshToken(new HashMap<>(), a);

    JwtResponse res = new JwtResponse();
    res.setAccessToken(jwt);
    res.setRefreshToken(rft);

    return res;
  }

  public JwtResponse refreshToken(TokenRequest req) {
    System.out.println("we.cod.bnz.account : AuthenticationServiceImpl : refreshToken");
    String username = serviceJWT.extractUsername(req.getToken());
    Account a = repoA.findByEmail(username).orElseThrow();

    if (serviceJWT.isTokenValid(req.getToken(), a)) {
      var jwt = serviceJWT.generateToken(a);

      JwtResponse res = new JwtResponse();
      res.setAccessToken(jwt);
      res.setRefreshToken(req.getToken());

      return res;
    }
    return null;
  }

  @Override
  public boolean check(String username) {
    if (repoA.findByUsername(username).isEmpty()) return false;
    else return true;
  }
}
