package kodlamaio.HMRS.business.abstracts;

import kodlamaio.HMRS.core.utilities.results.DataResult;
import kodlamaio.HMRS.core.utilities.results.Result;
import kodlamaio.HMRS.entities.concretes.JobAdvertisement;

import java.util.List;

public interface JobAdvertisementService {
    DataResult<List<JobAdvertisement>> getAll();

    DataResult<List<JobAdvertisement>> findByIsOpen(boolean isOpen);

    DataResult<List<JobAdvertisement>> findByIsOpenOrderByApplicationDeadlineAsc(boolean isOpen);

    Result addJobAdvertisement(JobAdvertisement jobAdvertisement);

    DataResult<List<JobAdvertisement>> findByEmployerCompanyNameAndIsOpen(String employerCompanyName, boolean isOpen);

    DataResult<JobAdvertisement> findById(int id);

    DataResult<JobAdvertisement> setJobAdvertisementStatus(int id, boolean newStatus);
}
