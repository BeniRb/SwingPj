package object;

import javax.imageio.ImageIO;
import java.io.File;

public class Obj_key extends Sobject{

    public Obj_key(){
        name = "Key";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/key.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
