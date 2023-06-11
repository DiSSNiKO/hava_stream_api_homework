import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Product_Manager {
    static List<Product> getProducts(){
        List<Product> products = new ArrayList<Product>();
        products.add(new Product(0, "Jays", 50.75, new Date(2003-1900, 11, 20)));
        products.add(new Product(1, "Radioactive Goo", 5000, new Date(9081-1900, 4, 26)));
        products.add(new Product(2, "Rusty Makarov Pistol", 0.75, new Date(1964-1900, 9, 2)));
        products.add(new Product(3, "Polish MRE", 150, new Date(2028-1900, 1, 25)));
        products.add(new Product(4, "Diet Orange Soda Neqtari", 1.0, new Date(2023-1900, 12, 1)));
        products.add(new Product(4, "Diet Orange Soda Neqtari", 2.0, new Date(2023-1900, 11, 15)));

        return products;
    }

    static Stream<Product> getValidProducts (){
        List<Product> allPros = getProducts();
        long currentTime = new Date().getTime();
//        System.out.println(allPros.get(2).getExpirationDate());
//        System.out.println(new Date());
        Stream<Product> validPros = allPros.stream()
                .filter(product -> product.getExpirationDate().getTime()>currentTime);
        return validPros;
    }

    static List<Product> getSortedValidProductsByPriceDecreasing (){
        List<Product> allPros = getProducts();
        long currentTime = new Date().getTime();
//        System.out.println(allPros.get(2).getExpirationDate());
//        System.out.println(new Date());
        List<Product> validPros = allPros.stream()
                .filter(product -> product.getExpirationDate().getTime()>currentTime)
                .sorted(Comparator.comparing(Product::getPrice).reversed())
                .collect(Collectors.toList());
        return validPros;
    }
    static List<Product> addPriceToProductsExcludingTheFirstOne () {
        List<Product> allProsSlashed = getProducts();
        allProsSlashed.remove(0);
        Stream<Product> doubled = allProsSlashed.stream().map(product -> new Product(product.getId(), product.getName(), product.getPrice()*2,product.getExpirationDate()));
        return doubled.collect(Collectors.toList());
    }

    static List<Product> similarNamedProducts () {
        List<Product> notSimilars = getProducts().stream().distinct().collect(Collectors.toList());
        List<Product> similars = new ArrayList<Product>();
        List<Product> oll = getProducts();
        notSimilars.forEach(System.out::println);
        for(int i = 0; i<notSimilars.size();i++){
            int nameCount = 0;
            for(int o = 0; o<oll.size(); o++){
                if (notSimilars.get(i).getName()==oll.get(o).getName()){
                    nameCount++;
                    if (nameCount>=1){
                        similars.add(oll.get(o));
                    }
                }

            }
        }
        return similars;
    }
    static Map<String, Double> mapToPrices(){
        List<Product> praises = getProducts();
        Map<String, Double> pricesToName = new HashMap<String, Double>();
        for(int i=0; i<praises.size();i++){
            pricesToName.putIfAbsent(praises.get(i).getName(), praises.get(i).getPrice());
        }
        return pricesToName;
    }
}
