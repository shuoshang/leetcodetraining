package com.changework;

public class CountPrimes {
    public int countPrimes(int n) {

        int count = 0;
        for(int j=2;j<n;j++){
            if(isPrimes(j)){
                count++;
            }
        }
        return count;
    }

    public boolean isPrimes(int k){
        for(int i=2;i * i<k;i++){
            if(k%i==0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        // write your code here
        CountPrimes countPrimes =  new CountPrimes();
        int  number = countPrimes.countPrimes(19);
        System.out.println(number);
    }
}
