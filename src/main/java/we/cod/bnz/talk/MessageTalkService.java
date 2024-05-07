package we.cod.bnz.talk;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
//import we.cod.bnz.account.Account;
//import we.cod.bnz.account.AccountRepository;

import java.security.Principal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class MessageTalkService {

  private final TalkRepository repoR;
  private final MessageTalkRepository repoM;
//  private final AccountRepository repoA;

  // getMessages 채팅 내역
  public List<MessageTalk> getAllMessages(Long id) {
    Optional<Talk> room = repoR.findById(id);
    if (room.isEmpty()) throw new RuntimeException("getMessages : NotFoundRoom");
    return repoM.findMessageByRoomId(id);
  }

  // sendMessage 채팅 보내기
  public MessageTalk createMessageTalk(Long id,
                                       MessageTalkDTO dto,
                                       Principal principal) {
    if (dto.getText().isEmpty()) throw new RuntimeException("sendMessage : TextEmpty");
    Optional<Talk> talk = repoR.findById(id);
    if (talk.isEmpty()) throw new RuntimeException("sendMessage : NotFoundRoom");
//    Optional<Account> account = repoA.findByUsername(principal.getName());
//    if (account.isEmpty()) throw new RuntimeException("sendMessage : NotFoundAccount");
//    if (!principal.getName().equals(account.get().getUsername())) throw new RuntimeException("sendMessage : AccountNotCorrect");
    MessageTalk messageTalk = new MessageTalk(
            null,
            dto.getText(),
            new Date(),
            talk.get());
    repoM.save(messageTalk);
    return messageTalk;
  }

  // deleteMessage 채팅 삭제
  public void deleteMessageTalk(Long id,
                                Long msgId) {
    Optional<Talk> room = repoR.findById(id);
    if (room.isEmpty()) throw new RuntimeException("deleteMessage : NotFoundRoom");
    Optional<MessageTalk> optionalTarget = repoM.findById(msgId);
    if (optionalTarget.isEmpty()) throw new RuntimeException("deleteMessage : NotFoundMessage");
    repoM.deleteById(msgId);
  }

}
