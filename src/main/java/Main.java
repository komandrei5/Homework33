import java.io.IOException;

// A sample application to demonstrate th usage of the Cache class.
public class Main {
    //    The entry point of the program.
    public static void main(String[] args) throws IOException {
        Cache cache = new Cache();

        //        Adding data the cache.

        cache.add("UserCache", "user1", "John Doe");
        cache.add("ProductCache", "product1", "Laptop");

//        Retrieving data from the cache.
        String user = (String) cache.getCache("UserCache", "user1");
        String product = (String) cache.getCache("ProductCache", "product1");

        if (user != null) {
            System.out.println("User: " + user);
        } else {
            System.out.println("User not found in cache.");
        }

        if (product != null) {
            System.out.println("Product: " + product);
        } else {
            System.out.println("Product not found in cache.");
        }

//        Checking the existence of caches.
        boolean userCacheExists = cache.isCacheExist("UserCache");
        boolean orderCacheExists = cache.isCacheExist("OrderCache");

        System.out.println("UserCache exists: " + userCacheExists);
        System.out.println("OrderCache exists: " + orderCacheExists);

// Clearing individual cache and all caches.
        cache.clear("UserCache");
        cache.clear();

// Checking the existence of caches after clearing.
        boolean userCacheExistsAfterClear = cache.isCacheExist("UserCache");
        boolean productCacheExistsAfterClear = cache.isCacheExist("ProductCache");

        System.out.println("UserCache exists after clear: " + userCacheExistsAfterClear);
        System.out.println("ProductCache exists after clear: " + productCacheExistsAfterClear);

    }
}
