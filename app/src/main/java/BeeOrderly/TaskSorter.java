package main.java.BeeOrderly;

import java.util.ArrayList;
import java.util.Comparator;


public class TaskSorter {

    private ArrayList<Task> taskList;

    public TaskSorter(ToDoList taskList){
        this.taskList = taskList.asArray();
    }

    /**
     * A method to display the contents of ArrayList
     * @param sortBy a string holding a number, "2" for sorting by project, otherwise it will sorty by date
     */
    public void listAllTasks(String sortBy) {
        Menus.separator('=',75);
        System.out.println(
                "Total Tasks = " + taskList.size()); Menus.separator('=',75);

        if (sortBy.equals("2")) {
            String displayFormat = "%-25s %-35s %-20s %-20s";

            if (taskList.size()>0) {
                System.out.println(String.format(displayFormat,"Project","Name","Deadline","Completed?"));
                System.out.println(String.format(displayFormat,"=======","=====","========","========="));

            } else {
                System.out.println("No tasks to show");
            }

            taskList.stream()
                    .sorted(Comparator.comparing(Task::getProject))
                    .forEach(task -> System.out.println(String.format(displayFormat,task.getProject(),
                            task.getName(),
                            task.getDeadline(),
                            (task.isDone()?"YES":"NO")
                    )));
        } else {
            String displayFormat = "%-25s %-35s %-20s %-20s";

            if (taskList.size() > 0) {
                System.out.println(String.format(displayFormat,"Deadline","Name","Project" , "Completed?"));
                System.out.println(String.format(displayFormat,"========","=====","=======" , "========="));
            } else {
                System.out.println("You gotta add some tasks first! ");
            }

            taskList.stream()
                    .sorted(Comparator.comparing(Task::getDeadline))
                    .forEach(task -> System.out.println(String.format(displayFormat,task.getDeadline(),
                            task.getName(),
                            task.getProject(),
                            (task.isDone() ? "YES" : "NO")
                    )));
        }
    }
}
