package mertcan_durmus.interfaceimpl;

import mertcan_durmus.models.Dimension;
import mertcan_durmus.interfaces.MapInterface;

public class MapInterfaceImpl implements MapInterface {

  int[][] board;

  public MapInterfaceImpl(int[][] board) {
    this.board = board;
  }

  @Override
  public void SetSize(Dimension dim) {
  }

  @Override
  public void GetSize(Dimension dim) {
    dim.height = board.length;
    dim.width = board[0].length;
  }

  @Override
  public void SetBorder(int x, int y) throws Exception {
    board[y][x] = 1;
  }

  @Override
  public void ClearBorder(int x, int y) throws Exception {
    board[y][x] = 0;
  }

  @Override
  public boolean IsBorder(int x, int y) throws Exception {
    if (board[y][x] == 0) {
      return true;
    } else {
      return false;
    }
  }

  @Override
  public void Show() {
    for (int i = 0; i < board.length; i++)
    {
      for (int j = 0; j < board[i].length; j++)
      {
        System.out.print(board[i][j]);
      }
      System.out.println();
    }
  }



  public int[][] getBoard() {
    return board;
  }

  public void setBoard(int[][] board) {
    this.board = board;
  }
}
