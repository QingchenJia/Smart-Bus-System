package SmartBusSystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Route {
    private String ID;
    private String name;
    private int status;
    private Time startTime;
    private Time endTime;
    private double price;
}
