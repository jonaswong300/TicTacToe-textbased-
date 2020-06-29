package com.company;

import java.util.Scanner;

//Enum class to contain content of each cell grid
enum content{
    EMPTY, CROSS, CIRCLE
}

//Enum class to contain state of game
enum gameState{
    PLAYING, DRAW, CROSS_WON, CIRCLE_WON
}

//Driver class to run game
class ticTaeToe{

    Board board;
    public gameState currentState;
    public content currentPlayer;

    private static Scanner input = new Scanner(System.in);

    //Constructor to initialise game
    ticTaeToe(){
        board = new Board();
        initialiseGame();

        //Do while loop to continuing running so long as game state has not been won by either players
        //Exit loop only if one player has won. !gamestate.playing
        do{
            playerMovement(currentPlayer);
            board.paint();
            updateGame(currentPlayer);

            //If game has been win, update current state and exit loop
            if(currentState == gameState.CROSS_WON){
                System.out.println("Player X has won the game of Tic Tae Toe.");
            }else if(currentState == gameState.CIRCLE_WON){
                System.out.println("Player O has won the game of Tic Tae Toe.");
            }else if(currentState == gameState.DRAW){
                System.out.println("Both player has reach a draw in the game of Tic Tae Toe.");
            }

            //Swap players
            currentPlayer = (currentPlayer == content.CROSS) ? content.CIRCLE : content.CROSS;

        }while(currentState == gameState.PLAYING);
    }

    //Initialise Board
    //Initialise starting player
    //Initialise starting state to playing
    public void initialiseGame(){
        board.initialise();
        currentPlayer = content.CROSS;
        currentState = gameState.PLAYING;
    }

    //Track player movement and receive their moves
    public void playerMovement(content c){
        boolean validMovement = false;

        do{
            if(c == content.CROSS){
                System.out.println("Player X, Enter your move (row[1 - 3], col[1 - 3])");
            }else if(c == content.CIRCLE){
                System.out.println("Player O, Enter your move (row[1 - 3], col[1 - 3])");
            }

            int row = input.nextInt() - 1;
            int col = input.nextInt() - 1;

            //If input matches assign and track position of row and col
            //Set cell content
            if(row >= 0 && row < board.ROW &&
                    col >= 0 && col < board.COL &&
                    board.grid[row][col].currentFill == content.EMPTY){
                board.grid[row][col].currentFill = c;
                board.currentRow = row;
                board.currentCol = col;
                validMovement = true;
            }else{
                System.out.println("Unable to make move at row: " + (row + 1) + " col: " + (col + 1));
            }


        }while(!validMovement);
    }

    //Update and check if game has been won or reach a draw
    public void updateGame(content c){
        if(board.hasWon(c)){
            currentState = (c == content.CROSS) ? gameState.CROSS_WON : gameState.CIRCLE_WON;
        }else if(board.isDraw()){
            currentState = gameState.DRAW;
        }
    }
}