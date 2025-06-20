package Tasks;

public class Tasks {
    private int taskId;
    private String taskName;
    private String status;

    public Tasks(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
    }

    public int getTaskId() {
        return taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return String.format("| %-8d | %-20s | %-10s |", taskId, taskName, status);
    }
}
