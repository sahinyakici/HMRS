package kodlamaio.HMRS.dataAccess.abstracts;

import kodlamaio.HMRS.entities.concretes.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CandidateDao extends JpaRepository<Candidate, Integer> {
    List<Candidate> findByeMailIgnoreCase(String email);

    List<Candidate> findByNationalId(String nationalId);

    Candidate findById(int id);
}
