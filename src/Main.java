import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static Map<Integer, String> map = new LinkedHashMap<>();
    static final String[] onesTeens = {"One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
    static final String[] tens = {"Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
    static final String[] denominations = {"Hundred","Thousand","Million","Billion"};
    public static void main(String[] args) {
        System.out.println(stringTransformation("1"));
    }

    public static String stringTransformation(String s){
        if(s.length()>9)return "OneBillionDollars";
        int number = Integer.parseInt(s,10);
        int ind;
        StringBuilder sb = new StringBuilder();
        fillMap();
        if(number>999999){
            ind = (number-(number%1000000))/1000000;
            sb.append(build(String.format("%03d",ind),denominations[2]));
            System.out.println(String.format("%03d",ind));
        }
        if(number>999){
            ind = ((number%1000000)-(number%1000))/1000;
            sb.append(build(String.format("%03d",ind),denominations[1]));
            System.out.println(String.format("%03d",ind));

        }
        if(number>0){
            ind = number%1000;
            sb.append(build(String.format("%03d",ind),""));
            System.out.println(String.format("%03d",ind));
        }
        sb.append("Dollars");
        return sb.toString();
    }

    static String build(String num,String dem){
        StringBuilder sb = new StringBuilder();
        int h, t, o;
        h = Integer.parseInt(num.substring(0,1));
        t = Integer.parseInt(num.substring(1,2));
        o = Integer.parseInt(num.substring(2,3));
        if(h!=0)sb.append(map.get(h)).append(denominations[0]);
        if(t!=0&&t!=1){
            sb.append(map.get(t*10));
        }else{
            sb.append(map.get(Integer.parseInt(num.substring(1,3)))).append(dem);
            return sb.toString();
        }
        if(o!=0)sb.append(map.get(o));
        sb.append(dem);
        return sb.toString();
    }

    private static void fillMap() {
        for(int i = 1;i < 100;){
            if(i<20){
                map.put(i,onesTeens[i-1]);
                i++;
            }else{
                map.put(i,tens[(i/10)-2]);
                i+=10;
            }
        }
    }
}
