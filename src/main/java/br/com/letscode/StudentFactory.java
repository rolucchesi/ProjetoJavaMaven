package br.com.letscode;

import java.util.Arrays;


public class StudentFactory {

    private final String[] values;

    public StudentFactory(String[] values) {
        this.values = values;
    }

    public Student create(){
        var valuesList = Arrays.stream(values)
                .toList();
        return Student.builder()
                .name(valuesList.get(0))
                .classNames(valuesList.get(1))
//                .className(valuesList.get(2))
                .build();
    }
}
