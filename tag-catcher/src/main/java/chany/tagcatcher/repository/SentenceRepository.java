package chany.tagcatcher.repository;

import chany.tagcatcher.domain.Sentence;

import java.util.List;
import java.util.Optional;

public interface SentenceRepository {

    Sentence save(Sentence sentence);
    Optional<Sentence> findById(Long id);
    List<Sentence> findAll();

}
