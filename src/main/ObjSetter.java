package main;

import object.Obj_door;
import object.Obj_key;
import object.Obj_water;
import object.Obj_wine;

public class ObjSetter {

    GamePanel gp;

    public ObjSetter(GamePanel gp) {
        this.gp = gp;

    }

    public void setObj() {
        gp.obj[0] = new Obj_key();
        gp.obj[0].worldX = 34 *gp.tileSize;
        gp.obj[0].worldY = 25 *gp.tileSize;

        gp.obj[1] = new Obj_key();
        gp.obj[1].worldX = 40 *gp.tileSize;
        gp.obj[1].worldY = 37 *gp.tileSize;

//        gp.obj[2] = new Obj_door();
//        gp.obj[2].worldX = 43 *gp.tileSize;
//        gp.obj[2].worldY = 33 *gp.tileSize;

        gp.obj[3] = new Obj_door();
        gp.obj[3].worldX = 31 *gp.tileSize;
        gp.obj[3].worldY = 26 *gp.tileSize;

        gp.obj[4] = new Obj_door();
        gp.obj[4].worldX = 17 *gp.tileSize;
        gp.obj[4].worldY = 29 *gp.tileSize;

        gp.obj[5] = new Obj_wine();
        gp.obj[5].worldX = 17 *gp.tileSize;
        gp.obj[5].worldY = 27 *gp.tileSize;

        gp.obj[6] = new Obj_water();
        gp.obj[6].worldX = 28 *gp.tileSize;
        gp.obj[6].worldY = 19 *gp.tileSize;
   }
}
