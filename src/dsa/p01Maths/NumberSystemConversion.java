package dsa.p01Maths;

import java.util.Scanner;

public class NumberSystemConversion {
  private static String SYMBOLS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

  private static long base1ToDecimalConversion(int base1, String num) {
    long base10Num = 0L;
    long pow = 1L;
    for (int i = num.length() - 1; i >= 0; i--) {
      char ch = num.charAt(i);
      if (ch >= 'a' && ch <= 'z') {
        ch = (char) (ch - 32);
      }
      int pos = SYMBOLS.indexOf(ch);
      if (pos < 0 || pos >= base1) {
        throw new Error("Enter a valid number for base");
      }
      base10Num += 1L * pos * pow;
      pow *= 1L * base1;
    }
    return base10Num;
  }

  private static String decimalToBase2Conversion(int base2, long base10Num) {
    StringBuilder sb = new StringBuilder();
    while (base10Num != 0) {
      int rem = (int) (base10Num % base2);
      sb.append(SYMBOLS.charAt(rem));
      base10Num /= base2;
    }
    return sb.reverse().toString();
  }

  private static String base1ToBase2Conversion(int base1, int base2, String num) {
    // Convert num from base1 to base 10
    long base10Num = base1ToDecimalConversion(base1, num);

    // Convert base10Num from base 10 to base2
    return decimalToBase2Conversion(base2, base10Num);
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      System.out.print("Enter base1: ");
      int base1 = sc.nextInt();
      System.out.print("Enter base2: ");
      int base2 = sc.nextInt();

      System.out.print("Enter num: ");
      String num = sc.next();

      System.out.println(base1ToBase2Conversion(base1, base2, num));
    }
  }
}
