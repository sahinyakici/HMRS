package kodlamaio.HMRS.api.controllers;

import kodlamaio.HMRS.business.abstracts.CandidateService;
import kodlamaio.HMRS.core.utilities.results.DataResult;
import kodlamaio.HMRS.core.utilities.results.Result;
import kodlamaio.HMRS.entities.concretes.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/candidate")
public class CandidatesController {
    private CandidateService candidateService;

    @Autowired
    public CandidatesController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @GetMapping("/getAll")
    public DataResult<List<Candidate>> getAllCandidates() {
        return this.candidateService.getAll();
    }

    @PostMapping("/add")
    public Result addCandidate(@RequestBody Candidate candidate) {
        return this.candidateService.addCandidate(candidate);
    }
}
