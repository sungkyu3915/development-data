package com.bit2015.network.echo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.util.Scanner;

public class UDPEchoClient {
	
	private static final String SERVER_IP = "222.106.22.80";
	private static final int SERVER_PORT = 40000;
	private static final int BUFFER_SIZE = 1024;
	
	public static void main(String[] args) {
		
		DatagramSocket datagramSocket = null;
		//Scanner scanner = new Scanner( System.in, "UTF-8" );
		Scanner scanner = new Scanner( System.in, "MS949" );

		try {
			//0. UDP 클라이언트 소켓 생성
			datagramSocket = new DatagramSocket();
				
			while( true ) {
				
				//1. 사용자 입력 받기
				System.out.print( ">>" );
				String message = scanner.nextLine();
				if( "quit".equals( message ) == true ) {
					break;
				}
				
				//2. packet 보내기
				byte[] data = message.getBytes();
				DatagramPacket sendPacket = 
		        new DatagramPacket( data, data.length, new InetSocketAddress( SERVER_IP, SERVER_PORT ) );
				datagramSocket.send( sendPacket );
				
				//3.데이터받기
				DatagramPacket receivePacket = 
				new DatagramPacket( new byte[BUFFER_SIZE], BUFFER_SIZE );
				datagramSocket.receive( receivePacket );
				
				//4.데이터 출력
				message =
				new String( receivePacket.getData(), 0, receivePacket.getLength(), "UTF-8" );
				System.out.println( "<< " + message );
			}
			
			//5.자원 정리
			datagramSocket.close();
			scanner.close();
			
		} catch( IOException ex ) {
			log( "error-" + ex );
		}
	}

	public static void log( String log ) {
		System.out.println( "[udp-echo-client] " + log );
	}
}
