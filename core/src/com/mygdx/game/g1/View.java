//package com.mygdx.game.g1;
//
//import com.mygdx.game.g1.units.BaseUnit;
//
//import java.util.Collections;
//
//public class View {
//
//
//    private static int step = 1;
//    private static final int[] l = {0};
//    private static final String top10 = formatDiv("a") + String.join("", Collections.nCopies(9, formatDiv("-b"))) + formatDiv("-c");
//    private static final String midl10 = formatDiv("d") + String.join("", Collections.nCopies(9, formatDiv("-e"))) + formatDiv("-f");
//    private static final String bottom10 = formatDiv("g") + String.join("", Collections.nCopies(9, formatDiv("-h"))) + formatDiv("-i");
//    private static void tabSetter(int cnt, int max){
//        int dif = max - cnt + 2;
//        if (dif>0) System.out.printf("%" + dif + "s", ":\t"); else System.out.print(":\t");
//    }
//    private static String formatDiv(String str) {
//        return str.replace('a', '\u250c')
//                .replace('b', '\u252c')
//                .replace('c', '\u2510')
//                .replace('d', '\u251c')
//                .replace('e', '\u253c')
//                .replace('f', '\u2524')
//                .replace('g', '\u2514')
//                .replace('h', '\u2534')
//                .replace('i', '\u2518')
//                .replace('-', '\u2500');
//    }
//    private static String getChar(int x, int y){
//        String out = "| ";
//        for (BaseUnit unit: Main.teamAll) {
//            if (unit.getCoords()[0] == x && unit.getCoords()[1] == y){
//                if (unit.getHp() == 0) {
//                    out = "|" + (AnsiColors.ANSI_PURPLE_BACKGROUND + unit.toString().charAt(0) + AnsiColors.ANSI_RESET);
//                    break;
//                }
//                if (Main.team_red.contains(unit)) out = "|" + (AnsiColors.ANSI_RED + unit.toString().charAt(0) + AnsiColors.ANSI_RESET);
//                if (Main.team_green.contains(unit)) out = "|" + (AnsiColors.ANSI_GREEN + unit.toString().charAt(0) + AnsiColors.ANSI_RESET);
//                break;
//            }
//        }
//        return out;
//    }
////    public static void view() {
////        if (step == 1 ){
////            System.out.print(AnsiColors.ANSI_YELLOW + "First step" + AnsiColors.ANSI_RESET);
////        } else {
////            System.out.print(AnsiColors.ANSI_YELLOW+ "Step " + step + AnsiColors.ANSI_RESET);
////        }
////        step++;
////        //Main.teamAll.forEach((v) -> l[0] = Math.max(l[0], v.getInfo().length()));
////        System.out.print("___________________");//repeat(l[0]*2));
////        System.out.println("");
////        System.out.print(top10 + "    ");
////        System.out.print(AnsiColors.ANSI_RED+":\tКоманда красных"+AnsiColors.ANSI_RESET);
////        //for (int i = 0; i < l[0]-9; i++)
////        System.out.print("___________________");//repeat(l[0]-9));
////        System.out.println(AnsiColors.ANSI_GREEN+"Команда зелёных"+AnsiColors.ANSI_RESET);
////        for (int i = 1; i < 11; i++) {
////            System.out.print(getChar(1, i));
////        }
////        System.out.print("|    ");
////        System.out.print(Main.team_red.get(0).getInfo());
////        tabSetter(Main.team_red.get(0).getInfo().length(), l[0]);
////        System.out.println(Main.team_green.get(0).getInfo());
////        System.out.println(midl10);
////
////        for (int i = 2; i < 10; i++) {
////            for (int j = 1; j < 11; j++) {
////                System.out.print(getChar(i, j));
////            }
////            System.out.print("|    ");
////            System.out.print(Main.team_red.get(i-1).getInfo());
////            tabSetter(Main.team_red.get(i-1).getInfo().length(), l[0]);
////            System.out.println(Main.team_green.get(i-1).getInfo());
////            System.out.println(midl10);
////        }
////        for (int j = 1; j < 11; j++) {
////            System.out.print(getChar(10, j));
////        }
////        System.out.print("|    ");
////        System.out.print(Main.team_red.get(9).getInfo());
////        tabSetter(Main.team_red.get(9).getInfo().length(), l[0]);
////        System.out.println(Main.team_green.get(9).getInfo());
////        System.out.println(bottom10);
////    }
//}
