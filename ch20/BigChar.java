package ch20;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class BigChar {
    private char charname;
    private String fontdata;
    // ANSI RESET 코드 상수 추가
    private static final String RESET = "\u001B[0m";

    public BigChar(char charname) {
        this.charname = charname;
        try {
            String filename = "big" + charname + ".txt";
            StringBuilder sb = new StringBuilder();
            for (String line: Files.readAllLines(Path.of(filename))) {
                sb.append(line);
                sb.append("\n");
            }
            this.fontdata = sb.toString();
        } catch (IOException e) {
            this.fontdata = charname + "?";
        }
    }

    public void print() {
        System.out.print(fontdata);
    }

    // [과제 요구사항] 색상 코드를 외재 상태로 받아 출력
    public void print(String colorCode) {
        System.out.print(colorCode + fontdata + RESET);
    }
}