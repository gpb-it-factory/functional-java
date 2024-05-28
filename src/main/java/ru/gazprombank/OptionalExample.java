package ru.gazprombank;

import lombok.Value;

import java.util.Optional;

public class OptionalExample {

    record Employee(Person person) {}
    record Person(Address address) {}
    record Address(String street) {}

    public static void main(String[] args) {

        final Address address = new Address("Москва, Ленинский проспект, дом 21");
        final Person person = null; //new Person(address);
        final Employee employee = new Employee(person);

        String street = "";

/*        String street = employee.person().address().street();
        System.out.println(street);*/

        //String street;
/*        if (employee != null
                && employee.person() != null
                && employee.person().address() != null) {
            street = employee.person().address().street();
        } else {
            street = "<неизвестно>";
        }*/



        street = Optional.of(employee)
                .map(Employee::person)
                .map(Person::address)
                .map(Address::street)
                .orElse("<неизвестно>");

        System.out.println(street);

    }
}

