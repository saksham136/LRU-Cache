package com.example.demo.cache.policies;

import com.example.demo.algorithms.Dll;
import com.example.demo.algorithms.DllNode;
import java.util.HashMap;
import java.util.Map;


//@param <Key> Key type.

public class LruEvictionPolicy<Key> implements EvictionPolicy<Key> {

    private Dll<Key> dll;
    private Map<Key, DllNode<Key>> mapper;

    public LruEvictionPolicy() {
        this.dll = new Dll<>();
        this.mapper = new HashMap<>();
    }

    @Override
    public void keyAccessed(Key key) {
        if (mapper.containsKey(key)) {
            dll.detachNode(mapper.get(key));
            dll.addNodeAtLast(mapper.get(key));
        } else {
            DllNode<Key> newNode = dll.addElementAtLast(key);
            mapper.put(key, newNode);
        }
    }


    @Override
    public Key evictKey() {
        DllNode<Key> first = dll.getFirstNode();
        if(first == null) {
            return null;
        }

        dll.detachNode(first);
        return first.getElement();

    }
}







