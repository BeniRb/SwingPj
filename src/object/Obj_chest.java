package object;

import javax.imageio.ImageIO;

public class Obj_chest extends Sobject{

    public Obj_chest(){
        name = "Chest";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/chest.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
