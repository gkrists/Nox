package com.github.pedrovgs.nox.path;

/**
 * Linear Path implementation used to place NoxItem objects in a single line in
 * NoxView starting from the left side of the view. NoxItem instances in this path will have the
 * same size.
 *
 * @author Pedro Vicente Gomez Sanchez.
 */
class LinearPath extends Path {

  LinearPath(PathConfig pathConfig) {
    super(pathConfig);
  }

  @Override public void calculate() {
    int numberOfItems = getPathConfig().getNumberOfElements();
    float height = (getPathConfig().getViewHeight() / 2) - (getPathConfig().getFirstItemSize() / 2);

    float itemWidth = getPathConfig().getFirstItemSize();
    float viewMargin = getPathConfig().getFirstItemMargin();
    float x = getFirstItemLeftPosition();

    for (int i = 0; i < numberOfItems; i++) {
      setNoxItemTopPosition(i, height);
      setNoxItemLeftPosition(i, x);
      x += itemWidth + viewMargin;
    }
  }

  protected float getFirstItemLeftPosition() {
    return getPathConfig().getFirstItemMargin();
  }

  @Override public int getMinX() {
    return 0;
  }

  @Override public int getMaxX() {
    int numberOfItems = getPathConfig().getNumberOfElements();
    float itemMargin = getPathConfig().getFirstItemMargin();
    float itemSize = getPathConfig().getFirstItemSize();
    float itemsSize = numberOfItems * (itemSize + itemMargin) + itemMargin;
    return (int) itemsSize - getPathConfig().getViewWidth();
  }
}
