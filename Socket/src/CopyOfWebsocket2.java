import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import org.codehaus.jackson.map.ObjectMapper;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketError;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;

@WebSocket
public class CopyOfWebsocket2 {
	public static int j=0;
	public static InetAddress ip=null;
    File file = new File("C:\\Users\\Aditya\\Documents\\NetBeansProjects\\Demo_code\\TV_like.csv");
	@OnWebSocketClose
    public void onClose(int statusCode, String reason) {
    	//check=1;
        System.out.println("Close: statusCode=" + statusCode + ", reason=" + reason);
        //i=0;
        j=0;
    }
	@OnWebSocketError
    public void onError(Throwable t) {
        System.out.println("Error: " + t.getMessage());
    }
	 @OnWebSocketMessage
	    public void onText(Session session,String message) throws IOException {
	    	System.out.println(message);
	    
	       InetAddress ip1=session.getRemoteAddress().getAddress();
	      String h=ip1.toString();
	      System.out.println(h);
	      BufferedWriter out = new BufferedWriter(new FileWriter
	    	         ("C:\\Users\\Aditya\\Documents\\NetBeansProjects\\Demo_code\\TV_like.csv",true));
	    	         out.write(message+"\n");
	    	         out.close();

			// if file doesnt exists, then create it
//			if (!file.exists()) {
//				file.createNewFile();
//			}
//
//			FileWriter fw = new FileWriter(file.getAbsoluteFile());
//			BufferedWriter bw = new BufferedWriter(fw);
//			bw.write(message);
//			bw.close();

	    	
	    }
	 @OnWebSocketConnect
	    public void onConnect(Session session) throws IOException {
	    	
	        System.out.println("Connect: " + session.getRemoteAddress().getAddress());
	         ip=session.getRemoteAddress().getAddress();
	        // ip.sendmessage("NO");
	        // Session.sendMessage("NO");
	     
	         String h=ip.toString();
//	         PrintWriter writer = new PrintWriter("the-file-name.txt", "UTF-8");
//	         writer.println("The first line");
//	         writer.println("The second line");
//	         writer.close();
//	        if((!"/192.168.0.18".equals(h))){
//	         session.getRemote().sendString("Start");
//	      // To connect to mongodb server
//	         MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
//	         // Now connect to your databases
//	         DB db = mongoClient.getDB( "test" );
//		 System.out.println("Connect to database successfully");
////	         boolean auth = db.authenticate(myUserName, myPassword);
////		 System.out.println("Authentication: "+auth);
//	         DBCollection coll = db.getCollection("mycollection");
//	         System.out.println("Collection mycollection created successfully");
//	       }
//	         else
//	         {
//	        	 session.getRemote().sendString("Stop");
//	        }
    }
	   
}
