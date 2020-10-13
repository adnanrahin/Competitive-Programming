package UvaOnlineJudge.BigMod_374;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int b = scanner.nextInt();
            int p = scanner.nextInt();
            int m = scanner.nextInt();
            solution(b, p, m);
        }
    }

    public static void solution(int b, int p, int m) {

        int res = 1;

        while (p > 0) {
            if (p % 2 == 1) res = ((res % m) * (b % m)) % m;
            b = (b % m) * (b % m);
            p /= 2;
        }
        System.out.println(res);
    }
}
