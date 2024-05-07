package we.cod.bnz.talk;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TalkRepository extends JpaRepository<Talk, Long> {
  
}
