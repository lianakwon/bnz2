package we.cod.bnz.mate;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import we.cod.bnz.account.Account;
import we.cod.bnz.account.AccountRepository;
import java.security.Principal;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MateService {

  private final AccountRepository repoA;
  private final MateRepository repoM;

  // getAll
  public List<MateDTO> getAll() {
    List<Mate> mates = repoM.findAll();
    List<MateDTO> dtos = mates.stream()
            .map(Mate::toDTO)
            .collect(Collectors.toList());
    return dtos;
  }

  // detail
  public MateDTO detail(Long id) {
    Optional<Mate> mateOpt = repoM.findById(id);
    if (mateOpt.isEmpty()) throw new RuntimeException("mate not found");
    MateDTO mate = mateOpt.get().toDTO();
    return mate;
  }

  // create
  public MateDTO create(MateDTO dto,
                        Principal principal) {
    Optional<Account> accountOpt = repoA.findByUsername(principal.getName());
    if (accountOpt.isEmpty()) throw new RuntimeException("account not found");
    Account author = accountOpt.get();
    Mate mate = new Mate();
    Mate created = mate.create(dto, author);
    repoM.save(created);
    return created.toDTO();
  }

  // update
  public MateDTO update(Long id,
                        MateDTO dto,
                        Principal principal) {
    Optional<Mate> mateOpt = repoM.findById(id);
    if (mateOpt.isEmpty()) throw new RuntimeException("mate not found");
    return null;
  }

  // delete
  public MateDTO delete(Long id,
                        Principal principal) {
    return null;
  }
}
