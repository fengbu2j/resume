package com.wuzhaoyan.admin.utils;

import java.util.BitSet;
import java.util.function.Function;

public class BloomFilter<T> {
    private BitSet bitSet;
    private int bitSize;
    private Function<T, Integer>[] hashFunctions;

    public BloomFilter(int bitSize, Function<T, Integer>[] hashFunctions) {
        this.bitSize = bitSize;
        this.bitSet = new BitSet(bitSize);
        this.hashFunctions = hashFunctions;
    }

    public void add(T item) {
        for (Function<T, Integer> hashFunction : hashFunctions) {
            int hash = hashFunction.apply(item) % bitSize;
            bitSet.set(hash);
        }
    }

    public boolean mightContain(T item) {
        for (Function<T, Integer> hashFunction : hashFunctions) {
            int hash = hashFunction.apply(item) % bitSize;
            if (!bitSet.get(hash)) {
                return false;
            }
        }
        return true;
    }
}