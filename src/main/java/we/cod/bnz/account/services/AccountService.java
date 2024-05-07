package we.cod.bnz.account.services;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.userdetails.UserDetailsService;
import we.cod.bnz.account.dto.JwtResponse;
import we.cod.bnz.account.dto.LoginRequest;

public interface AccountService {

  UserDetailsService detailsService();

//  JwtResponse login(LoginRequest req);
}
