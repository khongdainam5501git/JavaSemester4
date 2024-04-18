package CatSalon.Controller.OwnerController;

import CatSalon.Dao.OwnerDao.OwnerDao;
import CatSalon.Model.Owner;
import CatSalon.Service.OwnerService.OwnerService;

import java.util.List;
import java.util.UUID;

public class OwnerControllerImpl implements OwnerController {
    private OwnerService ownerService;

    public OwnerControllerImpl(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @Override
    public void createOwner(Owner owner) {
        ownerService.saveOwner(owner);
    }

    @Override
    public void updateOwner(Owner owner) {
        ownerService.updateOwner(owner);
    }

    @Override
    public void deleteOwner(UUID id) {
        Owner owner = findOwnerById(id);
        ownerService.deleteOwner(owner);
    }

    @Override
    public Owner findOwnerById(UUID id) {
        return ownerService.findOwnerById(id);
    }

    @Override
    public List<Owner> findAllOwners() {
        return ownerService.findAllOwners();
    }
}
