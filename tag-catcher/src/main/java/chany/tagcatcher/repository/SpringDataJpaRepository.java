package chany.tagcatcher.repository;

import chany.tagcatcher.domain.Sentence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataJpaRepository extends JpaRepository<Sentence, Long>, SentenceRepository {



}
