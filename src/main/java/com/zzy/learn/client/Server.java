package com.zzy.learn.client;

import com.zzy.learn.impl.DemoServiceImpl;
import com.zzy.learn.thrift.DemoService;
import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.server.TNonblockingServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.transport.TNonblockingServerSocket;

public class Server {
    public static void main(String[] args) {
        TNonblockingServerSocket socket;
        try {
            socket = new TNonblockingServerSocket(9090);
            TNonblockingServer.Args options = new TNonblockingServer.Args(socket);
            TProcessor processor = new DemoService.Processor<DemoService.Iface>(new DemoServiceImpl());
            options.processor(processor);
            options.protocolFactory(new TCompactProtocol.Factory());
            TServer server = new TNonblockingServer(options);
            System.out.println("Thrift Server is running at 9090 port");
            server.serve();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
