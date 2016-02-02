package scheduler;

import model.task.AperiodicTask;
import model.task.TaskSet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Razi on 2/2/2016.
 */
public class AperiodicScheduler extends Scheduler{

    List<AperiodicProcess> aperiodicReadyQueue;
    TaskSet<AperiodicTask> aperiodicTaskSet;
    int maxDeadline;

    @Override
    boolean isFinished() {
        return this.getFakeTime() >= maxDeadline && aperiodicReadyQueue.size() == 0 && this.getRunning() == null;
    }

    @Override
    protected void start() {
        super.start();
        aperiodicReadyQueue = new ArrayList<>();
    }

    public void schedule(Schedulable schedulable, TaskSet<AperiodicTask> aperiodicTaskSet) {
        this.setAperiodicTaskSet(aperiodicTaskSet);
        this.schedule(schedulable);
    }

    private void setAperiodicTaskSet(TaskSet<AperiodicTask> aperiodicTaskSet) {
        this.aperiodicTaskSet = aperiodicTaskSet;

        if (aperiodicTaskSet.getTasks().size() == 0) {
            this.maxDeadline = 0;
            return;
        }

        for (AperiodicTask at : this.aperiodicTaskSet.getTasks()) {
            if (this.maxDeadline < at.getDeadline())
            this.maxDeadline = at.getDeadline();
        }

    }

    @Override
    void updateReadyQueue() {
        for(AperiodicTask at : this.aperiodicTaskSet.getTasks()) {
            if(this.getFakeTime() == at.getArrivalTime()) {
                this.aperiodicReadyQueue.add(new AperiodicProcess(at));
            }
        }
    }

    @Override
    Process getHighestPriorityProcess(Schedulable schedulable) {
        List<AperiodicProcess> aperiodicProcesses = ((ArrayList<AperiodicProcess>)((ArrayList<AperiodicProcess>)this.aperiodicReadyQueue).clone());
        if (this.getRunning() != null) {
            aperiodicProcesses.add((AperiodicProcess)this.getRunning());
        }
        if (aperiodicProcesses.size() == 0) {
            return null;
        }
        return schedulable.getHighestPriorityProcess(aperiodicProcesses);
    }

    @Override
    void removeProcessFromReadyQueue(Process process) {
        aperiodicReadyQueue.remove((AperiodicProcess)process);
    }

    @Override
    void addProcessToReadyQueue(Process process) {
        aperiodicReadyQueue.add((AperiodicProcess)process);
    }

}
