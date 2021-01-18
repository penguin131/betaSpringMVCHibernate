package edu.school21.cinema.repositories;

import edu.school21.cinema.models.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class SessionRepositoryImpl implements SessionRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Session> findAll() {
        return entityManager.createQuery("from Session ", Session.class).getResultList();
    }

    @Override
    @Transactional
    public void save(Session session) {
        entityManager.persist(session);
        entityManager.flush();
    }
}
