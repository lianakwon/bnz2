package we.cod.bnz.talk;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/talk")
public class MessageTalkController {

  private final MessageTalkService serviceM;

  // getMessages 채팅 내역
  @GetMapping("/{id}")
  public ResponseEntity<List<MessageTalk>> getAllMessagesTalk(@PathVariable Long id) {
    return ResponseEntity.ok(serviceM.getAllMessages(id));
  }

  // createMessage 채팅 보내기
  @PostMapping("/{id}")
  public ResponseEntity<MessageTalk> createMessageTalk(@PathVariable Long id,
                                                       @RequestBody MessageTalkDTO dto,
                                                       Principal principal) {
    return ResponseEntity.ok(serviceM.createMessageTalk(id, dto, principal));
  }

  // deleteMessage 채팅 삭제
  @DeleteMapping("/{id}/{msgId}")
  public void deleteMessageTalk(@PathVariable Long id,
                                @PathVariable Long msgId) {
    serviceM.deleteMessageTalk(id, msgId);
  }

}
