package SmartBusSystem.pojo;

public class Schedule {
    private String DID;
    private String Time;
    private String licenseNumber;

    public Schedule() {
    }

    public Schedule(String DID, String time, String licenseNumber) {
        this.DID = DID;
        Time = time;
        this.licenseNumber = licenseNumber;
    }

    public String getDID() {
        return DID;
    }

    public void setDID(String DID) {
        this.DID = DID;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "DID='" + DID + '\'' +
                ", Time='" + Time + '\'' +
                ", licenseNumber='" + licenseNumber + '\'' +
                '}';
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }
}
