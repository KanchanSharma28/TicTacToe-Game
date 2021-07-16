package com.tictactoegame;

import java.util.Scanner;
public class TicTacToe
{
	private Player player1 , player2;
	private Board board;
	
	
	public static void main(String[] args)
	{
		TicTacToe t = new TicTacToe();
		t.startGame();
	}
	
	
	public void  startGame()
	{
		//Scanner s = new Scanner(System.in);
		// player input
		
		player1 = takePlayerInput(1);
		player2 = takePlayerInput(2);
		Scanner s = new Scanner(System.in);
		
		while(player1.getSymbol() == player2.getSymbol())
		{
			
			System.out.println("Symbol Already taken !! Pick another symbol");
			char symbol = s.next().charAt(0);
			player2.setSymbol(symbol);
		}
		
		// create board
		board = new Board(player1.getSymbol(),player2.getSymbol());
		
		//conduct game
		int status = Board.INCOMPLETE;
		boolean player1Turn = true;
		
		while(status==Board.INCOMPLETE || status==Board.INVALID)
		{
			
			if(player1Turn)
			{
				System.out.println("Player 1 -  " + player1.getName() + "'s turn");
				System.out.println("Enter x : ");
				int x = s.nextInt();
				System.out.println("Enter y : ");
				int y = s.nextInt();
				
				status=board.move(player1.getSymbol(), x, y);
				
				if(status != Board.INVALID)
				{
					player1Turn = false;
					board.print();
				}
			}else
			{
				
				System.out.println("Player 2 -  " + player2.getName() + "'s turn");
				System.out.println("Enter x : ");
				int x = s.nextInt();
				System.out.println("Enter y : ");
				int y = s.nextInt();
				
				status = board.move(player2.getSymbol(), x, y);
				
				if(status != Board.INVALID)
				{
					player1Turn = true;
					board.print();
				}
				else
				{
					System.out.println("Invalid Move !! Try Again !!");
				}
			}
		}
	
	
		if(status==Board.player_1_WINS)
		{
			System.out.println("Player 1 - " + player1.getName() + " WINS !!");
		}
		else if(status==Board.player_2_WINS)
		{
			System.out.println("Player 2 - " + player2.getName() + " WINS !!");
		}
		else
		{
			System.out.println("DRAW !!");
		}
	}
		
	private Player takePlayerInput(int num)
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Enter player " + num + " name : ");
		String name = s.next();
		System.out.println("Enter player " + num + " symbol : ");
		char symbol = s.next().charAt(0);
		
		Player p = new Player(name,symbol);
	    return p;
	}
}