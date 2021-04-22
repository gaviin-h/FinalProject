import java.io.File;
import java.io.IOException;
import java.io.FileWriter;

public class GenerateHTML{
	
	public GenerateHTML(){

	}

	public static void createFile(){
		try{
			File myDir = new File("myDir.html");
		 	if (myDir.createNewFile()) {
        		System.out.println("File created: " + myDir.getName());
      	} else{
			System.out.println("File already exists.");
		}
	} catch(IOException e){
			e.printStackTrace();
		}
	}


	public static void generateHTML(){
		try{

			FileWriter myWriter = new FileWriter("myDir.html");
			myWriter.write("<!DocType html><head></head><body><div id=\"container\"><h1>Directory Contents</h1>");
			myWriter.write("<table class=\"sortable\"><thead><tr><th>Filename</th><th>Type</th><th>Size <small>(bytes)</small></th><th>Date Modified</th></tr></thead><tbody>");
			myWriter.write("<tr class=\"$class\">");
			File directoryPath = new File(".\\");
        //List of all files and directories
        String contents[] = directoryPath.list();
        if(contents == null) {
            System.out.println("Nothing to see...");

        } else {
            System.out.println();
            for (int i = 0; i < contents.length; i++) {
            	myWriter.write("<tr class=\"$class\">");
                	String ext = contents[i].substring(contents[i].lastIndexOf('.') + 1, contents[i].length());
                    myWriter.write("<td><a href=\"" + contents[i] + "\">" + contents[i] +"</a></td>");
                    myWriter.write("<td>" + ext +"</td>");
                	myWriter.write("</tr>");
            }
            
            System.out.println();
        }
        	myWriter.write("</tbody>");
			myWriter.write("</table></div></body></html>");
			myWriter.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}

	}

}