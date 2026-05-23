package CA_2;

import java.util.Scanner;

/**
 * Bank Employee Management System — program entry point.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ApplicationController controller = new ApplicationController(scanner);

        try {
            controller.printWelcome();
            runMenuLoop(controller, scanner);
            System.out.println("Thank you. Goodbye.");
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    private static void runMenuLoop(ApplicationController controller, Scanner scanner) {
        boolean running = true;

        while (running) {
            controller.printSystemStatus();
            System.out.println();
            MenuOption.printAllOptions();
            System.out.print("Enter your choice (" + MenuOption.getMinCode()
                    + "-" + MenuOption.getMaxCode() + "): ");

            int choice = InputValidator.readMenuChoice(scanner);
            MenuOption selected = MenuOption.fromCode(choice);

            if (selected == null) {
                System.out.println("Invalid option. Please try again.");
                continue;
            }

            running = controller.processMenuChoice(selected);
        }
    }
}
