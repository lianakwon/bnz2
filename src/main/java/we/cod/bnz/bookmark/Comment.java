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
@Table(name = "comment")
public class Comment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String content;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "writer_id")
  private User writer;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "board_id")
  private Board board;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "comment_bookmark",
          joinColumns = @JoinColumn(name = "comment_id"),
          inverseJoinColumns = @JoinColumn(name = "user_id"))
  private Set<User> commentBookmark;

}
