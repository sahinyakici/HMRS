package kodlamaio.HMRS.dataAccess.abstracts;

import kodlamaio.HMRS.entities.concretes.HmrsEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HmrsEmployeeDao extends JpaRepository<HmrsEmployee, Integer> {
    HmrsEmployee findById(int id);
}
