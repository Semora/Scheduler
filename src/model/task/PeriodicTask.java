package model.task;

import java.io.Serializable;

/**
 * Created by Razi on 1/31/2016.
 */
public class PeriodicTask extends Task implements Serializable{
    private int period;

    public PeriodicTask(){

    }

    /**
     * @param color int color
     * @param name String name
     * @param period int period
     * @param exec int execution time
     */
    public PeriodicTask(int color, String name, int period, int exec) {
        this.setColor(color);
        this.setName(name);
        this.setPeriod(period);
        this.setExecutionTime(exec);
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public int getPeriod() {
        return period;
    }

    public double getUtilizationFactor() {
        return (double)this.getExecutionTime()/this.getPeriod();
    }


    public String getHeader() {
        return "color\tname\tperiod\texec\tutil";
    }

    public String toString() {
        String out = "";
        out += getColor() + "\t\t" + getName() + "\t\t" + getPeriod() + "\t\t" + getExecutionTime() + "\t\t" + getUtilizationFactor();
        return out;
    }
}
