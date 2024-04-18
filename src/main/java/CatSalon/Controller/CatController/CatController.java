package CatSalon.Controller.CatController;

import CatSalon.Model.Cat;

import java.util.List;
import java.util.UUID;

public interface CatController {

    void createCat(Cat cat);

    void updateCat(Cat cat);

    void deleteCat(UUID id);

    Cat findCatById(UUID id);

    List<Cat> findAllCats();

}