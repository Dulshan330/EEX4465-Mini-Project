import java.util.*;

public class ProductRecommendation {
    // User Interest Profiling
    public Map<String, Integer> userInterestProfiling(User user, ProductCatalog productCatalog){
        Map<String, Integer> interestProfile = new HashMap<>();
        for (Product product : user.history){
            String category = product.category;
            interestProfile.put(category, interestProfile.getOrDefault(category, 0) + 1);
        }
        return interestProfile;
    }

    // Product Popularity Ranking
    public List<Product> productPopularityRanking(String category, ProductCatalog productCatalog){
        List<Product> products = productCatalog.getProductCatalog(category);
        Collections.sort(products, (product1, product2) -> {
            int popular1 = product1.rating * product2.sales;
            int popular2 = product2.rating * product2.sales;
            return Integer.compare(popular2, popular1);
        });
        return products;
    }

    // Personalized Sorting
    public List<Product> personalizedSorting(User user, ProductCatalog productCatalog){
        List<Product> recommendedProducts = new ArrayList<>();
        Map<String, Integer> interestProfile = userInterestProfiling(user, productCatalog);
        for (Map.Entry<String, Integer> entry : interestProfile.entrySet()){
            String category = entry.getKey();
            List<Product> rankedProducts = productPopularityRanking(category, productCatalog);
            recommendedProducts.addAll(rankedProducts);
        }
        return recommendedProducts;
    }

    // Efficient Search for Recommendations
    public List<Product> searchRecommendation(User user, ProductCatalog productCatalog){
        List<Product> sortedRecommendedProducts = personalizedSorting(user, productCatalog);
        return sortedRecommendedProducts;
    }
}
