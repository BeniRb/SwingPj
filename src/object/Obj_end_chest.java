package object;

import javax.imageio.ImageIO;

public class Obj_end_chest extends Sobject{

    public Obj_end_chest(){
        name = "End chest";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/end_chest.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
