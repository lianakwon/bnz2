package we.cod.bnz.team;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "message_team")
public class MessageTeam {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column
  private String text;

  @Column
  private Date sendDateTime;

  @JoinColumn(name = "team_id")
  @ManyToOne(fetch = FetchType.LAZY)
  private Team team;

}
