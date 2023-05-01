package kodlamaio.HMRS.dataAccess.abstracts;

import kodlamaio.HMRS.entities.concretes.Employer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployerDao extends JpaRepository<Employer, Integer> {
    List<Employer> findByeMailIgnoreCase(String email);
}
