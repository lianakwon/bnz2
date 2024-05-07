package we.cod.bnz.account.services.impl;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import we.cod.bnz.account.AccountRepository;
import we.cod.bnz.account.dto.JwtResponse;
import we.cod.bnz.account.dto.LoginRequest;
import we.cod.bnz.account.services.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import we.cod.bnz.account.services.JWTService;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
  private final AccountRepository repoA;

  @Override
  public UserDetailsService detailsService() {
    System.out.println("we.cod.bnz.account : AccountServiceImpl : detailsService");
    return new UserDetailsService() {
      @Override
      public UserDetails loadUserByUsername(String username) {
        System.out.println("we.cod.bnz.account : AccountServiceImpl : detailsService : loadUserByUsername");
        return repoA.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("account not found"));
      }
    };
  }

//  @Override
//  public JwtResponse login(LoginRequest req) {
//    System.out.println("we.cod.bnz.account : AuthenticationServiceImpl : login");
//
//    authManager.authenticate(new UsernamePasswordAuthenticationToken(req.getUsername(), req.getPassword()));
//
//    var a = repoA.findByUsername(req.getUsername()).orElseThrow(() -> new IllegalArgumentException("invalid username or password"));
//
//    if (!req.getPassword().isEmpty() && !a.getPassword().equals(req.getPassword()))
//      throw new IllegalArgumentException("invalid username or password");
//
//    var jwt = serviceJWT.generateToken(a);
//    var rft = serviceJWT.generateRefreshToken(new HashMap<>(), a);
//
//    JwtResponse res = new JwtResponse();
//    res.setAccessToken(jwt);
//    res.setRefreshToken(rft);
//    return res;
//  }
}
