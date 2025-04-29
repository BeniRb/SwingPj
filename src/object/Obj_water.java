package object;

import javax.imageio.ImageIO;

public class Obj_water extends Sobject{
    public Obj_water(){
        name = "Water";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/water.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
