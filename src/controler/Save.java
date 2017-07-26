package controler;
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
    private int warrior;
    private int mage;
    private int archer;
    private static Scanner scan;
     
    
    public Save() {
    }
    
    public Save(int warrior, int mage, int archer) {
    	this.warrior = warrior;
    	this.mage = mage;
    	this.archer = archer;
    }
    
    public void createSave() {
    	try {
    		if (!file.exists()) {
    			file.createNewFile();
    	     	FileWriter fw = new FileWriter(file.getAbsoluteFile());
    	     	BufferedWriter bw = new BufferedWriter(fw);
    	     	//bw.write(dateS);
    	     	bw.write(""+warrior+" ");
    	     	bw.write(""+mage+" ");
    	     	bw.write(""+archer+" ");
    	     	bw.close();
    	     }
    	     else {
    	     	File fold=new File("./save.txt");
    	     	fold.delete();
    	     	
    	     	FileWriter fw = new FileWriter(file.getAbsoluteFile());
    	     	BufferedWriter bw = new BufferedWriter(fw);
    	   		//bw.write(dateS);
    	     	bw.write(""+warrior+" ");
    	     	bw.write(""+mage+" ");
    	     	bw.write(""+archer+" ");
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
          
    public int[] readSaveInt() {
    	int[] result = new int[3];
    	try {
    		scan = new Scanner(file);
    		result[0] = scan.nextInt();
    		result[1] = scan.nextInt();
    		result[2] = scan.nextInt();
    		return result;    		
    		
		} catch (FileNotFoundException e) {
    		result[0] = 0;
    		result[1] = 0;
    		result[2] = 0;
			return result;
		}
    	
    }
}
