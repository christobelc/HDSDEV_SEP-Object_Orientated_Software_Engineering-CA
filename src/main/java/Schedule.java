
public class Schedule {

    // data variables
    private Appointment[] appointment;
    private boolean[] dailyScheduleCheck;
    private String[] times;

    // Constructor
    public Schedule() {

        // Array of the times avilable for appointments
        this.times = new String[] { "9am", "10am", "11am", "12pm", "1pm", "2pm", "3pm", "4pm" };
        // Checking if the time slots are available
        this.dailyScheduleCheck = new boolean[] { true, true, true, true, true, true, true, true };
        // There are 8 appointments in the daily schedule.
        this.appointment = new Appointment[8];
    }

    // ---------get the Appointments for the day------
    public Appointment[] getAppointments() {
        return appointment;
    }

    // ---------public methods----------

    // updates a schedule with and appointment
    public boolean updateSchedule(Appointment app, int timeSlot) {

        if (dailyScheduleCheck[timeSlot - 1] == true) {
            // Sets the timeslot in the schedule to false and add slot to database
            dailyScheduleCheck[timeSlot - 1] = false;
            appointment[timeSlot - 1] = app;
            return true;
        }
        return false;
    }

    // prints the schedule
    public void printDailySchedule() {
        String slot;
        for (int i = 0; i < times.length; i++) {
            if (dailyScheduleCheck[i] == true) {
                slot = "Yes";
            } else {
                slot = "No";
            }
            System.out.println((i + 1) + ". " + "Time Slot at " + times[i] + " is Available: " + slot);
            if (dailyScheduleCheck[i] == false) {
                System.out.println("   PatientID: " + appointment[i].getPatientID() + ". The Reason: "
                        + appointment[i].getReason());
            }
            System.out.println();
        }
    }

    // returns true if schedule is not full
    public boolean scheduleNotFull() {
        for (int i = 0; i < dailyScheduleCheck.length; i++) {
            if (dailyScheduleCheck[i]) {
                return true;
            }
        }
        return false;
    }
}
