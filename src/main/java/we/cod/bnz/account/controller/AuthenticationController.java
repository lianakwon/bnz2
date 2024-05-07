package we.cod.bnz.account.controller;

import org.springframework.web.bind.annotation.*;
import we.cod.bnz.account.dto.JwtResponse;
import we.cod.bnz.account.dto.TokenRequest;
import we.cod.bnz.account.dto.LoginRequest;
import we.cod.bnz.account.dto.SignupRequest;
import we.cod.bnz.account.Account;
import we.cod.bnz.account.services.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class AuthenticationController {

  private final AuthenticationService serviceAuth;

  @PostMapping("/signup")
  public ResponseEntity<Account> signup(@RequestBody SignupRequest req) {
    System.out.println("we.cod.bnz.account : AuthenticationController : signup");
    return ResponseEntity.ok(serviceAuth.signup(req));
  }

  @PostMapping("/login")
  public ResponseEntity<JwtResponse> login(@RequestBody LoginRequest req) {
    System.out.println("we.cod.bnz.account : AuthenticationController : login");
    return ResponseEntity.ok(serviceAuth.login(req));
  }

  @PostMapping("/refresh")
  public ResponseEntity<JwtResponse> refresh(@RequestBody TokenRequest req) {
    System.out.println("we.cod.bnz.account : AuthenticationController : refresh");
    return ResponseEntity.ok(serviceAuth.refreshToken(req));
  }

}
