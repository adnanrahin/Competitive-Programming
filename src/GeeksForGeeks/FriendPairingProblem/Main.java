package GeeksForGeeks.FriendPairingProblem;

public class Main {

    public static void main(String[] args) {
        System.out.println(countFriendsPairings(3));
    }

    public static long countFriendsPairings(int n) {
        if (n <= 2) return n;
        long[] dp = new long[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        long mod = (long) 1e9 + 7;

        for (int i = 2; i <= n; i++) {
            dp[i] = ((dp[i - 1] % mod) + (((i - 1) % mod) * (dp[i - 2] % mod))) % mod;
        }

        return dp[n];
    }

}
