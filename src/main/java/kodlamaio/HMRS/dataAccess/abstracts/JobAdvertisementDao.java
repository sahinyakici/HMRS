package kodlamaio.HMRS.dataAccess.abstracts;

import kodlamaio.HMRS.entities.concretes.JobAdvertisement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {
    List<JobAdvertisement> findByIsOpen(boolean isOpen);

    List<JobAdvertisement> findByIsOpenOrderByApplicationDeadlineAsc(boolean isOpen);

    List<JobAdvertisement> findByEmployerCompanyNameAndIsOpen(String employerCompanyName, boolean isOpen);

    JobAdvertisement findById(int id);
}
