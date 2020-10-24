package com.yoon.quiz;

import com.yoon.quiz.dto.Trader;
import com.yoon.quiz.dto.Transaction;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        // init
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        // quiz start
        // 1. 2011년에 일어난 모든 트랜잭션을 찾아 값을 오름차순으로 정리하시오.
        List<Transaction> q1 = transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList());

        // 2. 거래자가 근무하는 모든 도시를 중복 없이 나열하시오.
        List<String> q2 = transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList());

        // 3. 케임브리지에서 근무하는 모든 거래자를 찾아서 이름순으로 정렬하시오.
        List<Trader> q3 = transactions.stream()
                .filter(transaction -> "Cambridge".equals(transaction.getTrader().getCity()))
                .map(Transaction::getTrader)
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());

        // 4. 모든 거래자의 이름을 알파벳순으로 정렬해서 반환하시오.
        List<String> q4 = transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        // 5. 밀라노에 거래자가 있는가?
        boolean q5 = transactions.stream()
                .anyMatch(transaction -> "Milan".equals(transaction.getTrader().getCity()));

        // 6. 케임브리지에 거주하는 거래자의 모든 트랜잭션값을 출력하시오.
        List<Transaction> q6 = transactions.stream()
                .filter(transaction -> "Cambridge".equals(transaction.getTrader().getCity()))
                .collect(Collectors.toList());

        // 7. 전체 트랜잭션 중 최대값은 얼마인가?
        int q7 = transactions.stream()
                .max(Comparator.comparingInt(Transaction::getValue))
                .orElse(new Transaction(null, 0, 0))
                .getValue();

        // 8. 전체 트랜잭션 중 최소값은 얼마인가?
        int q8 = transactions.stream()
                .min(Comparator.comparingInt(Transaction::getValue))
                .orElse(new Transaction(null, 0, 0))
                .getValue();

        System.out.println("\nq1--------------");
        System.out.println(q1);
        System.out.println("\nq2--------------");
        System.out.println(q2);
        System.out.println("\nq3--------------");
        System.out.println(q3);
        System.out.println("\nq4--------------");
        System.out.println(q4);
        System.out.println("\nq5--------------");
        System.out.println(q5);
        System.out.println("\nq6--------------");
        System.out.println(q6);
        System.out.println("\nq7--------------");
        System.out.println(q7);
        System.out.println("\nq8--------------");
        System.out.println(q8);
    }


}
