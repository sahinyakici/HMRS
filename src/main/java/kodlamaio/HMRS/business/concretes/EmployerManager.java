package kodlamaio.HMRS.business.concretes;

import kodlamaio.HMRS.business.abstracts.EmployerService;
import kodlamaio.HMRS.core.utilities.results.*;
import kodlamaio.HMRS.dataAccess.abstracts.EmailAuthDao;
import kodlamaio.HMRS.dataAccess.abstracts.EmployerDao;
import kodlamaio.HMRS.dataAccess.abstracts.HmrsAuthDao;
import kodlamaio.HMRS.entities.concretes.EMailAuth;
import kodlamaio.HMRS.entities.concretes.Employer;
import kodlamaio.HMRS.entities.concretes.HmrsAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Objects;

@Service
public class EmployerManager implements EmployerService {
    private EmployerDao employerDao;
    private EmailAuthDao emailAuthDao;
    private HmrsAuthDao hmrsAuthDao;

    @Autowired
    public EmployerManager(EmployerDao employerDao, EmailAuthDao emailAuthDao, HmrsAuthDao hmrsAuthDao) {
        this.employerDao = employerDao;
        this.emailAuthDao = emailAuthDao;
        this.hmrsAuthDao = hmrsAuthDao;
    }

    @Override
    public DataResult<List<Employer>> getAll() {
        return new SuccessDataResult<List<Employer>>(this.employerDao.findAll());
    }

    @Override
    public Result add(Employer employer) {
        Result emailResult = isEmailAlreadyRegistered(employer.getEMail());
        if (!emailResult.isSuccess()) {
            return new ErrorResult(emailResult.getMessage());
        }
        Result passwordResult = isPasswordsMatch(employer.getPassword(), employer.getRePassword());
        if (!passwordResult.isSuccess())
            return new ErrorResult(passwordResult.getMessage());
        Result domainResult = emailPrefix(employer);
        if (!domainResult.isSuccess())
            return new ErrorResult(domainResult.getMessage());
        Date date = new Date(System.currentTimeMillis());
        emailPrefix(employer);
        createEmailAuth(employer, date);
        createHmrsAuth(employer, date);
        this.employerDao.save(employer);
        return new SuccessResult("Employer added successfully");
    }

    void createEmailAuth(Employer employer, Date date) {
        EMailAuth newEMailAuth = new EMailAuth(0, true, date);
        emailAuthDao.save(newEMailAuth);
        employer.setEMailAuth(newEMailAuth.getId());
    }

    Result isPasswordsMatch(String password, String rePassword) {
        if (Objects.equals(password, rePassword))
            return new SuccessResult("Passwords match");
        return new ErrorResult("Passwords are not matched");
    }

    void createHmrsAuth(Employer employer, Date date) {
        HmrsAuth hmrsAuth = new HmrsAuth(0, date, 1, true);
        this.hmrsAuthDao.save(hmrsAuth);
        employer.setHrmsAuth(hmrsAuth.getId());
    }

    Result isEmailAlreadyRegistered(String email) {
        List<Employer> result = this.employerDao.findByeMailIgnoreCase(email);
        if (result.size() == 0)
            return new SuccessResult("");
        return new ErrorResult("Email already registered");
    }

    Result emailPrefix(Employer employer) {
        String domain = employer.getWebSite().replaceAll(".*\\.(?=.*\\.)", "");
        if (employer.getEMail().contains(domain))
            return new SuccessResult("");
        return new ErrorResult("Email didn't have true domain");
    }
}
