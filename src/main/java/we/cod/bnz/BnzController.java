package we.cod.bnz;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping({"", "/"})
@CrossOrigin(origins = "http://localhost:3000")
public class BnzController {

  @GetMapping({"", "/"})
  public Principal index(Principal principal) {
    System.out.println("we.cod.bnz.account : BnzController : index");

    if (principal != null) System.out.println(principal);
    if (principal != null) System.out.println("we.cod.bnz.account : BnzController : index : " + principal.getName());
    else System.out.println("we.cod.bnz.account : BnzController : index : " + "principal is null");

//    if (req != null) System.out.println(req);
//    if (req != null) System.out.println("BnzController : index : " + req.getCookies());
//    else System.out.println("BnzController : index : " + "res is null");

//    if (username != null) System.out.println(username);
//    System.out.println("we.cod.bnz.account : BnzController : index : " + "username not exist");
//    if (res.getCookie() != null) System.out.println(res.getCookie());
//    System.out.println("we.cod.bnz.account : BnzController : index : " + "res not exist");

    return principal;
  }


  @GetMapping("/onLoad")
  public ResponseEntity<String> onLoad(@CookieValue(name = "username", required = false) String username,
                                       @RequestHeader HttpHeaders http) {
    System.out.println("we.cod.bnz.account : BnzController : onLoad");
    if (username != null) System.out.println(username);
    System.out.println("we.cod.bnz.account : BnzController : onLoad : " + "username not exist");
//    if (res.getCookie() != null) System.out.println(res.getCookie());
//    System.out.println("we.cod.bnz.account : BnzController : onLoad : " + "res not exist");
    if (http.get("username") != null) System.out.println(http.get("username"));
    System.out.println("we.cod.bnz.account : BnzController : onLoad : " + "http not exist");
    return ResponseEntity.ok(username);
  }
}
