package SmartBusSystem.pojo;

public class Bus {
    private String licenseNumber;
    private int status;

    public Bus() {
    }

    public Bus(String licenseNumber, int status) {
        this.licenseNumber = licenseNumber;
        this.status = status;
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

    @Override
    public String toString() {
        return "Bus{" + "licenseNumber='" + licenseNumber + '\'' + ", status=" + status + '}';
    }
}
