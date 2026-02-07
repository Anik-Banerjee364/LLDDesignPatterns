package org.example.Tutorial1;

import javax.swing.text.SimpleAttributeSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
       HotelService hotelService = new HotelService();

       //METHOD 1
//       List<Hotel> hotels = hotelService.filterHotels(new Filter5StarHotel());
//       System.out.println("5 Star Hotels: " + hotels);

       //METHOD 2 Anonymous class
//        List<Hotel> hotels = hotelService.filterHotels(new FilteringCondition(){
//            @Override
//            public boolean test(Hotel hotel) {
//                return hotel.getType() == HotelType.FIVE_STAR;
//            }
//        });

        //METHOD 3
//        List<Hotel> hotels = hotelService.filterHotels(((Hotel hotel) -> {
//            return hotel.getType() == HotelType.FIVE_STAR;
//        }));
//        System.out.println("5 Star Hotels: " + hotels);

        //METHOD 4
//        FilteringCondition lambdaExp = (Hotel hotel) -> {
//            return hotel.getType() == HotelType.FIVE_STAR;
//        };
//        List<Hotel> hotels = hotelService.filterHotels(lambdaExp);
//        System.out.println("5 Star Hotels: " + hotels);

        //METHOD 5
//        Predicate<Hotel> lambdaExp = (Hotel hotel) -> {
//            return hotel.getType() == HotelType.FIVE_STAR;
//        };
//        List<Hotel> hotels = hotelService.filterHotels(lambdaExp);
//        System.out.println("5 Star Hotels: " + hotels);
//
//
//
//
//        //Examples
//        List<Integer> lst = new ArrayList<>(List.of(1, 2, 3, 4, 5));
//        Collections.sort(lst, (Integer a, Integer b) -> { return b - a;});
//        System.out.println("Sorted List: " + lst);


        //Predicate examples

        Predicate<Integer> divisibleBy2 = (Integer a) -> {
            return a % 2 == 0;
        };
        Predicate<Integer> divisibleBy3 = (Integer a) -> {
            return a % 3 == 0;
        };
        Predicate<Integer> divisibleBy2And3 = divisibleBy2.and(divisibleBy3);
        System.out.println("Divisible by 2 and 3: " + divisibleBy2And3.test(6)); // true

        Function<String, Integer> stringLengthFunction = (String s) -> {
            return s.length();
        };
//        stringLengthFunction.apply("Hello World"); // Returns 11
        System.out.println("Length of 'Hello World': " + stringLengthFunction.apply("Hello World"));

        Function<Integer, Integer> squareFunction = (Integer a) -> {
            return a * a;
        };
        Function<Integer, Integer> doubleFunction = (Integer a) -> {
            return a * 2;
        };
        System.out.println(squareFunction.andThen(doubleFunction).apply(3)); // Returns 18 (3^2 * 2)


    }
}
