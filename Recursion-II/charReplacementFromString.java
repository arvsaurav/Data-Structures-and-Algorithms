public class charReplacementFromString 
{
    public static String replaceChar(String str, char original, char replacement)
    {
        if(str.length() == 0)
            return str;
        String subStr = replaceChar(str.substring(1), original, replacement);
        if(str.charAt(0) == original)
        {
            return replacement + subStr;
        }
        else
        {
            return str.charAt(0) + subStr;
        }

    }
    public static void main(String[] args) 
    {
        System.out.println(replaceChar("axbxcxdx", 'x', 'y'));
    }
    
}
