public class LicenseNumberCheck {
    public static void main(String[] args) {
        String regex = "[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵青藏川宁琼]([A-Z]·[A-HJ-NP-Z0-9]{4}[A-HJ-NP-Z0-9挂学警港澳使领]|[DF]·[A-HJ-NP-Z0-9]{5})";
        System.out.println("鄂E·10001".matches(regex));
    }
}
