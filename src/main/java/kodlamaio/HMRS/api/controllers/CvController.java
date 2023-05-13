package kodlamaio.HMRS.api.controllers;

import kodlamaio.HMRS.business.abstracts.CvService;
import kodlamaio.HMRS.core.utilities.results.DataResult;
import kodlamaio.HMRS.core.utilities.results.Result;
import kodlamaio.HMRS.entities.concretes.Cv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cv")
public class CvController {
    private CvService cvService;

    @Autowired
    public CvController(CvService cvService) {
        this.cvService = cvService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody Cv cv) {
        return this.cvService.add(cv);
    }

    @GetMapping("/getAll")
    public DataResult<List<Cv>> getAll() {
        return this.cvService.getAll();
    }

    @GetMapping("/getbyid")
    public DataResult<Cv> getById(@RequestParam int id) {
        return this.cvService.getById(id);
    }

    @GetMapping("/getbycandidateid")
    public DataResult<List<Cv>> getByCandidateId(@RequestParam int candidateId) {
        return this.cvService.getByCandidateId(candidateId);
    }
}
