package com.mygdx.game.g1.units;

import java.util.ArrayList;

/**
 * Снайпер
 * */
public class SharpshooterUnit extends BaseUnit {

    protected int arrays, attac, timeToLoad;
    public SharpshooterUnit(String name, int x, int y, int speed) {
        super(12, 2, speed + 3, true, name, x, y, "ready", 1);
        this.attac = 1;
        this.arrays = 50;
        this.timeToLoad = 1;
    }

    @Override
    public void step(ArrayList<BaseUnit> units, ArrayList<BaseUnit> units2) {
        BaseUnit tmp = nearest(units2);
        if (isAlive) {
            for (BaseUnit unit: units) {
                if (unit instanceof CountrymanUnit && unit.state == "Stand" && arrays < 20) {
                    arrays += 1;
                    unit.state = "Busy";
                    return;
                }
            }

            if ((int) coordinates.countDistanse(tmp.coordinates) <= attac) {
                if (arrays > 0 && attac != 1) {
                    if (attac == 1) tmp.getDamage(1);
                    else tmp.getDamage(damage);
                    arrays -= 1;
                    state = "Attack";
                    return;
                } else {
                    attac = 1;
                    state = "->Melee";
                }
            } else {
                move(tmp.coordinates, units);
                state = "Moving";
                return;
            }
        }
        return;
    }

    @Override
    public String getInfo() {

        return "Снайпер " + super.getInfo() + " имеет стрел: " + arrays;
    }
}
