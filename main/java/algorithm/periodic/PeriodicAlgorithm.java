package algorithm.periodic;

import algorithm.Algorithm;
import model.task.PeriodicTask;
import model.task.TaskSet;

/**
 * Created by Razi on 2/1/2016.
 */
abstract public class PeriodicAlgorithm extends Algorithm {
    TaskSet<PeriodicTask> periodicTaskSet;

    public void setPeriodicTaskSet(TaskSet<PeriodicTask> periodicTaskSet) {
        this.periodicTaskSet = periodicTaskSet;
    }

    public TaskSet<PeriodicTask> getPeriodicTaskSet() {
        return periodicTaskSet;
    }
}
