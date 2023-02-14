import java.util.Scanner;

import static java.lang.String.valueOf;

public class Main {
    public static void main(String[] args) throws Exception{

        System.out.println("Hello world!");
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();                // метод считывания у объекта s сканер
        System.out.println(calc(input));
    }

    public static String calc(String input) throws Exception{

        String[] rome = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
                "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX",
                "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L",
                "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};

        String[] numbrs = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};

        String[] strings = input.split("[\\-*+/]");  // разделение выражения на а и б ввод в массив стрингс
        String num1 = strings[0];
        String num2 = strings[1];

        if (strings.length == 1) throw new Exception("т.к. строка не является математической операцией");
        if (strings.length != 2) throw new Exception ("т.к. формат математической операции не удовлетворяет " +
                                                        "заданию - два операнда и один оператор (+, -, /, *)");

        int romNum1 = converter1(rome, num1) + 1;
        int romNum2 = converter2(rome, num2) + 1;

        int arabNum1 = arabConverter1 (numbrs, num1);
        int arabNum2 = arabConverter2 (numbrs, num2);

        if (romNum1>10 && romNum2>0 && romNum2<11 || romNum1>0 && romNum1<11 && romNum2>10)
            throw new Exception("т.к. формат цифр не удовлетворяет заданию");                //проверка на римские
        if (arabNum1>10 && arabNum2>-1 && arabNum2<11 || arabNum1>-1 && arabNum1<11 && arabNum2>10)
            throw new Exception("т.к. формат цифр не удовлетворяет заданию");

        if (romNum1<1 && romNum2>0 && romNum2<11 || romNum1>0 && romNum1<11 && romNum2<1)
            throw new Exception("т.к. формат цифр не удовлетворяет заданию");                //проверка на римские
        if (arabNum1<0 && arabNum2>-1 && arabNum2<11 || arabNum1>-1 && arabNum1<11 && arabNum2<0)
            throw new Exception("т.к. формат цифр не удовлетворяет заданию");


        int pl = input.indexOf("+");
        int min = input.indexOf("-");
        int raz = input.indexOf("/");
        int umn = input.indexOf("*");

        if (raz>0 && arabNum2 == 0) throw new Exception("т.к. на ноль делить нельзя");

        int rezulta = calcul (romNum1, romNum2, arabNum1, arabNum2, pl, min, raz);

        String rezultat = reConvert (rezulta,romNum1, rome);

    return rezultat;
    }
   static int converter1(String [] rome,String num1){
        for(int i=0;i<rome.length;i++){
            if(num1.equals(rome[i])){
                return i;}
        }
        return-1;
   }
    static int converter2(String [] rome,String num2){
        for(int i=0;i<rome.length;i++){
            if(num2.equals(rome[i])){
                return i;}
        }
        return-1;
    }

    static int arabConverter1 (String [] numbrs, String num1) {
        for (int i = 0; i < numbrs.length; i++) {
            if (num1.equals(numbrs[i])){
                return i;}
        }
        return -1;
    }
    static int arabConverter2 (String [] numbrs, String num2) {
        for (int i = 0; i < numbrs.length; i++) {
            if (num2.equals(numbrs[i])){
                return i;}
        }
        return -1;
    }

    static String reConvert (int rezulta, int romNum1, String [] rome) {
        if (romNum1 > 0) { String rezult1 = rome [rezulta-1]; return rezult1;}
        else { String rezult1 =valueOf(rezulta) ; return rezult1;}
    }
    static int calcul (int romNum1, int romNum2, int arabNum1, int arabNum2, int pl, int min,
                       int raz) throws Exception{

    if (romNum1>0 && romNum2>0) {if (pl >0) {int rezul = romNum1+romNum2; return rezul;}
                                else if (min>0) {int rezul = romNum1-romNum2;if (rezul>0) {return rezul;}
                                {throw new Exception("т.к. римское число не может быть меньше ноля");}}
                                else if (raz>0) {int rezul = romNum1/romNum2; return rezul;}
                                else {int rezultat = romNum1*romNum2; return rezultat;}}

    else if (arabNum1>0 && arabNum2 >0) {if (pl >0) {int rezul = arabNum1+arabNum2; return rezul;}
                                        else if (min>0) {int rezul = arabNum1-arabNum2; return rezul;}
                                        else if (raz>0) {int rezul = arabNum1/arabNum2; return rezul;}
                                        else {int rezul = arabNum1*arabNum2; return rezul;}}
    else throw new Exception("т.к. используются одновременно разные системы счисления");
    }
}


