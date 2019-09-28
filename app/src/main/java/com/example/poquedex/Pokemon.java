package com.example.poquedex;

public class Pokemon {
    String name;
    String url;
    int id;
    SpritePokemon sprites;

    public Pokemon(){

    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSprites(SpritePokemon sprites) {
        this.sprites = sprites;
    }

    public int getId() {
        return id;
    }

    public SpritePokemon getSprites() {
        return sprites;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
