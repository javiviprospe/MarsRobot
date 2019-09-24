package utils.Robot;

public class Position {

    private int x;
    private int y;
    private String orientation;

    public Position(){
        this.x = 0;
        this.y = 0;
    }

    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }

    /***
     * simpler getter
     * @return X
     */
    public int getX(){
        return this.x;
    }
    /***
     * simpler getter
     * @return Y
     */
    public int getY(){
        return this.y;
    }

    /***
     * simpler getter
     * @return orientation
     */
    public String getOrientation(){
        return this.orientation;
    }

    /***
     * simpler setter
     * @param x x coordinate
     */
    public void setX(int x){
        this.x = x;
    }

    /***
     * Simpler setter y
     * @param y y coordinate
     */
    public void setY(int y){
        this.y = y;
    }

    /***
     * Simpler setter orientation
     * @param orientation orientation
     */
    public void setOrientation(String orientation){
        this.orientation = orientation;
    }
}
