public class BigMath {
    public static String factorial(int n) {
        return factorial(n,1000000);
    }

    private static String factorial(int n, int maxSize) {
        int res[] = new int[maxSize];
        res[0] = 1; // Initialize result
        int res_size = 1;

        // Apply simple factorial formula n! = 1 * 2 * 3 * 4... * n
        for (int x = 2; x <= n; x++) {
            res_size = multiply(x, res, res_size);
        }

        StringBuffer buff = new StringBuffer();
        for (int i = res_size - 1; i >= 0; i--) {
            buff.append(res[i]);
        }

        return buff.toString();
    }

    /**
     * This function multiplies x with the number represented by res[]. res_size
     * is size of res[] or number of digits in the number represented by res[].
     * This function uses simple school mathematics for multiplication.
     * 
     * This function may value of res_size and returns the new value of res_size.
     */
    private static int multiply(int x, int res[], int res_size) {
        int carry = 0; // Initialize carry.

        // One by one multiply n with individual digits of res[].
        for (int i = 0; i < res_size; i++) {
            int prod = res[i] * x + carry;
            res[i] = prod % 10; // Store last digit of 'prod' in res[]
            carry = prod / 10;  // Put rest in carry
        }

        // Put carry in res and increase result size.
        while (carry != 0) {
            res[res_size] = carry % 10;
            carry = carry / 10;
            res_size++;
        }

        return res_size;
    }

    /** Driver method. */
    public static void main(String[] args) {
        int n = 5000;
        String str=factorial(n);
        System.out.printf("Factorial %d = %s%n", n, str);
        System.out.println(str.length());
    }
}