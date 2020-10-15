import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.StringTokenizer;
import java.util.concurrent.CopyOnWriteArrayList;

public class MyParser {
    private List<String> list;

    public MyParser(@NotNull String expression) {
        toString(expression);
    }

    private void toString(@NotNull String str) {
        list = new CopyOnWriteArrayList<>();
        String delimiters = "+-*/()";
        StringTokenizer sTok = new StringTokenizer(str, delimiters, true);
        while (sTok.hasMoreTokens()) {
            list.add(sTok.nextToken());
        }
        System.out.println(list);
    }

    public double foundSolve() {
        while (list.size() != 1) {
            List<String> newList = new CopyOnWriteArrayList<>();
            int start = 0, finish = 0;
            int sizeNew;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).equals("(")) {
                    start = i;
                }
                if (list.get(i).equals(")")) {
                    finish = i;
                    sizeNew = finish - start;
                    newList.addAll(list.subList(start + 1, finish));
                    String el = foundMath(newList);
                    for (int c = 0; c <= sizeNew; c++) {
                        list.remove(start);
                    }
                    list.add(start, el);
                    newList.clear();
                }

            }
            try {
                foundMath(list);
            } catch (Exception e) {
                continue;
            }
            System.out.println(newList);
            System.out.println(list);
        }
        return Double.parseDouble(list.get(0));
    }

    private String foundMath(@NotNull List<String> list) {
        for (String newExpr : list) {
            if (newExpr.equals("*") || newExpr.equals("/")) {
                for (int i = 0; i < list.size(); i++) {
                    double digit;
                    if (list.get(i).equals("*")) {
                        digit = Double.parseDouble(list.get(i - 1)) * Double.parseDouble(list.get(i + 1));
                        list.set(i, Double.toString(digit));
                        list.remove(i + 1);
                        list.remove(i - 1);
                    } else if (list.get(i).equals("/")) {
                        digit = Double.parseDouble(list.get(i - 1)) / Double.parseDouble(list.get(i + 1));
                        list.set(i, Double.toString(digit));
                        list.remove(i + 1);
                        list.remove(i - 1);
                    }
                }
            }
        }
        System.out.println(list);
        for (String ss : list) {
            if (ss.equals("+") || ss.equals("-")) {
                for (int i = 0; i < list.size(); i++) {
                    double digit;
                    if (list.get(i).equals("+")) {
                        digit = Double.parseDouble(list.get(i - 1)) + Double.parseDouble(list.get(i + 1));
                        list.set(i, Double.toString(digit));
                        list.remove(i + 1);
                        list.remove(i - 1);
                    } else if (list.get(i).equals("-")) {
                        digit = Double.parseDouble(list.get(i - 1)) - Double.parseDouble(list.get(i + 1));
                        list.set(i, Double.toString(digit));
                        list.remove(i + 1);
                        list.remove(i - 1);
                    }
                }
            }
        }
        return list.get(0);
    }
}
