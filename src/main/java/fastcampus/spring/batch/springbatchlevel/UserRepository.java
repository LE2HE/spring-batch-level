package fastcampus.spring.batch.springbatchlevel;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Collection;

public interface UserRepository extends JpaRepository<User, Long> {
    Collection<Object> findAllByUpdateDate(LocalDate updateDate);
}
