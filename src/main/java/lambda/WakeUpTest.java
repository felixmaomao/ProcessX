package lambda;/**
 * Created by shenwei on 2017/2/24.
 */

/**
 * @author shenwei
 * @create 2017-02-24
 */
public class WakeUpTest {
    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        hotel.bellRang(() -> {
            System.out.println("so easy");
        });
    }

}

class Hotel {
    public void bellRang(WakeUp wakeUp) {
        wakeUp.wake();
    }
}
