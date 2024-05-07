package we.cod.bnz;

import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import we.cod.bnz.account.services.impl.JWTServiceImpl;

import java.security.Principal;

@RestController
@RequestMapping({"", "/"})
@CrossOrigin(origins = "http://localhost:3000")
public class BnzController {

  @GetMapping({"", "/"})
  public Principal index(Principal principal, HttpServletRequest req) {
    System.out.println("we.cod.bnz.account : BnzController : index");

    if (principal != null) System.out.println(principal);
    if (principal != null) System.out.println("BnzController : index : " + principal.getName());
    else System.out.println("BnzController : index : " + "principal is null");

    if (req != null) System.out.println(req);
    if (req != null) System.out.println("BnzController : index : " + req.getCookies());
    else System.out.println("BnzController : index : " + "res is null");

    return principal;
  }


  @GetMapping("/onLoad")
  public ResponseEntity<String> getUsernameFromToken(@RequestHeader("Authorization") String tokenHeader) {
    String token = tokenHeader.replace("Bearer ", "");
    Claims claims = JWTServiceImpl.extractAllClaims(token);
    String username = (String) claims.get("username");
    System.out.println(username);
    return ResponseEntity.ok(username);
  }
}
