package kodlamaio.HMRS.dataAccess.abstracts;

import kodlamaio.HMRS.core.utilities.results.Result;
import kodlamaio.HMRS.entities.concretes.MernisAuth;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MernisAuthDao extends JpaRepository<MernisAuth, Integer> {
    MernisAuth findById(int id);
}
