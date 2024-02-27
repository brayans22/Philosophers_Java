public class Validator {
    static boolean is_valid_argument(String nb) {
        if (nb == null)
            return false;
        if (nb.matches(".*\\D.*"))
            System.out.println(Constant.MESSAGE_ERROR_NOT_NUMERIC_ARGUMENT);
        long tmp = Util.atol(nb);
        if (tmp < Integer.MIN_VALUE || tmp > Integer.MAX_VALUE || (Util.getLenNb(nb) > 10 && nb.charAt(0) != '-')
                || (Util.getLenNb(nb) > 11 && nb.charAt(0) == '-')) {
            System.out.println(Constant.MESSAGE_ERROR_OUT_OF_INT_LIMIT);
            return false;
        }
        if (tmp <= 0) {
            System.out.println(Constant.MESSAGE_MORE_THAN_ZERO);
            return false;
        }
        return true;
    }
}
