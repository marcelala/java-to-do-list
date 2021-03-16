package main.java.BeeOrderly;


public class BeeOrderlyApp {
    // A string to hold the data file name which contains all tasks and their details
    //public static String filename = "tasks.txt";

    public BeeOrderlyApp(){
    }

    //main method of the app
    public static void main(String[] args) {

        //A string to hold the choice that will be entered by the user
        BeeOrderlyApp toDoListApp = new BeeOrderlyApp();


        String menuChoice = "-10";
        UserInput userInput= new UserInput();
        FileManager fileManager = new FileManager();
        try {

            ToDoList taskList = fileManager.loadFromFile();

            Menus.showMessage("Let's get you in order!\n");
            while (!menuChoice.equals("4")) {
                Menus.mainMenu();

                menuChoice = UserInput.nextLine();

                switch (menuChoice) {
                    case "1":
                        Menus.displayTasksMenu();
                        new TaskSorter(taskList).listAllTasks(UserInput.nextLine());
                        break;
                    case "2":
                        taskList.createTask();
                        fileManager.saveToFile(taskList);
                        break;
                    case "3":
                        new TaskEditor(taskList).displayTasksWithIndex();
                        Menus.editTaskSelection();
                        new TaskEditor(taskList).editTask(UserInput.nextLine());
                        break;
                    case "4":
                        fileManager.saveToFile(taskList);
                        break;

                    default:
                        Menus.unknownMessage();

                }

            }
            //taskList.saveToFile(tasks.txt);
            Menus.byeMessage();

        }catch (Exception e) {
            Menus.showMessage("UNCAUGHT EXCEPTION THROWN");
            System.out.println("Bzzzzzz... There was a problem while trying to write the unsaved data of all tasks in data file");
            System.out.println(e);
        }
    }
}
