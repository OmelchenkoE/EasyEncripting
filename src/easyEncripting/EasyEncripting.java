/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easyEncripting;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/**
 *
 * @author qwerty
 *
 *
 */
public class EasyEncripting {

    public static void main(String[] args) throws UnsupportedEncodingException {
        getStringFromBinaryLong(encript(encript(getBinaryInLongArrayFromString("привет"), "key"), "key"));
      }
    /*
     //it use String array
     public static ArrayList<String> getBinaryFromString(String s) {
     ArrayList<String> arr1 = new ArrayList<>();
     char[] arr = s.toCharArray();
     for (char c : arr) {
     String u = Integer.toBinaryString(c);
     arr1.add(u);
     }
     System.out.println(arr1);
     return arr1;
     }

     public static StringBuilder getStringFromBinaryString(ArrayList<String> arr1) {
     StringBuilder sb = new StringBuilder();
     System.out.println(arr1);
     ArrayList<Character> arr2 = new ArrayList<>();
     for (String p : arr1) {
     //arr2.add((char)Integer.parseInt(p,2));//put to array

     sb.append((char) Integer.parseInt(p, 2));//put to sb
     }

     // System.out.println(arr2); //show array
     System.out.println(sb);//show sb
     return sb;
     }
     */

    public static String getStringFromBinaryLong(ArrayList<Long> arr1) {
        StringBuilder sb = new StringBuilder();
        System.out.println(arr1);
        ArrayList<Character> arr2 = new ArrayList<>();
        for (Long p : arr1) {
            arr2.add((char) Integer.parseInt(p.toString(), 2));//put to array
            sb.append((char) Integer.parseInt(p.toString(), 2));//put to sb
        }
        // System.out.println(arr2); //show array
        System.out.println(sb);//show sb
        return sb.toString();
    }

    public static ArrayList<Long> getBinaryInLongArrayFromString(String s) {
        ArrayList<Long> arr1 = new ArrayList<>();
        char[] arr = s.toCharArray();
        for (char c : arr) {
            Long u = Long.valueOf(Integer.toBinaryString(c));
            arr1.add(u);
        }
        System.out.println(arr1);
        return arr1;
    }

    public static ArrayList<Long> encript(ArrayList<Long> arr, String key) {
        ArrayList<Long> longs = new ArrayList<>();
        StringBuilder sb1 = new StringBuilder();
        char[] chars = key.toCharArray();
        for (char c : chars) {
            sb1.append(Character.getNumericValue(c));
        }
        Long main = Long.valueOf(sb1.toString());
        for (long l : arr) {
            long encripted = l ^ main;
            longs.add(encripted);
        }
        System.out.println(main);
        System.out.println(longs);
        return longs;
    }
}
