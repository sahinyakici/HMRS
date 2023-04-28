package kodlamaio.HMRS.api.controllers;

import kodlamaio.HMRS.business.abstracts.TitleService;
import kodlamaio.HMRS.entities.concretes.Title;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public List<Title> getAll() {
        return titleService.getAll();
    }
}
