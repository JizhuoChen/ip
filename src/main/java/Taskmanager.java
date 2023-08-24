import java.util.Scanner;

public class Taskmanager {
    int counter = 0;
    private Task[] tasks = new Task[100];

    public void manageTasks() {
        Scanner sn = new Scanner(System.in);
        String input = sn.nextLine();
        String[] splt = input.split(" ");
        String keyword = splt[0];
        while (!keyword.equals("bye")) {
            if (keyword.equals("list")) {
                list();
            } else if (keyword.equals("mark")) {
                mark(Integer.parseInt(splt[1]));
            } else if (keyword.equals("unmark")) {
                unmark(Integer.parseInt(splt[1]));
            } else {
                try {
                    if (keyword.equals("todo")) {
                        String description = "";
                        for (int i = 1; i < splt.length; ++i) {
                            description = description + splt[i] + " ";
                        }
                        if (description.isEmpty()) {
                            throw new IllegalArgumentException("☹ OOPS!!! The description of a todo cannot be empty.");
                        }
                        addTask(new ToDos(description));
                    } else if (keyword.equals("deadline")) {
                        int i = 1;
                        if (i == splt.length) {
                            throw new IllegalArgumentException("☹ OOPS!!! The description of a deadline cannot be empty.");
                        }
                        String temp = splt[i];
                        String description = "";
                        while (!temp.equals("/by")) {
                            description = description + temp + " ";
                            i += 1;
                            temp = splt[i];
                        }
                        i += 1;
                        if (description.isEmpty()) {
                            throw new IllegalArgumentException("☹ OOPS!!! The description of a deadline cannot be empty.");
                        }
                        String time = "";
                        while (i < splt.length) {
                            time = time + splt[i] + " ";
                            i += 1;
                        }
                        if (time.isEmpty()) {
                            throw new IllegalArgumentException("☹ OOPS!!! The time/date of a deadline cannot be empty.");
                        }
                        addTask(new Deadlines(description, time));
                    } else if (keyword.equals("event")) {
                        int i = 1;
                        if (i == splt.length) {
                            throw new IllegalArgumentException("☹ OOPS!!! The description of an event cannot be empty.");
                        }
                        String temp = splt[i];
                        String description = "";
                        while (!temp.equals("/from")) {
                            description = description + temp + " ";
                            i += 1;
                            temp = splt[i];
                        }
                        i += 1;
                        if (description.isEmpty()) {
                            throw new IllegalArgumentException("☹ OOPS!!! The description of an event cannot be empty.");
                        }
                        String start = "";
                        if (i == splt.length) {
                            throw new IllegalArgumentException("☹ OOPS!!! The starting time of an event cannot be empty.");
                        }
                        temp = splt[i];
                        while (!temp.equals("/to")) {
                            start = start + temp + " ";
                            i += 1;
                            temp = splt[i];
                        }
                        i += 1;
                        if (start.isEmpty()) {
                            throw new IllegalArgumentException("☹ OOPS!!! The starting time of an event cannot be empty.");
                        }

                        String end = "";
                        while (i < splt.length) {
                            end = end + splt[i] + " ";
                            i += 1;
                        }
                        if (end.isEmpty()) {
                            throw new IllegalArgumentException("☹ OOPS!!! The ending time of an event cannot be empty.");
                        }
                        addTask(new Events(description, start, end));
                    } else {
                        throw new IllegalArgumentException("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
            input = sn.nextLine();
            splt = input.split(" ");
            keyword = splt[0];
        }
    }

    public void mark(int i) { //need handling
        tasks[i-1].setDone();
        System.out.println("Nice! I've marked this task as done:\n  " + tasks[i-1].toString());
    }

    public void unmark(int i) { //need handling
        tasks[i-1].setNotDone();
        System.out.println("OK, I've marked this task as not done yet:\n  " + tasks[i-1].toString());
    }

    public void list() {
        if (counter == 0) {
            System.out.println("There is no task in your list yet.");
        } else {
            System.out.println("Here are the tasks in your list:");
            for (int i = 1; i <= counter; i++) {
                System.out.println(i + "." + tasks[i - 1].toString());
            }
        }
    }

    public void addTask(Task t) {
        tasks[counter] = t;
        counter += 1;
        System.out.println("Got it. I've added this task:\n  " + t + "\nNow you have " + counter + " tasks in the list.");
    }
}
