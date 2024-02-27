public class Parser {
    static Table argumentsToTable(String[] arguments) {
        Table table;
        if (arguments == null || arguments.length < 4 || arguments.length > 5)
            return null;
        if (!Validator.is_valid_argument(arguments[0]) || !Validator.is_valid_argument(arguments[1])
                || !Validator.is_valid_argument(arguments[2]) || !Validator.is_valid_argument(arguments[3])
                || (arguments.length == 5 && !Validator.is_valid_argument(arguments[4])))
            return null;
        if (arguments.length == 5) {
            table = new Table(Integer.parseInt(arguments[0]), Long.parseLong(arguments[1]),
                    Long.parseLong(arguments[2]), Long.parseLong(arguments[3]), Long.parseLong(arguments[4]));
        }
        else
        {
            table = new Table(Integer.parseInt(arguments[0]), Long.parseLong(arguments[1]),
                    Long.parseLong(arguments[2]), Long.parseLong(arguments[3]), Constant.NOT_LIMIT_MEALS);
        }
        return table;
    }
}


