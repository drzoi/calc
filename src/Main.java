public class Main {
    public static void main(String[] args) {
        String input = Moduls.inStr();
        System.out.println(Main.calc(input));
    }

    public static String calc(String input) {
        String outRes = "";
        Moduls.lengthStr(input);

        String[] delInput = input.split(" ");
        int l = delInput.length;
        if (Moduls.checkNstr(l) == 3) {
            int[] str1mark = Moduls.strToNumber(delInput[0]);
            int[] str2mark = Moduls.strToNumber(delInput[1]);
            int[] str3mark = Moduls.strToNumber(delInput[2]);

            Moduls.checkStr(str1mark[1], str2mark[1], str3mark[1]);

            int result = Moduls.res(str1mark[0], str2mark[0], str3mark[0], str1mark[1]);

            if (str1mark[1] == 1) {
                outRes = Integer.toString(result);
            } else {
                outRes = Moduls.arabToRim(result);
            }

        }
        return outRes;
    }


}