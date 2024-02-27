public class Validator extends Exception{
    static boolean is_valid_argument(String nb) {
        if (nb == null)
            throw new RuntimeException();
        if (nb.matches(".*\\D.*"))
            throw new RuntimeException(Constant.MESSAGE_ERROR_NOT_NUMERIC_ARGUMENT);
        long tmp = Util.atol(nb);
        if (tmp < Integer.MIN_VALUE || tmp > Integer.MAX_VALUE || (Util.getLenNb(nb) > 10 && nb.charAt(0) != '-')
                || (Util.getLenNb(nb) > 11 && nb.charAt(0) == '-')) {
            throw new RuntimeException(Constant.MESSAGE_ERROR_OUT_OF_INT_LIMIT);
        }
        if (tmp <= 0)
            throw new RuntimeException(Constant.MESSAGE_MORE_THAN_ZERO);
        return true;
    }
}
