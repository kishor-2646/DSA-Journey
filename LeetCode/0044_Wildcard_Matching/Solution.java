class Solution {
   public boolean isMatch(String s, String p) {
    return solve(s, p, 0, 0);
}

private boolean solve(String s, String p, int i, int j) {

    // Both finished
    if (i == s.length() && j == p.length()) {
        return true;
    }

    // Pattern finished but string remains
    if (j == p.length()) {
        return false;
    }

    // String finished
    if (i == s.length()) {

        // Remaining pattern must contain only *
        while (j < p.length()) {
            if (p.charAt(j) != '*') {
                return false;
            }
            j++;
        }

        return true;
    }

    char sc = s.charAt(i);
    char pc = p.charAt(j);

    // Normal match or ?
    if (pc == '?' || sc == pc) {
        return solve(s, p, i + 1, j + 1);
    }

    // *
    if (pc == '*') {

        return solve(s, p, i, j + 1) ||
               solve(s, p, i + 1, j);
    }

    return false;
}
}