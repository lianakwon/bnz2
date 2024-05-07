package we.cod.bnz.today;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/today")
public class TodayController {

  @SuppressWarnings("unused")
  private final TodayService service;

  // getAll
  @GetMapping("")
  public ResponseEntity<List<Today>> getAll() {
    return null;
  }

  // detail
  @GetMapping("/{id}")
  public ResponseEntity<Today> detail(@PathVariable Long id) {
    return null;
  }

  // create=
  @PostMapping("")
  public ResponseEntity<Today> create() {
    return null;
  }

  // update=
  @PutMapping("/{id}")
  public ResponseEntity<Today> update(@PathVariable Long id) {
    return null;
  }

  // delete
  @DeleteMapping("/{id}")
  public ResponseEntity<String> delete(@PathVariable Long id) {
    return null;
  }
}
