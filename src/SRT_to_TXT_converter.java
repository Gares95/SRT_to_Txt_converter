import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;

public class SRT_to_TXT_converter {

	public static void main(String[] args){
		BufferedReader reader = null;
		FileWriter writer = null;
		String contentLine;
		int line;
		boolean sepFiles = false;
		File outFile;
		
		Scanner sc = new Scanner(System.in);
		
		final File srtFolder = new File("./srt_files");
		
		final File txtFolder = new File("./txt_files");
		if (! txtFolder.exists()){
			txtFolder.mkdir();
		}
		
		if (srtFolder.listFiles().length > 1) {
			System.out.println("Would you like to produce separated .txt files [y/n]?");
			String str = sc.nextLine();
			if (str.equalsIgnoreCase("Y")) {
				sepFiles = true;
	        }
		}
		sc.close();
		
		try {
			deleteDirectory(txtFolder);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		outFile = new File(txtFolder + "/" + srtFolder.listFiles()[0].getName().split("\\.")[0] + ".txt");
		
		for (final File file : srtFolder.listFiles()) {
			
			if(!sepFiles) {
				
				try{
					outFile.createNewFile();
			        writer = new FileWriter(outFile.getAbsoluteFile(), true);
			        BufferedWriter bw = new BufferedWriter(writer);
			        bw.write(file.getName().split("\\.")[0] + "\n");
			        bw.close();
			    }
			    catch (IOException e){
			        e.printStackTrace();
			        System.exit(-1);
			    }
			}
			
			else {
				outFile = new File(txtFolder + "/" + file.getName().split("\\.")[0] + ".txt");
							    	
			    try {
					outFile.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				} 
			}
			
			try {
				reader = new BufferedReader(new FileReader("./srt_files/"+file.getName()));
				writer = new FileWriter(outFile.getAbsoluteFile(), true);
		        BufferedWriter bw = new BufferedWriter(writer);
				contentLine = reader.readLine();
		        
				while (contentLine != null) {
					for (int i=0;i<4;i++) {
						switch (i) {
						case 0:
							line = Integer.parseInt(contentLine);
							break;
						case 1:
							break;
						case 2:
							char lst = contentLine.charAt(contentLine.length()-1);
							
							if (lst == '.') {
						        bw.write(contentLine + "\n");
							}
							else {
						        bw.write(contentLine + " ");
							}
							break;
							
						case 3:
							break;
						}
						contentLine = reader.readLine();
					}
				}
				bw.write("\n");
				bw.close();	
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	    }
	}
	
	static void deleteDirectory (File file) throws IOException{
		if (file.isDirectory()){
			for (File sfile : file.listFiles()) {
				if (!sfile.delete()) {
					throw new IOException ("Failed to delete files; " + sfile);
				}
			}
			
		}
		
	}
	
}