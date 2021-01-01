package chany.tagcatcher.service;

import chany.tagcatcher.domain.Sentence;
import chany.tagcatcher.repository.SentenceRepository;
import org.apache.catalina.startup.SetNextNamingRule;

public class SentenceService {

    public SentenceService(SentenceRepository sentenceRepository) {
        this.sentenceRepository = sentenceRepository;
    }
    private final SentenceRepository sentenceRepository;

    /**
     * sentence 객체 등록
     */
    public Long regist(Sentence sentence) {
        sentenceRepository.save(sentence);
        return sentence.getId();

    }



}
