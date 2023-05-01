package kodlamaio.HMRS.api.controllers;

import kodlamaio.HMRS.business.abstracts.MernisAuthService;
import kodlamaio.HMRS.core.utilities.results.DataResult;
import kodlamaio.HMRS.core.utilities.results.Result;
import kodlamaio.HMRS.entities.concretes.MernisAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mernis")
public class MernisAuthsController {
    private MernisAuthService mernisAuthService;

    @Autowired
    public MernisAuthsController(MernisAuthService mernisAuthService) {
        this.mernisAuthService = mernisAuthService;
    }

    @GetMapping("/getall")
    public DataResult<List<MernisAuth>> getAll() {
        return this.mernisAuthService.getAll();
    }

    @GetMapping("/getbyid")
    public DataResult<MernisAuth> getByid(@RequestParam int id) {
        return this.mernisAuthService.getById(id);
    }

    @PostMapping("/add")
    public Result addMernisAuth(@RequestBody MernisAuth mernisAuth) {
        return this.mernisAuthService.add(mernisAuth);
    }
}
