package algorithm.aperiodic;

import scheduler.AperiodicProcess;
import scheduler.Schedulable;

import java.util.List;

/**
 * Created by Razi on 2/2/2016.
 */
public class Horn extends AperiodicAlgorithm implements Schedulable<AperiodicProcess>{
    @Override
    public void validate() {

    }

    @Override
    public void analyze() {

    }

    @Override
    public AperiodicProcess getHighestPriorityProcess(List<AperiodicProcess> processes) {
        if (processes.size() == 0) {
            return null;
        }
        AperiodicProcess highestPriority =  processes.get(0);
        for(AperiodicProcess pp : processes) {
            if (pp.getDeadline() < highestPriority.getDeadline()){
                highestPriority = pp;
            }
        }
        return highestPriority;
    }
}
