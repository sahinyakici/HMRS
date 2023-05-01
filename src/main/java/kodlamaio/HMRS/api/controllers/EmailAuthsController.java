package kodlamaio.HMRS.api.controllers;

import kodlamaio.HMRS.business.abstracts.EmailAuthService;
import kodlamaio.HMRS.core.utilities.results.DataResult;
import kodlamaio.HMRS.core.utilities.results.Result;
import kodlamaio.HMRS.entities.concretes.EMailAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/emailauth")
public class EmailAuthsController {
    private EmailAuthService emailAuthService;

    @Autowired
    public EmailAuthsController(EmailAuthService emailAuthService) {
        this.emailAuthService = emailAuthService;
    }

    @GetMapping("/all")
    public DataResult<List<EMailAuth>> getAll() {
        return this.emailAuthService.getAll();
    }

    @GetMapping("/byid")
    public DataResult<EMailAuth> getById(@RequestParam int id) {
        return this.emailAuthService.getById(id);
    }

    @PostMapping("/add")
    public Result add(@RequestBody EMailAuth emailAuth) {
        return this.emailAuthService.add(emailAuth);
    }
}
