package kodlamaio.HMRS.business.concretes;

import kodlamaio.HMRS.business.abstracts.MernisAuthService;
import kodlamaio.HMRS.core.utilities.results.DataResult;
import kodlamaio.HMRS.core.utilities.results.Result;
import kodlamaio.HMRS.core.utilities.results.SuccessDataResult;
import kodlamaio.HMRS.core.utilities.results.SuccessResult;
import kodlamaio.HMRS.dataAccess.abstracts.MernisAuthDao;
import kodlamaio.HMRS.entities.concretes.MernisAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MernisAuthManager implements MernisAuthService {
    private MernisAuthDao mernisAuthDao;

    @Autowired
    public MernisAuthManager(MernisAuthDao mernisAuthDao) {
        this.mernisAuthDao = mernisAuthDao;
    }

    @Override
    public DataResult<List<MernisAuth>> getAll() {
        return new SuccessDataResult<List<MernisAuth>>(mernisAuthDao.findAll(), "Mernis auths are listed");
    }

    @Override
    public DataResult<MernisAuth> getById(int id) {
        return new SuccessDataResult<MernisAuth>(mernisAuthDao.findById(id));
    }

    @Override
    public Result add(MernisAuth auth) {
        mernisAuthDao.save(auth);
        return new SuccessResult("Auth is registered");
    }
}
