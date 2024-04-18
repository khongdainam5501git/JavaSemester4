package CatSalon.Controller.OwnerController;

import CatSalon.Model.Owner;

import java.util.List;
import java.util.UUID;

public interface OwnerController {

    void createOwner(Owner owner);

    void updateOwner(Owner owner);

    void deleteOwner(UUID id);

    Owner findOwnerById(UUID id);

    List<Owner> findAllOwners();

}