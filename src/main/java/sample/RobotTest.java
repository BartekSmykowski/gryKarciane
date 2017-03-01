package sample;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class RobotTest {
    private Robot robot;

    RobotTest(){
        try{
            robot = new Robot();
        } catch(AWTException e){
            e.printStackTrace();
        }
    }

    public void writeWord(){
        int[] text = {KeyEvent.VK_H, KeyEvent.VK_E, KeyEvent.VK_L, KeyEvent.VK_L, KeyEvent.VK_O, KeyEvent.VK_SPACE,
              KeyEvent.VK_W, KeyEvent.VK_O, KeyEvent.VK_R, KeyEvent.VK_L, KeyEvent.VK_D};
        for (int aText : text) {
            robot.keyPress(aText);
            robot.delay(200);
        }
    }


    void click(int times){
        for(int i = 0; i < times; i++){
            robot.mousePress(MouseEvent.BUTTON1_MASK);
            robot.mouseRelease(MouseEvent.BUTTON1_MASK);
            robot.delay(5);
        }
    }

}
