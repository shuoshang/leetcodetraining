package com.changework;

public class PowerOfFour {
    public boolean isPowerOfFour(int n) {

        while ( (n != 0)  && (n % 4 == 0)) {
            n /= 4;
        }
        if(n ==1){
            return true;
        }else{
            return false;
        }
}


    public static void main(String[] args) {

        // write your code here
        PowerOfFour powerOfFour =  new PowerOfFour();
        boolean poweroffour = powerOfFour.isPowerOfFour(16);
        System.out.println(poweroffour);
    }
}
