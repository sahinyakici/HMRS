package kodlamaio.HMRS.business.concretes;

import kodlamaio.HMRS.business.abstracts.HmrsAuthService;
import kodlamaio.HMRS.core.utilities.results.DataResult;
import kodlamaio.HMRS.core.utilities.results.Result;
import kodlamaio.HMRS.core.utilities.results.SuccessDataResult;
import kodlamaio.HMRS.core.utilities.results.SuccessResult;
import kodlamaio.HMRS.dataAccess.abstracts.HmrsAuthDao;
import kodlamaio.HMRS.entities.concretes.HmrsAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HmrsAuthManager implements HmrsAuthService {
    private HmrsAuthDao hmrsAuthDao;

    @Autowired
    public HmrsAuthManager(HmrsAuthDao hmrsAuthDao) {
        this.hmrsAuthDao = hmrsAuthDao;
    }

    @Override
    public DataResult<List<HmrsAuth>> getAll() {
        return new SuccessDataResult<List<HmrsAuth>>(this.hmrsAuthDao.findAll());
    }

    @Override
    public DataResult<HmrsAuth> getById(int id) {
        return new SuccessDataResult<HmrsAuth>(this.hmrsAuthDao.findById(id));
    }

    @Override
    public Result save(HmrsAuth hmrsAuth) {
        this.hmrsAuthDao.save(hmrsAuth);
        return new SuccessResult("Auth is successfully added");
    }
}
