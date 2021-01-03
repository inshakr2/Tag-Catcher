package chany.tagcatcher.service;

import chany.tagcatcher.repository.SentenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class IntegrationTest {

    @Autowired
    SentenceRepository sentenceRepository;
    @Autowired
    SentenceService sentenceService;


}
