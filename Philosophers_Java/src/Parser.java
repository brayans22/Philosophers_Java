public class Parser {
    static Table argumentsToTable(String[] arguments) {
        if (arguments == null || arguments.length < 5 || arguments.length > 6)
            return null;
        if (!Validator.is_valid_argument(arguments[1]) || !Validator.is_valid_argument(arguments[2])
                || !Validator.is_valid_argument(arguments[3]) || !Validator.is_valid_argument(arguments[4])
                || (arguments.length == 6 && !Validator.is_valid_argument(arguments[5])))
            return null;
        if (arguments.length == 6) {
            Table table = new Table(Integer.parseInt(arguments[1]), Long.parseLong(arguments[2]),
                    Long.parseLong(arguments[3]), Long.parseLong(arguments[4]), Long.parseLong(arguments[5]));
        }
        else
        {
            Table table = new Table(Integer.parseInt(arguments[1]), Long.parseLong(arguments[2]),
                    Long.parseLong(arguments[3]), Long.parseLong(arguments[4]), Constant.NOT_LIMIT_MEALS);
        }
        return table;
    }
}


