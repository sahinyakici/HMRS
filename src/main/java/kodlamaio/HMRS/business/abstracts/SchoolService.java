package kodlamaio.HMRS.business.abstracts;

import kodlamaio.HMRS.core.utilities.results.DataResult;
import kodlamaio.HMRS.core.utilities.results.Result;
import kodlamaio.HMRS.entities.concretes.School;

import java.util.List;

public interface SchoolService {
    DataResult<List<School>> getAll();

    Result add(School school);
}
