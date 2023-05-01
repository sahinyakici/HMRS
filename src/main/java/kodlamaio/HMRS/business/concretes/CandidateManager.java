package kodlamaio.HMRS.business.concretes;

import kodlamaio.HMRS.business.abstracts.CandidateService;
import kodlamaio.HMRS.core.utilities.results.*;
import kodlamaio.HMRS.dataAccess.abstracts.CandidateDao;
import kodlamaio.HMRS.dataAccess.abstracts.EmailAuthDao;
import kodlamaio.HMRS.dataAccess.abstracts.MernisAuthDao;
import kodlamaio.HMRS.entities.concretes.Candidate;
import kodlamaio.HMRS.entities.concretes.EMailAuth;
import kodlamaio.HMRS.entities.concretes.MernisAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Objects;

@Service
public class CandidateManager implements CandidateService {
    private CandidateDao candidateDao;
    private EmailAuthDao emailAuthDao;
    private MernisAuthDao mernisAuthDao;

    @Autowired
    public CandidateManager(CandidateDao candidateDao, EmailAuthDao emailAuthDao, MernisAuthDao mernisAuthDao) {
        this.candidateDao = candidateDao;
        this.emailAuthDao = emailAuthDao;
        this.mernisAuthDao = mernisAuthDao;
    }

    @Override
    public DataResult<List<Candidate>> getAll() {
        return new SuccessDataResult<List<Candidate>>(candidateDao.findAll(), "Candidates are listed");
    }

    @Override
    public Result addCandidate(Candidate candidate) {
        Result passwordResult = isPasswordsMatch(candidate.getPassword(), candidate.getRePassword());
        if (!passwordResult.isSuccess())
            return new ErrorResult("Passwords are not matched");
        Result eMailResult = isEmailAlreadyRegistered(candidate.getEMail());
        if (eMailResult.isSuccess())
            return new ErrorResult("Email is already registered");
        Result nationalIdResult = isNationalIdAlreadyRegistered(candidate.getNationalId());
        if (nationalIdResult.isSuccess())
            return new ErrorResult("National Id is already registered");
        Date date = new Date(System.currentTimeMillis());
        createEmailAuth(candidate, date);
        createMernisAuth(candidate, date);
        Result mernisResult = isMernisAuthVerified(candidate.getMernisAuth());
        Result emailAuthResult = isEMailAuthVerified(candidate.getEMailAuth());
        if (mernisResult.isSuccess()) {
            if (emailAuthResult.isSuccess()) {
                candidateDao.save(candidate);
                return new SuccessResult("Registered successfully");
            }
            return new ErrorResult(emailAuthResult.getMessage());
        }
        return new ErrorResult(mernisResult.getMessage());

    }

    Result isEmailAlreadyRegistered(String eMail) {
        List<Candidate> result = candidateDao.findByeMailIgnoreCase(eMail);
        if (result.size() != 0) {
            return new SuccessResult("Email already registered");
        }
        return new ErrorResult("");
    }

    Result isPasswordsMatch(String password, String rePassword) {
        if (Objects.equals(password, rePassword))
            return new SuccessResult("Passwords match");
        return new ErrorResult("");
    }

    Result isNationalIdAlreadyRegistered(String nationalId) {
        List<Candidate> result = candidateDao.findByNationalId(nationalId);
        if (result.size() != 0)
            return new SuccessResult("National Id already registered");
        return new ErrorResult("");
    }

    Result isMernisAuthVerified(int id) {
        MernisAuth mernisAuth = mernisAuthDao.findById(id);
        if (mernisAuth.isVerified()) {
            return new SuccessResult("");
        }
        return new ErrorResult("Mernis auth not verified");
    }

    Result isEMailAuthVerified(int id) {
        EMailAuth emailAuth = emailAuthDao.findById(id);
        if (emailAuth.isVerified()) {
            return new SuccessResult("");
        }
        return new ErrorResult("email auth not verified");
    }

    void createEmailAuth(Candidate candidate, Date date) {
        EMailAuth newEMailAuth = new EMailAuth(0, true, date);
        emailAuthDao.save(newEMailAuth);
        candidate.setEMailAuth(newEMailAuth.getId());
    }

    void createMernisAuth(Candidate candidate, Date date) {
        MernisAuth newMernisAuth = new MernisAuth(0, true, date);
        mernisAuthDao.save(newMernisAuth);
        candidate.setMernisAuth(newMernisAuth.getId());
    }
}
