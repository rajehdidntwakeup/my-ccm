package project.cmm.myccm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import project.cmm.myccm.core.model.Company;

public interface CompanyRepository extends JpaRepository<Company, Long>{

}
