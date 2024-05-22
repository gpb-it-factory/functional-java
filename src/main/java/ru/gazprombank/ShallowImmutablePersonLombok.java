package ru.gazprombank;

import lombok.Value;

import java.util.List;

/**
 * Shallow immutable класс с тремя полями
 * Конструктор, который устанавливает значения в эти поля
 * Геттеры
 * equals(), hashCode() и toString()
 */

@Value
public class ShallowImmutablePersonLombok {
    String name;
    Integer age;
    List<String> friends;
}

