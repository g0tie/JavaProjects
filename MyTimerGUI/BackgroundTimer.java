import java.util.Timer;
import java.util.TimerTask;

public class BackgroundTimer {
    private TimerGUI timerGUI;
    private Integer minutes;
    private Integer seconds;
    private String minutesStr;
    private String secondsStr;

    private Timer timer = new Timer();
    private TimerTask task = new TimerTask() {
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
        
       timerGUI.setMinutes(minutesStr);
       timerGUI.setSeconds(secondsStr);
      		
        if (minutes == 0 && seconds == 0) {
          stop();
        }
      }
    };

    public BackgroundTimer(TimerGUI timerUI) {
        timerGUI = timerUI;
    }

    public void start(String minutesArg, String secondsArg) {
        int minutesInt = Integer.parseInt(minutesArg);
        int secondsInt = Integer.parseInt(secondsArg);
        
        if (secondsInt == 0 && minutesInt != 0) {
            minutes = minutesInt - 1;
            seconds = 60;
        } else {
            minutes = minutesInt;
            seconds = secondsInt;
        }
      
      if (secondsInt == 0 && minutesInt == 0) {
        stop();
      } 
      
        timer.scheduleAtFixedRate(task, 1000, 1000);
    }

    public void stop() {
        timer.cancel();
    }

}