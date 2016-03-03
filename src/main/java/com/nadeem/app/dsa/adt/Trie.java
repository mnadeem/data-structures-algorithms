package com.nadeem.app.dsa.adt;

public interface Trie {

    String bestMatch(String word);

    boolean contains(String word);
  
    void insert(String word);

    boolean remove(String word);

    int size();
}
