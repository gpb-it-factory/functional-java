package ru.gazprombank;

import java.util.Comparator;

public class ComparatorLambda {

    public static void main(final String[] args) {

        // старинный вариант - до java8
        final Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(final Integer o1, final Integer o2) {
                return o1.compareTo(o2);
                // 0 -> if both are equal
                // 1 -> if o1 > o2
                //-1 -> if o1 < o2
            }
        };

        System.out.println(comparator.compare(1, 2));

        // Ура, лямбды! (начиная с java8)
        final Comparator<Integer> comparatorLambda = (Integer a, Integer b) -> a.compareTo(b);
        final Comparator<Integer> comparatorLambda1 = (a, b) -> a.compareTo(b);

        System.out.println(comparatorLambda1.compare(1, 2));
    }
}
