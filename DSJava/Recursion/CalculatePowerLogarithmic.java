public class CalculatePowerLogarithmic {
    
    public static void main(String[] args) {

        int num = 91;
        int pow = 5;
        System.out.println("Power : " + calcPower(num, pow));

    }

    public static int calcPower(int num, int pow) {

        if (pow == 0) {
            return 1;
        }

        int xpnb = calcPower(num, pow / 2);
        int xn = xpnb * xpnb;

        if(pow % 2 == 1 ) {
            xn *= num;
        }
        return xn;
    }

}
