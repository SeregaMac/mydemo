import java.net.SocketTimeoutException;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        Scanner s = new Scanner(System.in);
        String string = s.nextLine();                // метод считывания у объекта s сканер

        Rome rome1 = new Rome();
        Rome rome2 = new Rome();

        String[] numbrs = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};

        String[] strings = string.split("[-*+/]");  // разделение выражения на а и б ввод в массив стрингс
        String num1 = strings[0];
        String num2 = strings[1];
        rome1.number = strings[0];
        rome2.number = strings[1];

        int numb1 = rome1.converter()+1;
        int numb2 = rome2.converter()+1;


        int plus = string.indexOf("+");
        int minus = string.indexOf("-");
        int razdelit = string.indexOf("/");
        int umnozh = string.indexOf("*");

        if (strings.length!= 2) {System.out.println("Вы не ввели неправильное выражение");}

        int numbe1 = Arrays.binarySearch(numbrs, num1);
        int numbe2 = Arrays.binarySearch(numbrs, num2);

        if (numb1 > 0 && numb1<=10 && numb2 > 0 && numb2<=10) {

                if (plus > 0)               {int numb3 = numb1 + numb2; System.out.println(numb3);}

                else if (minus > 0)         {int numb3 = numb1 - numb2; if(numb3>0){ System.out.println(numb3);}
                                            else {System.out.println("throws Exception //т.к. в римской системе нет отрицательных чисел");}}
                else if (razdelit > 0)      {int numb3 = numb1 / numb2; System.out.println(numb3);}

                else if (umnozh > 0)        {int numb3 = numb1 * numb2; System.out.println(numb3);}

        } else if (numbe1 > -1 && numbe2 > -1) {

            if (plus > 0)                   {int numbe3 = numbe1 + numbe2; System.out.println(numbe3);}
            else if (minus > 0)             {int numbe3 = numbe1 - numbe2; System.out.println(numbe3);}
            else if (razdelit > 0)          {int numbe3 = numbe1 / numbe2; System.out.println(numbe3);}
            else                            {int numbe3 = numbe1 * numbe2; System.out.println(numbe3);}

        } else                              {System.out.println("3Введите правильное выражение");}
    }
}
class Rome {
    String [] rome = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
            "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
            "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX",
            "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
            "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L",
            "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
            "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
            "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
            "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
            "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};

    String number;
    int converter () {
        for (int i = 0; i <rome.length; i++)
        {if (number.equals(rome[i])) { return i;}}return-1;}

}

