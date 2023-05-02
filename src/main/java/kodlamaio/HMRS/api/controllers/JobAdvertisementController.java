package kodlamaio.HMRS.api.controllers;

import kodlamaio.HMRS.business.abstracts.JobAdvertisementService;
import kodlamaio.HMRS.core.utilities.results.DataResult;
import kodlamaio.HMRS.core.utilities.results.Result;
import kodlamaio.HMRS.entities.concretes.JobAdvertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobAdvertisement")
public class JobAdvertisementController {
    private JobAdvertisementService jobAdvertisement;

    @Autowired
    public JobAdvertisementController(JobAdvertisementService jobAdvertisement) {
        this.jobAdvertisement = jobAdvertisement;
    }

    @GetMapping("/getAll")
    public DataResult<List<JobAdvertisement>> getAll() {
        return this.jobAdvertisement.getAll();
    }

    @PostMapping("/save")
    public Result addJobAdvertisement(@RequestBody JobAdvertisement jobAdvertisement) {
        return this.jobAdvertisement.addJobAdvertisement(jobAdvertisement);
    }

    @GetMapping("/getAllWhichIsOpen")
    public DataResult<List<JobAdvertisement>> findByIsOpen() {
        return this.jobAdvertisement.findByIsOpen(true);
    }

    @GetMapping("/getAllWhichIsOpenOrder")
    public DataResult<List<JobAdvertisement>> findByIsOpenOrderByApplicationDeadlineAsc() {
        return this.jobAdvertisement.findByIsOpenOrderByApplicationDeadlineAsc(true);
    }

    @GetMapping("/getAllWithCompanyName")
    public DataResult<List<JobAdvertisement>> findByEmployerCompanyName(@RequestParam String employerName, @RequestParam Boolean isOpen) {
        return this.jobAdvertisement.findByEmployerCompanyNameAndIsOpen(employerName, isOpen);
    }

    @PatchMapping("/updateWithId")
    DataResult<JobAdvertisement> setJobAdvertisementStatus(@RequestParam int id, @RequestParam boolean newStatus) {
        return this.jobAdvertisement.setJobAdvertisementStatus(id, newStatus);
    }
}
