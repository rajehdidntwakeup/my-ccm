package project.cmm.myccm.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceUnit;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import project.cmm.myccm.core.model.AppUser;

import java.util.List;

@Repository
public class AppUserRepository {

    @PersistenceUnit
    public EntityManagerFactory entityManagerFactory;

    public AppUser findUserById(long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        AppUser user = entityManager.find(AppUser.class, id);
        entityManager.close();
        return user;
    }

    public AppUser findUserByUsername(String username) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Session session = entityManager.unwrap(Session.class);
        session.beginTransaction();
        AppUser user = session.createQuery("SELECT u FROM AppUser u WHERE u.username = :username", AppUser.class)
                .setParameter("username", username).getSingleResultOrNull();

        session.getTransaction().commit();
        session.close();
        return user;
    }

    public List<AppUser> findAllUsers() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Session session = entityManager.unwrap(Session.class);
        session.beginTransaction();
        List<AppUser> users = session.createQuery("SELECT u FROM AppUser u", AppUser.class).getResultList();
        session.getTransaction().commit();
        session.close();
        return users;
    }

    public void saveNewUser(AppUser user) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Session session = entityManager.unwrap(Session.class);
        session.beginTransaction();
        session.persist(AppUser.class.getName(), user);
        session.flush();
        session.getTransaction().commit();
        session.close();
        entityManager.close();
    }

    public void updateUser(AppUser updatedUser) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.merge(updatedUser);
        entityManager.close();
    }

}
