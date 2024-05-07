package we.cod.bnz.team;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import we.cod.bnz.talk.TalkService;

import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/team")
public class MessageTeamController {

  private final TalkService serviceR;
  private final MessageTeamService serviceM;

  // getMessages 채팅 내역
  @GetMapping("/{id}")
  public ResponseEntity<List<MessageTeam>> getMessagesTeam(@PathVariable Long id) {
    return ResponseEntity.ok(serviceM.getMessagesTeam(id));
  }

  // sendMessage 채팅 보내기
  @PostMapping("/{id}")
  public ResponseEntity<MessageTeam> createMessageTeam(@PathVariable Long id,
                                                       @RequestBody MessageTeamDTO dto,
                                                       Principal principal) {
    return ResponseEntity.ok(serviceM.createMessageTeam(id, dto, principal));
  }

  // deleteMessage 채팅 삭제
  @DeleteMapping("/{id}/{msgId}")
  public void deleteMessageTeam(@PathVariable Long id,
                                @PathVariable Long msgId) {
    serviceM.deleteMessageTeam(id, msgId);
  }

}
