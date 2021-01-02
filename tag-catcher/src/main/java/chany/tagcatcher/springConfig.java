package chany.tagcatcher;

import chany.tagcatcher.repository.SentenceRepository;
import chany.tagcatcher.service.SentenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class springConfig {

    private final SentenceRepository sentenceRepository;

    @Autowired
    public springConfig(SentenceRepository sentenceRepository) {
        this.sentenceRepository = sentenceRepository;
    }

    public SentenceService sentenceService() {
        return new SentenceService(sentenceRepository);
    }
}
