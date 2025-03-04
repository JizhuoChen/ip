package duke;

public class Task {
    protected String description;
    protected boolean isDone;
    protected String notes = "";

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public Task(String description, Boolean isDone, String notes) {
        this.description = description;
        this.isDone = isDone;
        this.notes = notes;
    }

    public String getStatusIcon() {
        return (isDone ? "X" : " "); // mark done task with X
    }

    public void setDone() {
        isDone = true;
    }

    public void setNotDone() {
        isDone = false;
    }

    public String getTaskType() {
        return "[ ]";
    }

    public String toString() {
        return getTaskType() + "[" + getStatusIcon() + "] " + description;
    }

    public String getSavingFormat() {
        return getTaskType() + " [" + getStatusIcon() + "] " + description + getNotes();
    }

    // Extension
    public void editNotes(String newNotes) {
        this.notes = newNotes;
    }

    public String getNotes() {
        return this.notes;
    }
}
