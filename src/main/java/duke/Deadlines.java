package duke;

/**
 * Represents a deadline task with a specified due date.
 */
public class Deadlines extends Task {
    /** The raw date string representing the deadline. */
    protected String date;

    /** The parsed DateTime object representation of the deadline date. */
    protected DateTime dt;

    /**
     * Initializes a Deadlines task with the given description and due date.
     *
     * @param description The description of the deadline task.
     * @param date The due date of the deadline task.
     */
    public Deadlines(String description, String date) {
        super(description);

        assert description != null && !description.trim().isEmpty() : "Description should not be null or empty";
        assert date != null && !date.trim().isEmpty() : "Date should not be null or empty";

        this.date = date;
        this.dt = new DateTime(date);
    }

    /**
     * Returns the formatted string used for saving this deadline task to storage.
     *
     * @return The formatted string representation for saving.
     */
    @Override
    public String getSavingFormat() {
        // Assert that all necessary data members are not null before formatting.
        assert date != null && !date.trim().isEmpty() : "Date should not be null or empty when saving";

        return "[D] | [" + getStatusIcon() + "] | "
                + description + " | " + date;
    }

    /**
     * Returns the string representation of this deadline task.
     *
     * @return The formatted string representation.
     */
    @Override
    public String toString() {
        return "[D][" + getStatusIcon()
                + "] " + description + " (by: " + dt + ")";
    }
}
