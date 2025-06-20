package Tasks;

public class TaskNode {
    Tasks task;
    TaskNode next;

    public TaskNode(Tasks task) {
        this.task = task;
        this.next = null;
    }
}
