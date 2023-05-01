package kodlamaio.HMRS.business.abstracts;

import kodlamaio.HMRS.core.utilities.results.DataResult;
import kodlamaio.HMRS.core.utilities.results.Result;
import kodlamaio.HMRS.entities.concretes.EMailAuth;

import java.util.List;

public interface EmailAuthService {
    DataResult<List<EMailAuth>> getAll();

    DataResult<EMailAuth> getById(int id);

    Result add(EMailAuth email);
}
