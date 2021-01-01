package chany.tagcatcher.repository;

import chany.tagcatcher.domain.Sentence;

import java.util.List;

public interface SentenceRepository {

    Sentence save(Sentence sentence);
    Sentence findById(Long id);
    List<Sentence> findAll();
}
