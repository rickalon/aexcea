package rickalon.aexcea.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import rickalon.aexcea.model.AexceaUser;

public interface AexceaUserRepository extends JpaRepository<AexceaUser, Long> {
    
}
