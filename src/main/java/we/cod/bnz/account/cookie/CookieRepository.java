package we.cod.bnz.account.cookie;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.client.web.AuthorizationRequestRepository;
import org.springframework.security.oauth2.core.endpoint.OAuth2AuthorizationRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@RequiredArgsConstructor
@Component
public class CookieRepository implements AuthorizationRequestRepository<OAuth2AuthorizationRequest> {
  public static final String OAUTH2_AUTHORIZATION_REQUEST_COOKIE_NAME = "oauth2_auth_request";
  public static final String REDIRECT_URI_PARAM_COOKIE_NAME = "redirect_uri";
  public static final String MODE_PARAM_COOKIE_NAME = "mode";
  private static final int COOKIE_EXPIRE_SECONDS = 180;

  @Override
  public OAuth2AuthorizationRequest loadAuthorizationRequest(HttpServletRequest request) {
    System.out.println("login : CookieRepository : loadAuthorizationRequest");
    return CookieUtils.getCookie(request, OAUTH2_AUTHORIZATION_REQUEST_COOKIE_NAME)
            .map(cookie -> CookieUtils.deserialize(cookie, OAuth2AuthorizationRequest.class)).orElse(null);
  }

  @Override
  public void saveAuthorizationRequest(OAuth2AuthorizationRequest authorizationRequest,
                                       HttpServletRequest request,
                                       HttpServletResponse response) {
    System.out.println("login : CookieRepository : saveAuthorizationRequest");
    if (authorizationRequest == null) {
      CookieUtils.deleteCookie(request, response, OAUTH2_AUTHORIZATION_REQUEST_COOKIE_NAME);
      CookieUtils.deleteCookie(request, response, REDIRECT_URI_PARAM_COOKIE_NAME);
      CookieUtils.deleteCookie(request, response, MODE_PARAM_COOKIE_NAME);
      return;
    }

    CookieUtils.addCookie(response, OAUTH2_AUTHORIZATION_REQUEST_COOKIE_NAME, CookieUtils.serialize(authorizationRequest), COOKIE_EXPIRE_SECONDS);

    String redirectUriAfterLogin = request.getParameter(REDIRECT_URI_PARAM_COOKIE_NAME);
    if (StringUtils.hasText(redirectUriAfterLogin))
      CookieUtils.addCookie(response, REDIRECT_URI_PARAM_COOKIE_NAME, redirectUriAfterLogin, COOKIE_EXPIRE_SECONDS);

    String mode = request.getParameter(MODE_PARAM_COOKIE_NAME);
    if (StringUtils.hasText(mode))
      CookieUtils.addCookie(response, MODE_PARAM_COOKIE_NAME, mode, COOKIE_EXPIRE_SECONDS);
  }

  @Override
  public OAuth2AuthorizationRequest removeAuthorizationRequest(HttpServletRequest request,
                                                               HttpServletResponse response) {
    System.out.println("login : CookieRepository : removeAuthorizationRequest");
    return this.loadAuthorizationRequest(request);
  }

  public void removeAuthorizationRequestCookies(HttpServletRequest request, HttpServletResponse response) {
    System.out.println("login : CookieRepository : removeAuthorizationRequestCookies");
    CookieUtils.deleteCookie(request, response, OAUTH2_AUTHORIZATION_REQUEST_COOKIE_NAME);
    CookieUtils.deleteCookie(request, response, REDIRECT_URI_PARAM_COOKIE_NAME);
    CookieUtils.deleteCookie(request, response, MODE_PARAM_COOKIE_NAME);
  }

  // JWT 토큰 보내기

}
