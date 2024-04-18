import CatSalon.Controller.OwnerController.OwnerController;
import CatSalon.Controller.OwnerController.OwnerControllerImpl;
import CatSalon.Model.Owner;
import CatSalon.Service.OwnerService.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.time.LocalDate;
import java.util.UUID;
import static org.mockito.Mockito.*;

public class OwnerControllerTest {

    @Mock
    private OwnerService ownerService;

    private OwnerController ownerController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        ownerController = new OwnerControllerImpl(ownerService);
    }

    @Test
    public void testCreateOwner() {
        Owner owner = new Owner(UUID.randomUUID(), "John Doe", LocalDate.now(), "123-456-7890", null);
        ownerController.createOwner(owner);
        verify(ownerService, times(1)).saveOwner(owner);
    }

    @Test
    public void testUpdateOwner() {
        Owner owner = new Owner(UUID.randomUUID(), "John Doe", LocalDate.now(), "123-456-7890", null);
        ownerController.updateOwner(owner);
        verify(ownerService, times(1)).updateOwner(owner);
    }

    @Test
    public void testDeleteOwner() {
        UUID ownerId = UUID.randomUUID();
        ownerController.deleteOwner(ownerId);
        verify(ownerService, times(1)).deleteOwner(ownerController.findOwnerById(ownerId));
    }

    @Test
    public void testFindOwnerById() {
        UUID ownerId = UUID.randomUUID();
        Owner owner = new Owner(ownerId, "John Doe", LocalDate.now(), "123-456-7890", null);
        when(ownerService.findOwnerById(ownerId)).thenReturn(owner);
        Owner foundOwner = ownerController.findOwnerById(ownerId);
        verify(ownerService, times(1)).findOwnerById(ownerId);
        assert foundOwner != null;
        assert foundOwner.getId().equals(ownerId);
    }

    @Test
    public void testFindAllOwners() {
        ownerController.findAllOwners();
        verify(ownerService, times(1)).findAllOwners();
    }
}
