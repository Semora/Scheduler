package model.task;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Razi on 1/31/2016.
 */
abstract public class Task implements Serializable{
    private String name;
    private int color;
    private int executionTime;

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public void setExecutionTime(int executionTime) {
        this.executionTime = executionTime;
    }

    public String getName() {
        return name;
    }

    public abstract String getHeader();

    public int getColor() {
        return color;
    }

    public int getExecutionTime() {
        return executionTime;
    }

    abstract public void setValueByName(String name, String value);
    abstract public List<String> getValuesByName(List<String>names);
}
