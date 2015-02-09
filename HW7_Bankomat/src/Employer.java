/**
 * Created by denis on 29.10.14.
 */
public class Employer implements Runnable {
    @Override
    public void run() {

        int contribution = 1000;

        while (!Bankomat.closed) {
            try {
                Bankomat.deposit += contribution;
                System.out.println("Employer пополнил на " + contribution + " , на счету " + Bankomat.deposit);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
