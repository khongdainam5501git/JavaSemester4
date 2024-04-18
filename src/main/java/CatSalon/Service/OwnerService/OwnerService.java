package CatSalon.Service.OwnerService;

import CatSalon.Model.Owner;

import java.util.List;
import java.util.UUID;

public interface OwnerService {

    void saveOwner(Owner owner);

    void updateOwner(Owner owner);

    void deleteOwner(Owner owner);

    Owner findOwnerById(UUID id);

    List<Owner> findAllOwners();

}