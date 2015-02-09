import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Programmers {
    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Integer num =0;
            try {
                System.out.print("Введите число - ");
                num = Integer.parseInt(reader.readLine());
                } catch (Exception e) {
                System.out.println("Ошибка ввода!");
            }


        Programmers prog = new Programmers();
        LinkedList<String> stack = new LinkedList<>();

/**
 *  Map использовал по указанию преподователя. Я бы использовал массивы String[][]
 */
        Map<Integer, String> map = new HashMap<>();
        Map<Integer, String> map11 = new HashMap<>();
        Map<Integer, String> mapDec = new HashMap<>();
        Map<Integer, String> mapHun = new HashMap<>();
        Map<Integer, String> mapNumTh = new HashMap<>();

        Map<Integer, String> mapTh = new HashMap<>();
        Map<Integer, String> mapMl = new HashMap<>();
        Map<Integer, String> mapBl = new HashMap<>();

        mapNumTh.put(0, "");
        mapNumTh.put(1, "одна ");
        mapNumTh.put(2, "две ");
        mapNumTh.put(3, "три ");
        mapNumTh.put(4, "четыре ");
        mapNumTh.put(5, "пять ");
        mapNumTh.put(6, "шесть ");
        mapNumTh.put(7, "семь ");
        mapNumTh.put(8, "восемь ");
        mapNumTh.put(9, "девять ");

        map.put(0, "");
        map.put(1, "один ");
        map.put(2, "два ");
        map.put(3, "три ");
        map.put(4, "четыре ");
        map.put(5, "пять ");
        map.put(6, "шесть ");
        map.put(7, "семь ");
        map.put(8, "восемь ");
        map.put(9, "девять ");

        map11.put(1, "одинадцать ");
        map11.put(2, "двенадцать ");
        map11.put(3, "тринадцать ");
        map11.put(4, "четырнадцать ");
        map11.put(5, "пятнадцать ");
        map11.put(6, "шетнадцать ");
        map11.put(7, "семнадцать ");
        map11.put(8, "восемнадцать ");
        map11.put(9, "девятнадцать ");

        mapDec.put(0, "");
        mapDec.put(1, "десять ");
        mapDec.put(2, "двадцать ");
        mapDec.put(3, "тридцать ");
        mapDec.put(4, "сорок ");
        mapDec.put(5, "пятьдесят ");
        mapDec.put(6, "шестьдесят ");
        mapDec.put(7, "семьдесят ");
        mapDec.put(8, "восемьдесят ");
        mapDec.put(9, "девяносто ");

        mapHun.put(0, "");
        mapHun.put(1, "сто ");
        mapHun.put(2, "двести ");
        mapHun.put(3, "триста ");
        mapHun.put(4, "четыреста ");
        mapHun.put(5, "пятьсот ");
        mapHun.put(6, "шестьсот ");
        mapHun.put(7, "семьсот ");
        mapHun.put(8, "восемьсот ");
        mapHun.put(9, "девятьсот ");

        mapTh.put(0, "");
        mapTh.put(1, "тысяча ");
        mapTh.put(2, "тысячи ");
        mapTh.put(3, "тысячь ");

        mapMl.put(0, "");
        mapMl.put(1, "миллион ");
        mapMl.put(2, "миллиона ");
        mapMl.put(3, "миллионов ");

        mapBl.put(0, "");
        mapBl.put(1, "миллиард ");
        mapBl.put(2, "миллиарда ");

        Integer nMl = num % 1000000000;
        Integer n1000 = num % 1000000;
        Integer n100 = num % 1000;
        Integer n10 = num % 100;
        Integer n1 = num % 10;

//        System.out.println(num / 1000000000 + " " + nMl / 1000000 + " " + n1000 / 1000 + " " + n100);
//        System.out.println(nMl / 100000000 % 10);
//        System.out.println(nMl / 10000000 % 10);
//        System.out.println(nMl / 1000000 % 10);
//
//        System.out.println(n1000 / 100000 % 10);
//        System.out.println(n1000 / 10000 % 10);
//        System.out.println(n1000 / 1000 % 10);
//        System.out.println("1-4 = " + n1000 / 1000);

//
//        System.out.println(n100 / 100 % 10);
//        System.out.println(n100 / 10 % 10);
//        System.out.println(n100 % 10);
//        System.out.println(n10);
//
//        System.out.println("Hun = " + n100 / 100); // Hundred
//        System.out.println("Dec = " + n10 / 10); // Dec
//        System.out.println("One = " + n1);
//        System.out.println("1-4 = " + n10);
//
        if (num == 0) {
            stack.push("ноль ");
        } else {
            if (num / 1000000000 > 0 && num < 2140000000) {
                stack.push(map.get(num / 1000000000) + mapBl.get(num / 1000000000));
            }
            if (nMl / 1000000 % 100 < 20 && nMl / 1000000 % 100 > 10) {
                stack.push(mapHun.get(nMl / 100000000 % 10) + map11.get(nMl / 1000000 % 10)+ mapMl.get(prog.numberPower(nMl / 1000000 % 100)));
            } else if (nMl / 1000000 > 0) {
                stack.push(mapHun.get(nMl / 100000000 % 10) + mapDec.get(nMl / 10000000 % 10) + mapNumTh.get(nMl / 1000000 % 10) + mapMl.get(prog.numberPower(nMl / 1000000 % 10)));
            }
            if (n1000 / 1000 % 100 < 20 && n1000 / 1000 % 100 > 10) {
                stack.push(mapHun.get(nMl / 100000 % 10) + map11.get(nMl / 1000 % 10) + mapTh.get(prog.numberPower(n1000 / 1000 % 100)));
            } else if (n1000 / 1000 > 0) {
                stack.push(mapHun.get(nMl / 100000 % 10) + mapDec.get(nMl / 10000 % 10) + mapNumTh.get(nMl / 1000 % 10) + mapTh.get(prog.numberPower(n1000 / 1000 % 10)));
            }
            if (n10 < 20 && n10 > 10) {
                stack.push(mapHun.get(n100 / 100 % 10) + map11.get(n10 % 10));
            } else {
                stack.push(mapHun.get(n100 / 100 % 10) + mapDec.get(n100 / 10 % 10) + map.get(n1));
            }
        }
        // вывод числительного
        System.out.println();
        for (int i = stack.size() - 1; i >= 0; i--) {
            System.out.print(stack.get(i));
        }
        // вывод программистов
        System.out.println(prog.numberProgrammers(num % 100));

    }


    // определение падежа у порядков чисел
    public Integer numberPower(Integer number) {

        if (number > 10 && number < 20) {
            return 3;
        } else {
            if (number == 1) {
                return 1;
            }
            if (number > 1 && number < 5) {
                return 2;
            }
        }
        return 3;
    }

    // определение падежа программистов
    public String numberProgrammers(Integer number) {

        if (number > 10 && number < 20) {
            return "программистов";
        } else {
            number %= 10;
            if (number == 1) {
                return "программист";
            }
            if (number > 1 && number < 5) {
                return "программиста";
            }
        }
        return "программистов";
    }
}
