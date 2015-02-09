/**
 * Created by denis on 29.10.14.
 */
public class Employee implements Runnable {
    @Override
    public void run() {

        int getContribution = 100;

        while (!Bankomat.closed) {
            if (Bankomat.deposit >= getContribution) {
                try {
                    Bankomat.deposit -= getContribution;
                    System.out.println(Thread.currentThread().getName() + " снял " + getContribution + " , на счету " + Bankomat.deposit);
                    Thread.sleep(250);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    System.out.println("Недостаточно денег" + " , на счету " + Bankomat.deposit);
                    Thread.sleep(250);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
