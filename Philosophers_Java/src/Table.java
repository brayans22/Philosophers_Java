import java.util.ArrayList;
import java.util.LinkedList;
import java.lang.Thread;

public class Table extends Thread {
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
    private void initForks()
    {
        for (int i = 0; i < this.totalPhilos; i++)
            this.forks.add(new Fork(i));
    }
    private void initPhilos()
    {
        for (int i = 0; i < this.totalPhilos; i++){
            this.philosophers.add(new Philosopher(this.forks, totalPhilos, i + 1));
        }
    }
    public void initTable()
    {
        this.initForks();
        this.initPhilos();
    }

    public void startDinner()
    {
        int i = 0;
        Thread[] threads = new Thread[philosophers.size()];
        for (Philosopher philo : philosophers) {
            Thread thread = new Thread(() -> {
                while (!philo.isDead() && !philo.isFull()) {
                    try {
                        if (philo.ateOnce)
                        {
                            philo.sleep();
                            philo.think();
                        }

                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
            });
            threads[i++] = thread;
        }
        // Esperamos a que todos los hilos terminen su ejecución
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }

}
