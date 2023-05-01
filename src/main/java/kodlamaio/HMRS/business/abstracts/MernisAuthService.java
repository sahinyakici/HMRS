package kodlamaio.HMRS.business.abstracts;

import kodlamaio.HMRS.core.utilities.results.DataResult;
import kodlamaio.HMRS.core.utilities.results.Result;
import kodlamaio.HMRS.entities.concretes.MernisAuth;

import java.util.List;

public interface MernisAuthService {
    DataResult<List<MernisAuth>> getAll();

    DataResult<MernisAuth> getById(int id);

    Result add(MernisAuth auth);
}
