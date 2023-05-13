package kodlamaio.HMRS.business.concretes;

import kodlamaio.HMRS.business.abstracts.SchoolService;
import kodlamaio.HMRS.core.utilities.results.DataResult;
import kodlamaio.HMRS.core.utilities.results.Result;
import kodlamaio.HMRS.core.utilities.results.SuccessDataResult;
import kodlamaio.HMRS.core.utilities.results.SuccessResult;
import kodlamaio.HMRS.dataAccess.abstracts.SchoolDao;
import kodlamaio.HMRS.entities.concretes.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolManager implements SchoolService {
    private SchoolDao schoolDao;

    @Autowired
    public SchoolManager(SchoolDao schoolDao) {
        this.schoolDao = schoolDao;
    }

    @Override
    public DataResult<List<School>> getAll() {
        return new SuccessDataResult<>(this.schoolDao.findAll());
    }

    @Override
    public Result add(School school) {
        this.schoolDao.save(school);
        return new SuccessResult("school is added successfully");
    }
}
