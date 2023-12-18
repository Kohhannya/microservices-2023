package ru.mipt1c.homework.task1;

import java.io.Serializable;

public class MyPair<K, V> implements Serializable {
    K key;
    V value;

    MyPair(K key, V value) {
        this.key = key;
        this.value = value;
    }
}
