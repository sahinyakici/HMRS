package kodlamaio.HMRS.dataAccess.abstracts;

import kodlamaio.HMRS.entities.concretes.Title;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TitleDao extends JpaRepository<Title, Integer> {
}
