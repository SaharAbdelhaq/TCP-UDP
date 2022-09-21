import java.io.*; 
import java.net.*; 
  
class UDPClient { 
    public static void main(String args[]) throws Exception 
    { 
      BufferedReader inFromUser = 
        new BufferedReader(new InputStreamReader(System.in)); 
      
      DatagramSocket clientSocket = new DatagramSocket(); 
      
      InetAddress IPAddress = InetAddress.getByName("192.168.1.52"); 
      String sentence;
      
      byte[] sendData = new byte[1024]; 
      byte[] receiveData = new byte[1024]; 
      while(true) {
	  clientSocket = new DatagramSocket();
	  
		  System.out.println("Test Sending a request from user");
		  sentence = inFromUser.readLine();
		  if(sentence.compareTo("q")==0) {
			  System.out.println("End system");
			  break;
		  }
          

      sendData = sentence.getBytes();         
      DatagramPacket sendPacket = 
    	         new DatagramPacket(sendData, sendData.length, IPAddress, 9000); 
    	  
    	      clientSocket.send(sendPacket); 
    	  
    	      DatagramPacket receivePacket = 
    	         new DatagramPacket(receiveData, receiveData.length); 
    	  
    	      clientSocket.receive(receivePacket); 
    	  
    	      String modifiedSentence = 
    	          new String(receivePacket.getData()); 
    	  
    	      System.out.println("FROM SERVER:" + modifiedSentence); 
    	      clientSocket.close(); 
    	      } }
    	} 
