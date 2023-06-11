
public class Main {
    public static void main(String[] args) {
        Product_Manager productManager = new Product_Manager();
//        System.out.println(productManager.getProducts());
        productManager.getValidProducts().forEach(System.out::println); // method one
        System.out.println(productManager.getSortedValidProductsByPriceDecreasing());; // method two
        System.out.println(productManager.similarNamedProducts()); // Method three
        System.out.println(productManager.mapToPrices()); //method four
    }
}