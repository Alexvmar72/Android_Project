package com.mygdx.game.g1.units;

import java.util.ArrayList;

public interface InGameInterface {
    void step(ArrayList<BaseUnit> units, ArrayList<BaseUnit> units2);
    String getInfo();
}
