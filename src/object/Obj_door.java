package object;

import javax.imageio.ImageIO;

public class Obj_door extends Sobject{

    public Obj_door(){
        name = "Door";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/door.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
