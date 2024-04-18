package CatSalon.Dao.CatDao;

import org.springframework.data.jpa.repository.JpaRepository;
import CatSalon.Model.Cat;
import java.util.List;
import java.util.UUID;

public interface CatDao extends JpaRepository<Cat, UUID> {

    void save(Cat cat);

    void update(Cat cat);

    void delete(Cat cat);

    Cat findById(UUID id);

    List<Cat> findAll();

}