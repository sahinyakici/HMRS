package kodlamaio.HMRS.business.concretes;

import kodlamaio.HMRS.business.abstracts.TitleService;
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
    public List<Title> getAll() {
        return this.titleDao.findAll();
    }
}
