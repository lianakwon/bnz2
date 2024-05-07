package we.cod.bnz.team;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/team")
public class TeamController {

  private final TeamService service;

  // getRooms 채팅방 목록
  @GetMapping({"", "/"})
  public ResponseEntity<List<Team>> getTeams(
          @SessionAttribute(name = "username", required = false) String username) {
    return ResponseEntity.ok(service.getTeams());
  }

  // makeRoom 채팅방 생성
  @PostMapping("/add")
  public ResponseEntity<Team> createTeam(@RequestBody TeamDTO dto,
                                         @SessionAttribute(name = "username", required = false) String username) {
    return ResponseEntity.ok(service.createTeam(dto, username));
  }

  // editRoom 채팅방 이름 수정
  @PutMapping("/{id}/update")
  public ResponseEntity<Team> updateTeam(@PathVariable Long id,
                                         @RequestBody TeamDTO dto,
                                         @SessionAttribute(name = "username", required = false) String username) {
    return ResponseEntity.ok(service.updateTeam(id, dto, username));
  }

  // deleteRoom 채팅방 삭제
  @DeleteMapping("/{id}/delete")
  public void deleteTeam(@PathVariable Long id,
                         @SessionAttribute(name = "username", required = false) String username) {
    service.deleteTeam(id, username);
  }
  
}



