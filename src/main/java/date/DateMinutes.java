package date;/**
 * Created by shenwei on 2017/6/21.
 */

import java.util.Calendar;
import java.util.Date;

/**
 * @author shenwei
 * @create 2017-06-21
 */
public class DateMinutes {
    public static void main(String[] args) {
        int minute= DateUtil.getDiffMinite(new Date(),tomorrow(new Date()));
        System.out.println(minute);
    }
    /**
     * 返回昨天
     * @param today
     * @return
     */
    public static Date yesterday(Date today) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
        calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) - 1);
        return calendar.getTime();
    }

    /**
     * 返回明天
     * @param today
     * @return
     */
    public static Date tomorrow(Date today) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
        calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) + 1);
        return calendar.getTime();
    }
}
