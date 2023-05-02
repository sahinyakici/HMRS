package kodlamaio.HMRS.business.concretes;

import kodlamaio.HMRS.business.abstracts.HmrsEmployeeService;
import kodlamaio.HMRS.core.utilities.results.DataResult;
import kodlamaio.HMRS.core.utilities.results.Result;
import kodlamaio.HMRS.core.utilities.results.SuccessDataResult;
import kodlamaio.HMRS.core.utilities.results.SuccessResult;
import kodlamaio.HMRS.dataAccess.abstracts.HmrsEmployeeDao;
import kodlamaio.HMRS.entities.concretes.HmrsEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HmrsEmployeeManager implements HmrsEmployeeService {
    private HmrsEmployeeDao hmrsEmployeeDao;

    @Autowired
    public HmrsEmployeeManager(HmrsEmployeeDao hmrsEmployeeDao) {
        this.hmrsEmployeeDao = hmrsEmployeeDao;
    }

    @Override
    public DataResult<List<HmrsEmployee>> getAll() {
        return new SuccessDataResult<List<HmrsEmployee>>(this.hmrsEmployeeDao.findAll());
    }

    @Override
    public DataResult<HmrsEmployee> getHmrsEmployeeById(int id) {
        HmrsEmployee employee = this.hmrsEmployeeDao.findById(id);
        return new SuccessDataResult<HmrsEmployee>(employee, "Employee is found");
    }

    @Override
    public Result saveHmrsEmployee(HmrsEmployee employee) {
        employee.setHmrsAuthList(null);
        this.hmrsEmployeeDao.save(employee);
        return new SuccessResult("Employee saved successfully");
    }
}
