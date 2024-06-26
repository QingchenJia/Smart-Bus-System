package SmartBusSystem.pojo;

public class Admin {
    private String ID;
    private String passwd;

    public Admin(String ID, String passwd) {
        this.ID = ID;
        this.passwd = passwd;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    @Override
    public String toString() {
        return "Admin{" + "ID='" + ID + '\'' + ", passwd='" + passwd + '\'' + '}';
    }
}
