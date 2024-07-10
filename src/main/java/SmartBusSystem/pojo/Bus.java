package SmartBusSystem.pojo;

public class Bus {
    private String licenseNumber;
    private int status;
    private String RID;

    public Bus() {
    }

    public Bus(String licenseNumber, int status, String RID) {
        this.licenseNumber = licenseNumber;
        this.status = status;
        this.RID = RID;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getRID() {
        return RID;
    }

    public void setRID(String RID) {
        this.RID = RID;
    }

    @Override
    public String toString() {
        return "Bus{" + "licenseNumber='" + licenseNumber + '\'' + ", status=" + status + ", RID='" + RID + '\'' + '}';
    }
}
