package scheduler;

import model.task.PeriodicTask;

/**
 * Created by Razi on 2/1/2016.
 */
public class PeriodicProcess extends Process {
    int period;

    PeriodicProcess(PeriodicTask periodicTask, int number){
        //TODO
    }

    public int getPeriod() {
        return period;
    }
}
