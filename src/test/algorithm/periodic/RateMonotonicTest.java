package test.algorithm.periodic;

import algorithm.periodic.RateMonotonic;
import model.result.TimeLine;
import model.task.PeriodicTask;
import model.task.TaskSet;
import org.junit.*;
import org.junit.runners.MethodSorters;
import scheduler.*;

import static org.junit.Assert.assertEquals;

/**
 * Created by Razi on 2/1/2016.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RateMonotonicTest {

    /*
    @BeforeClass
    public static void setUpClass() throws Exception {
        // Code executed before the first test method
    }*/

    RateMonotonic rm;
    PeriodicScheduler periodicScheduler;

    @Before
    public void setUp() throws Exception {
        this.rm = new RateMonotonic();
        this.periodicScheduler = new PeriodicScheduler();
    }



    @Test
    public void scheduleEmptyTaskSet() throws Exception {
        this.periodicScheduler.schedule(this.rm);
    }

    @Test
    public void schedule() throws Exception {
        PeriodicTask pt = new PeriodicTask(7,"task_1",5,2);
        PeriodicTask pt1 = new PeriodicTask(5,"task_2",9,2);

        TaskSet<PeriodicTask> ts = new TaskSet<PeriodicTask>("temp/");
        ts.addTask(pt);
        ts.addTask(pt1);
        this.rm.setPeriodicTaskSet(ts);
        this.periodicScheduler.setPeriodicTaskSet(ts);
        this.periodicScheduler.schedule(this.rm);
        TimeLine timeLine = this.periodicScheduler.getMainTimeLine();
        for (scheduler.Process p : timeLine.getExecutionList()){
            if (p != null)
                System.out.println(p.getName());
            else
                System.out.println("idle");
        }
    }

    /*@AfterClass
    public static void tearDownClass() throws Exception {
        // Code executed after the last test method
    }*/
}
