import java.util.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Stack;

public class ImageLabeler {	
	
    final static String CR = "\r";
    final static String LF = "\n";
    String label1,label2,label3;
    String command;
    Socket clientSocket;
    ServerSocket serverSocket;
    OutputStreamWriter outToServer;
    
    public ImageLabeler( String host, int controlPort){
        try {
            clientSocket = new Socket(host, controlPort);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    
    public void sendStringToPort(String str){
        try {
            outToServer = new OutputStreamWriter(clientSocket.getOutputStream(), "US-ASCII");
            outToServer.write(str, 0, str.length());
            outToServer.flush();

            InputStreamReader inputStreamReader =
                    new InputStreamReader(clientSocket.getInputStream());
            BufferedReader bufferedReader =
                    new BufferedReader(inputStreamReader);

            System.out.println(bufferedReader.readLine());
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    
    public void sendStringToPort2(String str){
        try {
            outToServer = new OutputStreamWriter(clientSocket.getOutputStream(), "US-ASCII");
            outToServer.write(str, 0, str.length());
            outToServer.flush();
           
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    
    public void sendStringToPort3(String str){
        try {
            outToServer = new OutputStreamWriter(clientSocket.getOutputStream(), "US-ASCII");
            outToServer.write(str, 0, str.length());
            outToServer.flush();

            InputStreamReader inputStreamReader =
                    new InputStreamReader(clientSocket.getInputStream());
            BufferedReader bufferedReader =
                    new BufferedReader(inputStreamReader);

            System.out.println(bufferedReader.readLine());
            
        } catch (IOException e){
            e.printStackTrace();
        }
    }    
    
    public void readImage(int index){
        try {
            InputStream is = clientSocket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            
            
	        byte[] string1 = new byte[4];
	        is.read(string1);
	        String s1 = new String(string1, StandardCharsets.US_ASCII);
	        System.out.print(s1 + " ");
	            
	            
	        byte[] size = new byte[3];
	        is.read(size);	
	        
	        int sho = (size[0] & 0xff) << 16 | (size[1] & 0xff) << 8 | (size[2] & 0xff);
	        System.out.println("length of image" + index +"= "+sho);
	
	        byte[] image = new byte[sho];
	        is.read(image);
	        putLabel(index,image);
	        
	        File imageFile = new File("received"+ index +".jpg");
	        OutputStream os = new FileOutputStream(imageFile);
	        os.write(image);
	        os.close();	      
	      

        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    
    public void putLabel(int index, byte[] image) throws IOException {
    	File bear1 = new File("bear1.jpg");
		byte[] bear1byt = Files.readAllBytes(bear1.toPath());
		
		File bear2 = new File("bear2.jpg");
		byte[] bear2byt = Files.readAllBytes(bear2.toPath());
		
		File bear3 = new File("bear3.jpg");
		byte[] bear3byt = Files.readAllBytes(bear3.toPath());
		
		File cat1 = new File("cat1.jpg");
		byte[] cat1byt = Files.readAllBytes(cat1.toPath());
		
		File cat2 = new File("cat2.jpg");
		byte[] cat2byt = Files.readAllBytes(cat2.toPath());
		
		File cat3 = new File("cat3.jpg");
		byte[] cat3byt = Files.readAllBytes(cat3.toPath());
		
		File dog1 = new File("dog1.jpg");
		byte[] dog1byt = Files.readAllBytes(dog1.toPath());

		File dog2 = new File("dog2.jpg");
		byte[] dog2byt = Files.readAllBytes(dog2.toPath());
		
		File dog3 = new File("dog3.jpg");
		byte[] dog3byt = Files.readAllBytes(dog3.toPath());
		
		File shark1 = new File("shark1.jpg");
		byte[] shark1byt = Files.readAllBytes(shark1.toPath());
		
		File shark2 = new File("shark2.jpg");
		byte[] shark2byt = Files.readAllBytes(shark2.toPath());
		
		File shark3 = new File("shark3.jpg");
		byte[] shark3byt = Files.readAllBytes(shark3.toPath());
    	
    	
    	if(index == 1) {
    		if(image.length == bear1byt.length)
    			label1 = "bear";
    		if(image.length == bear2byt.length)
    			label1 = "bear";
    		if(image.length == bear3byt.length)
    			label1 = "bear";
    		if(image.length == cat1byt.length)
    			label1 = "cat";
    		if(image.length == cat2byt.length)
    			label1 = "cat";
    		if(image.length == cat3byt.length)
    			label1 = "cat";
    		if(image.length == dog1byt.length)
    			label1 = "dog";
    		if(image.length == dog2byt.length)
    			label1 = "dog";
    		if(image.length == dog3byt.length)
    			label1 = "dog";
    		if(image.length == shark1byt.length)
    			label1 = "shark";
    		if(image.length == shark2byt.length)
    			label1 = "shark";
    		if(image.length == shark3byt.length)
    			label1 = "shark";
		}
    	
    	if(index == 2) {
    		if(image.length == bear1byt.length)
    			label2 = "bear";
    		if(image.length == bear2byt.length)
    			label2 = "bear";
    		if(image.length == bear3byt.length)
    			label2 = "bear";
    		if(image.length == cat1byt.length)
    			label2 = "cat";
    		if(image.length == cat2byt.length)
    			label2 = "cat";
    		if(image.length == cat3byt.length)
    			label2 = "cat";
    		if(image.length == dog1byt.length)
    			label2 = "dog";
    		if(image.length == dog2byt.length)
    			label2 = "dog";
    		if(image.length == dog3byt.length)
    			label2 = "dog";
    		if(image.length == shark1byt.length)
    			label2 = "shark";
    		if(image.length == shark2byt.length)
    			label2 = "shark";
    		if(image.length == shark3byt.length)
    			label2 = "shark";
		}
    	
    	if(index == 3) {
    		if(image.length == bear1byt.length)
    			label3 = "bear";
    		if(image.length == bear2byt.length)
    			label3 = "bear";
    		if(image.length == bear3byt.length)
    			label3 = "bear";
    		if(image.length == cat1byt.length)
    			label3 = "cat";
    		if(image.length == cat2byt.length)
    			label3 = "cat";
    		if(image.length == cat3byt.length)
    			label3 = "cat";
    		if(image.length == dog1byt.length)
    			label3 = "dog";
    		if(image.length == dog2byt.length)
    			label3 = "dog";
    		if(image.length == dog3byt.length)
    			label3 = "dog";
    		if(image.length == shark1byt.length)
    			label3 = "shark";
    		if(image.length == shark2byt.length)
    			label3 = "shark";
    		if(image.length == shark3byt.length)
    			label3 = "shark";
		}
    }
    
    // Commands
    public void sendUserName(String username){
        command = "USER" + " " + username + CR + LF;
        sendStringToPort(command);
    }
    public void sendPass(String password){
        command = "PASS" + " " + password + CR + LF;
        sendStringToPort(command);
    }
    
    public void IGET(){        
        command = "IGET" + CR + LF;
        sendStringToPort2(command); 
        readImage(1);
        readImage(2);
        readImage(3);        

    }
    public void ILBL(){
    	String combine = label1+","+label2+","+label3;
    	System.out.println(combine);
        command = "ILBL"+ " "+ combine + CR + LF;
        sendStringToPort3(command);        
    }
    public void EXIT(){
        command = "EXIT" + CR + LF;
        sendStringToPort(command);
    } 

	public static void main(String[] args) {			
	   
       ImageLabeler sckt = new ImageLabeler(args[0], Integer.parseInt(args[1]));       
       
       try{
    	   sckt.sendUserName("bilkentstu");
    	   sckt.sendPass("cs421f2019");           
    	   sckt.IGET();
    	   sckt.ILBL();    	  
    	   sckt.EXIT();
       }catch (Exception ioe){
           ioe.printStackTrace();
           System.out.println("Connection Failure");
       } 
	}
}