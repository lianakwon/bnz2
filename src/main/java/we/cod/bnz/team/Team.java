package we.cod.bnz.team;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "teams")
public class Team {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "team_title")
  private String teamTitle;

  public Team makeTeam(TeamDTO dto) {
    return new Team(null, dto.getTitle());
  }

  public void editTeam(String teamTitle) {
    this.teamTitle = teamTitle;
  }
}

