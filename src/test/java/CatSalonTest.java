import CatSalon.Controller.CatController.CatController;
import CatSalon.Controller.CatController.CatControllerImpl;
import CatSalon.Controller.OwnerController.OwnerController;
import CatSalon.Controller.OwnerController.OwnerControllerImpl;
import CatSalon.Dao.CatDao.CatDao;
import CatSalon.Dao.OwnerDao.OwnerDao;
import CatSalon.Model.Cat;
import CatSalon.Model.Owner;
import CatSalon.Service.CatService.CatService;
import CatSalon.Service.CatService.CatServiceImpl;
import CatSalon.Service.OwnerService.OwnerService;
import CatSalon.Service.OwnerService.OwnerServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.lang.AssertionError;

public class CatSalonTest {

    @Mock
    private CatDao catDao;

    @Mock
    private OwnerDao ownerDao;

    private CatService catService;
    private OwnerService ownerService;
    private CatController catController;
    private OwnerController ownerController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        catService = new CatServiceImpl(catDao);
        ownerService = new OwnerServiceImpl(ownerDao);
        catController = new CatControllerImpl(catService);
        ownerController = new OwnerControllerImpl(ownerService);
    }

    @Test
    public void testCatController() {
        // Mock CatService
        Cat cat = new Cat(UUID.randomUUID(), "Fluffy", LocalDate.now(), "Persian", Color.WHITE, null, null);
        when(catService.findCatById(any(UUID.class))).thenReturn(cat);

        // Test createCat
        catController.createCat(cat);
        verify(catDao, times(1)).save(cat);

        // Test updateCat
        catController.updateCat(cat);
        verify(catDao, times(1)).update(cat);

        // Test deleteCat
        UUID catId = cat.getId();
        catController.deleteCat(catId);
        verify(catDao, times(1)).delete(cat);

        // Test findCatById
        Cat foundCat = catController.findCatById(catId);
        assertNotNull(foundCat);
        assertEquals(catId, foundCat.getId());

        // Test findAllCats
        List<Cat> catList = new ArrayList<>();
        catList.add(cat);
        when(catDao.findAll()).thenReturn(catList);
        List<Cat> allCats = catController.findAllCats();
        verify(catDao, times(1)).findAll();
        assertNotNull(allCats);
        assertEquals(1, allCats.size());
        assertEquals(catId, allCats.get(0).getId());
    }

    @Test
    public void testOwnerController() {
        // Test createOwner
        Owner owner = new Owner(UUID.randomUUID(), "John Doe", LocalDate.now(), "123-456-7890", null);
        ownerController.createOwner(owner);
        verify(ownerDao, times(1)).save(owner);

        // Test updateOwner
        ownerController.updateOwner(owner);
        verify(ownerDao, times(1)).update(owner);

        // Test deleteOwner
        var ownerId = owner.getId();
        ownerController.deleteOwner(ownerId);
        verify(ownerDao, times(1)).delete(ownerController.findOwnerById(ownerId));

        // Test findOwnerById
        when(ownerDao.findById(ownerId)).thenReturn(owner);
        Owner foundOwner = ownerController.findOwnerById(ownerId);
        assertNotNull(foundOwner);
        assertEquals(ownerId, foundOwner.getId());

        // Test findAllOwners
        List<Owner> ownerList = new ArrayList<>();
        ownerList.add(owner);
        when(ownerDao.findAll()).thenReturn(ownerList);
        List<Owner> allOwners = ownerController.findAllOwners();
        verify(ownerDao, times(1)).findAll();
        assert allOwners != null;
        assert allOwners.size() == 1;
        assert allOwners.get(0).getId().equals(ownerId);
    }
}
