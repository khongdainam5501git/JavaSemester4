package CatSalon.Service.CatService;

import CatSalon.Dao.CatDao.CatDao;
import CatSalon.Model.Cat;

import java.util.List;
import java.util.UUID;

public class CatServiceImpl implements CatService {
    private CatDao catDao;

    public CatServiceImpl(CatDao catDao) {
        this.catDao = catDao;
    }

    @Override
    public void saveCat(Cat cat) {
        catDao.save(cat);
    }

    @Override
    public void updateCat(Cat cat) {
        catDao.update(cat);
    }

    @Override
    public void deleteCat(Cat cat) {
        catDao.delete(cat);
    }

    @Override
    public Cat findCatById(UUID id) {
        return catDao.findById(id);
    }

    @Override
    public List<Cat> findAllCats() {
        return catDao.findAll();
    }
}
