package ru.gazprombank;

import java.util.List;

/**
 * Shallow immutable класс с тремя полями
 * Конструктор, который устанавливает значения в эти поля
 * Геттеры
 * equals(), hashCode() и toString()
 */
public record ShallowImmutablePersonRecord(String name, Integer age, List<String> friends) {}
