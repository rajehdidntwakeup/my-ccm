package project.cmm.myccm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.cmm.myccm.core.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long>{

}
