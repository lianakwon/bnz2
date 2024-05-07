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
@Table(name = "mates")
public class Mate {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id; // 게시글 아이디

  @Column(name = "title")
  private String title; // 제목

  @Column(name = "content")
  private String content; // 내용

  @JoinColumn(name = "author")
  @ManyToOne(fetch = FetchType.LAZY)
  private Account author; // 작성자

  @Column(name = "create_date")
  private LocalDateTime createDate; // 생성일시

  @Column(name = "modify_date")
  private LocalDateTime modifyDate; // 수정일시

  @Column(name = "hit")
  private Long hit; // 조회수

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "mate_likes",
          joinColumns = @JoinColumn(name = "mate_id"),
          inverseJoinColumns = @JoinColumn(name = "account_id"))
  private Set<Account> like; // 좋아요 누른 사람 리스트

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "mate_questions",
          joinColumns = @JoinColumn(name = "mate_id"),
          inverseJoinColumns = @JoinColumn(name = "account_id"))
  private Set<Account> quest; // 나도 궁금해요 누른 사람 리스트

  public MateDTO toDTO() {
    return new MateDTO(title, content, author);
  }

  public Mate create(MateDTO dto,
                     Account author) {
    this.title = dto.getTitle();
    this.content = dto.getContent();
    this.author = author;
    this.createDate = LocalDateTime.now();
    this.modifyDate = LocalDateTime.now();
    this.hit = 0L;
    return this;
  }
}
