
package Ruben.socket;
import java.net.*;
import java.io.*;
 
public class hola2{
public static void main (String[] args){
 DataInputStream input;
 BufferedInputStream bis;
 BufferedOutputStream bos;
 int in;
 byte[] byteArray;

 final String filename = "D:\\file\\pase.pdf";
 
try{
 final File localFile = new File( filename );
 Socket client = new Socket("localhost", 2020);
 bis = new BufferedInputStream(new FileInputStream(localFile));
 bos = new BufferedOutputStream(client.getOutputStream());

 DataOutputStream dos=new DataOutputStream(client.getOutputStream());
 dos.writeUTF(localFile.getName());

 byteArray = new byte[8192];
 while ((in = bis.read(byteArray)) != -1){
 bos.write(byteArray,0,in);
 }
 
bis.close();
 bos.close();
 
}catch ( Exception e ) {
 System.err.println(e);
 }
 }
}