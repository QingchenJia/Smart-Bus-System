package SmartBusSystem.pojo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
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
