package com.lonch.game.service;
 
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.sql.SQLException;
//这里是根据客户端的需求写的响应
//import com.Server_To_Client_Response.Add_File_Response;
//import com.Server_To_Client_Response.Add_User_Response;
//import com.Server_To_Client_Response.Select_User_Response;
public class ServerThread extends Thread {
    //创建与本线程相关的socket
     Socket socket=null;
     ObjectInputStream ois=null;
     //重写构造函数
     public ServerThread(Socket socket){
        this.socket=socket; 
     }
     //线程操作 获取输出流，响应客户端的请求
     @Override
     public void run(){
            try {
                //3.获取输入流，并读取客户端信息
                ois=new ObjectInputStream(socket.getInputStream());
                Object obj=ois.readObject();
                int i=1;
                     /*
                      * 读取接收到的对象信息
                      */
                //available() 方法返回从这个输入流中读取余下的字节数
//                     while( ois.available()!=-1){
                     //输入流读取的信息对象化
//                     ClientToServerInfo ctsi =(ClientToServerInfo)ois.readObject();
//                     System.out.println(ctsi.toString());//打印客户端传到服务器的数据（对象）
//                     /*
//                      * 需要客户端传入的对象数据进行分析，根据传入的sign标志值进行相应的操作
//                      * sign="1"完成注册会员操作，链接数据库，向数据库中user表添加记录
//                      * sign="2"完成会员登录操作，连接数据库，在数据库中user表查询记录
//                      * sign="3"完成文件上传操作，连接数据库，向数据库中file表添加记录
//                      */
//                     //System.out.println(ctsi.sign);
//                     if(ctsi.sign.equals("1")){
//                         //调用 Add_User_Response类的构造方法对客户端传入的信息进行详细的响应
//                         Add_User_Response aur=new Add_User_Response(socket, ctsi.name,ctsi.password_OR_path);
//                        //System.out.println("运行完Add_User_Response类");
//                        break;
//                     }
//                     if(ctsi.sign.equals("2")){
//                         //调用 Select_User_Response类的构造方法对客户端传入的信息进行详细的响应
//                         Select_User_Response sur=new Select_User_Response(socket, ctsi.name,ctsi.password_OR_path);
//                         //System.out.println("运行完 Select_User_Response类");
//                         break;
//                     }
//                     if(ctsi.sign.equals("3")){
//                        //调用  Add_File_Response类的构造方法对客户端传入的信息进行详细的响应
//                         Add_File_Response afr=new Add_File_Response(socket, ctsi.name,ctsi.password_OR_path);
//                        // System.out.println("运行完 Add_File_Response类");
//                         break;
//                     }
//                     }
                    //5.关闭资源
                     ois.close();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
 
     }
 