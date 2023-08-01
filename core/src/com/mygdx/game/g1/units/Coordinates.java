package com.mygdx.game.g1.units;

import java.util.ArrayList;

public class Coordinates {
    int x, y;
    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public double countDistanse(Coordinates coordinates){
        int dx = coordinates.x - x;
        int dy = coordinates.y - y;
        return Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
    }
    public Coordinates newPosition(Coordinates targetPosition, ArrayList<BaseUnit> units) {
        Coordinates currentPos = new Coordinates(x, y);

        if (Math.abs(targetPosition.x - x) >= Math.abs(targetPosition.y - y)) {
            if (targetPosition.x - x > 0) currentPos.x += 1;
            else currentPos.x -= 1;
        }

        if (Math.abs(targetPosition.x - x) < Math.abs(targetPosition.y - y)) {
            if (targetPosition.y - y > 0) currentPos.y += 1;
            else currentPos.y -= 1;
        }
        return currentPos;
    }

    public boolean containsByPos(Coordinates nextPosition, ArrayList<BaseUnit> units) {
        for (BaseUnit unit: units) {
            if (unit.coordinates == nextPosition) return true;
        }
        return false;
    }
}
