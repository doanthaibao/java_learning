package bao.doan.mettl;

import java.util.ArrayList;
import java.util.Arrays;

public class NeedForSpeed {


  private int v;
  private ArrayList<Integer>[] adjList;

  //  public UserMainCode(int vertices) {
  //    this.v = vertices;
  //    initAdjList();
  //  }

  private void initAdjList() {
    adjList = new ArrayList[v];

    for (int i = 0; i < v; i++) {
      adjList[i] = new ArrayList<>();
    }
  }

  // add edge from u to v
  public void addEdge(int u, int v) {
    // Add v to u's list.
    adjList[u].add(v);
  }

  public ArrayList<ArrayList<Integer>> printAllPaths(int s, int d) {
    boolean[] isVisited = new boolean[v];
    ArrayList<Integer> pathList = new ArrayList<>();
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    pathList.add(s);
    printAllPathsUtil(s, d, isVisited, pathList, result);
    return result;
  }

  private void printAllPathsUtil(Integer u,
                                 Integer d,
                                 boolean[] isVisited,
                                 ArrayList<Integer> localPathList,
                                 ArrayList<ArrayList<Integer>> result) {
    isVisited[u] = true;
    if (u.equals(d)) {
      result.add((ArrayList<Integer>) localPathList.clone());
    }
    for (Integer i : adjList[u]) {
      if (!isVisited[i]) {
        localPathList.add(i);
        printAllPathsUtil(i, d, isVisited, localPathList, result);
        localPathList.remove(i);
      }
    }
    isVisited[u] = false;
  }

  int getSpeed(String input) {
    int result = 2;
    switch (input.toUpperCase()) {
      case "NITRO":
        result = 4;
        break;
      case "SAND":
        result = 1;
        break;
      case "COP":
        result = 0;
        break;
      case "NONE":
        break;
    }
    return result;
  }


  public int[] win(int input1, String[] input2, int intput3, int[][] input4) {
    this.v = input1;
    this.initAdjList();
    for (int i = 0; i < input4.length; i++) {
      this.addEdge(input4[i][0], input4[i][1]);
    }
    ArrayList<ArrayList<Integer>> paths = printAllPaths(0, input1 - 1);
    int[] speeds = new int[paths.size()];
    for (int i = 0; i < paths.size(); i++) {
      int speed = 0;
      for (int j = 0; j < paths.get(i).size(); j++) {
        speed += getSpeed(input2[paths.get(i).get(j)]);
      }
      speeds[i] = speed;
    }
    int maxx = max(speeds);
    int index = 0;
    for (int i = 0; i < speeds.length; i++) {
      if (maxx == speeds[i]) {
        index = i;
      }
    }

    return paths.get(index).stream().mapToInt(i -> i).toArray();
  }

  public int max(int[] input) {
    Arrays.sort(input);
    return input[input.length - 1];
  }

  // Driver program
  public static void main(String[] args) {
    NeedForSpeed code = new NeedForSpeed();
    String[] input2 = {"None", "Cop", "None", "None", "None"};
    int[][] input4 = {{0, 1}, {0, 2}, {1, 2}, {2, 3}, {3, 4}};
    int[] result = code.win(5, input2, 5, input4);
    System.out.print(result);
  }
}
