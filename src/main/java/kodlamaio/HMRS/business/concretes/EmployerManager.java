package kodlamaio.HMRS.business.concretes;

import kodlamaio.HMRS.business.abstracts.EmployerService;
import kodlamaio.HMRS.core.utilities.results.*;
import kodlamaio.HMRS.dataAccess.abstracts.EmailAuthDao;
import kodlamaio.HMRS.dataAccess.abstracts.EmployerDao;
import kodlamaio.HMRS.dataAccess.abstracts.HmrsAuthDao;
import kodlamaio.HMRS.dataAccess.abstracts.HmrsEmployeeDao;
import kodlamaio.HMRS.entities.concretes.EMailAuth;
import kodlamaio.HMRS.entities.concretes.Employer;
import kodlamaio.HMRS.entities.concretes.HmrsAuth;
import kodlamaio.HMRS.entities.concretes.HmrsEmployee;
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
    private HmrsEmployeeDao hmrsEmployeeDao;

    @Autowired
    public EmployerManager(EmployerDao employerDao, EmailAuthDao emailAuthDao, HmrsAuthDao hmrsAuthDao, HmrsEmployeeDao hmrsEmployeeDao) {
        this.employerDao = employerDao;
        this.emailAuthDao = emailAuthDao;
        this.hmrsAuthDao = hmrsAuthDao;
        this.hmrsEmployeeDao = hmrsEmployeeDao;
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
        EMailAuth newEMailAuth = new EMailAuth(0, true, date, null);
        emailAuthDao.save(newEMailAuth);
        employer.setEMailAuth(newEMailAuth);
    }

    Result isPasswordsMatch(String password, String rePassword) {
        if (Objects.equals(password, rePassword))
            return new SuccessResult("Passwords match");
        return new ErrorResult("Passwords are not matched");
    }

    void createHmrsAuth(Employer employer, Date date) {
        HmrsAuth hmrsAuth = new HmrsAuth(0, date, true, null, getEmployee());
        this.hmrsAuthDao.save(hmrsAuth);
        employer.setHmrsAuth(hmrsAuth);
    }

    HmrsEmployee getEmployee() {
        return this.hmrsEmployeeDao.findById(1);
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
