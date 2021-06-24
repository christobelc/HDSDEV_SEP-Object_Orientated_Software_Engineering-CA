import java.util.Scanner;

public class ScheduleApplicationController {
    public static void main(String[] args) {

        Schedule friSchedule = new Schedule();

        // input initalised to -1
        int input = 1;

        String reason;

        Scanner scanner = new Scanner(System.in);
        Scanner scannerStr = new Scanner(System.in);

        System.out.println("Schedule Controller Tester:");

        while (input != -1) {

            // catching an invalid input from the main options
            try {
                System.out.println(" 1 - Check Shedule: ");
                System.out.println(" 2 - Add Appointment to Schedule: ");
                System.out.println("-1 - To Exit: ");
                input = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("An invalid input has been entered. Please restart and try again.");
                break;
            }

            // checks if the daily shedule is full
            if (friSchedule.scheduleNotFull()) {
                // print the daily schedule
                if (input == 1) {
                    friSchedule.printDailySchedule();
                    // add an appointment
                } else if (input == 2) {

                    // checks if an integer has been inputted for the patient Id
                    try {
                        System.out.println("Enter the Patient ID: ");
                        input = scanner.nextInt();
                    } catch (Exception e) {
                        System.out.println("An invalid input has been entered. Please restart and try again.");
                        break;
                    }

                    // checks if PatientId is a positive number (no negative numbers)
                    if (input > 0) {
                        System.out.println();

                        System.out.println("Enter the reason Patient " + input + " is visiting: ");
                        reason = scannerStr.nextLine();

                        // checks if the reason is not an empty string
                        if (!(reason.equals(""))) {
                            System.out.println();

                            // Create a new Appointment Obj with patientID and reason
                            Appointment testPerson = new Appointment(input, reason);

                            System.out.println("Enter the timeSlot you would like?: ");
                            friSchedule.printDailySchedule();

                            System.out.println("(Available slots: between 1-8): ");
                            input = scanner.nextInt();

                            // checks if the shedule can be added.
                            if (friSchedule.updateSchedule(testPerson, input)) {
                                friSchedule.updateSchedule(testPerson, input);
                                System.out.println("Your Appointment has been sucessfully added!");
                                System.out.println();
                            } else {
                                System.out.println("Sorry, this time slot is unavailable.");
                                System.out.println();
                            }
                        } else {
                            System.out.println("A reason must be added to book an appointment");
                        }

                    } else {
                        System.out.println("Invalid patient Id");
                    }
                }
            } else {
                System.out.println("Sorry, there are no time slots available");
            }
        }
        System.out.println("Exited App");
        scanner.close();
        scannerStr.close();
    }
}
