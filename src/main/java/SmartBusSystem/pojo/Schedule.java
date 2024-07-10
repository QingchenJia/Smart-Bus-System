package SmartBusSystem.pojo;

public class Schedule {
    private String licenseNumber;
    private String DID;
    private String time;

    public Schedule() {
    }

    public Schedule(String licenseNumber, String DID, String time) {
        this.licenseNumber = licenseNumber;
        this.DID = DID;
        this.time = time;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getDID() {
        return DID;
    }

    public void setDID(String DID) {
        this.DID = DID;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "licenseNumber='" + licenseNumber + '\'' +
                ", DID='" + DID + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
