package we.cod.bnz.talk;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
//import we.cod.bnz.account.Account;
//import we.cod.bnz.account.AccountRepository;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class TalkService {

  private final TalkRepository repoR;
//  private final AccountRepository repoA;

  // getTalks 채팅방 목록
  public List<Talk> getTalks() {
    return repoR.findAll();
  }

  // addTalk 채팅방 생성
  public void createTalk(TalkDTO dto,
                         Principal principal) {
//    Optional<Account> fromOpt = repoA.findByUsername(principal.getName());
//    Optional<Account> toOpt = repoA.findByUsername(dto.getTo().getUsername());
//    if (fromOpt.isEmpty()) throw new RuntimeException("sender not exist");
//    if (toOpt.isEmpty()) throw new RuntimeException("receiver not exist");
//    Account from = fromOpt.get();
//    Account to = toOpt.get();
//    Talk room = new Talk(null, from, to);
    Talk room = new Talk();
    repoR.save(room);
  }

  // deleteTalk 채팅방 나가기
  public void deleteTalk(Long id) {
    Optional<Talk> roomOpt = repoR.findById(id);
    if (roomOpt.isEmpty()) throw new RuntimeException("room not exist");
    Talk room = roomOpt.get();
    repoR.delete(room);
  }
}
