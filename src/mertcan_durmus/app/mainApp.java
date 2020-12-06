package mertcan_durmus.app;

import mertcan_durmus.interfaceimpl.MapInterfaceImpl;
import mertcan_durmus.interfaceimpl.ZoneCounterInterfaceImpl;
import mertcan_durmus.interfaces.MapInterface;
import mertcan_durmus.interfaces.ZoneCounterInterface;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class mainApp {

  private static final Logger LOGGER = Logger.getLogger(mainApp.class.getName());

  public static void main(String[] args) throws Exception {


    Scanner scan = new Scanner(System.in);
    int optionSelect = 0;
    int rows = 0, columns = 0;

    MapInterface mapInterface;
    ZoneCounterInterface zone;

    StringBuilder menu = new StringBuilder("Use default array (1) or read array from file(2) or exit (3)");

    int[][] board = new int[rows][columns];

    final int[][] defaultBoard = {
        {1, 0, 0, 0, 1},
        {1, 1, 1, 1, 1},
        {0, 0, 0, 0, 0},
        {1, 1, 1, 1, 1},
        {0, 1, 0, 0, 1}
    };

    while (optionSelect != 3) {
      System.out.println(menu.toString());
      optionSelect = scan.nextInt();
      if (optionSelect == 3)
        break;

      if (optionSelect == 1) {
        // use default board
        board = new int[defaultBoard.length][defaultBoard[0].length];
        for (int i = 0; i < defaultBoard.length; ++i) {
          for (int j = 0; j < defaultBoard[0].length; ++j) {
            board[i][j] = defaultBoard[i][j];
          }
        }
      } else if (optionSelect == 2) {
        scan.nextLine();
        LOGGER.log(Level.INFO, "PLEASE ENTER ARRAY PATH");
        String path = scan.nextLine();
        LOGGER.log(Level.INFO, "PLEASE ENTER ROW NUMBER IN PATH ARRAY");
        rows = scan.nextInt();
        LOGGER.log(Level.INFO, "PLEASE ENTER COL NUMBER IN PATH ARRAY\"");
        columns = scan.nextInt();
        int[][] myArray = new int[rows][columns];
        Scanner sc = new Scanner(new BufferedReader(new FileReader(path)));
        while (sc.hasNextLine()) {
          for (int i = 0; i < myArray.length; i++) {
            String[] line = sc.nextLine().trim().split(" ");
            for (int j = 0; j < line.length; j++) {
              myArray[i][j] = Integer.parseInt(line[j]);
            }
          }
        }
        board = myArray;
      } else if (optionSelect != 3) {
        LOGGER.log(Level.WARNING, "WRONG OPTION !!!");
        LOGGER.log(Level.INFO, "DEFAULT PROGRAM RUNS !!!");
      }
      MapInterfaceImpl mapInterfaceImpl = new MapInterfaceImpl(board);
      mapInterface = mapInterfaceImpl;
      mapInterface.Show();
      ZoneCounterInterfaceImpl zoneCounterInterfaceImpl = new ZoneCounterInterfaceImpl();
      zoneCounterInterfaceImpl.setZoneMap(board);
      zone = zoneCounterInterfaceImpl;
      zone.Init(mapInterface);
      zone.Solve();
    }
  }
}

