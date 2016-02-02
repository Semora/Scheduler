package scheduler;

import model.task.PeriodicTask;

/**
 * Created by Razi on 2/1/2016.
 */
public class PeriodicProcess extends Process {
    PeriodicProcess(PeriodicTask periodicTask, int number){
        super(periodicTask, periodicTask.getPeriod() * number, (periodicTask.getPeriod() + 1) * number);
        this.name = periodicTask.getName() + '.' + number;
    }

    public int getPeriod() {
        return ((PeriodicTask)this.task).getPeriod();
    }
}
