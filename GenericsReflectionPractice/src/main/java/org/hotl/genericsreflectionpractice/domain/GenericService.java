package org.hotl.genericsreflectionpractice.domain;


import lombok.extern.slf4j.Slf4j;
import org.hotl.genericsreflectionpractice.api.SearchRequest;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.util.Tuple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

@Slf4j
@Service
public class GenericService {

    // Сплитим только по ';' или по ',', которая не является дробным разделителем
    private static final String SPLIT_PATTERN = "(?:,(?!\\d)|(?<=\\d[.,]\\d{1,30}),|,(?=\\d+[.,]\\d)|;)+";


    private static final String INT_PATTERN    = "[+-]?\\d+";
    private static final String DOUBLE_PATTERN = "[+-]?(?:\\d+[.,]\\d+|[.,]\\d+|\\d+[.,])(?:[eE][+-]?\\d+)?";


    //@SuppressWarnings({"rawtypes", "unchecked"})
    public String sortMassive(String text){
        if (text == null || text.isBlank()) {
            return "Text is blsnk!";
        }
        List<?> results = convertList(text);

        if (results.isEmpty()) {
            return "[]";
        }

        if(results.get(0) instanceof Integer){
            List<Integer> ints = (List<Integer>) results;
            log.info("unsorted MassiveInteger({})", ints);
            sort_generics(ints, Function.identity());
            log.info("sorted MassiveInteger({})", ints);
            return ints.toString();

        } else if(results.get(0) instanceof Double){
            List<Double> doubles = (List<Double>) results;
            log.info("unsorted MassiveDouble({})", doubles);
            sort_generics(doubles, Function.identity());
            log.info("sorted MassiveDouble({})", doubles);
            return doubles.toString();
        }
        else if(results.get(0) instanceof String){
            List<String> strings = (List<String>) results;
            log.info("unsorted MassiveString({})", strings);
            sort_generics(strings, Function.identity());
            log.info("sorted MassiveString({})", strings);
            return strings.toString();

        }else return "Wrong result!";
    }

    //придется использовать wildcard потому что дженерики не могут просто так возвращать тип Т если он не в параметрах функции
    private List<?> convertList(String text){

        String[] parts = Arrays.stream(text.split(SPLIT_PATTERN))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .toArray(String[]::new);

        if (Arrays.stream(parts).allMatch(p -> p.matches(INT_PATTERN))) {
            try {
                List<Integer> r = new ArrayList<>(parts.length);
                for (String p : parts) {
                    r.add(Integer.parseInt(p));
                }
                return r;
            } catch (NumberFormatException ignored) {
                new RuntimeException("parsing problem");
            }
        }

        if (Arrays.stream(parts).allMatch(p -> isDoubleLiteral(p))) {
            try {
                List<Double> r = new ArrayList<>(parts.length);
                for (String p : parts) {
                    r.add(Double.parseDouble(p));
                }
                return r;
            } catch (NumberFormatException ignored) {
                new RuntimeException("parsing problem");
            }
        }

        return new ArrayList<>(Arrays.asList(parts));
    }

    private Object convertItem(String text){

        String t = text.trim();

        if(t.matches(INT_PATTERN)){
            try {
                return Integer.parseInt(t);
            }
            catch (NumberFormatException ignored) {
                new RuntimeException("parsing problem");
            }

        }else if (isDoubleLiteral(t)){
            try {
                return Double.parseDouble(t);

            }
            catch (NumberFormatException ignored) {
                new RuntimeException("parsing problem");
            }
        }
        return t;

    }


    private static boolean isDoubleLiteral(String s) {
        return s.matches(DOUBLE_PATTERN);
    }



    public static <T , S extends Comparable<S>> void sort_generics(
            List<T> mass,
            Function<T, S> funcGetField
    ){

        for (int i = 0; i < mass.size() - 1; i++){
            for (int j = 0; j < mass.size() - i - 1; j++){
                if (
                        funcGetField.apply(mass.get(j))
                                .compareTo(funcGetField.apply(mass.get(j + 1))) > 0
                )

                {
                    swap(j,j + 1, mass);

                }

            }
        }
    }

    public static <T> void swap(int i, int j, List<T> a){
        T temp = a.get(i);
        a.set( i, a.get(j) );
        a.set( j, temp );
    }



    //@SuppressWarnings({"rawtypes", "unchecked"})
    public String findItem(SearchRequest request){
        if(request.massiveText() == null || request.massiveText().isEmpty() || request.itemText() == null){
            return "[]";
        }

        Object result = convertItem(request.itemText());
        List<?> results = convertList(request.massiveText());


        if (result instanceof Integer && results.get(0) instanceof Integer ) {
            List<Integer> ints = (List<Integer>) results;
            Integer i = (Integer) result;
            //Какой-то tuple из библиотеки org.yaml.snakeyaml.util.Tuple для текущей задачи подойдет.
            Tuple<Integer, Integer> tuple = searchInList(ints, i);
            return tuple._1() + " " + tuple._2();


        } else if (result instanceof Double && results.get(0) instanceof Double) {
            List<Double> ints = (List<Double>) results;
            Double d = (Double) result;
            Tuple<Integer, Double> tuple = searchInList(ints, d);
            return tuple._1() + " " +  tuple._2();


        } else if (result instanceof String && results.get(0) instanceof String) {
            List<String> strs = (List<String>) results;
            String s = (String) result;
            Tuple<Integer, String> tuple = searchInList(strs, s);
            return tuple._1().toString() + " " + tuple._2();


        } else {
            return "Incompatible types";
        }
    }



    private <T> Tuple<Integer, T> searchInList(List<T> list, T itemToSearch){

        for (int i = 0; i < list.size(); i++) {
            T item = list.get(i);
            if (Objects.equals(item, itemToSearch)) {
                return new Tuple<>(i, item);
            }
        }
        return new Tuple<>(-1, null);

    }

}
