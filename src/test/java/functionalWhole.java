import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import utils.Robot;

public class functionalWhole {

    @Test
    public void setRobot1(){
        Robot robot = new Robot();
        robot.setPositionBoundaries(5,3).setPositionCurrent(1,1).setOrientation("E").changeOrientation("R")
            .moveOneStep().changeOrientation("R").moveOneStep().changeOrientation("R").moveOneStep().changeOrientation("R").moveOneStep();

        System.out.println("Moved "+robot.getPosition()+" Lost? "+robot.isOutOfGrid()+" Position "+robot.getOrientation());
        assertEquals(robot.getPosition(),"1 1");
        assertEquals(robot.isOutOfGrid(),false);
        assertEquals(robot.getOrientation(),"E");
    }
    @Test
    public void setRobot2(){
        Robot robot = new Robot();
        robot.setPositionBoundaries(5,3).setPositionCurrent(3,2).setOrientation("N").moveOneStep().changeOrientation("R")
            .changeOrientation("R").moveOneStep().changeOrientation("L").changeOrientation("L").moveOneStep()
            .moveOneStep()
            .changeOrientation("R").changeOrientation("R").moveOneStep().changeOrientation("L").changeOrientation("L");


        System.out.println("Moved "+robot.getPosition()+" Lost? "+robot.isOutOfGrid()+" Position "+robot.getOrientation());
        assertEquals(robot.getPosition(),"3 3");
        assertEquals(robot.isOutOfGrid(),true);
        assertEquals(robot.getOrientation(),"N");
    }
    @Test
    public void setRobot3(){
        Robot robot = new Robot();
        robot.setPositionBoundaries(5,3).setPositionCurrent(0,3).setPositionScent(2,3).setOrientation("W").changeOrientation("L")
            .changeOrientation("L").moveOneStep().moveOneStep().moveOneStep().changeOrientation("L").moveOneStep()
            .changeOrientation("L").moveOneStep().changeOrientation("L");
        System.out.println("Moved "+robot.getPosition()+" Lost? "+robot.isOutOfGrid()+" Position "+robot.getOrientation());
        assertEquals(robot.getPosition(),"2 3");
        assertEquals(robot.isOutOfGrid(),false);
        assertEquals(robot.getOrientation(),"S");
    }



}
