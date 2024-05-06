import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProductCatalog {
    Map<String, List<Product>> productCatalog;

    public ProductCatalog(Map<String, List<Product>> productCatalog) {
        this.productCatalog = productCatalog;
    }

    public List<Product> getProductCatalog(String category) {
        return productCatalog.getOrDefault(category, new ArrayList<>());
    }
}
