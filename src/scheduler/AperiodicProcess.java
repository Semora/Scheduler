package scheduler;


import model.task.AperiodicTask;

/**
 * Created by Razi on 2/2/2016.
 */
public class AperiodicProcess extends Process {
    AperiodicProcess(AperiodicTask aperiodicTask) {
        super(aperiodicTask, aperiodicTask.getArrivalTime(), aperiodicTask.getDeadline());
        this.name = aperiodicTask.getName();
    }
}
