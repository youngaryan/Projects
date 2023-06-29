import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {

        //defining a bound
        int min = 123;
        int max = 1000000000;

        System.out.println(randomGen(max, min));

    }

    public static int randomGen(int max, int min){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ss");
        LocalDateTime now = LocalDateTime.now();
        int nowInt = Integer.parseInt((dtf.format(now)));
        int result = min - max;
        if (nowInt%2 == 0 ){
            result = (int) (Math.sin(nowInt)*max);
        }
        result =  (int) (Math.cos(nowInt)*max);

        while (result<min)result+=10;
        while (result>max)result-=10;

        return result;

    }
}
