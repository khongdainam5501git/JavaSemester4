package CatSalon.Service.OwnerService;

import CatSalon.Dao.OwnerDao.OwnerDao;
import CatSalon.Model.Owner;

import java.util.List;
import java.util.UUID;

public class OwnerServiceImpl implements OwnerService {
    private OwnerDao ownerDao;

    public OwnerServiceImpl(OwnerDao ownerDao) {
        this.ownerDao = ownerDao;
    }

    @Override
    public void saveOwner(Owner owner) {
        ownerDao.save(owner);
    }

    @Override
    public void updateOwner(Owner owner) {
        ownerDao.update(owner);
    }

    @Override
    public void deleteOwner(Owner owner) {
        ownerDao.delete(owner);
    }

    @Override
    public Owner findOwnerById(UUID id) {
        return ownerDao.findById(id);
    }

    @Override
    public List<Owner> findAllOwners() {
        return ownerDao.findAll();
    }

}
