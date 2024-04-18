import CatSalon.Controller.CatController.CatController;
import CatSalon.Controller.CatController.CatControllerImpl;
import CatSalon.Model.Cat;
import CatSalon.Service.CatService.CatService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.UUID;
import static org.mockito.Mockito.*;

public class CatControllerTest {

    @Mock
    private CatService catService;

    private CatController catController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        catController = new CatControllerImpl(catService);
    }

    @Test
    public void testCreateCat() {
        Cat cat = new Cat(UUID.randomUUID(), "Fluffy", null, "Persian", null, null, null);
        catController.createCat(cat);
        verify(catService, times(1)).saveCat(cat);
    }

    @Test
    public void testUpdateCat() {
        Cat cat = new Cat(UUID.randomUUID(), "Fluffy", null, "Persian", null, null, null);
        catController.updateCat(cat);
        verify(catService, times(1)).updateCat(cat);
    }

    @Test
    public void testDeleteCat() {
        UUID catId = UUID.randomUUID();
        catController.deleteCat(catId);
        verify(catService, times(1)).deleteCat(catController.findCatById(catId));
    }

    @Test
    public void testFindCatById() {
        UUID catId = UUID.randomUUID();
        Cat cat = new Cat(catId, "Fluffy", null, "Persian", null, null, null);
        when(catService.findCatById(catId)).thenReturn(cat);
        Cat foundCat = catController.findCatById(catId);
        verify(catService, times(1)).findCatById(catId);
        assert foundCat != null;
        assert foundCat.getId().equals(catId);
    }

    @Test
    public void testFindAllCats() {
        catController.findAllCats();
        verify(catService, times(1)).findAllCats();
    }
}
