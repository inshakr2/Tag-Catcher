package chany.tagcatcher.repository;

import chany.tagcatcher.domain.DemoSentence;

import javax.persistence.EntityManager;
import java.util.List;

public class JpaSentenceRepository implements SentenceRepository {

    public JpaSentenceRepository(EntityManager em) {
        this.em = em;
    }

    private final EntityManager em;


    @Override
    public DemoSentence save(DemoSentence sentence) {
        em.persist(sentence);
        return sentence;
    }

    @Override
    public DemoSentence findById(Long id) {
        DemoSentence sentence = em.find(DemoSentence.class, id);
        return sentence;
    }

    @Override
    public List<DemoSentence> findAll() {
        List<DemoSentence> result = em.createQuery("select sen from DemoSentence sen", DemoSentence.class)
                .getResultList();
        return result;
    }
}
