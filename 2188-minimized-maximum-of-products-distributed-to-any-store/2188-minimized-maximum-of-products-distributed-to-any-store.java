class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int low = 1;
        int high = 0;

        for (int q : quantities) {
            high = Math.max(high, q);
        }

        int ans = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int stores = 0;

            for (int q : quantities) {
                stores += (q + mid - 1) / mid;

                if (stores > n)
                    break;
            }

            if (stores <= n) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }
}