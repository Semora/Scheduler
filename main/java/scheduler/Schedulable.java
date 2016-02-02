package scheduler;

import java.util.List;

/**
 * Created by Razi on 2/1/2016.
 */
public interface Schedulable <processType extends Process> {
    public processType getHighestPriorityProcess(List<processType> processes);
}