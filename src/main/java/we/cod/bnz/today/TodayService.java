package we.cod.bnz.today;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodayService {

  @SuppressWarnings("unused")
  private final TodayRepository repo;

  // getAll
  public List<TodayDTO> getAll() {
    return null;
  }

  // detail
  public TodayDTO detail() {
    return null;
  }

  // create
  public TodayDTO create() {
    return null;
  }

  // update
  public TodayDTO update() {
    return null;
  }

  // delete
  public void delete() {
  }
}
