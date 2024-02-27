public class Util {
    public static long atol(String str) {
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException e) {
            System.out.println(Constant.MESSAGE_ERROR_NOT_NUMERIC_ARGUMENT);
            return 0;
        }
    }
    public static int getLenNb(String str) {
        int len = 0;
        int start = 0;

        if (str == null)
            return 0;
        while (start < str.length() && str.charAt(start) == '0')
            start++;
        len = str.length() - start;
        return len;
    }
}
