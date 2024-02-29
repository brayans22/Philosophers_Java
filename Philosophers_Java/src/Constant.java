public class Constant {
    public static final char MIN_DIGIT_CHAR = '0';
    public static final char MAX_DIGIT_CHAR = '9';
    public static final char NULL_STR = '\0';
    public static final int MAX_INT = 2147483647;
    public static final int MIN_INT = -2147483648;
    public static final String MESSAGE_ERROR_MUTEX = "Error\nMutex throw exception\n";
    public static final String MESSAGE_ERROR_THREAD = "Error\nThread throw exception\n";
    public static final String MESSAGE_ERROR_INVALID_MODE_MUTEX = "Error\nInvalid mode mutex\n";
    public static final String MESSAGE_MORE_THAN_ZERO = "Error\nArgument has to be more than zero\n";
    public static final String MESSAGE_ERROR_INVALID_MODE_THREAD = "Error\nInvalid mode thread\n";
    public static final String MESSAGE_ERROR_NOT_NUMERIC_ARGUMENT = "Error\nArguments has to be positive numbers!\n";
    public static final String MESSAGE_ERROR_OUT_OF_INT_LIMIT = "Error\nArguments has to respect the int limits\n";
    public static final String MESSAGE_ERROR_MALLOC = "Error\nMalloc allocation fails\n";
    public static final String MESSAGE_ERROR_MEMSET = "Error\nMemset fails\n";
    public static final String MESSAGE_ERROR_INVALID_ARGUMENTS = "Error Invalid Arguments!\n" +
            "Usage: number_of_philosophers time_to_die time_to_eat time_to_sleep " +
            "[number_of_times_each_philosopher_must_eat]" + "\nExample: ./philo 5 600 500 400 [5]\n";
    public static final long NOT_LIMIT_MEALS = -100;
    public static final int EMPTY = -2;
    public static final int OK = 2;
}
