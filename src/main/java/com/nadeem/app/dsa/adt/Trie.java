package com.nadeem.app.dsa.adt;

public interface Trie {

    boolean contains(String word);  
    void insert(String word);
    boolean remove(String word);    
    int frequency(String word);
    int size();
}
