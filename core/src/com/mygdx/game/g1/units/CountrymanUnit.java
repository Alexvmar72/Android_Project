package com.mygdx.game.g1.units;

import java.util.ArrayList;

/**
 * Крестьянин
 * */
public class CountrymanUnit extends BaseUnit {
    protected int attac, actionPriority;
    public CountrymanUnit(String name, int x, int y, int speed){
        super(12, 1, speed, true, name, x, y, "ready", 1);
        this.attac = 1;
        this.actionPriority = 25;
    }

    @Override
    public String getInfo() {
        return "Крестьянин " + super.getInfo();
    }

    @Override
    public void step(ArrayList<BaseUnit> units, ArrayList<BaseUnit> units2) {
        BaseUnit tmp = nearest(units2);
        if (isAlive) {
            if (state == "Busy") {
                state = "Stand";
            }
        } else return;

        if ((int) coordinates.countDistanse(tmp.coordinates) <= attac) {
            tmp.getDamage(damage);
            state = "Attack";
        } else {
            move(tmp.coordinates, units);
            state = "Moving";
        }
    }
}
