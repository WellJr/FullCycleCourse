package io.grpc.examples.helloworld.client;

import example.GreeterGrpc;
import example.HelloReply;
import example.HelloRequest;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GreeterClient {

    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051)
                .usePlaintext()
                .build();

        GreeterGrpc.GreeterBlockingStub stub = GreeterGrpc.newBlockingStub(channel);
        HelloReply response = stub.sayHello(HelloRequest.newBuilder().setName("Mundo").build());

        System.out.println(response.getMessage());
        channel.shutdown();
    }

}
