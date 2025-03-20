

// just for the factory pattern




//package com.example.demo.cache.factories;
//
//import com.example.demo.cache.Cache;
//import com.example.demo.cache.policies.LruEvictionPolicy;
//import com.example.demo.cache.storage.HashMapBasedStorage;
//
//public class CacheFactory<Key, Value> {
//
//    public Cache<Key, Value> defaultCache(final int capacity) {
//        return new Cache<Key, Value>(new LruEvictionPolicy<>(),
//                new HashMapBasedStorage<>(capacity));
//    }
//}
