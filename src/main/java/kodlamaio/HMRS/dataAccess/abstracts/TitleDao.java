package kodlamaio.HMRS.dataAccess.abstracts;

import kodlamaio.HMRS.entities.concretes.Title;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TitleDao extends JpaRepository<Title, Integer> {
    List<Title> findByTitleName(String titleName);
}
