package com.javarush.task.task21.task2104;

import java.util.HashSet;
import java.util.Set;

/* 
Equals and HashCode
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Donald", "Duck"));
        System.out.println(s.contains(new Solution("Donald", "Duck")));
        s.add(new Solution("Donald", "Duck2"));
        System.out.println(s.size());


        Solution sol1 = new Solution("123", "234");
        Solution sol2 = new Solution("123", "2344");
        Solution sol3 = new Solution("123", "234");
        System.out.println(sol1.hashCode());
        System.out.println(sol2.hashCode());
        System.out.println(sol1.equals(sol2));
        System.out.println(sol1.hashCode() == sol2.hashCode());
        System.out.println(sol1.hashCode() == sol3.hashCode());

    }

    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }

        if (!(o instanceof Solution)) {
            return false;
        }

        if (this == o) {
            return true;
        }
        Solution solution = (Solution) o;

        if (first != null ? !first.equals(solution.first) : solution.first != null) return false;
        if (last != null ? !last.equals(solution.last) : solution.last != null) return false;

        return true;
    }

    public int hashCode() {
        int result = first != null ? first.hashCode() : 0;
        result = 31 * result + (last != null ? last.hashCode() : 0);
        return result;
    }
}
