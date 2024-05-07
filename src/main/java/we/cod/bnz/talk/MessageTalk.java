package we.cod.bnz.talk;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "message_talk")
public class MessageTalk {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column
  private String text;

  @Column
  private Date sendDateTime;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "talk_id")
  private Talk talk;

}
