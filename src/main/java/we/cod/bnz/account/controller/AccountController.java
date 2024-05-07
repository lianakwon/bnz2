package we.cod.bnz.account.controller;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import we.cod.bnz.account.cookie.CookieUtils;
import we.cod.bnz.account.dto.JwtResponse;
import we.cod.bnz.account.dto.LoginRequest;
import we.cod.bnz.account.services.AccountService;
import we.cod.bnz.account.services.AuthenticationService;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class AccountController {

  @Autowired
  private final AccountService serviceA;

//  @Autowired
//  private final CookieUtils utils;

  @Autowired
  private final AuthenticationService serviceAuth;

  @GetMapping
  public ResponseEntity<String> sayHello() {
    return ResponseEntity.ok("Hi User");
  }

  @PostMapping("/check")
  public ResponseEntity<Boolean> check(@RequestBody String username) {
    System.out.println("we.cod.bnz.account : AuthenticationController : loginCheck");
    return ResponseEntity.ok(serviceAuth.check(username));
  }

  @PostMapping("/login")
  public ResponseEntity<JwtResponse> login(@RequestBody LoginRequest req) {
    System.out.println("we.cod.bnz.account : AuthenticationController : login");
//    JwtResponse res = serviceA.login(req);
//    if (res == null) return ResponseEntity.badRequest().build();
//    CookieUtils.addCookie(response, req.getUsername(), req.getPassword(), 60*60);
//    return ResponseEntity.ok(res);
    return null;
  }
}
