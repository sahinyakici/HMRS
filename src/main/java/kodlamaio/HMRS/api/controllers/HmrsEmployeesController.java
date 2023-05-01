package kodlamaio.HMRS.api.controllers;

import kodlamaio.HMRS.business.abstracts.HmrsEmployeeService;
import kodlamaio.HMRS.core.utilities.results.DataResult;
import kodlamaio.HMRS.core.utilities.results.Result;
import kodlamaio.HMRS.entities.concretes.HmrsEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/hmrsEmployee")
public class HmrsEmployeesController {
    private HmrsEmployeeService hmrsEmployeeService;

    @Autowired
    public HmrsEmployeesController(HmrsEmployeeService hmrsEmployeeService) {
        this.hmrsEmployeeService = hmrsEmployeeService;
    }

    @GetMapping("/getAll")
    public DataResult<List<HmrsEmployee>> getAll() {
        return this.hmrsEmployeeService.getAll();
    }

    @GetMapping("/getbyid")
    public Result getById(int id) {
        return this.hmrsEmployeeService.getHmrsEmployeeById(id);
    }

    @PostMapping("/add")
    public Result add(HmrsEmployee employee) {
        return this.hmrsEmployeeService.saveHmrsEmployee(employee);
    }
}
