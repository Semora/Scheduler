package scheduler;

/**
 * Created by Razi on 2/1/2016.
 */
abstract public class Process {
    private static int lastId = 0;
    private final int id;

    private int remainingTime;

    private static int getId() {
        return lastId++;
    }

    Process() {
        this.id = Process.getId();
    }

    boolean equals(Process process) {
        return this.id == process.id;
    }

    public void setRemainingTime(int remainingTime) {
        this.remainingTime = remainingTime;
    }

    public int getRemainingTime() {
        return remainingTime;
    }

    void decreaseRemainingTime() {
        if(this.remainingTime > 0) {
            this.remainingTime--;
        }
    }
    boolean isDone() {
        return this.remainingTime == 0;
    }

}
