private static int naive(String text, String pattern, int n, int m) {
        for(int idx = 0; idx < n - m; idx++) {
            int j = 0;

            while(j < m && pattern.charAt(j) == text.charAt(idx + j)) {
                j += 1;
            }

            if(j == m) {
                return idx;
            }
        }

        return -1;
}
