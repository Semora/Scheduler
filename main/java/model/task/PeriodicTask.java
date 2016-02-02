package model.task;

import constants.TaskFieldNames;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public void setValueByName(String name, String value) {
        switch (name) {
            case TaskFieldNames.NAME:
                this.setName(value);
                break;
            case TaskFieldNames.EXECUTION_TIME:
                this.setExecutionTime(Integer.parseInt(value));
                break;
            case TaskFieldNames.PERIOD:
                this.period = Integer.parseInt(value);
                break;
        }
    }

    @Override
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
                case TaskFieldNames.PERIOD:
                    values.add(String.valueOf(this.getPeriod()));
                    break;
            }
        }
        return values;
    }

    public String toString() {
        String out = "";
        out += getColor() + "\t\t" + getName() + "\t\t" + getPeriod() + "\t\t" + getExecutionTime() + "\t\t" + getUtilizationFactor();
        return out;
    }
}
