package kodlamaio.HMRS.dataAccess.abstracts;

import kodlamaio.HMRS.entities.concretes.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobDao extends JpaRepository<Job, Integer> {
}
