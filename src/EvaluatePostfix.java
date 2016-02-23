//import java.io.*;
//import java.util.*;
//
//public class EvaluatePostfix {
//    public static void main(String[] args) {
//        Stack<Integer> stack = new Stack<Integer>();
//
//        while (!StdIn.isEmpty()) {
//            String s = StdIn.readString();
//            if      (s.equals("+")) stack.push(stack.pop() + stack.pop());
//            else if (s.equals("*")) stack.push(stack.pop() * stack.pop());
//            else stack.push(Integer.parseInt(s));
//        }
//        System.out.println(stack.pop());
//    }
//}