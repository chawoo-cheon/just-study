package main

import(
	"log"
	"net"

	"google.golang.org/grpc"
)

const portNumber = "9000"

func main(){
	lis, err := net.Listen("tcp",":"+portNumber)
	if err != nil {
		log.Fatalf("failed to Listen : %v",err)
	}

	grpcServer := grpc.NewServer()

	log.Printf("start gRpc Server On %s port", portNumber)
	if err := grpcServer.Serve(lis); err != nil {
		log.Fatalf("failed to serve : %s",err)
	}

}
