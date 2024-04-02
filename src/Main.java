import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        try {

            Scanner input = new Scanner(System.in);
            ArrayList<Task> myTasks = new ArrayList<>();
            String menuNum = "";

            while (!(menuNum.equals("0"))) {
                int taskIndex;

                System.out.println("What would you like to do? (Type the number of the action you wish to take)");
                System.out.println("(1) Add a task");
                System.out.println("(2) Remove a task");
                System.out.println("(3) Update a task");
                System.out.println("(4) View all tasks");
                System.out.println("(5) List tasks by priority");
                System.out.println("(0) Quit program");
                menuNum = input.nextLine();

                switch (menuNum) {
                    case "1":
                        System.out.println("What task would you like to add? (Type a task)");
                        addTask(myTasks);
                        System.out.println(myTasks);
                        break;
                    case "2":
                        System.out.println("What task would you like to remove? (Choose the number of the task)");
                        taskIndex = Integer.parseInt(input.nextLine()) - 1;
                        removeTask(myTasks, taskIndex);
                        System.out.println(myTasks);
                        break;
                    case "3":
                        System.out.println("What task would you like to update? (Choose the number of the task)");
                        taskIndex = Integer.parseInt(input.nextLine()) - 1;
                        System.out.println("What do you want to change the task to? (Type your replacement task)");
                        updateTask(myTasks, taskIndex);
                        System.out.println(myTasks);
                        break;
                    case "4":
                        System.out.println("Here are your tasks:");
                        System.out.println();
                        Collections.sort(myTasks);

                        for (int i = 0; i < myTasks.size(); i++) {
                            System.out.println(myTasks.get(i));
                        }

                        System.out.println();
                        break;
                    case "5":
                        System.out.println("Choose the priority number of the tasks you want to display");
                        int taskPriority = input.nextInt();
                        input.nextLine();

                        Collections.sort(myTasks);

                        for (int i = 0; i < myTasks.size(); i++) {
                            if (myTasks.get(i).getPriority() == taskPriority) {
                                System.out.println(myTasks.get(i));
                            }
                        }
                        break;
                }
            }

            System.out.println();
            System.out.println("Here are your final tasks:");
            System.out.println(myTasks);


        }catch (Exception e) {
            System.out.println("Something went wrong");
        }
    }


    static ArrayList<String> removeTask(ArrayList a, int b){
        try {
            a.remove(b);

        }catch (Exception e){
            System.out.println("Something went wrong");
        }
        return a;
    }

    static ArrayList<String> updateTask(ArrayList a, int b){
        try {
            a.remove(b);

            Scanner input = new Scanner(System.in);
            System.out.println("Name");
            String title = input.nextLine();

            System.out.println("Desc");
            String description = input.nextLine();

            System.out.println("Pri");
            int priority = input.nextInt();
            input.nextLine();

            Task newTask = new Task(title, description, priority);

            a.add(newTask);

        }catch (Exception e) {
            System.out.println("Something went wrong");
        }


        return a;
    }

    static void addTask(ArrayList a){

        try {

            Scanner input = new Scanner(System.in);
            System.out.println("Name");
            String title = input.nextLine();

            System.out.println("Desc");
            String description = input.nextLine();

            System.out.println("Pri");
            int priority = input.nextInt();
            input.nextLine();

            Task newTask = new Task(title, description, priority);

            a.add(newTask);

        }catch (Exception e) {
            System.out.println("Something went wrong");
        }

    }

}