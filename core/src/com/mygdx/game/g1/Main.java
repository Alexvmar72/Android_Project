package com.mygdx.game.g1;

import com.mygdx.game.g1.units.*;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    public ArrayList<BaseUnit> team_red = new ArrayList<>();
    public ArrayList<BaseUnit> team_green = new ArrayList<>();
    public ArrayList<BaseUnit> teamAll = new ArrayList<>();

    public void main() {
        int teamCount = 10;
        Random rand = new Random();
        System.out.println();
        System.out.println("Команда красных: ");
        for (int i = 0; i <= teamCount; i++) {
            int val_r = rand.nextInt(4);
            switch (val_r) {
                case 0:
                    team_red.add(new MagicianUnit(getName(), 1, i, rand.nextInt(21)));
                    break;
                case 1:
                    team_red.add(new RobberUnit(getName(), 1, i, rand.nextInt(21)));
                    break;
                case 2:
                    team_red.add(new CountrymanUnit(getName(), 1, i, rand.nextInt(21)));
                    break;
                case 3:
                    team_red.add(new SharpshooterUnit(getName(), 1, i, rand.nextInt(21)));
                    break;
            }
            System.out.println(team_red.get(i).getInfo());
        }
        System.out.println();
        System.out.println("Команда зелёных: ");
        for (int j = 0; j <= teamCount; j++) {
            int val_g = rand.nextInt(4);
            switch (val_g) {
                case 0:
                    team_green.add(new MonkUnit(getName(), 10, j, rand.nextInt(21)));
                    break;
                case 1:
                    team_green.add(new ArbalesterUnit(getName(), 10, j, rand.nextInt(21)));
                    break;
                case 2:
                    team_green.add(new CountrymanUnit(getName(), 10, j, rand.nextInt(21)));
                    break;
                case 3:
                    team_green.add(new SpearmanUnit(getName(), 10, j, rand.nextInt(21)));
                    break;
            }
            System.out.println(team_green.get(j).getInfo());
        }

        public String getName () {
            String s = String.valueOf(Name.values()[new Random().nextInt(Name.values().length)]);
            return s;
        }

        teamAll.addAll(team_green);
        teamAll.addAll(team_red);
        teamAll.sort(BaseUnit::compareTo);

        //Scanner in = new Scanner(System.in);
        // while (true){
        //View.view();
        //in.nextLine();
    public void run() {
        for (BaseUnit unit : teamAll) {
            if (team_green.contains(unit)) {
                unit.step(team_green, team_red);
            } else unit.step(team_red, team_green);
        }
        if (isTeamDie(team_green)) {
            System.out.println("Команда красных выиграла");
            break;
        }
        if (isTeamDie(team_red)) {
            System.out.println("Команда зелёных выиграла");
            break;
        }
    }





        static boolean isTeamDie (ArrayList < BaseUnit > team) {
                for (BaseUnit unit : team) {
                    if (!unit.die()) return false;
                }
                return true;
            }
    }



}