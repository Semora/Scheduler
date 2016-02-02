package model.task;

import constants.TaskFieldNames;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public void setValueByName(String name, String value) {
        switch (name) {
            case TaskFieldNames.NAME:
                this.setName(value);
                break;
            case TaskFieldNames.EXECUTION_TIME:
                this.setExecutionTime(Integer.parseInt(value));
                break;
            case TaskFieldNames.ARRIVAL_TIME:
                this.arrivalTime = Integer.parseInt(value);
                break;
            case TaskFieldNames.DEADLINE:
                this.deadline = Integer.parseInt(value);
                break;
        }
    }

    public List<String> getValuesByName(List<String> names) {
        List<String> values = new ArrayList<>();
        for (String name: names) {
            switch (name) {
                case TaskFieldNames.NAME:
                    values.add(this.getName());
                    break;
                case TaskFieldNames.EXECUTION_TIME:
                    values.add(String.valueOf(this.getExecutionTime()));
                    break;
                case TaskFieldNames.ARRIVAL_TIME:
                    values.add(String.valueOf(this.getArrivalTime()));
                    break;
                case TaskFieldNames.DEADLINE:
                    values.add(String.valueOf(this.getDeadline()));
                    break;
            }
        }
        return values;
    }
}
