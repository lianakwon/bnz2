package we.cod.bnz.account;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import we.cod.bnz.member.Member;
import we.cod.bnz.team.TeamDTO;

import java.util.Collection;
import java.util.List;

@Data
@Entity
@Table(name = "account")
public class Account implements UserDetails {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String username;

  private String password;

  @Getter
  private String email;

  @Getter
  private String nickname;

  @Getter
  private String phone;

  @Getter
  private String profile;

  @Column(name = "account_role")
  @Enumerated(EnumType.STRING)
  private AccountRole accountRole;


  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return List.of(new SimpleGrantedAuthority(accountRole.name()));
  }

  @Override
  public String getUsername() {
    return username;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

  public Member saveManager(TeamDTO dto) {
    System.out.println("Account : saveManager");
    return null;
  }
}
