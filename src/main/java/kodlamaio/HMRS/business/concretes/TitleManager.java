package kodlamaio.HMRS.business.concretes;

import kodlamaio.HMRS.business.abstracts.TitleService;
import kodlamaio.HMRS.core.utilities.results.*;
import kodlamaio.HMRS.dataAccess.abstracts.TitleDao;
import kodlamaio.HMRS.entities.concretes.Title;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TitleManager implements TitleService {
    private TitleDao titleDao;

    @Autowired
    public TitleManager(TitleDao titleDao) {
        this.titleDao = titleDao;
    }

    @Override
    public DataResult<List<Title>> getAll() {
        return new SuccessDataResult<List<Title>>(titleDao.findAll(), "Data listed");
    }

    @Override
    public Result add(Title title) {
        Result result = isTitleAlreadyAdded(title.getTitleName());
        if (!result.isSuccess()) {
            return new ErrorResult(result.getMessage());
        }
        this.titleDao.save(title);
        return new SuccessResult("Title is added");
    }

    Result isTitleAlreadyAdded(String titleName) {
        List<Title> title = this.titleDao.findByTitleName(titleName);
        if (title.size() != 0) {
            return new ErrorResult("Title already added");
        }
        return new SuccessResult();
    }
}
