package com.example.demo.cache.policies;

public interface EvictionPolicy<Key> {
    void keyAccessed(Key key);
    Key evictKey();
}
