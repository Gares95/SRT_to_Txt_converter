import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;


public class main {

	public static void main(String[] args){
		BufferedReader reader = null;
		String contentLine;
		int line;
		final File folder = new File("./srt_files");
		for (final File file : folder.listFiles()) {
			System.out.println(file.getName().split("\\.")[0]);
//			System.out.println(file.getName().substring(22, file.getName().length()-13));

			System.out.println("");
			try {
				reader = new BufferedReader(new FileReader("./srt_files/"+file.getName()));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			try {
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
							if (lst == '.')
								System.out.println(contentLine);
							else
								System.out.print(contentLine + " ");
							break;
						case 3:
							break;
						}
						
						contentLine = reader.readLine();
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("");
	    }
		
	}

}