package mertcan_durmus.interfaceimpl;


import mertcan_durmus.models.Dimension;
import mertcan_durmus.interfaces.MapInterface;
import mertcan_durmus.interfaces.ZoneCounterInterface;

public class ZoneCounterInterfaceImpl implements ZoneCounterInterface {

  int[][] zoneMap;
  int x = 0;
  int y = 0;
  Dimension dimension = new Dimension(x, y);
  int zoneCount = 0;
  MapInterfaceImpl mapObj;

  public ZoneCounterInterfaceImpl() {
  }

  @Override
  public void Init(MapInterface map) throws Exception {
    this.mapObj = new MapInterfaceImpl(zoneMap);

    //we use call by value for map sizes as this.x and this.y
    map.GetSize(dimension);
    this.x = dimension.getWidth();
    this.y = dimension.getHeight();
  }

  @Override
  public int Solve() throws Exception {
    for (int i = 0; i < x; i++) {
      for (int j = 0; j < y; j++) {
        if (mapObj.IsBorder(i,j)) {
          if (areaCheck(i, j) >= 1) {
            zoneCount++;
          }
        }
      }
    }
    System.out.println(zoneCount);
    return zoneCount;
  }

  private int areaCheck(int x, int y) {
    if (!dimension.CheckWithin(x,y))
      return 0;
    if ((mapObj.board[y][x] == 1) || (mapObj.board[y][x] == 2)) {
      return 0;
    }
    mapObj.board[y][x] = 2;
    // check all directions
    int areaSize = 1 + areaCheck(x, y - 1) + areaCheck(x, y + 1) + areaCheck(x - 1, y) + areaCheck(x + 1, y);
    return areaSize;
  }

  public void setZoneMap(int[][] zoneMap) {
    this.zoneMap = zoneMap;
  }
}

