public class Main {
    public static void main(String[] args) {
        if (args.length == 4 || args.length == 5) {
            Table table = Parser.argumentsToTable(args);
            if (table == null)
                return ;
            table.initTable();
            table.startDinner();
        }
        else
            System.out.println(Constant.MESSAGE_ERROR_INVALID_ARGUMENTS);
    }
}