package LeetCode;

public class MagicNumber {

    public boolean checkMagicNumber(int num) {
        return sumNumber(num) == 1;
    }

    public int sumNumber(int num) {
        if (num / 10 == 0) {
            return num;
        }

        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sumNumber(sum);
    }

    public static void main(String[] args) {
        MagicNumber mn = new MagicNumber();
        System.out.println(mn.checkMagicNumber(50114));
    }
}
