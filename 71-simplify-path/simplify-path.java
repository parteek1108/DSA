class Solution {
    public String simplifyPath(String path) {
        Stack<String> st = new Stack<>();

        String[] arr = path.split("/");

        for (String str : arr) {
            if (str.equals("") || str.equals(".")) {
                continue;
            }

            if (str.equals("..")) {
                if (!st.isEmpty()) {
                    st.pop();
                }
            } else {
                st.push(str);
            }
        }

        StringBuilder res = new StringBuilder();

        for (String str : st) {
            res.append("/").append(str);
        }

        return res.length() == 0 ? "/" : res.toString();
    }
}