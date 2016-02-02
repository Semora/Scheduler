package scheduler;

import model.result.TimeLine;

/**
 * Created by Razi on 2/1/2016.
 */
abstract public class Scheduler {

    private int fakeTime;
    private Process running;
    private TimeLine mainTimeLine;

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
        this.running = null;
        this.mainTimeLine = new TimeLine();
    }

    void executeOneTimeUnit(Process nextProcess) {//TODO what if nextProcess was null -> idle
        if(this.running == null) {
            if (nextProcess != null) {
                this.running = nextProcess;
                this.removeProcessFromReadyQueue(nextProcess);
            }
        }
        else if (!this.running.equals(nextProcess)) {
            //TODO Preemption
            this.addProcessToReadyQueue(this.running);
            this.removeProcessFromReadyQueue(nextProcess);
            this.running = nextProcess;
        }

        this.mainTimeLine.getExecutionList().add(this.running);

        if (this.running == null) {
            return;
        }
        this.running.decreaseRemainingTime();//TODO Execute
        if(this.running.isDone()) {
            this.running = null;
        }

    }

    public int getFakeTime() {
        return fakeTime;
    }

    public Process getRunning() {
        return running;
    }

    public TimeLine getMainTimeLine() {
        return mainTimeLine;
    }

    abstract boolean isFinished();
    abstract void updateReadyQueue();
    abstract Process getHighestPriorityProcess(Schedulable schedulable);
    abstract void removeProcessFromReadyQueue(Process process);
    abstract void addProcessToReadyQueue(Process process);
}
