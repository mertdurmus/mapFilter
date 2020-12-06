package mertcan_durmus.interfaces;

import mertcan_durmus.models.Dimension;

public interface MapInterface {

  void SetSize(Dimension dim);
  // Get dimensions of given map.
  void GetSize(Dimension dim);
  // Sets border at given point.
  void SetBorder(int x, int y) throws Exception;
  // Clears border at given point.
  void ClearBorder(int x, int y) throws Exception;
  // Checks if given point is border.
  boolean IsBorder(int x, int y) throws Exception;
  // Show map contents.
  void Show();
}
