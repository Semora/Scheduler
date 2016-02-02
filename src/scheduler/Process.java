package scheduler;

import model.task.Task;

/**
 * Created by Razi on 2/1/2016.
 */
abstract public class Process {
    private static int lastId = 0;
    private final int id;

    protected Task task;

    protected String name;

    protected int arrivalTime;
    protected int deadline;

    private int remainingTime;

    private static int getId() {
        return lastId++;
    }

    protected Process(Task task, int arrivalTime, int deadline) {
        this.id = Process.getId();
        this.task = task;
        this.arrivalTime = arrivalTime;
        this.deadline = deadline;
        this.remainingTime = task.getExecutionTime();
    }

    boolean equals(Process process) {
        return this.id == process.id;
    }

    void decreaseRemainingTime() {
        if(this.remainingTime > 0) {
            this.remainingTime--;
        }
    }
    boolean isDone() {
        return this.remainingTime == 0;
    }

    public int getRemainingTime() {
        return remainingTime;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public int getDeadline() {
        return deadline;
    }

    public String getName() {
        return name;
    }
}
