package verifyingInstances;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class CartServiceTest {

    @Test
    public void testAddProductToCart_VerifySaveCalled() {
        ProductRepository mockRepo = mock(ProductRepository.class);
        CartService cartService = new CartService(mockRepo);
        Product product = new Product("1", "Laptop");

        cartService.addProductToCart(product);

        verify(mockRepo, times(1)).save(product);
    }

    @Test
    public void testRemoveProductFromCart_VerifyDeleteCalled() {
        ProductRepository mockRepo = mock(ProductRepository.class);
        CartService cartService = new CartService(mockRepo);

        cartService.removeProductFromCart("1");

        verify(mockRepo).deleteById("1");
    }
}