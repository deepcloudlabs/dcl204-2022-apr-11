package com.example.zoo.application;

import java.util.List;
import java.util.stream.Collectors;

import com.example.zoo.domain.Animal;
import com.example.zoo.domain.Cat;
import com.example.zoo.domain.Fish;
import com.example.zoo.domain.Pet;
import com.example.zoo.domain.Spider;

/**
*
*  @author Binnur Kurt <binnur.kurt@gmail.com>
*/
public class Zoo {

	public static void main(String[] args) {
		var zooAnimals = List.of(
			new Spider(),
			new Cat(),
			new Fish("Free Willy"),
			new Spider(),
			new Cat("Garfield"),
			new Fish("Nemo"),
			new Spider()
		);
        for (var animal : zooAnimals) {
        	animal.walk();
        	animal.eat();
//        	if (animal instanceof Pet) {
//        		var pet = (Pet) animal;
//        	    pet.play();
//        	} 
        	if (animal instanceof Pet pet) { // since Java SE 17
        		pet.play();
        	} 
        }
        var totalLegs = 0;
        for (var animal : zooAnimals) {
        	totalLegs += animal.getLegs();
        }
        System.out.println("Total number of legs: %d".formatted(totalLegs));
        
        var numberOfLegs = zooAnimals.stream()
        		                     .parallel()
        		                     .mapToInt(Animal::getLegs)
        		                     .sum(); 
        System.out.println("Total number of legs: %d".formatted(numberOfLegs));
        var animalCounts = zooAnimals.stream()
        							 .parallel()
        		                     .collect(Collectors.groupingBy(Animal::getClass,Collectors.counting()));
        animalCounts.forEach((tur,counter) -> System.out.println("%s: %d".formatted(tur.getSimpleName(),counter)) );
        
	}

}
