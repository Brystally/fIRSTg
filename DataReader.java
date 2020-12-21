package com.company;

import java.util.Scanner;

public class DataReader {

    private int number1;
    private int number2;
    private char operation;
    private boolean exitFlag;
    private char exitCharacter;

    public DataReader(char exitCharacter) {
        this.exitCharacter = exitCharacter;
    }

    public void read() {
        Integer[] arabic = {1,2,3,4,5,6,7,8,9,10};
        String[] roman = {"I","II", "III","IV","V","VI","VII","VIII","IX","X"};

        System.out.println("Введите выражение, состоящее из двух целых чисел от 0 до 10 или от I до X, знака операции и знака равно (напр. 5+5 ИЛИ II+V): ");
        Scanner scanner = new Scanner(System.in);
        //StringBuilder builder = new StringBuilder();
        String text = scanner.nextLine();
        if (text.indexOf(exitCharacter) != -1) {
            exitFlag = true;
            return;
        }

        //Исключение
        try {
            //Разделитель
            boolean flag = false;
            text = text.substring(0, text.length());
            String[] blocks = text.split("[+-/*]");

            // проверяем, входит ли строка blocks[0] в массив строк массива "roman"
            for (int i = 0; i < roman.length; i++) {
                if (roman[i].equals(blocks[0]) || roman[i].equals(blocks[1])) {
                    flag = true;
                }
                //flag = true, значит будем иметь дело с римскими обозначениями
                if (flag) {
                    number1 = RomanNumbers(blocks[0]);
                    number2 = RomanNumbers(blocks[1]);
                }}if(flag==false) {
                    number1 = Integer.parseInt(blocks[0]);
                    number2 = Integer.parseInt(blocks[1]);
                }
                operation = text.charAt(blocks[0].length());
            //Выход за пределы проверка
            if ((number1 > 10 || number1 < 0) || (number2 > 10 || number2 < 0)) {
                throw new IllegalArgumentException("Вышли за пределы доступных чисел!!!");
            }
            if (number1 == RomanNumbers(blocks[0]) && number2 == RomanNumbers(blocks[1] )) {
                String result = romanNumeral.arabicToRoman((int) Calculator.calculate(getVar1(), getVar2(), getOper()));
                System.out.println(result);
            }
            else{
                double result =(int) Calculator.calculate(getVar1(), getVar2(), getOper());
                System.out.println(result);
                }

        } catch (Exception e) {
            throw new IllegalArgumentException("Неверный формат данных: " + e);
        }}

    private static int RomanNumbers(String roman) {
        switch(roman){
            case ("I"): return 1;
            case ("II"): return 2;
            case("III"): return 3;
            case("IV"): return 4;
            case("V"): return 5;
            case("VI"): return 6;
            case("VII"): return 7;
            case("VIII"): return 8;
            case("IX"): return 9;
            case("X"): return 10;
            default: return -1;
    }}

    public int getVar1() {
        return number1;
    }
    public int getVar2() {
        return number2;
    }
    public char getOper() {
        return operation;
    }

    public boolean isExitFlag() {
        return exitFlag;
    }
}


