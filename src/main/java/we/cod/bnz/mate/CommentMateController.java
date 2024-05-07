package we.cod.bnz.mate;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/mate")
public class CommentMateController {

  private final CommentMateService service;

  // getAll
  @GetMapping("/{id}")
  public ResponseEntity<List<CommentMateDTO>> getAll(@PathVariable Long id) {
    List<CommentMateDTO> list = service.getAll(id);
    return ResponseEntity.ok(list);
  }

  // create
  @PostMapping("/{id}")
  public ResponseEntity<CommentMateDTO> create(@PathVariable Long id,
                                               @RequestBody CommentMateDTO dto,
                                               Principal principal) {
    CommentMateDTO created = service.create(id, dto, principal);
    return ResponseEntity.ok(created);
  }

  // delete
  @DeleteMapping("/{id}/{commentId}")
  public ResponseEntity<CommentMateDTO> delete(@PathVariable Long id,
                                       @PathVariable Long commentId) {
    CommentMateDTO deleted = service.delete(id, commentId);
    return ResponseEntity.ok(deleted);
  }
}
