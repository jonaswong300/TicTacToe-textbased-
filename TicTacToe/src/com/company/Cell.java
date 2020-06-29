package com.company;

//Class to build object for individual grid of the 3 x 3 board
class Cell{
    public content currentFill; //Contains the content of each fill
    public int row, col;

    Cell(int row, int col){
        this.row = row;
        this.col = col;
    }

    public void clear(){
        currentFill = content.EMPTY;
    }

    //For each state the individual cell is in, output the following based on its state
    public void paint(){
        switch(currentFill){
            case EMPTY:
                System.out.print(" ");
                break;
            case CROSS:
                System.out.print("X");
                break;
            case CIRCLE:
                System.out.print("O");
                break;
        }
    }
}
