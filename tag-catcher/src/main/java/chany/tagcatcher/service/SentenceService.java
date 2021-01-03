package chany.tagcatcher.service;

import chany.tagcatcher.domain.Sentence;
import chany.tagcatcher.repository.SentenceRepository;

import java.util.List;
import java.util.Optional;

public class SentenceService {

    private SentenceRepository sentenceRepository;

    public SentenceService(SentenceRepository sentenceRepository) {
        this.sentenceRepository = sentenceRepository;
    }

    /**
     * sentence 객체 등록
     */
    public Long regist(Sentence sentence) {
        sentence.setResult();
        sentence.setOrgSentence();
        sentenceRepository.save(sentence);
        return sentence.getId();

    }

    /**
     * id 값으로 조회
     */
    public Optional<Sentence> findOne(Long id) {
        return sentenceRepository.findById(id);
    }

    /**
     * 전체 조회
     */
    public List<Sentence> findAll() {
        return sentenceRepository.findAll();
    }





}
