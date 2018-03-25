package F21ASE_Stage2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Log {

	private static Log uniqueInstance;
	private DateFormat dateFormat;
	private Date date;

	private Log() {
		this.dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		this.date = new Date();
	}

	/**
	 * singleton: get the log object
	 * 
	 * @return uniqueInstance
	 */

	public static synchronized Log getInstance() {
		if (uniqueInstance == null) // only if no instance
			synchronized (Log.class) { // lock block
				if (uniqueInstance == null) // and re-check
					uniqueInstance = new Log();
			}
		return uniqueInstance;
	}

	/**
	 * Write log msg to log.txt
	 * 
	 * @param msg
	 */
	public void write(String msg) {
		try {
			// the file path
			File file = new File("log.txt");
			// if the file not exist create one
			if (!file.exists()) {
				file.createNewFile();
			}
			// append to the file
			FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
			BufferedWriter bw = new BufferedWriter(fw);
			// format the msg
			String output = msg.substring(0, 1).toUpperCase() + msg.substring(1);
			date.setTime(System.currentTimeMillis());
			// write the msg
			bw.write(dateFormat.format(date) + ": " + output);
			// start a newline
			bw.newLine();
			// close BufferedWriter
			bw.close();
			// close FileWriter
			fw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// TEST the Log class
//	public static void main(String[] args) {
//		Log log = Log.getInstance();
//		log.write("add passenger");
//
//		 long startTime = System.currentTimeMillis(); int i = 2; while(i > 1) { if
//		 (System.currentTimeMillis() - startTime > 5000) {
//		 log.write("check in passenger"); return; } else { log.write("waiting"); } }
//
//	}

}
