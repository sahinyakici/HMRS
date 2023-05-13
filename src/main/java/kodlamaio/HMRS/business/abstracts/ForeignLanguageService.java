package kodlamaio.HMRS.business.abstracts;

import kodlamaio.HMRS.core.utilities.results.DataResult;
import kodlamaio.HMRS.core.utilities.results.Result;
import kodlamaio.HMRS.entities.concretes.ForeignLanguage;

import java.util.List;

public interface ForeignLanguageService {
    DataResult<List<ForeignLanguage>> getAll();

    Result add(ForeignLanguage foreignLanguage);
}
