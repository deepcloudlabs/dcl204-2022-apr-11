package com.example;

import java.nio.file.Paths;
import java.util.Optional;
import java.util.function.Consumer;

/**
*
*  @author Binnur Kurt <binnur.kurt@gmail.com>
*/
public class StudyProcessApi {

	public static void main(String[] args) {
		var numberOfProcesses = ProcessHandle.allProcesses().count();
		System.out.println(numberOfProcesses);
		Consumer<String> printCommand = command -> {
			var path = Paths.get(command);
			System.out.println(path.getFileName());
		};
		ProcessHandle.allProcesses()
		             .map(p -> p.info().command())
		             .filter(Optional::isPresent)
		             .map(Optional::get)
		             //.distinct()
		             .sorted()
		             .forEach(printCommand );
	}

}
