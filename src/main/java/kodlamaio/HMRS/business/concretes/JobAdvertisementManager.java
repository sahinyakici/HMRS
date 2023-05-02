package kodlamaio.HMRS.business.concretes;

import kodlamaio.HMRS.business.abstracts.JobAdvertisementService;
import kodlamaio.HMRS.core.utilities.results.DataResult;
import kodlamaio.HMRS.core.utilities.results.Result;
import kodlamaio.HMRS.core.utilities.results.SuccessDataResult;
import kodlamaio.HMRS.core.utilities.results.SuccessResult;
import kodlamaio.HMRS.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.HMRS.entities.concretes.JobAdvertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {
    private JobAdvertisementDao jobAdvertisementDao;

    @Autowired
    public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
        this.jobAdvertisementDao = jobAdvertisementDao;
    }

    @Override
    public DataResult<List<JobAdvertisement>> getAll() {
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll());
    }

    @Override
    public DataResult<List<JobAdvertisement>> findByIsOpen(boolean isOpen) {
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findByIsOpen(isOpen));
    }

    @Override
    public DataResult<List<JobAdvertisement>> findByIsOpenOrderByApplicationDeadlineAsc(boolean isOpen) {
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findByIsOpenOrderByApplicationDeadlineAsc(isOpen));
    }

    @Override
    public Result addJobAdvertisement(JobAdvertisement jobAdvertisement) {
        this.jobAdvertisementDao.save(jobAdvertisement);
        return new SuccessResult();
    }

    @Override
    public DataResult<List<JobAdvertisement>> findByEmployerCompanyNameAndIsOpen(String employerName, boolean isOpen) {
        return new SuccessDataResult<>(this.jobAdvertisementDao.findByEmployerCompanyNameAndIsOpen(employerName, isOpen));
    }

    @Override
    public DataResult<JobAdvertisement> findById(int id) {
        return new SuccessDataResult<>(this.jobAdvertisementDao.findById(id));
    }

    @Override
    public DataResult<JobAdvertisement> setJobAdvertisementStatus(int id, boolean newStatus) {
        JobAdvertisement advertisement = findById(id).getData();
        advertisement.setOpen(newStatus);
        return new SuccessDataResult<>(this.jobAdvertisementDao.save(advertisement));
    }

}
