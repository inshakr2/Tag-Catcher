package chany.tagcatcher.service;

import chany.tagcatcher.domain.Sentence;
import chany.tagcatcher.repository.SentenceRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@SpringBootTest
@Transactional
class SentenceServiceIntegrationTest {

    @Autowired
    SentenceRepository sentenceRepository;
    @Autowired
    SentenceService sentenceService;


    @Test
    void 문장등록() {
        Sentence sentence = new Sentence();
        // csvBind 생략
        sentence.setSentence("안녕하세요. <유창열:PE>입니다. 테스트 문장 등록");

        // when
        Long registId = sentenceService.regist(sentence);

        // then
        Sentence registSentence = sentenceService.findOne(registId).get();
        System.out.println("registSentence = " + registSentence.getId());
        System.out.println("registSentence = " + registSentence.getSentence());
        System.out.println("registSentence = " + registSentence.getResult());
        System.out.println("registSentence = " + registSentence.getOrgSentence());

    }

    @Test
    void 문장수정() {
        Sentence sentence = new Sentence();
        sentence.setSentence("안녕하세요, <유창열:P123ER>입니다. Test를 위해 Tag를 이렇게 적었네요.");
        String updateSentence = "안녕하세요, <유창열:PER>입니다. Test를 위해 문장을 수정해봤어요.";

        //when
        Long registId = sentenceService.regist(sentence);
        System.out.println(sentenceService.findOne(registId).get().getSentence());
        Optional<Sentence> update = sentenceService.updateById(registId, updateSentence);

        //then
        System.out.println(sentenceService.findOne(registId).get().getSentence());

    }
}
