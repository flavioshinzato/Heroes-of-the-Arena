import java.io.BufferedWriter;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Save {
	private static final DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    private String dateS = (sdf.format(new Date()).toString());
    private File file = new File("./save.txt");
    private int numPersonagens;
    private static Scanner scan;
     
    public Save(/*int numPersonagens*/) {
    	//this.setNumPersonagens(numPersonagens);
    }
    
    public void createSave() {
    	try {
    		if (!file.exists()) {
    			file.createNewFile();
    	     	FileWriter fw = new FileWriter(file.getAbsoluteFile());
    	     	BufferedWriter bw = new BufferedWriter(fw);
    	     	bw.write(dateS);
    	     	//bw.write(numPersonagens);
    	     	bw.close();
    	         	
    	     }
    	     else {
    	     	File fold=new File("./save.txt");
    	     	fold.delete();
    	     	
    	     	FileWriter fw = new FileWriter(file.getAbsoluteFile());
    	     	BufferedWriter bw = new BufferedWriter(fw);
    	   		bw.write(dateS);
    	   		//bw.write(" " + numPersonagens);
    	   		bw.close();
    	   	}

    	} catch (IOException e) {
    			e.printStackTrace();
    	  }
     }
     
    public String readSave() {
    	String result;
    	try {
    		scan = new Scanner(file);
    		result = scan.nextLine();
    		return result;    		
    		
		} catch (FileNotFoundException e) {
			return result = "Não existe save";
		}
    	
    }
     

	public int getNumPersonagens() {
		return numPersonagens;
	}

	public void setNumPersonagens(int numPersonagens) {
		this.numPersonagens = numPersonagens;
	}
     
}
