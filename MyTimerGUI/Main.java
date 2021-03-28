public class Main {
    public static void main(String[] args) {
        TimerGUI timer = new TimerGUI();
        BackgroundTimer bgTimer = new BackgroundTimer(timer);
        timer.attachTimer(bgTimer);
    }
}