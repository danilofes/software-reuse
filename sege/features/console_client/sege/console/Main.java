package sege.console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import sege.GameException;
import sege.GameService;
import sege.GameServiceImpl;

public class Main {

	public static void main(String[] args) throws IOException {
		GameService gs = GameServiceImpl.create();
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		try {
			Cmd command;
			do {
				command = readCommand(console);
				try {
					printResponse(command.exec(gs));
				} catch (GameException e) {
					printResponse(e.getMessage());
				}
			} while (!command.isExit());
		} finally {
			console.close();
		}
	}
	
	private static Cmd readCommand(BufferedReader console) throws IOException {
		String input = console.readLine();
		String[] parts = input.split(" ");
		Cmd cmd;
		if (parts[0].equals("list")) {
			cmd = new ListCmd();
		} else if (parts[0].equals("status")) {
			cmd = new StatusCmd(parts[1], parts[2]);
		} else if (parts[0].equals("join")) {
			cmd = new JoinCmd(parts[1], parts[2]);
		} else if (parts[0].equals("leave")) {
			cmd = new LeaveCmd(parts[1], parts[2]);
		} else if (parts[0].equals("do")) {
			cmd = new DoCmd(parts[1], parts[2], parts[3]);
		} else {
			cmd = new ExitCmd();
		}
		return cmd;
	}
	
	private static void printResponse(String response) {
		System.out.println(response);
	}
}
