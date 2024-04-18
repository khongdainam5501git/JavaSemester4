package CatSalon.Controller.CatController;

import CatSalon.Dao.CatDao.CatDao;
import CatSalon.Model.Cat;
import CatSalon.Service.CatService.CatService;

import java.util.List;
import java.util.UUID;

public class CatControllerImpl implements CatController{
    private CatService catService;

    public CatControllerImpl(CatService catService) {
        this.catService = catService;
    }

    @Override
    public void createCat(Cat cat) {
        catService.saveCat(cat);
    }

    @Override
    public void updateCat(Cat cat) {
        catService.updateCat(cat);
    }

    @Override
    public void deleteCat(UUID id) {
        Cat cat = findCatById(id);
        catService.deleteCat(cat);
    }

    @Override
    public Cat findCatById(UUID id) {
        return catService.findCatById(id);
    }

    @Override
    public List<Cat> findAllCats() {
        return catService.findAllCats();
    }
}
