import java.util.LinkedList;

public class Table {
    private int totalPhilos;
    private long timeToDie;
    private long timeToEat;
    private long timeToSleep;
    private long limitsMeals;
    private int countPhilosFull;
    private boolean isEnd;
    private long timeStart;
    private LinkedList<Philosopher> philosophers;
    private LinkedList<Fork> forks;
    public Table()
    {
        this.timeToEat = 0;
        this.timeToSleep = 0;
        this.timeStart = 0;
        this.timeToDie = 0;
        this.countPhilosFull = 0;
        this.totalPhilos = 0;
        this.limitsMeals = Constant.NOT_LIMIT_MEALS;
        this.isEnd = false;
        this.forks = new LinkedList<Fork>();
        this.philosophers = new LinkedList<Philosopher>();
    }
    public Table(int _totalPhilos, long _timeToDie, long _timeToSleep, long _timeToEat, long _limitMeals)
    {
        this.timeToEat = _timeToEat;
        this.timeToSleep = _timeToSleep;
        this.timeStart = 0;
        this.timeToDie = _timeToDie;
        this.countPhilosFull = 0;
        this.totalPhilos = _totalPhilos;
        this.limitsMeals = _limitMeals;
        this.isEnd = false;
        this.forks = new LinkedList<Fork>();
        this.philosophers = new LinkedList<Philosopher>();
    }
    public void addPhilo(Philosopher _philo) { this.philosophers.add(_philo); }
    public void addFork(Fork _forks) { this.forks.add(_forks); }
}
