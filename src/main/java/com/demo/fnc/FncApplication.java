package com.demo.fnc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

@SpringBootApplication
public class FncApplication {

	public static void main(String[] args) {
		SpringApplication.run(FncApplication.class, args);
	}

	List<TollStation> tollStationList;

	public FncApplication() {
		tollStationList = new ArrayList<TollStation>();
		tollStationList.add(new TollStation("100A", (float)100, 1));
		tollStationList.add(new TollStation("200B", (float)200, 2));
		tollStationList.add(new TollStation("300C", (float)300, 3));
	}

	@Bean
	public Function<String, TollStation> retrieveTollStation() {
		return value -> {
			System.out.println("received request for station :" + value);
			return tollStationList.stream()
					.filter(t -> value.equals(t.getStationId()))
					.findAny()
					.orElse(null);
		};
	}
}
