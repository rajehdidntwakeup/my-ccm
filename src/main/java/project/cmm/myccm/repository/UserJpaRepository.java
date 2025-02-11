package project.cmm.myccm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.cmm.myccm.core.model.AppUser;

@Repository
public interface UserJpaRepository extends JpaRepository<AppUser, Long> {

}
