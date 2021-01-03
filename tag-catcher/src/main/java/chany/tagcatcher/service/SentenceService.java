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
     * id 값으로 조회 후
     * updateSentence로 문장 수정
     * result, orgSentence 모두 재세팅 후 save
     */
    public Optional<Sentence> updateById(Long id, String updateSentence) {
        Optional<Sentence> sentence = sentenceRepository.findById(id);

        sentence.ifPresent(newSentence -> {
            newSentence.setSentence(updateSentence);
            newSentence.setResult();
            newSentence.setOrgSentence();
            sentenceRepository.save(newSentence);
        });
        return sentence;
    }

    /**
     * id 값으로 문장 삭제
     */
    public void deleteOne(Long id) {

        sentenceRepository.findById(id)
                .ifPresent(action -> {
                    sentenceRepository.deleteById(id);
                });

    }

    /**
     * 전체 조회
     */
    public List<Sentence> findAll() {
        return sentenceRepository.findAll();
    }





}
