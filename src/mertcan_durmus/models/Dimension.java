package mertcan_durmus.models;

public class Dimension {

  public int width, height;

  public Dimension(int w, int h) {
    width = w;
    height = h;
  }
  public boolean CheckWithin(int x, int y) {
    return (x >= 0 && x < width && y >= 0 && y < height);
  }

  public int getWidth() {
    return width;
  }

  public void setWidth(int width) {
    this.width = width;
  }

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    this.height = height;
  }
}
