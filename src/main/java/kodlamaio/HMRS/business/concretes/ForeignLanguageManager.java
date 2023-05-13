package kodlamaio.HMRS.business.concretes;

import kodlamaio.HMRS.business.abstracts.ForeignLanguageService;
import kodlamaio.HMRS.core.utilities.results.DataResult;
import kodlamaio.HMRS.core.utilities.results.Result;
import kodlamaio.HMRS.core.utilities.results.SuccessDataResult;
import kodlamaio.HMRS.core.utilities.results.SuccessResult;
import kodlamaio.HMRS.dataAccess.abstracts.ForeignLanguageDao;
import kodlamaio.HMRS.entities.concretes.ForeignLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ForeignLanguageManager implements ForeignLanguageService {
    private ForeignLanguageDao foreignLanguageDao;

    @Autowired
    public ForeignLanguageManager(ForeignLanguageDao foreignLanguageDao) {
        this.foreignLanguageDao = foreignLanguageDao;
    }

    @Override
    public DataResult<List<ForeignLanguage>> getAll() {
        return new SuccessDataResult<>(this.foreignLanguageDao.findAll());
    }

    @Override
    public Result add(ForeignLanguage foreignLanguage) {
        this.foreignLanguageDao.save(foreignLanguage);
        return new SuccessResult("Language is added");
    }
}
