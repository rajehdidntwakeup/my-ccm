package project.cmm.myccm.repository;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceUnit;
import project.cmm.myccm.core.model.dto.CompanyDto;

@Repository
public class CompanyUserRepository {

	@PersistenceUnit
	public EntityManagerFactory entityManagerFactory;
	
	
	
	public CompanyDto getCompanyDto() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Session session = entityManager.unwrap(Session.class);
		session.beginTransaction();
//		CompanyDto company = session.createQuery("SELECT new project.cmm.myccm.core.model.dto.CompanyDto()", CompanyDto.class);
		
		return null;
	}
}
