package com.mygdx.game.g1.units;

import java.util.Comparator;

public class InitComparator implements Comparator<BaseUnit> {
    @Override
    public int compare(BaseUnit o1, BaseUnit o2) {
        return Integer.compare(o2.speed, o1.speed);
    }
}
