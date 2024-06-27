package SmartBusSystem.pojo;

public class User {
    private String ID;
    private String password;
    private String name;
    private int aptitude;
    private String phoneNum;

    public User() {
    }

    public User(String ID, String password, String name, int aptitude, String phoneNum) {
        this.ID = ID;
        this.password = password;
        this.name = name;
        this.aptitude = aptitude;
        this.phoneNum = phoneNum;
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

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAptitude() {
        return aptitude;
    }

    public void setAptitude(int aptitude) {
        this.aptitude = aptitude;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    @Override
    public String toString() {
        return "User{" +
                "ID='" + ID + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", aptitude=" + aptitude +
                ", phoneNum='" + phoneNum + '\'' +
                '}';
    }
}
