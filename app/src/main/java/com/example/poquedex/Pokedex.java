package com.example.poquedex;

import java.util.List;

public class Pokedex {
    int count;
    List<Pokemon> results;

    public Pokedex (){

    }

    public int getCount() {
        return count;
    }

    public List<Pokemon> getResults() {
        return results;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setResults(List<Pokemon> results) {
        this.results = results;
    }
}
