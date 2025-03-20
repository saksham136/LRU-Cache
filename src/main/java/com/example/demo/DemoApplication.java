//package com.example.demo;
//
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//@SpringBootApplication
//public class DemoApplication {
//
//    public static void main(String[] args) {
//        SpringApplication.run(DemoApplication.class, args);
//        System.out.println("Saksham");
//
//    }
//
//}

package com.example.demo;

import com.example.demo.cache.Cache;
import com.example.demo.cache.policies.LruEvictionPolicy;
import com.example.demo.cache.storage.HashMapBasedStorage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        System.out.println("Cache Testing Started...");

        // ✅ Initialize Cache with LRU Eviction Policy and Storage
        int capacity = 3;  // Set cache capacity
        Cache<String, String> cache = new Cache<>(
                new LruEvictionPolicy<>(),
                new HashMapBasedStorage<>(capacity)
        );

        // ✅ Testing cache operations
        System.out.println("\n--- Adding Elements ---");
        cache.put("1", "One");
        cache.put("2", "Two");
        cache.put("3", "Three");

        System.out.println("\n--- Fetching Elements ---");
        System.out.println("Get 1: " + cache.get("1"));  // Accessing 1 → should return "One"
        System.out.println("Get 2: " + cache.get("2"));  // Accessing 2 → should return "Two"

        System.out.println("\n--- Adding More Elements (Triggering Eviction) ---");
        cache.put("4", "Four");  // Should evict "3" since it is the least recently used

        System.out.println("\n--- Final State ---");
        System.out.println("Get 1: " + cache.get("1"));  // Should return "One"
        System.out.println("Get 3: " + cache.get("3"));  // Should return null (evicted)
        System.out.println("Get 4: " + cache.get("4"));  // Should return "Four"

        System.out.println("\n✅ Cache Testing Completed!");
    }
}

