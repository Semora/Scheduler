package model.task;

import java.io.Serializable;

/**
 * Created by Razi on 1/31/2016.
 */
public class AperiodicTask extends Task implements Serializable{
    private int arrivalTime;
    private int deadline;

    public AperiodicTask() {

    }

    /**
     * @param color int color
     * @param name String name
     * @param arrivalTime int arrivalTime
     * @param exec int execution time
     * @param deadline int deadline
     */
    public AperiodicTask(int color, String name, int arrivalTime, int exec, int deadline) {
        this.setColor(color);
        this.setName(name);
        this.setArrivalTime(arrivalTime);
        this.setExecutionTime(exec);
        this.setDeadline(deadline);
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public void setDeadline(int deadLine) {
        this.deadline = deadLine;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public int getDeadline() {
        return deadline;
    }

    public String getHeader() {
        return "color\tname\tarrival\texec\tdeadline";
    }

    public String toString() {
        String out = "";
        out += getColor() + "\t\t" + getName() + "\t\t" + getArrivalTime() + "\t\t" + getExecutionTime() + "\t\t" + getDeadline();
        return out;
    }
}
