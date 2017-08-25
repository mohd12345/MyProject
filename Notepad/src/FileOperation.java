import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

class FileOperation {
	static String readFile(String path) throws IOException{
		
		FileInputStream fs = new FileInputStream(path);
		BufferedInputStream bi = new BufferedInputStream(fs);
		StringBuffer sb = new StringBuffer();
		
		int singleByte = bi.read(); 
		while(singleByte!=-1){
			sb.append((char)singleByte);
			
			singleByte = bi.read();
		}
		bi.close();
		fs.close();  
		System.out.println(sb.toString());
		return sb.toString();
	}
	static public void writeFile(String data,String path) throws IOException{
		
	FileOutputStream fo = new FileOutputStream(path);
	BufferedOutputStream bo = new BufferedOutputStream(fo);
      bo.write(data.getBytes());
	  bo.close();  
      fo.close();
   }
	

	}
