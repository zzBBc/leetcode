// Runtime: 11 ms
// Memory Usage: 50.1 MB

class Solution {
    public int findJudge(int n, int[][] trust) {
        for (int i = 1; i <= n; i++) {
            if (checkTrust(i, trust, n)) {
                return i;
            }
        }

        return -1;
    }

    private boolean checkTrust(int townJudge, int[][] trust, int n) {
        int countTrust = 0;

        for (int i = 0; i < trust.length; i++) {
            if (trust[i][0] == townJudge) {
                return false;
            } else if (trust[i][1] == townJudge) {
                countTrust++;
            }
        }

        if (countTrust == n - 1) {
            return true;
        }

        return false;
    }
}
