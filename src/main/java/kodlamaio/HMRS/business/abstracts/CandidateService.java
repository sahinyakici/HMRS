package kodlamaio.HMRS.business.abstracts;

import kodlamaio.HMRS.core.utilities.results.DataResult;
import kodlamaio.HMRS.core.utilities.results.Result;
import kodlamaio.HMRS.entities.concretes.Candidate;

import java.util.List;

public interface CandidateService {
    DataResult<List<Candidate>> getAll();
    Result addCandidate(Candidate candidate);
}
