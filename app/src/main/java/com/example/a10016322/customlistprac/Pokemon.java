package com.example.a10016322.customlistprac;

/**
 * Created by 10016322 on 11/16/2016.
 */
public class Pokemon {
    String name;
    int hp;
    int level;
    String type;

    public Pokemon(String nam, int HP, int lvl, String kind){
        name = nam;
        hp = HP;
        level = lvl;
        type = kind;
    }

    public String getName()
    {
        return name;
    }

}
