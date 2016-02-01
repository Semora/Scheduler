package scheduler;

/**
 * Created by Razi on 2/1/2016.
 */
abstract public class Scheduler {

    private int fakeTime;
    private Process runnig;

    public void schedule(Schedulable schedulable) {
        this.start();
        while(!this.isFinished()) {
            this.updateReadyQueue();
            Process nextProcess = this.getHighestPriorityProcess(schedulable);

            this.executeOneTimeUnit(nextProcess);

            this.fakeTime++;
        }
    }

    protected void start() {
        this.fakeTime = 0;
        this.runnig = null;
    }

    void executeOneTimeUnit(Process nextProcess) {//TODO what if nextProcess was null -> idle
        if(this.runnig == null) {
            this.runnig = nextProcess;
        }
        else if (!this.runnig.equals(nextProcess)) {
            //TODO Preemption
            this.addProcessToReadyQueue(this.runnig);
            this.removeProcessFromReadyQueue(nextProcess);
            this.runnig = nextProcess;
        }

        this.runnig.decreaseRemainingTime();//TODO Execute

        if(this.runnig.isDone()) {
            this.runnig = null;
        }

    }

    public int getFakeTime() {
        return fakeTime;
    }

    public Process getRunnig() {
        return runnig;
    }

    abstract boolean isFinished();
    abstract void updateReadyQueue();
    abstract Process getHighestPriorityProcess(Schedulable schedulable);//TODO
    abstract void removeProcessFromReadyQueue(Process process);
    abstract void addProcessToReadyQueue(Process process);
}
