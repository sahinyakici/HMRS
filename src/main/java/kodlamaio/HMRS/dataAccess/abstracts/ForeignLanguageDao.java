package kodlamaio.HMRS.dataAccess.abstracts;

import kodlamaio.HMRS.entities.concretes.ForeignLanguage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ForeignLanguageDao extends JpaRepository<ForeignLanguage, Integer> {
}
