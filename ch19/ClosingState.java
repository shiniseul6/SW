package hw.ch19;


public class ClosingState implements State {
    private static ClosingState singleton = new ClosingState();

    private ClosingState() {}

    public static State getInstance() {
        return singleton;
    }

    @Override
    public void doClock(Context context, int hour) {
        if (hour < 17) {
            context.changeState(DayState.getInstance());
        } else if (hour >= 20) {
            context.changeState(NightState.getInstance());
        }
    }

    @Override
    public void doUse(Context context) {
        context.callSecurityCenter("call! 마감 금고 점검");
    }

    @Override
    public void doAlarm(Context context) {
        context.callSecurityCenter("call! 비상벨(마감)");
        context.changeState(UrgentState.getInstance());
    }

    @Override
    public void doPhone(Context context) {
        context.recordLog("record ... 퇴근 확인 통화(마감)");
    }

    @Override
    public String toString() {
        return "[마감]";
    }
}