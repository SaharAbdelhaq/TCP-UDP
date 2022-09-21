import java.io.*; 
import java.net.*; 
public class TCPClient  { 

	public static void main(String argv[]) throws Exception 
    { 
        String sentence; 
        String modifiedSentence;
        
        BufferedReader inFromUser = 
          new BufferedReader(new InputStreamReader(System.in)); 
        while(true) {
        Socket clientSocket = new Socket("192.168.1.52", 9000); 

        DataOutputStream outToServer = 
          new DataOutputStream(clientSocket.getOutputStream()); 

        BufferedReader inFromServer = 
                new BufferedReader(new
                InputStreamReader(clientSocket.getInputStream())); 

              
            	  System.out.println("Test sending a request from user ");
            	  sentence = inFromUser.readLine();

              outToServer.writeBytes(sentence+"\n"); 

              modifiedSentence = inFromServer.readLine(); 
              if(sentence.compareTo("q")==0) {
        		  System.out.println("End system");
        		  break;
    		  }
              System.out.println("FROM SERVER: " + modifiedSentence); 
              clientSocket.close(); }             
          } 
      } 
