public class replacePi 
{
    public static String replace(String str)
    {
        if(str.length() <= 1)
        {
            return str;
        }
        /*
        if(str.substring(0, 2).equals("pi"))
        {
            String subStr = replace(str.substring(2));
            return "3.14" + subStr;
        }
        */
        if(str.charAt(0) == 'p' && str.charAt(1) == 'i')
        {
            String subStr = replace(str.substring(2));
            return "3.14" + subStr;
        }
        else
        {
            String subStr = replace(str.substring(1));
            return str.charAt(0) + subStr;
        }
    }

    public static void main(String[] args) 
    {
        System.out.println(replace("piabpipcdpi"));
    }
    
}
