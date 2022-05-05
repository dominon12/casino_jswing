package utils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Database {
	private String dbPath;
	
	public Database(String dbPath) {
		this.setDbPath(dbPath);
		File file = new File(this.dbPath);
		try {
			if (!file.exists()) file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void save(String content) throws IOException {
		FileWriter fw = new FileWriter(this.dbPath);
		
		PrintWriter pw = new PrintWriter(fw);
		pw.printf("%s" + "%n", content);
		pw.close();
	}
	
	public String read() throws IOException {
		FileReader fr = new FileReader(this.dbPath);
		try (BufferedReader br = new BufferedReader(fr)) {
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();
			
			while (line != null) {
				sb.append(line);
				sb.append(System.lineSeparator());
				line = br.readLine();
			}
			
			return sb.toString();
		} 
	}

	public String getDbPath() {
		return dbPath;
	}

	public void setDbPath(String dbPath) {
		this.dbPath = dbPath;
	}
}
