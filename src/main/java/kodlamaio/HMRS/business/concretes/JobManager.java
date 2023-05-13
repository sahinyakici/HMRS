package kodlamaio.HMRS.business.concretes;

import kodlamaio.HMRS.business.abstracts.JobService;
import kodlamaio.HMRS.core.utilities.results.DataResult;
import kodlamaio.HMRS.core.utilities.results.Result;
import kodlamaio.HMRS.core.utilities.results.SuccessDataResult;
import kodlamaio.HMRS.core.utilities.results.SuccessResult;
import kodlamaio.HMRS.dataAccess.abstracts.JobDao;
import kodlamaio.HMRS.entities.concretes.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobManager implements JobService {
    private JobDao jobDao;

    @Autowired
    public JobManager(JobDao jobDao) {
        this.jobDao = jobDao;
    }

    @Override
    public DataResult<List<Job>> getAllJob() {
        return new SuccessDataResult<>(this.jobDao.findAll());
    }

    @Override
    public Result addJob(Job job) {
        this.jobDao.save(job);
        return new SuccessResult("Job is added successfully");
    }

    @Override
    public DataResult<Job> getById(int id) {
        return new SuccessDataResult<>(this.jobDao.getById(id));
    }
}
