package object;

import javax.imageio.ImageIO;

public class Obj_golden_door extends Sobject{

    public Obj_golden_door(){
        name = "Golden door";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/golden_door.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        collision = true;
    }
}
