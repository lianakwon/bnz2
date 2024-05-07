package we.cod.bnz.account.config;

import org.springframework.web.bind.annotation.CrossOrigin;
import we.cod.bnz.account.services.JWTService;
import we.cod.bnz.account.services.AccountService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class JwtAuthenticationFilter extends OncePerRequestFilter {

  private final JWTService serviceJWT;
  private final AccountService serviceA;

  protected void doFilterInternal(HttpServletRequest req,
                                  HttpServletResponse res,
                                  FilterChain filter) throws ServletException, IOException {
    final String header = req.getHeader("Authorization");
    final String jwt;
    final String username;
    if (StringUtils.isEmpty(header)
            || !org.apache.commons.lang3.StringUtils.startsWith(header, "Bearer ")) {
      filter.doFilter(req, res);
      return;
    }

    jwt = header.substring(7);
    username = serviceJWT.extractUsername(jwt);

    if (StringUtils.isNotEmpty(username)
            && SecurityContextHolder.getContext().getAuthentication() == null) {
      UserDetails details = serviceA.detailsService().loadUserByUsername(username);
      if (serviceJWT.isTokenValid(jwt, details)) {
        SecurityContext context = SecurityContextHolder.createEmptyContext();
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(details, null, details.getAuthorities());
        token.setDetails(new WebAuthenticationDetailsSource().buildDetails(req));
        context.setAuthentication(token);
        SecurityContextHolder.setContext(context);
      }
    }
    filter.doFilter(req, res);
  }
}