package SmartBusSystem.pojo;

public class Admin {
    private String ID;
    private String password;

    public Admin() {
    }

    public Admin(String ID, String password) {
        this.ID = ID;
        this.password = password;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getPassword() {
        return password;
    }

    public void setPasswd(String passwd) {
        this.password = passwd;
    }

    @Override
    public String toString() {
        return "Admin{" + "ID='" + ID + '\'' + ", password='" + password + '\'' + '}';
    }
}
