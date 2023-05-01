package kodlamaio.HMRS.business.abstracts;

import kodlamaio.HMRS.core.utilities.results.DataResult;
import kodlamaio.HMRS.entities.concretes.Title;

import java.util.List;

public interface TitleService {
    DataResult<List<Title>> getAll();
}
