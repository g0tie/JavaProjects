import java.util.Timer;
import java.util.TimerTask;
import java.util.Scanner;

public class MyTimer {
    
    private Integer minutes;
    private Integer seconds;
    private String minutesStr;
    private String secondsStr;
    Timer timer = new Timer();
    TimerTask task = new TimerTask() {
      public void run() {
        
        if (seconds == 0 && minutes != 0) {
              seconds = 60;
              minutes -= 1;
        }
        
        
        seconds--;
        
        if (minutes < 10) { 
        		minutesStr = "0" + minutes.toString();
        } else {
        		minutesStr = minutes.toString();
        }
        
        if (seconds < 10) {
        		secondsStr = "0" + seconds.toString();
        } else {
        		secondsStr = seconds.toString();
        }
        
        System.out.println("Timer: " + minutesStr + " : " + secondsStr);
      		
        if (minutes == 0 && seconds == 0) {
          System.out.println("Time's up");
          timer.cancel();
        }
      }
      
    };
    
    public void startTimer() {
      timer.scheduleAtFixedRate(task, 1000, 1000);
    }
    
    public MyTimer(int minutesArg, int secondsArg) {
      if (secondsArg == 0 && minutesArg != 0) {
        minutes = minutesArg - 1;
        seconds = 60;
      } else {
      	minutes = minutesArg;
      	seconds = secondsArg;
      }
      
      if (secondsArg == 0 && minutesArg == 0) {
        System.out.println("Error: Invalid arguments, timer cannot start at 0");
        System.exit(0);
      } 
      
    }
    
    public static void main(String[] args) {
    
      try {
      		Scanner input = new Scanner(System.in);
      		
      		System.out.print("Enter minutes:");
      		int minArg = input.nextInt();
      		
      		System.out.print("Enter seconds:");
      		int secArg = input.nextInt();
      		
        MyTimer myTimer = new MyTimer(minArg, secArg);
        myTimer.startTimer();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
}