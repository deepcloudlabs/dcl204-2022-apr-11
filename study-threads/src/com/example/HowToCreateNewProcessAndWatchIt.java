package com.example;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

/**
 *
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public class HowToCreateNewProcessAndWatchIt {

	public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
		do {
			Process process = Runtime.getRuntime().exec("java -jar c:/tmp/Java2D.jar");
			ProcessHandle processHandle = process.toHandle();
			var onExit = processHandle.onExit();
			onExit.get();
			System.out.println("Notepad has been closed!");
		} while (true);
	}

}
