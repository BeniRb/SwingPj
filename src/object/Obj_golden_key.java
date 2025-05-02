package object;

import javax.imageio.ImageIO;

public class Obj_golden_key extends Sobject{

    public Obj_golden_key(){
        name = "Golden key";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/golden_key.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
