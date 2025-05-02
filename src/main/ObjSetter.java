package main;

import object.*;

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

        gp.obj[2] = new Obj_door();
        gp.obj[2].worldX = 45 *gp.tileSize;
        gp.obj[2].worldY = 29 *gp.tileSize;

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

        gp.obj[7] = new Obj_golden_key();
        gp.obj[7].worldX = 40 *gp.tileSize;
        gp.obj[7].worldY = 11 *gp.tileSize;

        gp.obj[8] = new Obj_golden_door();
        gp.obj[8].worldX = 15 *gp.tileSize;
        gp.obj[8].worldY = 45 *gp.tileSize;

        gp.obj[9] = new Obj_key();
        gp.obj[9].worldX = 28 *gp.tileSize;
        gp.obj[9].worldY = 43 *gp.tileSize;

        gp.obj[10] = new Obj_door();
        gp.obj[10].worldX = 14 *gp.tileSize;
        gp.obj[10].worldY = 8 *gp.tileSize;

        gp.obj[11] = new Obj_end_chest();
        gp.obj[11].worldX = 15 *gp.tileSize;
        gp.obj[11].worldY = 47 *gp.tileSize;

        gp.obj[12] = new Obj_key();
        gp.obj[12].worldX = 13 *gp.tileSize;
        gp.obj[12].worldY = 29 *gp.tileSize;

        gp.obj[13] = new Obj_golden_key();
        gp.obj[13].worldX = 19 *gp.tileSize;
        gp.obj[13].worldY = 47 *gp.tileSize;
   }
}
