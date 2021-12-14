import java.util.*;
import java.util.stream.Collectors;

public class Puzzle14 extends BasePuzzle {
    private String template;
    private Map<String, Character> rules; // If input data is "SO-> F", then <"SO", 'F'>

    Puzzle14(String input) {
        super(input);
        template = getPuzzleInput().split("[\n\r]", 2)[0];
        rules = getPuzzleInput().split("[\n\r]", 2)[1].lines().filter(item -> !item.equals("")).map(item-> item.split(" -> ")).collect(Collectors.toMap(item -> item[0], item -> item[1].charAt(0)));
    }

    @Override
    public int getDay() {
        return 14;
    }

    @Override
    public String solveFirstPart() {
        Map<String, Long> pairs = new HashMap<>();
        Map<Character, Long> counter = new HashMap<>();
        for (int i=0 ; i<template.length()-1 ; i++) {
            pairs.merge(template.substring(i, i+2), 1L, Long::sum);
            counter.merge(template.charAt(i), 1L, Long::sum);
        }
        counter.merge(template.charAt(template.length()-1), 1L, Long::sum);

        for (int round = 0 ; round < 10; round++) {
            Map<String, Long> newPairs = new HashMap<>();
            pairs.forEach((key, value) -> {
                if (rules.containsKey(key)) {
                    char between = rules.get(key);
                    newPairs.merge(key.charAt(0) + String.valueOf(between), value, Long::sum);
                    newPairs.merge(String.valueOf(between) + key.charAt(1), value, Long::sum);
                    counter.merge(between, value, Long::sum);
                }
            });
            pairs = newPairs;
        }
        Map.Entry<Character, Long> mostCommonElement = counter.entrySet().stream().max(Map.Entry.comparingByValue()).get();
        Map.Entry<Character, Long> leastCommonElement = counter.entrySet().stream().min(Map.Entry.comparingByValue()).get();
        return String.valueOf(mostCommonElement.getValue() - leastCommonElement.getValue());
    }

    @Override
    public String solveSecondPart() {
        Map<String, Long> pairs = new HashMap<>();
        Map<Character, Long> counter = new HashMap<>();
        for (int i=0 ; i<template.length()-1 ; i++) {
            pairs.merge(template.substring(i, i+2), 1L, Long::sum);
            counter.merge(template.charAt(i), 1L, Long::sum);
        }
        counter.merge(template.charAt(template.length()-1), 1L, Long::sum);

        for (int round = 0 ; round < 40; round++) {
            Map<String, Long> newPairs = new HashMap<>();
            pairs.forEach((key, value) -> {
                if (rules.containsKey(key)) {
                    char between = rules.get(key);
                    newPairs.merge(key.charAt(0) + String.valueOf(between), value, Long::sum);
                    newPairs.merge(String.valueOf(between) + key.charAt(1), value, Long::sum);
                    counter.merge(between, value, Long::sum);
                }
            });
            pairs = newPairs;
        }
        Map.Entry<Character, Long> mostCommonElement = counter.entrySet().stream().max(Map.Entry.comparingByValue()).get();
        Map.Entry<Character, Long> leastCommonElement = counter.entrySet().stream().min(Map.Entry.comparingByValue()).get();
        return String.valueOf(mostCommonElement.getValue() - leastCommonElement.getValue());
    }

}
