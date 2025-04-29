package object;

import javax.imageio.ImageIO;

public class Obj_wine extends Sobject{

    public Obj_wine(){
        name = "Wine";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/wine.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
