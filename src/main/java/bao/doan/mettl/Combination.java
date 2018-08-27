package bao.doan.mettl;

import java.util.ArrayList;
import java.util.Arrays;

// Read only region start
class Combination {

  public int[] construction(int input1, int[] input2) {
    // Read only region end
    int[] resultArray = new int[input1];

    for (int i = 1; i <= input1; i++) {
      ArrayList<int[]> subset = new ArrayList<int[]>();
      int data[] = new int[input1];
      Combination.getCombination(input2, input1, i /*length of combination*/, 0, data, 0, subset);

      int minArr[] = new int[subset.size()];
      for (int j = 0; j < subset.size(); j++) {
        int minValue = min(subset.get(j));
        minArr[j] = minValue;
      }
      resultArray[i - 1] = max(minArr);
    }
    System.out.print("{");
    for (int i = 0; i < resultArray.length; i++) {

      System.out.print(resultArray[i]);
      if (i < resultArray.length - 1) {
        System.out.print(",");
      }
    }
    System.out.print("}");
    return resultArray;
  }

  public static boolean isContinueGroup(int[] subset, int[] origin) {
    if (subset.length <= 1) {
      return true;
    }
    int firstValue = subset[0];
    int index = -1;
    for (int i = 0; i < origin.length; i++) {
      if (firstValue == origin[i]) {
        index = i;
        break;
      }
    }
    if (index >= 0) {
      int count = 1;
      for (int j = index + 1; j < origin.length && count < subset.length; j++) {
        if (subset[count] != origin[j]) {
          return false;
        }
        count++;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    Combination code = new Combination();
    int[] arr = {1, 2, 3};
    code.construction(3, arr);
  }

  public int min(int[] input) {
    Arrays.sort(input);
    return input[0];
  }

  public int max(int[] input) {
    Arrays.sort(input);
    return input[input.length - 1];
  }

  static void getCombination(int arr[], int n, int length, int index, int data[], int i, ArrayList<int[]> result) {
    if (index == length) {
      int[] sub = new int[length];
      for (int j = 0; j < length; j++) {
        sub[j] = data[j];
      }
      if (isContinueGroup(sub, arr)) {
        result.add(sub);
      }
      return;
    }
    if (i >= n)
      return;
    data[index] = arr[i];
    getCombination(arr, n, length, index + 1, data, i + 1, result);

    getCombination(arr, n, length, index, data, i + 1, result);
  }
}
