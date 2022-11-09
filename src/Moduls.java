import java.util.Scanner;

public class Moduls {

    // Модуль ввода с клавиатуры
    static String inStr() {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите выражение в виде: два операнда и один оператор (+, -, /, *)");
        System.out.println("Пример: a + b");
        return in.nextLine();
    }




    // Модуль проверки длины выражения макс 11: VIII + VIII
    static void lengthStr(String input) {
        int lStr = input.length();
        if (lStr > 11) {
            try {
                throw new Exception("throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.exit(0);
            }
        }
    }



    //Модуль преобразовния сторки в числа
    static int[] strToNumber(String input) {
        //Массивы чисел и знаков
        String[] oblZadachArab = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        String[] oblZadachRim = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        String[] oblZadachZnaki = {"+", "-", "*", "/"};

        //Марекры соответствия строки массивам области определений
        int m1 = 1;
        int m2 = 0;


        for (int i = 0; i < 10; i++) {
            if (input.equalsIgnoreCase(oblZadachArab[i])) {
                m2 = 1;
                break;
            }
            if (input.equalsIgnoreCase(oblZadachRim[i])) {
                m2 = 2;
                break;
            }
            if (i < 4 && input.equalsIgnoreCase(oblZadachZnaki[i])) {
                m2 = 3;
                break;
            }
            m1++;
        }
        if (m2 == 0) {
            System.out.println("throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда от 1 до 10 и один оператор (+, -, /, *)");
            System.exit(0);
        }
        return new int[]{m1, m2};
    }



    //модуль перевода числа в римские цифры
    static String arabToRim(int input) {
        String result = "";
        int n1 = input / 100;
        int n2 = (input % 100) / 10;
        int n3 = input % 10;

        if (n1 == 1) {
            result = result + "C";
        }

        result = switch (n2) {
            case 1 -> result + "X";
            case 2 -> result + "XX";
            case 3 -> result + "XXX";
            case 4 -> result + "XL";
            case 5 -> result + "L";
            case 6 -> result + "LX";
            case 7 -> result + "LXX";
            case 8 -> result + "LXXX";
            case 9 -> result + "XC";
            default -> result;
        };

        result = switch (n3) {
            case 1 -> result + "I";
            case 2 -> result + "II";
            case 3 -> result + "III";
            case 4 -> result + "IV";
            case 5 -> result + "V";
            case 6 -> result + "VI";
            case 7 -> result + "VII";
            case 8 -> result + "VIII";
            case 9 -> result + "IX";
            default -> result;
        };
        return result;
    }


    // Модуль проверки кол-ва строк между пробелами
    static int checkNstr (int in){
        int n=0;
        switch (in) {
            case 3 -> n = 3;
            case 1, 2 -> {
                System.out.println("throws Exception //т.к. строка не является математической операцией");
                System.exit(0);
            }
            default -> {
                System.out.println("throws Exception // т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
                System.exit(0);
            }
        }
        return n;
    }


    // Модуль проверки корректности введенного выражения:
    static void checkStr (int in1, int in2, int in3){
        if (in2 != 3) {
            System.out.println("throws Exception //т.к. строка не является математической операцией");
            System.exit(0);
        }

        if (in1 != in3) {
            System.out.println("throws Exception //т.к. используются одновременно разные системы счисления");
            System.exit(0);
        }

    }

    static int res (int in1, int in2, int in3, int in4){
        int result = 0;

        result = switch (in2) {
            case 1 -> in1 + in3;
            case 2 -> in1 - in3;
            case 3 -> in1 * in3;
            case 4 -> in1 / in3;
            default -> result;
        };

        if (in4 == 2 && result < 1) {
            System.out.println("throws Exception //т.к. в римской системе нет отрицательных чисел и 0");
            System.exit(0);
        }
    return result;
    }

}


