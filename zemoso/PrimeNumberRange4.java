public class PrimeNumberRange4{

    public static void primeRange(int low, int high){

        for(int i = low; i < high + 1; i++){

            if(isPrime(i)){
                System.out.print(i + " ");
            }

        }
    }
    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        primeRange(10, 50);
    }
}