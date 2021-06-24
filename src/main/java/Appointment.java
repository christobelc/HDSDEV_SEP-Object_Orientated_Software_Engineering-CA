
public class Appointment {

    // ------data variables -----
    private int patientID;
    private String reason;

    // ----------constructors--------

    // constructor
    public Appointment(int patientID, String reason) {
        this.patientID = patientID;
        this.reason = reason;
    }

    public int getPatientID() {
        return patientID;
    }

    public String getReason() {
        return reason;
    }

}