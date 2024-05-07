package we.cod.bnz.account.config;

import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import we.cod.bnz.account.AccountRole;
import we.cod.bnz.account.cookie.CookieRepository;
import we.cod.bnz.account.services.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

  private final JwtAuthenticationFilter filter;
  private final AccountService serviceA;
  private final CookieRepository repoC;

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
            .csrf(AbstractHttpConfigurer::disable)
            .cors(cors -> cors.configurationSource(corsConfigurationSource()))
            .sessionManagement(sessionManagementConfigurer -> sessionManagementConfigurer
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authorizeHttpRequests(request -> request
                    .requestMatchers("/**").permitAll()
//                    .requestMatchers("/auth/**").permitAll()
//                    .requestMatchers("/account/login").permitAll()
//                    .requestMatchers("/account/join").permitAll()
//                    .requestMatchers("/account/check").permitAll()
//                    .requestMatchers("/admin/**").hasAnyAuthority(AccountRole.ADMIN.name())
                    .anyRequest().authenticated())
            .httpBasic(HttpBasicConfigurer::disable)
            .formLogin(AbstractHttpConfigurer::disable)
            .authenticationProvider(authenticationProvider())
            .addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class)
    ;
    return http.build();
  }

  @Bean
  public AuthenticationProvider authenticationProvider() {
    DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
    authenticationProvider.setUserDetailsService(serviceA.detailsService());
    authenticationProvider.setPasswordEncoder(passwordEncoder());
    return authenticationProvider;
  }
  @Bean
  protected CorsConfigurationSource corsConfigurationSource(){

    CorsConfiguration corsConfiguration = new CorsConfiguration();
    corsConfiguration.addAllowedOrigin("*");
    corsConfiguration.addAllowedMethod("*");
    corsConfiguration.addAllowedHeader("*");

    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/account/**" , corsConfiguration);
    return source;
  }

//  @Bean
//  public CookieRepository repoC() {
//    return new CookieRepository();
//  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
    return config.getAuthenticationManager();
  }
}
