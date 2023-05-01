package kodlamaio.HMRS.dataAccess.abstracts;

import kodlamaio.HMRS.core.utilities.results.Result;
import kodlamaio.HMRS.entities.concretes.EMailAuth;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailAuthDao extends JpaRepository<EMailAuth, Integer> {
    EMailAuth findById(int id);
}
