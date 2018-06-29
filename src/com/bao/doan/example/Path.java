package com.bao.doan.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*Write a function that provides change directory (cd) function for an abstract file system.

Notes:

Root path is '/'.
Path separator is '/'.
Parent directory is addressable as "..".
Directory names consist only of English alphabet letters (A-Z and a-z).
The function should support both relative and absolute paths.
The function will not be passed any invalid paths.
Do not use built-in path-related functions.
For example:

Path path = new Path("/a/b/c/d");
path.cd('../x');
System.out.println(path.getPath());
should display '/a/b/c/x'.*/
public class Path {
    private String path;

    public Path(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void cd(String newPath) {
       if(newPath.startsWith("/")) {
    	   path = newPath;
    	   return;
       } 
       List<String> splitPath = new ArrayList<String> (Arrays.asList(path.split("/")) );
       String [] newSplitPath = newPath.split("/");
       for( int i = 0 ; i< newSplitPath.length ;i ++) {
    	   if (newSplitPath[i].equals("..")) {
    		   splitPath = splitPath.subList(0, splitPath.size() -1);
    	   }else{
    		   splitPath.add(newSplitPath[i]);
    	   }
       }
       String [] result =  splitPath.toArray(new String[splitPath.size()]);
       path = String.join("/", result);
       
    }

    public static void main(String[] args) {
        Path path = new Path("/a/b/c/d");
        path.cd("../x");
        System.out.println(path.getPath());
    }
}
