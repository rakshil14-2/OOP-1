import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class ParseRecords {
	java.util.HashMap<java.lang.String, Student> IDtoStudentObj;

	java.util.HashMap<java.lang.String, Batch> batchtoBatchObj;

	public ParseRecords() {
		this.IDtoStudentObj = new HashMap<String, Student>();

		this.batchtoBatchObj = new HashMap<String, Batch>();
	}

	int getRecords(java.lang.String filename) {
		
			int recordsProcessed= 0;
	
			File file = new File(filename);
			BufferedReader br = null;
			
			try {
				br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
				
				String line;
				
				try {
					while((line = br.readLine()) != null) {
						recordsProcessed++;
						StringTokenizer st = new StringTokenizer(line);
						String id = st.nextToken();
						String name = st.nextToken();
						Student s = new Student(id, name);
						Batch b = new Batch(s.getBatch());
						
						if(!IDtoStudentObj.containsKey(id)) {
							IDtoStudentObj.put(id, s);
							
							if(!batchtoBatchObj.containsKey(s.getBatch())) {
								batchtoBatchObj.put(s.getBatch(), b);
							}
							
							batchtoBatchObj.get(s.getBatch()).addStudenttoBatch(s);
						}
						
						String sem = st.nextToken();
						String gpa = st.nextToken();
						
						IDtoStudentObj.get(id).addGPA(sem, gpa);
											
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return recordsProcessed;
			
	}

	int getStudentSize() {
		return IDtoStudentObj.size();
	}

	int getBatchSize() {
		return batchtoBatchObj.size();
	}

	void answerQueries(java.lang.String inputfile, java.lang.String outputfile) {
		File ifile = new File(inputfile);
		File ofile = new File(outputfile);
		
		BufferedReader br = null;
		BufferedWriter bw = null;
		
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(ifile)));
			bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(ofile)));

			String line;
			
			try {
				while((line = br.readLine()) != null) {
					
//					StringTokenizer st = new StringTokenizer(line, " ");
					
					String elements[] = line.split(" ");
					
//					String query = st.nextToken();
//					String key = st.nextToken();
					String query = elements[0];
					String key = elements[1];
					
					
					if(query.equals("Q1")) {
						bw.write(IDtoStudentObj.get(key).studentInfo());
					}
					else if(query.equals("Q2")) {
						Batch b = batchtoBatchObj.get(key);
						
						for(Student s: b.allStudents()) {
							bw.write(s.studentInfo());
						}
					}
					else if(query.equals("Q3")) {
						batchtoBatchObj.get(key).sortByID();
						
						for(Student s: batchtoBatchObj.get(key).allStudents()) {
							bw.write(s.studentInfo());
						}
						
					}
					else if(query.equals("Q4")) {
						batchtoBatchObj.get(key).sortByCGPA();
						
						for(Student s: batchtoBatchObj.get(key).allStudents()) {
							bw.write(s.studentInfo());
						}
						
					}
					else if(query.equals("Q5")) {
//						String batch = st.nextToken();
						String batch = elements[2];
						
						bw.write(batchtoBatchObj.get(key).findMaxCGPA(batch).studentInfo());
					}
//					switch(query) {
////					case "Q1":
////						bw.write(IDtoStudentObj.get(key).studentInfo());
////						break;
////					
	//					case "Q2":
	//						Batch b = batchtoBatchObj.get(key);
	//						
	//						for(Student s: b.allStudents()) {
	//							bw.write(s.studentInfo());
	//						}
	//						break;
	//						
	//					case "Q3":
	//						batchtoBatchObj.get(key).sortByID();
	//						break;
	//					
	//					case "Q4":
	//						batchtoBatchObj.get(key).sortByCGPA();
	//						
	//					case "Q5":
	//						String batch = st.nextToken();
	//						
	//						bw.write(batchtoBatchObj.get(batch).findMaxCGPA(key).studentInfo());
	//						break;
//						
//					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

//	public static void main(String[] args) {
//		
//		ParseRecords pr = new ParseRecords();
//		
//		pr.getRecords("records.txt");
//		
//		pr.answerQueries("inputfile.txt", "outputfile.txt");
//	}
}
