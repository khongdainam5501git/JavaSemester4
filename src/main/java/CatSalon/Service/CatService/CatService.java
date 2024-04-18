package CatSalon.Service.CatService;

import CatSalon.Model.Cat;

import java.util.List;
import java.util.UUID;

public interface CatService {

    void saveCat(Cat cat);

    void updateCat(Cat cat);

    void deleteCat(Cat cat);

    Cat findCatById(UUID id);

    List<Cat> findAllCats();

}