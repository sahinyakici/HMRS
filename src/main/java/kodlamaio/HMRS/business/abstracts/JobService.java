package kodlamaio.HMRS.business.abstracts;

import kodlamaio.HMRS.core.utilities.results.DataResult;
import kodlamaio.HMRS.core.utilities.results.Result;
import kodlamaio.HMRS.entities.concretes.Job;

import java.util.List;

public interface JobService {
    DataResult<List<Job>> getAllJob();

    Result addJob(Job job);

    DataResult<Job> getById(int id);
}
