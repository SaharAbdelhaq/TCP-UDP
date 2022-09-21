import java.io.*; 
import java.net.*;
import java.util.Scanner; 
class TCPServer { 
  public static void main(String argv[]) throws Exception 
    { 
      String clientRequest; 
      String result; 
      ServerSocket welcomeSocket = new ServerSocket(9000); 
      
      while(true) { 
            Socket connectionSocket = welcomeSocket.accept(); 
           BufferedReader inFromClient =  new BufferedReader(new InputStreamReader(connectionSocket.getInputStream())); 
           DataOutputStream  outToClient = new DataOutputStream(connectionSocket.getOutputStream()); 

           clientRequest = inFromClient.readLine(); 
           result = findinTCP(clientRequest);
           outToClient.writeBytes(result+'\n'); 
        } 
    }
  
   private static String findinTCP(String clientRequest) throws Exception {
	  File TCP = new File("TCP.txt");
      Scanner analyzier = new Scanner(TCP);
      String response = "Error 404";
      
	 while (analyzier.hasNextLine()) {
	        String data = analyzier.nextLine();
            String a[]= data.split(" ");
            if(a[0].equalsIgnoreCase(clientRequest.trim())) {
            	
            	if(a[1].length()==1) {
            		response=a[1]+" "+a[2];
            		break;
            	}
            	
            	else {
            	response=a[1];
            	break;
            	}
            }
	      }
	return response;
	} 
} 
 
