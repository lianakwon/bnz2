package we.cod.bnz.mate;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentMateRepository extends JpaRepository<CommentMate, Long> {

  List<CommentMate> findByMate(Mate mate);
}
