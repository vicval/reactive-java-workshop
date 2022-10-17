package io.javabrains.reactiveworkshop;

public class Exercise1 {

    public static void main(String[] args) {

        // Use StreamSources.intNumbersStream() and StreamSources.userStream()

        // Print all numbers in the intNumbersStream stream
        StreamSources.intNumbersStream().forEach(t -> System.out.println(t));

        // Print numbers from intNumbersStream that are less than 5
        StreamSources.intNumbersStream().filter(t -> t < 5).forEach(t -> System.out.println(t));

        // Print the second and third numbers in intNumbersStream that's greater than 5
        StreamSources.intNumbersStream().filter(t -> t > 5).skip(1).limit(2).forEach(t -> System.out.println(t));

        //  Print the first number in intNumbersStream that's greater than 5.
        //  If nothing is found, print -1
        Integer integer = StreamSources.intNumbersStream().filter(t -> t > 5).findFirst().orElse(-1);
        System.out.println(integer);

        // Print first names of all users in userStream
        StreamSources.userStream().map(t -> t.getFirstName()).forEach(System.out::println);

        // Print first names in userStream for users that have IDs from number stream
        StreamSources.intNumbersStream().flatMap(id -> StreamSources.userStream().filter(user -> user.getId() == id)).forEach(System.out::println);

    }

}
