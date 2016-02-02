package test.algorithm.aperiodic;

import algorithm.aperiodic.Horn;
import model.result.TimeLine;
import model.task.AperiodicTask;
import model.task.TaskSet;
import org.junit.Before;
import org.junit.Test;
import scheduler.AperiodicScheduler;

/**
 * Created by Razi on 2/2/2016.
 */
public class HornTest {
    Horn horn;
    AperiodicScheduler aperiodicScheduler;

    @Before
    public void setUp() throws Exception {
        this.horn = new Horn();
        this.aperiodicScheduler = new AperiodicScheduler();
    }

    @Test
    public void schedule() throws Exception {
        AperiodicTask at = new AperiodicTask(7,"t1",5,1,9);
        AperiodicTask at1 = new AperiodicTask(5,"t2",9,2,20);
        AperiodicTask at2 = new AperiodicTask(5,"t3",10,5,15);

        TaskSet<AperiodicTask> ts = new TaskSet<AperiodicTask>("temp/");
        ts.addTask(at);
        ts.addTask(at1);
        ts.addTask(at2);

        horn.setAperiodicTaskSet(ts);

        this.aperiodicScheduler.schedule(this.horn, ts);
        TimeLine timeLine = this.aperiodicScheduler.getMainTimeLine();
        for (scheduler.Process p : timeLine.getExecutionList()){
            if (p != null)
                System.out.println(p.getName());
            else
                System.out.println("idle");
        }
    }
}
