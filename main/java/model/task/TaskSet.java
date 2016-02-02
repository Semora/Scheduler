package model.task;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Razi on 1/31/2016.
 */
public class TaskSet <TaskType extends Task> implements Serializable {
    private String folderPath;
    private String name;
    private List<TaskType> tasks;

    public TaskSet(String path) {
        this.folderPath = path;
        this.tasks = new ArrayList<>();
    }

    public void save(String name) {
        this.name = name;
        try {
            FileOutputStream fileOut = new FileOutputStream(this.folderPath + name);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(this);
            out.close();
            fileOut.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public static <TaskType extends Task> TaskSet load(String filePath) {
        TaskSet<TaskType> taskSet = null;
        try {
            FileInputStream fileIn = new FileInputStream(filePath);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            taskSet = (TaskSet<TaskType>) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Employee class not found");
            c.printStackTrace();
        }
        return taskSet;
    }

    public void addTask(TaskType task) {
        this.tasks.add(task);
    }

    public void removeTask(TaskType task){
        this.tasks.remove(task);
    }

    public void removeTask(int index) {
        this.tasks.remove(index);
    }

    /**
     *
     * @return Array of TaskType, it return null if there was no task
     */
    public List<TaskType> getTasks() {
        return tasks;
    }

    public String toString() {
        if (tasks.size() == 0) {
            return "This task set in empty.";
        }

        TaskType typeVar = tasks.get(0);
        String out = typeVar.getHeader() + '\n';

        for(TaskType t: tasks) {
            out += t.toString() + '\n';
        }
        return out;
    }
}
