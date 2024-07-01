package SmartBusSystem.pojo;

public class Schedule {
    private String RID;
    private String DID;
    private String licenseNumber;
    private String time;

    public Schedule() {
    }

    public String getRID() {
        return RID;
    }

    public void setRID(String RID) {
        this.RID = RID;
    }

    public String getDID() {
        return DID;
    }

    public void setDID(String DID) {
        this.DID = DID;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Schedule{" + "RID='" + RID + '\'' + ", DID='" + DID + '\'' + ", licenseNumber='" + licenseNumber + '\'' + ", time='" + time + '\'' + '}';
    }
}
