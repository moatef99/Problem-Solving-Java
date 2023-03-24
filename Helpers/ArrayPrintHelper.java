package ProblemSolving.Helpers;

public class ArrayPrintHelper<T> {
    Printer printer;
    public ArrayPrintHelper(Printer printer){
      this.printer = printer;
    }

    public ArrayPrintHelper(){
        printer = new ConsolePrinter();
    }

    public void print(T[] arr){
        printer.print(arr);
    }

    public void print(int[] arr){
        printer.print(arr);
    }


    public void print(double[] arr){
        printer.print(arr);
    }

    public void print(float[] arr){
        printer.print(arr);
    }

    public void print(byte[] arr){
        printer.print(arr);
    }

    public void print(char[] arr){
        printer.print(arr);
    }

    public void print(boolean[] arr){
        printer.print(arr);
    }

    public void print(long[] arr){
        printer.print(arr);
    }

    public void print(short[] arr){
        printer.print(arr);
    }
}
