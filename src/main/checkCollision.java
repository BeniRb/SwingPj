package main;

import entity.Entity;

public class checkCollision {

    GamePanel gp;

    public checkCollision(GamePanel gp) {
        this.gp= gp;
    }
// this method will check which tiles should collide with the player and also make them collide with the player
    public void checkTiles(Entity entity){

        int entityLeftWorldX = entity.worldX + entity.solidArea.x;
        int entityRightWorldX = entity.worldX + entity.solidArea.x + entity.solidArea.width;
        int entityTopWorldY = entity.worldY + entity.solidArea.y;
        int entityBottomWorldY = entity.worldY + entity.solidArea.y + entity.solidArea.height;

        int entityLeftCol= entityLeftWorldX / gp.tileSize;
        int entityRightCol= entityRightWorldX / gp.tileSize;
        int entityTopRow = entityTopWorldY / gp.tileSize;
        int entityBottomRow= entityBottomWorldY / gp.tileSize;

        int tileNum1, tileNum2;
        //tilenum1 is top, tilenum2 is bottom
//here i check collision for right and left shoulder
        switch(entity.direction) {
            case "up":
                entityTopRow = (entityTopWorldY - entity.speed) / gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
                if(gp.tileM.tiles[tileNum1].collision || gp.tileM.tiles[tileNum2].collision){
                    entity.isCollided = true;
                }
                break;
            case "down":
                entityBottomRow = (entityBottomWorldY + entity.speed) / gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
                if(gp.tileM.tiles[tileNum1].collision || gp.tileM.tiles[tileNum2].collision){
                    entity.isCollided = true;
                }
                break;
            case "left":
                entityLeftCol = (entityLeftWorldX - entity.speed) / gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
                if(gp.tileM.tiles[tileNum1].collision || gp.tileM.tiles[tileNum2].collision){
                    entity.isCollided = true;
                }
                break;
            case "right":
                entityRightCol = (entityRightWorldX + entity.speed) / gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
                if(gp.tileM.tiles[tileNum1].collision || gp.tileM.tiles[tileNum2].collision){
                    entity.isCollided = true;
                }
                break;
        }
    }
    public int checkObj(Entity entity,boolean player){
        //just a random number that returns the index of the object
        int index = 999;

        for (int i=0;i<gp.obj.length;i++) {
            if(gp.obj[i]!=null) {
                //get entity pos
                entity.solidArea.x = entity.worldX + entity.solidArea.x;
                entity.solidArea.y = entity.worldY + entity.solidArea.y;

                //object pos
                gp.obj[i].solidArea.x= gp.obj[i].worldX + gp.obj[i].solidArea.x;
                gp.obj[i].solidArea.y = gp.obj[i].worldY + gp.obj[i].solidArea.y;

                switch(entity.direction) {
                    case "up":
                        entity.solidArea.y -= entity.speed;
                        if(entity.solidArea.intersects(gp.obj[i].solidArea)){
                            if(gp.obj[i].collision){
                                entity.isCollided = true;
                            }
                            if(player) {
                                index = i;
                            }
                        }
                        break;
                    case "down":
                        entity.solidArea.y += entity.speed;
                        if(entity.solidArea.intersects(gp.obj[i].solidArea)){
                            if(gp.obj[i].collision){
                                entity.isCollided = true;
                            }
                            if(player) {
                                index = i;
                            }
                        }
                        break;
                    case "left":
                        entity.solidArea.x -= entity.speed;
                        if(entity.solidArea.intersects(gp.obj[i].solidArea)){
                            if(gp.obj[i].collision){
                                entity.isCollided = true;
                            }
                            if(player) {
                                index = i;
                            }
                        }
                        break;
                    case "right":
                        entity.solidArea.x += entity.speed;
                        if(entity.solidArea.intersects(gp.obj[i].solidArea)){
                            if(gp.obj[i].collision){
                                entity.isCollided = true;
                            }
                            if(player) {
                                index = i;
                            }
                        break;
                        }
                }
                entity.solidArea.x = entity.solidAreaDefX;
                entity.solidArea.y = entity.solidAreaDefY;
                gp.obj[i].solidArea.x = gp.obj[i].solidAreaDefX;
                gp.obj[i].solidArea.y = gp.obj[i].solidAreaDefY;
            }
        }
        return index;
    }
}
