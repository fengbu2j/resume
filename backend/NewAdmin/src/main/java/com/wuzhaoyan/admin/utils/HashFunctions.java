package com.wuzhaoyan.admin.utils;

import java.util.function.Function;

public class HashFunctions {
    public static Function<String, Integer> hashFunction1 = s -> s.hashCode();
    public static Function<String, Integer> hashFunction2 = s -> s.hashCode() * 31;
    public static Function<String, Integer> hashFunction3 = s -> s.hashCode() * 31 * 31;
}