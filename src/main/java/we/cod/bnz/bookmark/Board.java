package we.cod.bnz.bookmark;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "board")
public class Board {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String title;

  private String content;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "author_id")
  private User author;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "board_bookmark",
          joinColumns = @JoinColumn(name = "board_id"),
          inverseJoinColumns = @JoinColumn(name = "user_id"))
  private Set<User> boardBookmark;

}
