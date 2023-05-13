package kodlamaio.HMRS.business.concretes;

import kodlamaio.HMRS.business.abstracts.CvService;
import kodlamaio.HMRS.core.utilities.results.DataResult;
import kodlamaio.HMRS.core.utilities.results.Result;
import kodlamaio.HMRS.core.utilities.results.SuccessDataResult;
import kodlamaio.HMRS.core.utilities.results.SuccessResult;
import kodlamaio.HMRS.dataAccess.abstracts.*;
import kodlamaio.HMRS.entities.concretes.Cv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CvManager implements CvService {
    private CvDao cvDao;
    private SchoolDao schoolDao;
    private JobDao jobDao;
    private ForeignLanguageDao foreignLanguageDao;
    private CandidateDao candidateDao;

    @Autowired
    public CvManager(CvDao cvDao, SchoolDao schoolDao, JobDao jobDao, ForeignLanguageDao foreignLanguageDao, CandidateDao candidateDao) {
        this.cvDao = cvDao;
        this.schoolDao = schoolDao;
        this.jobDao = jobDao;
        this.foreignLanguageDao = foreignLanguageDao;
        this.candidateDao = candidateDao;
    }

    @Override
    public Result add(Cv cv) {
        cv.setCandidate(candidateDao.findById(cv.getCandidate().getId()));
        this.cvDao.save(cv);
        return new SuccessResult("Cv successfully added");
    }

    @Override
    public DataResult<List<Cv>> getAll() {
        return new SuccessDataResult<>(this.cvDao.findAll());
    }

    @Override
    public DataResult<Cv> getById(int id) {
        return new SuccessDataResult(this.cvDao.getById(id));
    }

    @Override
    public DataResult<List<Cv>> getByCandidateId(int candidateId) {
        return new SuccessDataResult<>(this.cvDao.getByCandidateId(candidateId));
    }


}
