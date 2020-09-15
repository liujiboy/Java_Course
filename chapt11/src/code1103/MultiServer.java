/**
 * 
 */
package code1103;

/**
 * MultiServer.java
 * Copyright (c) 2016 ChongQing University All rights reserved.
 */
import java.io.*;
import java.net.*;
public class MultiServer {
   public static void main(String[] args) {
      try{ 
         System.out.println("等待连接");
         ServerSocket serverSocket=new ServerSocket(5500);
         Socket s=null;
         while (true){ 
            //等待客户端的请求
            s=serverSocket.accept();
            //每次请求都启动一个线程来处理
            new ServerThread(s);
         }
      }catch(IOException e){
         e.printStackTrace();
      }
   }
}

