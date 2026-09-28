class Solution {
    public int maxEnvelopes(int[][] envelopes) {

        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0])
                return b[1] - a[1];

            return a[0] - b[0];
        });
        int[] dp = new int[envelopes.length];
        int size = 0;
        for (int[] e : envelopes) {
            int height = e[1];
            int low = 0;
            int high = size;

            while (low < high) {
                int mid = low + (high - low) / 2;
                if (dp[mid] < height)
                    low = mid + 1;
                else
                    high = mid;
            }
            dp[low] = height;

            if (low == size)
                size++;
        }
        return size;
    }
}