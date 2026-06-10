package ch20;

public class Main {
    // [과제 요구사항] ANSI 색상 코드 상수 정의
    static final String RED = "\u001B[31m";
    static final String GREEN = "\u001B[32m";
    static final String YELLOW = "\u001B[33m";
    static final String BLUE = "\u001B[34m";
    static final String MAGENTA = "\u001B[35m";
    static final String CYAN = "\u001B[36m";

    public static void main(String[] args) {
        System.out.println("학번: 20240873 / 이름: 신이슬\n");

        if (args.length == 0) {
            System.out.println("Usage: java Main 1212123");
            return;
        }

        BigString bs = new BigString(args[0]);
        
        // 1(RED) 2(BLUE) 1(GREEN) 2(MAGENTA) 1(CYAN) 2(YELLOW) 3(BLUE)
        String[] colors = {RED, BLUE, GREEN, MAGENTA, CYAN, YELLOW, BLUE};
        
        bs.print(colors);
    }
}