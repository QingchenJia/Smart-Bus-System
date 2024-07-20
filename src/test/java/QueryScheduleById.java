import SmartBusSystem.pojo.Schedule;
import SmartBusSystem.service.function.AdminEditSchedule;

public class QueryScheduleById {
    public static void main(String[] args) {
        Schedule schedule = new Schedule();
        schedule.setTime("星期1");
        schedule.setDID("D10006");
        schedule.setLicenseNumber("鄂E·40006");
/*        Schedule scheduleResult = AdminEditSchedule.queryScheduleById(schedule);
        System.out.println(scheduleResult);*/
        AdminEditSchedule.addNewSchedule(schedule);
    }
}
