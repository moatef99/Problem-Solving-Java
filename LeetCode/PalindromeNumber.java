package LeetCode;

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;

        int length = 0;
        int copy = x;
        while (copy > 0) {
            copy /= 10;
            length++;
        }

      int secondPointer = (int)Math.pow(10,length-1);
      int first = 0;
      int last = 0;
      copy = x;
      for(int i =0; i<length/2; i++){
          first = copy % 10;
          last = (x / secondPointer) % 10;

          if(first != last)
              return false;

          copy /= 10;
          secondPointer /= 10;
      }

      return true;
    }

    public static void main(String[] args) {
       System.out.println(5<<-2);
    }
}
