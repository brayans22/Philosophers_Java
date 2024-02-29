import java.util.ArrayList;
import java.util.LinkedList;

public class Philosopher extends Thread {
    private Fork leftFork;
    private Fork rightFork;
    private int id;
    private int index;
    private int counterMeals;
    private long lastMealTime;
    private Table table;
    public Philosopher(LinkedList<Fork> _forks, int _totalPhilos, int _id, Table _table)
    {
        this.assignForks(_forks, _totalPhilos);
        this.id = _id;
        this.index = _id - 1;
        this.lastMealTime = 0;
        this.counterMeals = 0;
        this.table = _table;
    }
    @Override
    public void run()
    {
        while (!table.isEndDinner())
        {
            if (this.counterMeals > 0){
                try {
                    this.sleepRoutine(table.getTimeToSleep());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                try {
                    this.thinkRoutine();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("ENTRO EL HILO: " + this.id);
            this.eatRoutine();
        }
    }
    private void assignForks(LinkedList<Fork> forks, int totalPhilos)
    {
        System.out.println("LEFT FORK " + leftFork);
        System.out.println("RIGHT FORK " + rightFork);
        System.out.println("total: " + totalPhilos);
        if (totalPhilos > 1)
        {
            this.leftFork = forks.get(this.index);
            this.rightFork = forks.get((this.index + 1) % totalPhilos);
        }
        else
        {
            this.leftFork = forks.get(0);
            this.rightFork = leftFork;
        }
        System.out.println("------LEFT FORK " + leftFork);
        System.out.println("------RIGHT FORK " + rightFork);
    }
    synchronized private void sleepRoutine(long timeToSleep) throws InterruptedException {
        System.out.println("Philo: " + this.id + "| " + table.getCurrentTime() + " ms" + "is Sleeping");
        Thread.sleep(timeToSleep);
    }
    synchronized private void thinkRoutine() throws InterruptedException {
        System.out.println("Philo: " + this.id + "| " + table.getCurrentTime() + " ms" + "is thinking");
    }
    private boolean isDied()
    {
        return (System.currentTimeMillis() - this.lastMealTime > table.getTimeToDie());
    }
    private void eatRoutine() {
        if (table.philoCanEat(this.counterMeals)) {
            synchronized (System.out) {
                System.out.println("Philo: " + this.id + "Take Left Fork: "
                        + this.leftFork + " Time: " + table.getCurrentTime());
                System.out.println("Philo: " + this.id + "Take Right Fork: "
                        + this.rightFork + " Time: " + table.getCurrentTime());
            }
            try {
                sleep(table.getTimeToEat());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized (System.out) {
                System.out.println("Philo: "+ this.id + "Take Left Fork: " + this.leftFork
                        + " Time: " + table.getCurrentTime());
                System.out.println("Philo: "+ this.id + "Take Right Fork: " + this.rightFork
                        + " Time: " + table.getCurrentTime());
            }
            this.counterMeals++;
            if (!this.isDied())
                this.lastMealTime = System.currentTimeMillis();
            else
                this.table.endDinner();
        }
        System.out.println("TOTAL DE COMIDAS: " + this.counterMeals);
        if (!table.philoCanEat(this.counterMeals)) {
            table.increasePhilosFull();
            if (table.allPhilosAreFull()){
                System.out.println("ENTRO");
                table.endDinner();
            }
        }
    }
}