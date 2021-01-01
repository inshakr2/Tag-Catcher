package chany.tagcatcher.repository;

import chany.tagcatcher.domain.DemoSentence;
import chany.tagcatcher.domain.Sentence;

import java.util.List;

public interface SentenceRepository {

    DemoSentence save(DemoSentence sentence);

    DemoSentence findById(Long id);
    List<DemoSentence> findAll();
}
