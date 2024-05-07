package we.cod.bnz.team;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import we.cod.bnz.account.Account;
import we.cod.bnz.account.AccountRepository;

import java.security.Principal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class MessageTeamService {

 private final TeamRepository repoT;
 private final MessageTeamRepository repoM;
 private final AccountRepository repoA;

  // getMessages 채팅 내역
 public List<MessageTeam> getMessagesTeam(Long id) {
   Optional<Team> team = repoT.findById(id);
   if (team.isEmpty()) throw new RuntimeException("getMessages : NotFoundTeam");
   List<MessageTeam> messages = repoM.findMessageByRoomId(id);
   if (messages.isEmpty()) throw new RuntimeException("getMessages : NotFoundMessages");
   return messages;
 }

 // sendMessage 채팅 보내기
 public MessageTeam createMessageTeam(Long id,
                                      MessageTeamDTO dto,
                                      Principal principal) {
   if (dto.getText().isEmpty()) throw new RuntimeException("sendMessage : TextEmpty");
   Optional<Team> team = repoT.findById(id);
   if (team.isEmpty()) throw new RuntimeException("sendMessage : NotFoundTeam");
   Optional<Account> account = repoA.findByUsername(principal.getName());
   if (account.isEmpty()) throw new RuntimeException("sendMessage : NotFoundAccount");
   if (!principal.getName().equals(account.get().getUsername())) throw new RuntimeException("sendMessage : AccountNotCorrect");
   if (!principal.getName().equals(account.get().getUsername())) throw new RuntimeException("sendMessage : AccountNotCorrect");
   MessageTeam message = new MessageTeam(
           null,
           dto.getText(),
           new Date(),
           team.get());
   repoM.save(message);
   return message;
 }

 // deleteMessage 채팅 삭제
 public void deleteMessageTeam(Long id,
                               Long msgId) {
   Optional<Team> team = repoT.findById(id);
   if (team.isEmpty()) throw new RuntimeException("getMessages : NotFoundTeam");
   Optional<MessageTeam> optionalTarget = repoM.findById(msgId);
   if (optionalTarget.isEmpty()) throw new RuntimeException("deleteMessage : NotFoundMessage");
   repoM.deleteById(msgId);
 }

}
