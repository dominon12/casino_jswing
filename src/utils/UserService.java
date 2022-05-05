package utils;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.util.ArrayList;
import java.util.List;

import Models.User;

import java.util.Arrays;

public class UserService {
	private String dbPath = FileSystems.getDefault().getPath(new String()).toAbsolutePath() + "db.txt";
	private Database db;
	private String delimiter = ":";
	
	public UserService() {
		this.db = new Database(dbPath);
	}
	
	public void saveResults(String name, int saldoBefore, int saldoAfter) {
		try {
		// get saved results
		List<String> users = this.getSavedResults(name);
		

		// get user data
		String userData = name + delimiter + getProfitPercent(saldoBefore, saldoAfter);
		
		// append user data to the array of records
		users.add(userData);
		
		// join the array with line separator
		String stringToSave = String.join(System.lineSeparator(), users);
		
		// save user data to the file
		this.db.save(stringToSave);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<User> getResults() {
		List<User> results = new ArrayList<User>();
		
		try {			
			List<String> saved = this.getAllResults();
			for (String row : saved) {
				String[] splitted = row.split(delimiter);
				if (splitted.length == 2) {
					String username = splitted[0];
			 		int result = Integer.parseInt(splitted[1]); 
					User user = new User(username, result);
					results.add(user);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return results;
	}
	
	private int getProfitPercent(int saldoBefore, int saldoAfter) {
		return Math.round(saldoAfter * 100 / saldoBefore);
	}
	
	private List<String> getSavedResults(String name) throws IOException {		
		List<String> results = this.getAllResults();
		
		int userRecordIndex = this.getUserIndexByName(name, results);
		
		
		if (userRecordIndex != -1) {
			// if there are already records for the selected user, 
			// remove it from the file and save without it. 
			results.remove(userRecordIndex);
		}
		
		return results;
	}

	private List<String> getAllResults() throws IOException {
		String savedResults = this.db.read();
		String[] splittedResults = savedResults.split(System.lineSeparator());
		List<String> results = new ArrayList<String>();
		results = new ArrayList<String>(Arrays.asList(splittedResults));
		return results;
	}
	
	private int getUserIndexByName(String name, List<String> results) {
		int userRecordIndex = -1;
		
		for (int i = 0; i < results.size(); i++) {
			String[] userArray = results.get(i).split(delimiter);
			String savedUserName = userArray[0];
			if (savedUserName.equalsIgnoreCase(name)) {
				userRecordIndex = i;
				break;
			}
		}
		
		return userRecordIndex;
	}
}
