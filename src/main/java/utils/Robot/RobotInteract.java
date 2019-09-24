package utils.Robot;

public class RobotInteract {

    private int positionX;
    private int positionY;
    private int dimensionGridX;
    private int dimensionGridY;
    private final int maxDimension = 50;
    private boolean isLost;

    public RobotInteract(int x, int y, int dimensionX, int dimensionY){
        this.positionX = x;
        this.positionY = y;
        this.dimensionGridX = dimensionX;
        this.dimensionGridY = dimensionY;
        this.isLost = false;

    }

    /***
     * Set the position and ensure it fits the boundaries
     * @param x coordinate to set
     * @param y coordinate to set
     * @return true : position set OK || false : unable to set
     */
    public boolean setPosition(int x, int y){
        if (x<=this.dimensionGridX&&y<=this.dimensionGridY) {
            this.positionX = x;
            this.positionY = y;
            return true;
        }else
            return false;
    }



}
