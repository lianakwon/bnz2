package we.cod.bnz.mate;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tags")
public class Tag {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "recruit")
  private boolean recruit; // 모집완료/모집중

  @Column(name = "goal")
  private String goal; // 스터디/프로젝트 : 목적

  @Column(name = "spce")
  private String space; // 온라인/오프라인 : 영역

  @Column(name = "locas")
  private Set<String> locas; // 모집지역 (locations)

  @Column(name = "parts")
  private Set<String> parts; // 모집분야

  @Column(name = "langs")
  private Set<String> langs; // 사용언어, 사용툴 (languages)

  @JoinColumn(name = "mate_id")
  @ManyToOne(fetch = FetchType.LAZY)
  private Mate mate; // 댓글이 달린 게시글 엔티티 조인

}
