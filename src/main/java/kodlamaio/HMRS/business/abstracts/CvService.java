package kodlamaio.HMRS.business.abstracts;

import kodlamaio.HMRS.core.utilities.results.DataResult;
import kodlamaio.HMRS.core.utilities.results.Result;
import kodlamaio.HMRS.entities.concretes.Cv;

import java.util.List;

public interface CvService {
    Result add(Cv cv);

    DataResult<List<Cv>> getAll();

    DataResult<Cv> getById(int id);

    DataResult<List<Cv>> getByCandidateId(int candidateId);
}
