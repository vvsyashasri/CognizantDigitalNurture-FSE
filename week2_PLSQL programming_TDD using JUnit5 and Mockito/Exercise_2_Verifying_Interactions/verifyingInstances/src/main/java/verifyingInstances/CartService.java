package verifyingInstances;

public class CartService {
	 private final ProductRepository productRepository;

	    public CartService(ProductRepository productRepository) {
	        this.productRepository = productRepository;
	    }

	    public void addProductToCart(Product product) {
	        productRepository.save(product);
	    }

	    public void removeProductFromCart(String productId) {
	        productRepository.deleteById(productId);
	    }
}
