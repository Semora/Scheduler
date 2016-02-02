package model.result;

import java.util.ArrayList;
import java.util.List;

import scheduler.Process;

/**
 * Created by Razi on 2/1/2016.
 */
public class TimeLine {
    List<Process> executionList;
    List<Process> arrivalList;
    List<Process> deadlineList;
    //List<> chargeLineList;
    List<List<Message>> messageList;

    public TimeLine() {
        this.executionList = new ArrayList<>();
        this.arrivalList = new ArrayList<>();
        this.deadlineList = new ArrayList<>();
        this. messageList = new ArrayList<>();
    }

    public List<Process> getExecutionList() {
        return executionList;
    }

    public List<Process> getArrivalList() {
        return arrivalList;
    }

    public List<Process> getDeadlineList() {
        return deadlineList;
    }

    public List<List<Message>> getMessageList() {
        return messageList;
    }
}
