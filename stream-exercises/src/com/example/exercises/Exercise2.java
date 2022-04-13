package com.example.exercises;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.maxBy;

import java.util.List;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Function;

import com.example.dao.CountryDao;
import com.example.dao.InMemoryWorldDao;
import com.example.domain.City;
import com.example.domain.Country;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class Exercise2 {
	private static final CountryDao countryDao = InMemoryWorldDao.getInstance();

	public static void main(String[] args) {
		// Find the most populated city of each continent
		var countries = countryDao.findAllCountries();
		Function<Country, List<ContinentCity>> countryToContinentCities = country -> country.getCities() // Stream<List<ContinentCity>>
				.stream().map(city -> new ContinentCity(country.getContinent(), city)).toList();
		Function<ContinentCity, String> kita = ContinentCity::continent;
		Function<ContinentCity, City> byCity = ContinentCity::city;
		Function<City, Integer> byPopulation = City::getPopulation;
		BiConsumer<String, Optional<ContinentCity>> printContinentCity = (continent, continentCity) -> System.out
				.println("%s: %s".formatted(continent, continentCity.get().city()));
		// Map<String,Optional<ContinentCity>>
		var continentHighestPopulatedCity = countries.stream() // Stream<Country>
				.map(countryToContinentCities) // Stream<List<ContinentCity>>
				.flatMap(List::stream) // Stream<ContinentCity>
				.collect(groupingBy(kita, maxBy(comparing(byCity.andThen(byPopulation)))));
		continentHighestPopulatedCity.forEach(printContinentCity);
	}

}

// Since Java SE 17
record ContinentCity2(String continent, City city) {}

final class ContinentCity { // ContinentCity ===> ContinentCity2
	private final String continent;
	private final City city;

	public ContinentCity(String continent, City city) {
		this.continent = continent;
		this.city = city;
	}

	public String continent() {
		return continent;
	}

	public City city() {
		return city;
	}

	@Override
	public String toString() {
		return "ContinentCity [continent=" + continent + ", city=" + city + "]";
	}

}