/**
 * Created by denis on 29.10.14.
 */
public class Main {
    public static void main(String[] args) {
        Employer employer = new Employer();
        Thread employer1 = new Thread(employer);
        employer1.start();

        Employee employee = new Employee();
        Thread employee1 = new Thread(employee, "Employee-1");
        employee1.start();
        Employee employee4 = new Employee();
        Thread employee2 = new Thread(employee4, "Employee-2");
        employee2.start();
        Employee employee5 = new Employee();
        Thread employee3 = new Thread(employee5, "Employee-3");
        employee3.start();



        try {
            Thread.sleep(4000);
            Bankomat.closed = true;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
