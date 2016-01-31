package main;

import logic.Logic;
import model.task.AperiodicTask;
import model.task.PeriodicTask;
import model.task.TaskSet;

import java.util.List;

/**
 * Created by Razi on 1/31/2016.
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println("---------------------------------------- testPeriodicTaskSet");
        main.testPeriodicTaskSet();

        System.out.println("---------------------------------------- testAperiodicTaskSet");
        main.testAperiodicTaskSet();

        System.out.println("---------------------------------------- testLogicAlgorithmLists");
        main.testLogicAlgorithmLists();

    }

    public void testPeriodicTaskSet() {
        PeriodicTask pt = new PeriodicTask(7,"t1",5,1);
        PeriodicTask pt1 = new PeriodicTask(5,"t2",9,2);

        TaskSet <PeriodicTask> ts = new TaskSet<PeriodicTask>("temp/");
        ts.addTask(pt);
        ts.addTask(pt1);

        ts.save("first");
        TaskSet <PeriodicTask> lts = TaskSet.<PeriodicTask>load("temp/first");

        System.out.println(ts);
        System.out.println(lts);
    }

    public void testAperiodicTaskSet() {
        AperiodicTask at = new AperiodicTask(7,"t1",5,1,9);
        AperiodicTask at1 = new AperiodicTask(5,"t2",9,2,70);

        TaskSet <AperiodicTask> ts = new TaskSet<AperiodicTask>("temp/");
        ts.addTask(at);
        ts.addTask(at1);

        ts.save("second");
        TaskSet <AperiodicTask> lts = TaskSet.<AperiodicTask>load("temp/second");

        System.out.println(ts);
        System.out.println(lts);
    }

    public void testLogicAlgorithmLists() {
        List<String> pl = Logic.getPeriodicAlgorithmList();
        List<String> al = Logic.getAperiodicAlgorithmList();
        List<String> ml = Logic.getMixedAlgorithmList();

        System.out.println("periodic algorithms :");
        for(String n : pl) {
            System.out.println(n);
        }
        System.out.println();

        System.out.println("aperiodic algorithms :");
        for(String n : al) {
            System.out.println(n);
        }
        System.out.println();

        System.out.println("mixed algorithms :");
        for(String n : ml) {
            System.out.println(n);
        }
        System.out.println();
    }

}
