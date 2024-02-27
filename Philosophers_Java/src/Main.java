public class Main {
    public static void main(String[] args) {
        if (args.length == 5 || args.length == 6) {
            Table table = Parser.argumentsToTable(args);
            if (table == null)
                return ;

        }
        System.out.println(Constant.MESSAGE_ERROR_INVALID_ARGUMENTS);
    }
}