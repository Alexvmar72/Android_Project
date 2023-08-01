package com.mygdx.game.g1.units;

import java.util.ArrayList;

/**
 * Основной класс юнитов
 * */
public abstract class BaseUnit implements InGameInterface {
    String name;
    public float hp;
    public float maxHp;
    int damage;
    int speed;
    public boolean isAlive;
    //public String status = "Stand";
    Coordinates coordinates;
    String state;
    int moveDistance;

    public BaseUnit(float maxHp, int damage, int speed, boolean isAlive, String name, int x, int y, String state, int moveDistance) {
        this.name = name;
        this.maxHp = this.hp = maxHp;
        this.damage = damage;
        this.speed = speed;
        this.isAlive = isAlive;
        coordinates = new Coordinates(x, y);
        this.state = "Stand";
        this.moveDistance = moveDistance;
    }

    public void getDamage(int damage){
        hp -= damage;
        if (hp <= 0) {
            hp = 0;
            isAlive = false;
            state = "Dead";
        }
        if (hp > maxHp) hp = maxHp;
    }

    @Override
    public String getInfo() {
        return String.format("%s x: %d y: %d, Статус: %s" , name, coordinates.x, coordinates.y, state);
    }

    /**
     * Поиск ближайшего врага
     */
    public BaseUnit nearest(ArrayList<BaseUnit> units) {
        double nearestDistanse = Double.MAX_VALUE;
        BaseUnit nearestEnemy = units.get(0);
        for (int i = 0; i < units.size(); i++) {
            if(coordinates.countDistanse(units.get(i).coordinates) < nearestDistanse) {
                nearestEnemy = units.get(i);
                nearestDistanse = coordinates.countDistanse(units.get(i).coordinates);
            }
        }
        return nearestEnemy;
   }

   public String toString(){
        return this.getClass().getSimpleName();
   }
    public int compareTo(BaseUnit o) {
        return o.speed-this.speed;
    }
    public int[] getCoords() {
        return new int[] {coordinates.x, coordinates.y};
    }

    public void move(Coordinates targetPosition, ArrayList<BaseUnit> units) {
        if (!coordinates.containsByPos(coordinates.newPosition(targetPosition, units), units)) {
            for (int i = 0; i < moveDistance; i++) {
                coordinates = coordinates.newPosition(targetPosition, units);
            }
        }
    }
    public float getHp(){
        return hp;
    }

    public boolean die() {
        if (this.state == "Dead") {
            return true;
        }
        return false;
    }
}
