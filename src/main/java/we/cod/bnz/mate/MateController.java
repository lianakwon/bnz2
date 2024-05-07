package we.cod.bnz.mate;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/office")
public class MateController {

  private final MateService service;

  // getAll
  @GetMapping("")
  public ResponseEntity<List<MateDTO>> getAll() {
    List<MateDTO> list = service.getAll();
    return ResponseEntity.ok(list);
  }

  // detail
  @GetMapping("/{id}")
  public ResponseEntity<MateDTO> detail(@PathVariable Long id) {
    MateDTO mate = service.detail(id);
    return ResponseEntity.ok(mate);
  }

  // create
  @PostMapping("")
  public ResponseEntity<MateDTO> create(@RequestBody MateDTO dto,
                                        Principal principal) {
    MateDTO created = service.create(dto, principal);
    return ResponseEntity.ok(created);
  }

  // update
  @PutMapping("/{id}")
  public ResponseEntity<MateDTO> update(@PathVariable Long id,
                                        @RequestBody MateDTO dto,
                                        Principal principal) {
    MateDTO updated = service.update(id, dto, principal);
    return ResponseEntity.ok(updated);
  }

  // delete
  @DeleteMapping("/{id}")
  public ResponseEntity<MateDTO> delete(@PathVariable Long id,
                                        Principal principal) {
    MateDTO deleted = service.delete(id, principal);
    return ResponseEntity.ok(deleted);
  }
}
