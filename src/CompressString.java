public class CompressString {
    public String compressString(String S) {
        if (S.length() == 0) return "";
        StringBuilder sb = new StringBuilder();
        char[] chars = S.toCharArray();
        int index = 0;
        int count = 0;
        for (int i = 0; i < chars.length - 1; i++) {
            count++;
            if (chars[i] != chars[i + 1]) {
                sb.append(chars[i]).append(count);
                count = 0;
                index = i + 1;
            }
        }
        sb.append(chars[index]).append(chars.length - index);
        String result = sb.toString();
        return result.length() < S.length() ? result : S;


    }
}
