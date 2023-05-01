package kodlamaio.HMRS.business.concretes;

import kodlamaio.HMRS.business.abstracts.EmailAuthService;
import kodlamaio.HMRS.core.utilities.results.DataResult;
import kodlamaio.HMRS.core.utilities.results.SuccessDataResult;
import kodlamaio.HMRS.dataAccess.abstracts.EmailAuthDao;
import kodlamaio.HMRS.entities.concretes.EMailAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailAuthManager implements EmailAuthService {
    private EmailAuthDao emailAuthDao;

    @Autowired
    public EmailAuthManager(EmailAuthDao emailAuthDao) {
        this.emailAuthDao = emailAuthDao;
    }

    @Override
    public DataResult<List<EMailAuth>> getAll() {
        return new SuccessDataResult<>(emailAuthDao.findAll(), "Email auths are listed");
    }

    @Override
    public DataResult<EMailAuth> getById(int id) {
        return new SuccessDataResult<EMailAuth>(emailAuthDao.findById(id));
    }

    @Override
    public DataResult<EMailAuth> add(EMailAuth emailAuth) {
        emailAuthDao.save(emailAuth);
        return new SuccessDataResult<EMailAuth>(emailAuth, "Email auth is added");
    }
}
