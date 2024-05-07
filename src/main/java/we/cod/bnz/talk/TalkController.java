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
public class TalkController {

  private final TalkService service;

  // getTalks 채팅방 목록
  @GetMapping({"", "/"})
  public ResponseEntity<List<Talk>> getTalks() {
    return ResponseEntity.ok(service.getTalks());
  }

  // addTalk 채팅방 생성
  @GetMapping("/add")
  public void createTalk(@RequestBody TalkDTO dto,
                         Principal principal) {
    service.createTalk(dto, principal);
  }

  // deleteTalk 채팅방 삭제
  @DeleteMapping("/{id}/delete")
  public void deleteTalk(@PathVariable Long id) {
    service.deleteTalk(id);
  }

}
