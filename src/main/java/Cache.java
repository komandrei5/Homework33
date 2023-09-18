import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

// A simple cache implementation that allows storing and retrieving
// objects based on cache names and keys.
public class Cache {
    private Map<String, Map<String, Object>> caches;
    private static final Logger logger = Logger.getLogger(Cache.class.getName());

//    Constructs a new Cache instance and initializes logging to a file.
    public Cache() throws IOException {
        this.caches = new HashMap<>();
        FileHandler fileHandler = new FileHandler("cache.log");
        logger.addHandler(fileHandler);
        SimpleFormatter formatter = new SimpleFormatter();
        fileHandler.setFormatter(formatter);
    }

//    Adds an object to the specified cache.
    public boolean add(String cacheName, String key, String value) {
        if (!caches.containsKey(cacheName)) {
            caches.put(cacheName, new HashMap<>());
        }

        caches.get(cacheName).put(key, value);
        logger.log(Level.INFO, "Add object with key: " + key + " to cache " + cacheName + " .");

        return true;
    }

//    Retrieves an object from the specified cache.
    public Object getCache(String cache, String key) {
        Map<String, Object> cacheMap = caches.get(cache);
        if (cacheMap != null) {
            Object value = cacheMap.get(key);
            if (value != null) {
                logger.log(Level.INFO, "Get object with key: " + key + " to cache " + cache + ".");
            } else {
                logger.log(Level.INFO, "Object with key: " + key + " not found in cache " + cache + ".");
            }
            return value;
        } else {
            logger.log(Level.INFO, "Cache " + cache + " does not exist.");
            return null;
        }
    }

//    Clears all caches.
    public void clear() {
        caches.clear();
        logger.log(Level.INFO, "All caches have been cleared.");
    }

//    Clears the specified cache. The name of the cache to clear.
    public void clear(String cache) {
        if (caches.containsKey(cache)) {
            caches.get(cache).clear();
            logger.log(Level.INFO, "Cache " + cache + " have been cleared.");
        } else {
            logger.log(Level.INFO, "Cache " + cache + " does not exist.");
        }
    }

//    Checks if a cache with the specified name exists. 
    public boolean isCacheExist(String cache) {
        boolean exists = caches.containsKey(cache);
        if (exists) {
            logger.log(Level.INFO, "Cache " + cache + " exist.");
        } else {
            logger.log(Level.INFO, "Cache " + cache + " does not exist.");
        }
        return exists;
    }
}
