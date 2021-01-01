package chany.tagcatcher.repository;

import chany.tagcatcher.domain.Sentence;

import javax.persistence.EntityManager;
import java.util.List;

public class JpaSentenceRepository implements SentenceRepository {

    public JpaSentenceRepository(EntityManager em) {
        this.em = em;
    }

    private final EntityManager em;


    @Override
    public Sentence save(Sentence sentence) {
        em.persist(sentence);
        return sentence;
    }

    @Override
    public Sentence findById(Long id) {
        Sentence sentence = em.find(Sentence.class, id);
        return sentence;
    }

    @Override
    public List<Sentence> findAll() {
        List<Sentence> result = em.createQuery("select sen from DemoSentence sen", Sentence.class)
                .getResultList();
        return result;
    }
}
