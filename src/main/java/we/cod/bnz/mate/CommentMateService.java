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
public class CommentMateService {

  private final MateRepository repoM;
  private final AccountRepository repoA;
  private final CommentMateRepository repoC;


  // getAll
  public List<CommentMateDTO> getAll(Long id) {
// Mate(게시글) 존재 여부 판별
    Optional<Mate> mateOpt = repoM.findById(id);
    if (mateOpt.isEmpty()) throw new RuntimeException("mate not found");
    Mate mate = mateOpt.get();
// Mate(게시글) 별 CommentMate List 호출
    List<CommentMate> comments = repoC.findByMate(mate);
    return comments.stream()
            .map(CommentMate::toDTO)
            .collect(Collectors.toList());
  }


  // create
  public CommentMateDTO create(Long id,
                               CommentMateDTO dto,
                               Principal principal) {
// Mate(게시글) 존재 여부 판별
    Optional<Mate> mateOpt = repoM.findById(id);
    if (mateOpt.isEmpty()) throw new RuntimeException("mate not found");
    Mate mate = mateOpt.get();
// Account(댓글작성자) 존재 여부 판별
    Optional<Account> accountOpt = repoA.findByUsername(principal.getName());
    if (accountOpt.isEmpty()) throw new RuntimeException("account not found");
    Account writer = accountOpt.get();
// new CommentMate 생성
    CommentMate comment = new CommentMate();
    return comment.create(dto.getContent(), mate, writer).toDTO();
  }


  // delete
  public CommentMateDTO delete(Long id,
                               Long commentId) {
// Mate(게시글) 존재 여부 판별
    Optional<Mate> mateOpt = repoM.findById(id);
    if (mateOpt.isEmpty()) throw new RuntimeException("mate not found");
// CommentMate(댓글) 존재 여부 판별
    Optional<CommentMate> commentOpt = repoC.findById(commentId);
    if (commentOpt.isEmpty()) throw new RuntimeException("comment not found");
    CommentMateDTO deleted = commentOpt.get().toDTO();
// CommentMate 삭제
    repoC.delete(commentOpt.get());
    return deleted;
  }

}
