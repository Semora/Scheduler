package algorithm.aperiodic;

import algorithm.Algorithm;
import model.task.AperiodicTask;
import model.task.TaskSet;

import java.util.AbstractCollection;

/**
 * Created by Razi on 2/2/2016.
 */
abstract public class AperiodicAlgorithm extends Algorithm {
    TaskSet<AperiodicTask> aperiodicTaskSet;

    public void setAperiodicTaskSet(TaskSet<AperiodicTask> aperiodicTaskSet) {
        this.aperiodicTaskSet = aperiodicTaskSet;
    }

    public TaskSet<AperiodicTask> getAperiodicTaskSet() {
        return aperiodicTaskSet;
    }
}