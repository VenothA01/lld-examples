package com.dailycoder;

import com.dailycoder.model.Board;
import com.dailycoder.model.Ladder;
import com.dailycoder.model.Player;
import com.dailycoder.model.Snake;
import com.dailycoder.service.SnakeAndLadderService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Driver {

    private Board SnakeAndLadderBoard;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int noOfSnakes = sc.nextInt();
        List<Snake> snakes = new ArrayList<>();

        for(int i=0;i<noOfSnakes;++i){
            snakes.add(new Snake(sc.nextInt(), sc.nextInt()));
        }

        int numberOfLadders = sc.nextInt();

        List<Ladder> ladders = new ArrayList<>();

        for(int i=0;i<numberOfLadders;++i){
            ladders.add(new Ladder(sc.nextInt(),sc.nextInt()));
        }

        int numberOfPlayers = sc.nextInt();
        List<Player> players = new ArrayList<>();

        for (int i=0;i<numberOfPlayers;++i){
         players.add(new Player(sc.next()));
        }

        SnakeAndLadderService snakeAndLadderService = new SnakeAndLadderService();
        snakeAndLadderService.setLadders(ladders);
        snakeAndLadderService.setSnakes(snakes);
        snakeAndLadderService.setPlayers(players);
        snakeAndLadderService.startGame();
    }

}
