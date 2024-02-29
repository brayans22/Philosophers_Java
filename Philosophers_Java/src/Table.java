import java.util.ArrayList;
import java.util.LinkedList;
import java.lang.Thread;

public class Table extends Thread {
    private int totalPhilos;
    private long timeToDie;
    private long timeToEat;
    private long timeToSleep;
    private long limitsMeals;
    private volatile int countPhilosFull;
    private volatile boolean isEnd;
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
    public Table(int _totalPhilos, long _timeToDie, long _timeToSleep,
                 long _timeToEat, long _limitMeals)
    {
        this.timeToEat = _timeToEat;
        this.timeToSleep = _timeToSleep;
        this.timeStart = System.currentTimeMillis();
        this.timeToDie = _timeToDie;
        this.countPhilosFull = 0;
        this.totalPhilos = _totalPhilos;
        this.limitsMeals = _limitMeals;
        this.isEnd = false;
        this.forks = new LinkedList<Fork>();
        this.philosophers = new LinkedList<Philosopher>();
    }
    public long getTimeToDie() {
        return timeToDie;
    }
    public long getTimeToSleep() {
        return timeToSleep;
    }
    public long getTimeToEat() {
        return timeToEat;
    }
    public void initTable()
    {
        for (int i = 0; i < this.totalPhilos; i++)
            this.forks.add(new Fork(i));
        for (int i = 0; i < this.totalPhilos; i++)
            this.philosophers.add(new Philosopher(this.forks, totalPhilos, i + 1, this));
    }

    void increasePhilosFull(){ this.countPhilosFull++; }
    synchronized public void endDinner() {
        this.isEnd = true;
        System.out.println("Philo: " + "is died: " + " Time: " + (System.currentTimeMillis() - this.timeStart));
    }
    synchronized public boolean isEndDinner()
    {
        return (this.isEnd);
    }
    synchronized public boolean allPhilosAreFull() { return (countPhilosFull + 1 <= totalPhilos); }
    synchronized public boolean philoCanEat(int countMeals) {
        return (this.limitsMeals == Constant.NOT_LIMIT_MEALS || countMeals + 1 <= this.limitsMeals);
    }
    public void startDinner()
    {
        for (Philosopher philo : this.philosophers)
        {
            philo.start();
        }
        for (Philosopher philo : this.philosophers) {
            try {
                philo.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
    public long getCurrentTime()
    {
        return (System.currentTimeMillis() - this.timeStart);
    }
}
