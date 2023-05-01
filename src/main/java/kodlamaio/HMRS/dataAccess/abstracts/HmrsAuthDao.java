package kodlamaio.HMRS.dataAccess.abstracts;

import kodlamaio.HMRS.entities.concretes.HmrsAuth;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HmrsAuthDao extends JpaRepository<HmrsAuth, Integer> {
    HmrsAuth findById(int id);
}
