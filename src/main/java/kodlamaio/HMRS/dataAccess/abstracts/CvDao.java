package kodlamaio.HMRS.dataAccess.abstracts;

import kodlamaio.HMRS.entities.concretes.Cv;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CvDao extends JpaRepository<Cv, Integer> {
    List<Cv> getByCandidateId(int candidateId);

    Cv getById(int id);
}
