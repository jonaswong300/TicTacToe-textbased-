package com.company;

//Class to construct the 3 x 3 board for the game
class Board{
    Cell [][] grid;                    //2D array of individual cells to form the grid
    public int currentRow, currentCol; //Hold information on current row and col
    public final int ROW = 3, COL = 3; //Final value for row and col

    //Constructor
    Board(){
        //Initialise grid
        grid = new Cell[ROW][COL];

        //Initialise individual cell within grid
        for(int row = 0; row < ROW; row++){
            for(int col = 0; col < COL; col++){
                grid[row][col] = new Cell(row, col);
            }
        }
    }

    public void initialise(){
        for(int row = 0; row < ROW; row++){
            for(int col = 0; col < COL; col++){
                grid[row][col].clear();
            }
        }
    }

    //Function returns boolean to see if result is a tie/draw
    public boolean isDraw(){
        for(int row = 0; row < ROW; row++){
            for(int col = 0; col < COL; col++){
                if(grid[row][col].currentFill == content.EMPTY){
                    return false;
                }
            }
        }
        return true;
    }

    //Function returns boolean to see if any player has won the game
    public boolean hasWon(content c){
        return (grid[currentRow][0].currentFill == c && //Check Row
                grid[currentRow][1].currentFill == c &&
                grid[currentRow][2].currentFill == c ||
                grid[0][currentCol].currentFill == c && //Check Column
                        grid[1][currentCol].currentFill == c &&
                        grid[2][currentCol].currentFill == c ||
                grid[0][0].currentFill == c &&          //Check diagonal \
                        grid[1][1].currentFill == c &&
                        grid[2][2].currentFill == c ||
                grid[2][2].currentFill == c &&          //Check diagonal /
                        grid[1][1].currentFill == c &&
                        grid[0][2].currentFill == c);
    }

    //Paint/display the 3x3 grid of tictaetoe game
    public void paint(){
        for(int x = 0; x < ROW; x++){
            for(int y = 0; y < COL; y++){
                grid[x][y].paint();

                if(y < COL - 1)
                    System.out.print(" | ");
            }
            System.out.println();
            if(x < ROW - 1)
                System.out.println("---------");
        }
    }


}