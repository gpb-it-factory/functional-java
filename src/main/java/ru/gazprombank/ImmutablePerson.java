package ru.gazprombank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Все поля являются private и final для предотвращения изменений после инициализации.
 * Класс объявлен final, чтобы запретить наследование.
 * Конструктор проверяет и инициализирует все поля, включая защиту от передачи null значений.
 * Поле friends является изменяемым объектом типа List<String>.
 * В конструкторе мы клонируем список друзей, чтобы предотвратить внешнее изменение оригинального списка
 * (параметра конструктора).
 * В методе getFriends() мы возвращаем неизменяемую версию списка с помощью Collections.unmodifiableList(),
 * чтобы защитить внутреннее состояние объекта от изменений вне класса.
 */

public final class ImmutablePerson {
    private final String name;
    private final int age;
    private final List<String> friends;

    // Конструктор принимает все поля
    public ImmutablePerson(String name, int age, List<String> friends) {
        this.name = name;
        this.age = age;

        // Клонируем изменяемый объект, чтобы сохранить неизменяемость класса
        if (friends == null) {
            throw new IllegalArgumentException("friends cannot be null");
        }
        this.friends = new ArrayList<>(friends);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // Геттер для друзей, возвращаем неизменяемый список
    public List<String> getFriends() {
        return Collections.unmodifiableList(friends);
    }
}
