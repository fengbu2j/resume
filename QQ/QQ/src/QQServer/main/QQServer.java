package QQServer.main;

import common.Message;
import common.MessageType;
import common.User;
import QQServer.server.ManageServerConnectClientThread;
import QQServer.server.ServerConnectClientThread;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ConcurrentHashMap;

public class QQServer {
    ServerSocket serverSocket;
    //模拟用户数据库
    private static ConcurrentHashMap<String, User> userMap = new ConcurrentHashMap<>();

    static {
        userMap.put("123", new User("123", "123"));
        userMap.put("tom", new User("tom", "123"));
        userMap.put("捉妖龙", new User("捉妖龙", "123"));
    }

    public static void main(String[] args) {
        new QQServer();
    }
    public QQServer() {
        try {
            System.out.println("在端口9999监听");
            serverSocket = new ServerSocket(9999);
            while (true) {
                Socket socket = serverSocket.accept();
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                User user = (User) ois.readObject();
                //构建一个Message对象，准备回复
                Message message = new Message();
                //验证账号密码是否正确
                if (isUser(user.getUserId(), user.getPasswd())) {
                    message.setMessageType(MessageType.MESSAGE_LOGIN_SUCCESS);
                    oos.writeObject(message);
                    ServerConnectClientThread thread = new ServerConnectClientThread(socket, user.getUserId());
                    thread.start();
                    ManageServerConnectClientThread.addThread(user.getUserId(), thread);
                    ManageServerConnectClientThread.sendOffLineMessage(user.getUserId(), oos);
                } else {
                    message.setMessageType(MessageType.MESSAGE_LOGIN_FAIL);
                    oos.writeObject(message);
                    socket.close();
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static ConcurrentHashMap<String, User> getUserMap() {
        return userMap;
    }

    public boolean isUser(String userId, String pw) {
        User user = userMap.get(userId);
        //没有这个用户
        if (user == null) {
            return false;
        }
        //密码不正确
        if (!user.getPasswd().equals(pw)) {
            return false;
        }
        return true;
    }

    public static boolean isUser(String userId) {
        User user = userMap.get(userId);
        if (user == null) {
            return false;
        }
        return true;
    }
}
