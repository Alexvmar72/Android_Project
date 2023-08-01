package com.mygdx.game.g1.units;

import java.util.ArrayList;
import java.util.Random;

/**
 * Маг, волшебник
 * */
public class MagicianUnit extends BaseUnit {
    private int mana, attac;

    public MagicianUnit(String name, int x, int y, int speed) {
        super(70, 5, speed,  true, name, x, y, "ready", 1);
        this.mana = 10;
        this.attac = 1;
    }

    @Override
    public void step(ArrayList<BaseUnit> units, ArrayList<BaseUnit> units2) {
        if (!isAlive) return;
        BaseUnit tmp = nearest(units2);
        if ((int) coordinates.countDistanse(tmp.coordinates) <= attac) {
            if (mana > 0) {
                tmp.getDamage(damage);
                mana -= 1;
                state = "Attack";
            } else {
                mana += 1;
                state = "Busy";
            }
        } else {
            move(tmp.coordinates, units);
            state = "Moving";
        }
        ArrayList<BaseUnit> deadTeammates = new ArrayList<>();
        if (!isAlive) return;
        for (BaseUnit unit: units) {
            if (!unit.isAlive) {
                deadTeammates.add(unit);
            }
        }
        if (deadTeammates.size() > units.size() / 2 - 1 && mana >= 5) {
            int rand = new Random().nextInt(deadTeammates.size() - 1);
            deadTeammates.get(rand).isAlive = true;
            deadTeammates.get(rand).hp = deadTeammates.get(rand).maxHp / 2;
            state = "Revive";
            mana = 0;
            return;
        }
    }

    @Override
    public String getInfo() {
        return "Маг " + super.getInfo() + ", Мана: " + mana;
    }
}
