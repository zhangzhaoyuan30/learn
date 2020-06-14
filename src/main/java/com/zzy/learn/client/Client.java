package com.zzy.learn.client;

import com.zzy.learn.thrift.DemoService;
import com.zzy.learn.thrift.Parameter;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

import java.util.Map;

public class Client {
    public static void main(String[] args) throws Exception {
        TSocket socket = new TSocket("127.0.0.1", 9090);
        socket.setTimeout(3000);
        TTransport transport = new TFramedTransport(socket);
        TProtocol protocol = new TCompactProtocol(transport);
        transport.open();
        System.out.println("Connected to Thrfit Server");

        DemoService.Client client = new DemoService.Client.Factory()
                .getClient(protocol);
        int result = client.demoMethod("1", new Parameter(1, "1"), Map.of("num", "1"));
        System.out.println(result);
        Thread.currentThread().join();
    }
}