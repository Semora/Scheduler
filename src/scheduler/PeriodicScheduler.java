package scheduler;

import model.task.PeriodicTask;
import model.task.TaskSet;
import utils.Math;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Razi on 2/1/2016.
 */
public class PeriodicScheduler extends Scheduler {

    List<PeriodicProcess> periodicReadyQueue;
    TaskSet<PeriodicTask> periodicTaskSet;

    int hyperPeriod;

    public PeriodicScheduler() {
        this.hyperPeriod = 0;
    }

    @Override
    protected void start() {
        super.start();
        periodicReadyQueue = new ArrayList<>();
    }

    public void setPeriodicTaskSet(TaskSet<PeriodicTask> periodicTaskSet) {
        this.periodicTaskSet = periodicTaskSet;

        if (periodicTaskSet.getTasks().size() == 0) {
            this.hyperPeriod = 0;
            return;
        }

        this.hyperPeriod = 1;
        for (PeriodicTask pt : this.periodicTaskSet.getTasks()) {
            this.hyperPeriod = Math.lcm(hyperPeriod, pt.getPeriod());
        }

    }

    /*public TaskSet<PeriodicTask> getPeriodicTaskSet() {
        return periodicTaskSet;
    }*/

    boolean isFinished() {
        return this.getFakeTime() >= this.hyperPeriod;
    }

    void updateReadyQueue() {
        for(PeriodicTask pt : this.periodicTaskSet.getTasks()) {
            if(this.getFakeTime() % pt.getPeriod() == 0) {
                int number = this.getFakeTime() / pt.getPeriod() + 1;
                this.periodicReadyQueue.add(new PeriodicProcess(pt, number));
            }
        }
    }

    Process getHighestPriorityProcess(Schedulable schedulable) {
        List<PeriodicProcess> periodicProcesses = ((ArrayList<PeriodicProcess>)((ArrayList<PeriodicProcess>)this.periodicReadyQueue).clone());
        if (this.getRunnig() != null) {
            periodicProcesses.add((PeriodicProcess)this.getRunnig());
        }
        if (periodicProcesses.size() == 0) {
            return null;
        }
        return schedulable.getHighestPriorityProcess(periodicProcesses);
    }
    
    void removeProcessFromReadyQueue(Process process) {
        periodicReadyQueue.remove(process);
    }
    void addProcessToReadyQueue(Process process) {
        periodicReadyQueue.add((PeriodicProcess)process);
    }
}
