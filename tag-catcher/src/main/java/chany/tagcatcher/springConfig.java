package chany.tagcatcher;

import chany.tagcatcher.repository.SentenceRepository;
import chany.tagcatcher.service.SentenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class springConfig {

    private SentenceRepository sentenceRepository;

    @Autowired
    public springConfig(SentenceRepository sentenceRepository) {
        this.sentenceRepository = sentenceRepository;
    }

    @Bean
    public SentenceService sentenceService() {
        return new SentenceService(sentenceRepository);
    }

}
