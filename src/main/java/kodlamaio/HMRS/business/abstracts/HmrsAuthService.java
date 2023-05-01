package kodlamaio.HMRS.business.abstracts;

import kodlamaio.HMRS.core.utilities.results.DataResult;
import kodlamaio.HMRS.core.utilities.results.Result;
import kodlamaio.HMRS.entities.concretes.HmrsAuth;

import java.util.List;

public interface HmrsAuthService {
    DataResult<List<HmrsAuth>> getAll();

    DataResult<HmrsAuth> getById(int id);

    Result save(HmrsAuth hmrsAuth);
}
