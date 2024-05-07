package we.cod.bnz.today;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TodayRepository extends JpaRepository<Today, Long> {
  
}
