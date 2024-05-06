import java.util.*;

public class Main {

    public static void main(String[] args) {
        // user's browsing history
        List<Product> history = new ArrayList<>();
        history.add(new Product("ZTE Blade A71","Smart Phones", 2,42));
        history.add(new Product("RTX 3090 GPU","Computer Accessories", 3,69));
        history.add(new Product("500W 80+ PSU","Computer Accessories", 6,150));
        history.add(new Product("T-Shirt","Clothing", 4,88));
        User user = new User(history);

        // Product catalog
        Map<String, List<Product>> productsCatogery = new HashMap<>();
        productsCatogery.put("Smart Phones", Arrays.asList(
                new Product("Google Pixel 8", "Smart Phones", 10,46),
                new Product("Samsung Galaxy A15", "Smart Phones", 3,68),
                new Product("Asus ROG Phone 8 Pro", "Smart Phones", 9,5)
        ));

        productsCatogery.put("Computer Accessories", Arrays.asList(
                new Product("B260 motherboard", "Computer Accessories",8,49),
                new Product("DDR4 8GB RAM Kit", "Computer Accessories",5,116),
                new Product("Intel i5 11gen processor", "Computer Accessories",6,92)
        ));
        productsCatogery.put("Clothing", Arrays.asList(
                new Product("Blue color denim", "Clothing", 7,82),
                new Product("White shirt", "Clothing", 4,120),
                new Product("Black short", "Clothing", 10,112)
        ));

        ProductCatalog productCatalog = new ProductCatalog(productsCatogery);

        ProductRecommendation productRecommendation = new ProductRecommendation();
        List<Product> recommendedProducts = productRecommendation.searchRecommendation(user, productCatalog);
        for (Product recommendedproduct : recommendedProducts){
            System.out.println("Product name : "+recommendedproduct.name +" - Category : "+ recommendedproduct.category +
                    " - Rating : "+ recommendedproduct.rating +" - Number of sales : "+ recommendedproduct.sales);
        }
    }
}