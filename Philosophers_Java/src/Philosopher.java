import java.util.ArrayList;
import java.util.LinkedList;

public class Philosopher extends Thread {
    private Fork leftFork;
    private Fork rightFork;
    private int id;
    private int index;
    private int counterMeals;
    private long lastMealTime;
    private boolean isFull;
    public Philosopher(LinkedList<Fork> _forks, int _totalPhilos, int _id)
    {
        this.assignForks(_forks, _totalPhilos);
        this.id = _id;
        this.isFull = false;
        this.lastMealTime = 0;
        this.counterMeals = 0;
    }
    private int	assignForks(LinkedList<Fork> forks, int totalPhilos)
    {
        Fork leftFork;
        Fork rightFork;

        leftFork = forks.getFirst();
        rightFork = forks.getFirst();
        if (totalPhilos > 1)
        {
            if (this.id % 2 != 0)
            {
                rightFork = forks.get(this.index);
                leftFork = forks.get((index + 1) % totalPhilos);
            }
            else {
                leftFork = forks.get(this.index);
                rightFork = forks.get((index + 1) % totalPhilos);
            }
        }
        return (Constant.OK);
    }

    private void sleeping(long timeToSleep) throws InterruptedException {
        System.out.println("Philo: " + this.id + "| " + System.currentTimeMillis() + " ms" + "Is Sleeping");
        Thread.sleep(timeToSleep);
    }

    private void thinking() throws InterruptedException {
        System.out.println("Philo: " + this.id + "| " + System.currentTimeMillis() + " ms" + "Is thinking");
    }

    private void eat() throws InterruptedException {
        synchronized (this.leftFork) {
            synchronized (this.rightFork) {
                if ()
            }
        }
    }
}
