package we.cod.bnz.team;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TeamDTO {

  private String title;

  public Team toEntity() {
    return new Team(null, title);
  }
}
