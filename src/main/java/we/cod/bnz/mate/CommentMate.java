package we.cod.bnz.mate;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import we.cod.bnz.account.Account;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "comment_mate")
public class CommentMate {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id; // 댓글 아이디

  @Column(name = "content")
  private String content; // 내용

  @JoinColumn(name = "author")
  @ManyToOne(fetch = FetchType.LAZY)
  private Account writer; // 작성자

  @JoinColumn(name = "mate_id")
  @ManyToOne(fetch = FetchType.LAZY)
  private Mate mate; // 작성자

  @Column(name = "create_date")
  private LocalDateTime createDate; // 생성일시

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "comment_mate_questions",
          joinColumns = @JoinColumn(name = "comment_mate_id"),
          inverseJoinColumns = @JoinColumn(name = "account_id"))
  private Set<Account> like; // 좋아요

  public CommentMateDTO toDTO() {
    return CommentMateDTO.builder()
            .content(content)
            .writer(writer)
            .build();
  }

  public CommentMate create(String content,
              Mate mate,
              Account writer) {
    this.content = content;
    this.mate = mate;
    this.writer = writer;
    this.createDate = LocalDateTime.now();
    return this;
  }
}
