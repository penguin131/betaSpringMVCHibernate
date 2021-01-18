package edu.school21.cinema.repositories;

import edu.school21.cinema.models.Film;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class FilmRepositoryImpl implements FilmRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Film> findAll() {
        return entityManager.createQuery("from Film ", Film.class).getResultList();
    }

    @Override
    @Transactional
    public void save(Film film) {
        entityManager.persist(film);
        entityManager.flush();
    }

    @Override
    public Film findForId(int id) {
        return entityManager
                .createQuery("from Film where filmId=:id",Film.class)
                .setParameter("id", id)
                .getSingleResult();
    }
}
