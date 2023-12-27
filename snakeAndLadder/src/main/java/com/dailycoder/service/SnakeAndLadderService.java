package com.dailycoder.service;

import com.dailycoder.model.Board;
import com.dailycoder.model.Ladder;
import com.dailycoder.model.Player;
import com.dailycoder.model.Snake;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SnakeAndLadderService {

    private static int DEFAULTBOARDSIZE = 100;
    private Queue<Player> players;

    private int numberOfPlayers;

    private int size;

    private Board SnakeAndLadderBoard;

    private SnakeAndLadderService(int size) {
        this.SnakeAndLadderBoard = new Board(size);
        this.players = new LinkedList<Player>();
        this.size = size;
    }

    public SnakeAndLadderService() {
        this(DEFAULTBOARDSIZE);
    }

    public void setPlayers(List<Player> players){
        this.numberOfPlayers = players.size();
        HashMap<String, Integer> playerPieces = new HashMap<String, Integer>();
        for (Player p : players) {
            this.players.offer(p);
            playerPieces.put(p.getName(), 0);
        }
        this.SnakeAndLadderBoard.setPlayerPosition(playerPieces);
    }

    public void setSnakes(List<Snake> snakes) {
        this.SnakeAndLadderBoard.setSnakes(snakes);
    }

    public void setLadders(List<Ladder> ladders) {
        this.SnakeAndLadderBoard.setLadders(ladders);
    }

    public void startGame(){
        while (!isGameEnded()){
            int diceVal = getCurrentDiceValues();
            Player currentPlayer = players.poll();
            movePosition(currentPlayer,diceVal);
            if(isPlayerWon(currentPlayer)){
                System.out.println(currentPlayer+" won the game");
                this.SnakeAndLadderBoard.getPlayerPosition().remove(currentPlayer.getName());
            }else {
                this.players.offer(currentPlayer);
            }
        }
    }


    public boolean isGameEnded() {
        return this.players.size() < numberOfPlayers;
    }

    public int getCurrentDiceValues(){
        return DiceService.roll();
    }

    public void movePosition(Player player,int diceValue){

        int currentPostition = this.SnakeAndLadderBoard.getPlayerPosition().get(player.getName());

        int nextPosition = currentPostition + diceValue;

        if(nextPosition > size){
            nextPosition = currentPostition; //do not reach more than 100
        }else {
            nextPosition = getNewPositionWithLaddersAndSnakes(nextPosition);
        }

        this.SnakeAndLadderBoard.getPlayerPosition().put(player.getName(), nextPosition);

        System.out.println("Player " + player.getName() + " moved from position " + currentPostition + " to " + nextPosition);
    }

    public int getNewPositionWithLaddersAndSnakes(int newPosition){

        int nextnewPositon;

        do{
            nextnewPositon = newPosition;

            for(Snake nextSnake:this.SnakeAndLadderBoard.getSnakes()){
                if(nextnewPositon==nextSnake.getStart())
                    nextnewPositon = nextSnake.getEnd();
            }

            for(Ladder ladder:this.SnakeAndLadderBoard.getLadders()){
                if(nextnewPositon==ladder.getStart())
                    nextnewPositon = ladder.getEnd();
            }
        }while (nextnewPositon!=newPosition);

        return nextnewPositon;
    }

    public boolean isPlayerWon(Player player) {
        return this.SnakeAndLadderBoard.getPlayerPosition().get(player.getName()) == size;
    }

}
