package SmartBusSystem.pojo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Admin {
    private String ID;
    private String password;

    public Admin() {
    }

    public Admin(String ID, String password) {
        this.ID = ID;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Admin{" + "ID='" + ID + '\'' + ", password='" + password + '\'' + '}';
    }
}
