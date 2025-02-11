package project.cmm.myccm.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceUnit;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import project.cmm.myccm.core.model.dto.CompanyDto;

@Repository
public class CompanyUserRepository {

    @PersistenceUnit
    public EntityManagerFactory entityManagerFactory;

    public CompanyDto getCompanyDtoById(long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Session session = entityManager.unwrap(Session.class);
        session.beginTransaction();
        String fetchQuery = "SELECT new project.cmm.myccm.core.model.dto.CompanyDto(c.name, a.streetName, a.streetNumber, a.zip, a.city) "
                + "FROM Company c "
                + "JOIN c.addresses a "
                + "WHERE c.companyId = :id";
        CompanyDto company = session.createQuery(fetchQuery, CompanyDto.class).setParameter("id", id).getSingleResult();

        return company;
    }
}
