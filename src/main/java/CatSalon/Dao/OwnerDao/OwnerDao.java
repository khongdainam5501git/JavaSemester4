package CatSalon.Dao.OwnerDao;

import CatSalon.Model.Owner;

import java.util.List;
import java.util.UUID;

public interface OwnerDao {
    void save(Owner owner);
    void update(Owner owner);

    void delete(Owner owner);

    Owner findById(UUID id);

    List<Owner> findAll();
}
