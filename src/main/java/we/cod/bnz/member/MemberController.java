package we.cod.bnz.member;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/team")
public class MemberController {

  private final MemberService service;

  // putIn 채팅방 초대
  @PutMapping("/{id}/member")
  public ResponseEntity<MemberPre> getMembers(@PathVariable Long id,
                                         Principal principal) {
    return ResponseEntity.ok(service.getMembers(id, principal));
  }

  // putIn 채팅방 초대
  @PutMapping("/{id}/putIn")
  public ResponseEntity<MemberPre> putInTeam(@PathVariable Long id,
                                               @RequestBody MemberRequestDTO req,
                                               Principal principal) {
    return ResponseEntity.ok(service.putInTeam(id, req, principal));
  }

  // getIn 채팅방 참여 수락
  @PutMapping("/{id}/getIn")
  public ResponseEntity<Member> getInTeam(@PathVariable Long id,
                                            @RequestBody MemberRequestDTO req,
                                            Principal principal) {
    return ResponseEntity.ok(service.getInTeam(id, req, principal));
  }

  // getInNot 채팅방 참여 거절
  @PutMapping("/{id}/getInNot")
  public void getInTeamNot(@PathVariable Long id,
                             @RequestBody MemberRequestDTO req,
                             Principal principal) {
    service.getInTeamNot(id, req, principal);
  }

  // putOut 멤버 강퇴
  @PutMapping("/{id}/putOut")
  public void putOutTeam(@PathVariable Long id,
                           @RequestBody MemberRequestDTO req,
                           Principal principal) {
    service.putOutTeam(id, req, principal);
  }

  // getOut 채팅방 탈퇴
  @PutMapping("/{id}/getOut")
  public void getOutTeam(@PathVariable Long id,
                           @RequestBody MemberRequestDTO req,
                           Principal principal) {
    service.getOutTeam(id, req, principal);
  }
}
