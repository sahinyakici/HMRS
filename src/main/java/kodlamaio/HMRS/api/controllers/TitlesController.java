package kodlamaio.HMRS.api.controllers;

import kodlamaio.HMRS.business.abstracts.TitleService;
import kodlamaio.HMRS.core.utilities.results.DataResult;
import kodlamaio.HMRS.core.utilities.results.Result;
import kodlamaio.HMRS.entities.concretes.Title;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/titles")
public class TitlesController {
    private TitleService titleService;

    @Autowired
    public TitlesController(TitleService titleService) {
        this.titleService = titleService;
    }

    @GetMapping("/getAll")
    public DataResult<List<Title>> getAll() {
        return titleService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody Title title) {
        return this.titleService.add(title);
    }
}
