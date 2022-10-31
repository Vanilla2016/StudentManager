package com.wds.util;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import org.apache.commons.fileupload.FileItem;
import com.wds.beans.Student;

public class FileItemProcessor {

	String fileContents;
	
	public FileItemProcessor() {
	}
	
	public Student[] processFileToBeans (FileItem item) throws NumberFormatException {
	
		String [] lines = null; 
		Student [] students = null;
		
		try {
			fileContents = item.getString(StandardCharsets.UTF_8.name());
			lines = fileContents.split("\n");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		if (lines != null) {
			students = new Student [lines.length];
			int count=0;
				for(String line : lines) {
						String [] nameScore =  line.split(",");
							if (nameScore.length == 2) {
							String name = null;	
							Double score = null;
							name = nameScore[0];
							//try {
								score = Double.valueOf(nameScore[1]);
							//} catch (NumberFormatException num) {
							//	System.out.println("Cannot parse score . Student record not created. "+num.getMessage());
							//}
							if(name != null && score !=null) {
								students[count]  = new Student(name, score);
							}
							}
					count++;
				}
		}
		return students;
	}
}
