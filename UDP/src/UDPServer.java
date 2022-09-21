import java.io.*; 
import java.net.*;
import java.util.Scanner; 
  
class UDPServer { 
  public static void main(String args[]) throws Exception 
    { 
  
      DatagramSocket serverSocket = new DatagramSocket(9000); 
  
      byte[] receiveData = new byte[1024]; 
      byte[] sendData  = new byte[1024]; 
  
      while(true) 
        { 
  
          DatagramPacket receivePacket = 
             new DatagramPacket(receiveData, receiveData.length); 
           serverSocket.receive(receivePacket); 

           String sentence = new String(receivePacket.getData()); 
   
           InetAddress IPAddress = receivePacket.getAddress(); 
   
           int port = receivePacket.getPort(); 
   
                       String Result = findinUDP(sentence); 

           sendData = Result.getBytes(); 
   
           DatagramPacket sendPacket = 
              new DatagramPacket(sendData, sendData.length, IPAddress, 
                                port); 
   
           serverSocket.send(sendPacket); 
         } 
     }
  private static String findinUDP(String clientRequest) throws Exception {
	  File UDP = new File("UDP.txt");
      Scanner analyzier = new Scanner(UDP);
      String response = "Error 404";
	 while (analyzier.hasNextLine()) {
	        String data = analyzier.nextLine();
            String a[]= data.split(" ");
            if(a[0].equalsIgnoreCase(clientRequest.trim())) {
            	if(a[1].length()==1) {
            		response=a[1]+" "+a[2] ;break;
            	}else {
            	response=a[1] ;break;}}
	      }
	return response;} 
 }  
