package com.example.zoo.application;

import java.util.List;

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
	}

}
