package ProblemSolving.Helpers;

public interface Printer<T> {
    void print (T[] arr);
    void print (int[] arr);

    void print(double[] arr);

    void print(float[] arr);

    void print(byte[] arr);

    void print(char[] arr);

    void print(boolean[] arr);

    void print(long[] arr);

    void print(short[] arr);
}
