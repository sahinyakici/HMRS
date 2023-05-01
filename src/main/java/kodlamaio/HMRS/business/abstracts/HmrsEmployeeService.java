package kodlamaio.HMRS.business.abstracts;

import kodlamaio.HMRS.core.utilities.results.DataResult;
import kodlamaio.HMRS.core.utilities.results.Result;
import kodlamaio.HMRS.entities.concretes.HmrsEmployee;

import java.util.List;

public interface HmrsEmployeeService {
    DataResult<List<HmrsEmployee>> getAll();

    DataResult<HmrsEmployee> getHmrsEmployeeById(int id);

    Result saveHmrsEmployee(HmrsEmployee employee);
}
