package ch20;
public class BigString {
    private BigChar[] bigchars;

    public BigString(String string) {
        initShared(string);
    }

    public BigString(String string, boolean shared) {
        if (shared) {
            initShared(string);
        } else {
            initUnshared(string);
        }
    }

    private void initShared(String string) {
        BigCharFactory factory = BigCharFactory.getInstance();
        bigchars = new BigChar[string.length()];
        for (int i = 0; i < bigchars.length; i++) {
            bigchars[i] = factory.getBigChar(string.charAt(i));
        }
    }

    private void initUnshared(String string) {
        bigchars = new BigChar[string.length()];
        for (int i = 0; i < bigchars.length; i++) {
            bigchars[i] = new BigChar(string.charAt(i));
        }
    }

    public void print() {
        for (BigChar bc: bigchars) {
            bc.print();
        }
    }

    // [과제 요구사항] 각 문자에 대응하는 색상 배열로 출력
    public void print(String[] colors) {
        for (int i = 0; i < bigchars.length; i++) {
            bigchars[i].print(colors[i]);
        }
    }
}