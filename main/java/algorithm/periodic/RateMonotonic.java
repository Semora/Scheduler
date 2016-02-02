package algorithm.periodic;

import scheduler.PeriodicProcess;
import scheduler.PeriodicScheduler;
import scheduler.Process;
import scheduler.Schedulable;

import java.util.List;

/**
 * Created by Razi on 2/1/2016.
 */
public class RateMonotonic extends PeriodicAlgorithm implements Schedulable<PeriodicProcess>{

    public RateMonotonic() {

    }

    @Override
    public void validate() {

    }

    @Override
    public void analyze() {

    }

    public  PeriodicProcess getHighestPriorityProcess(List<PeriodicProcess> periodicProcesses) {
        if (periodicProcesses.size() == 0) {
            return null;
        }
        PeriodicProcess highestPriority =  periodicProcesses.get(0);
        for(PeriodicProcess pp : periodicProcesses) {
            if (pp.getPeriod() < highestPriority.getPeriod()){
                highestPriority = pp;
            }
        }
        return highestPriority;
    }
}
