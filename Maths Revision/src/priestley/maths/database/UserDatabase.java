package priestley.maths.database;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class UserDatabase {

	public static void CreateUser(String userID, char[] passwordChar, String securityQuestion, String securityAnswer) {
		// TODO Create User
		boolean userIDTaken = false;
		if (userID != "Users") {
			BufferedReader br;
			try {
				br = new BufferedReader(new InputStreamReader(new FileInputStream("Users.txt")));
				try {
					String line;
					while ((line = br.readLine()) != null) {
						// System.out.println(line);
						if (line == userID) userIDTaken = true;
					}
				} catch (IOException e) {
					System.out.println("ERROR! Could not read file");
				} finally {
					try {
						br.close();
					} catch (IOException e) {
						System.out.println("ERROR! Could not close file");
					}
				}
			} catch (FileNotFoundException e) {
				System.out.println("ERROR! Could not find file");
			}
		}

		if (!userIDTaken) {
			try {
				PrintWriter file = new PrintWriter(userID + ".txt", "UTF-8");
			} catch (IOException e) {
				System.out.println("ERROR! Cannot CreateFile!");
			}
			List<String> lines = Arrays.asList(userID, passwordChar.toString(), securityQuestion, securityAnswer);
			Path file = Paths.get(userID + ".txt");
			try {
				Files.write(file, lines, Charset.forName("UTF-8"));
			} catch (IOException e) {
				System.out.println("ERROR! Could not write to file");
			}
		}
	}

	public static boolean Login(String userID, char[] passwordChar) {
		// TODO Login
		BufferedReader br;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(userID + ".txt")));
			try {
				String line;
				for (int i = 0; i < 4; i++) {
					try {
						line = br.readLine();
						if (i == 1) {
							System.out.println(line +"\n" + passwordChar.toString());
							if (Arrays.equals(passwordChar, line.toCharArray())) {
								// TODO Login
								return true;
							}
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						System.out.println("Error!");
						return false;
					}

				}
			} finally {
				try {
					br.close();
				} catch (IOException e) {
					System.out.println("ERROR! Could not close file");
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("ERROR! Could not find file");
			return false;
			// TODO Tell User cannot find file so user does not exist
		}
		return false;
	}

	private void ChangePassword() {
		// TODO Change user
	}

}
