package tile;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TileManage {

    GamePanel gp;
    public Tile [] tiles;
    public int [][] mapTileNum;

    public TileManage(GamePanel gp) {
        this.gp = gp;
        //initialize tile array and set its size to 40(0-39)
        //basiclly meaning 40 different tiles
        // i made it so big because when creating the world map it gets weird when 1-9 nums and 10-99 because it changes the map size in the txt
        //and its annoying me
        tiles = new Tile[40];
        //initialize mapTileNum
        //right now its 16x12but soon its gonna be 63x60
        //this gets the numbers from the map and instead of drawing each tile and writing like 5000 lines of code it does it for me
        mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];
        //initializing getTileImage
        getTileImage();
        //intializing loadMap method
        loadMap("/maps/world_map.txt");
    }

        public void getTileImage() {
        try {
            //placeholders
            tiles[0] = new Tile();
            tiles[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/flower.png"));
            tiles[1] = new Tile();
            tiles[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/flower.png"));
            tiles[2] = new Tile();
            tiles[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/flower.png"));
            tiles[3] = new Tile();
            tiles[3].image = ImageIO.read(getClass().getResourceAsStream("/tiles/flower.png"));
            tiles[4] = new Tile();
            tiles[4].image = ImageIO.read(getClass().getResourceAsStream("/tiles/flower.png"));
            tiles[5] = new Tile();
            tiles[5].image = ImageIO.read(getClass().getResourceAsStream("/tiles/flower.png"));
            tiles[6] = new Tile();
            tiles[6].image = ImageIO.read(getClass().getResourceAsStream("/tiles/flower.png"));
            tiles[7] = new Tile();
            tiles[7].image = ImageIO.read(getClass().getResourceAsStream("/tiles/flower.png"));
            tiles[8] = new Tile();
            tiles[8].image = ImageIO.read(getClass().getResourceAsStream("/tiles/flower.png"));
            tiles[9] = new Tile();
            tiles[9].image = ImageIO.read(getClass().getResourceAsStream("/tiles/flower.png"));
//0-9 are placeholders
            //collision =true on the tiles i want to collide with the player
            tiles[10] = new Tile();
            tiles[10].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass.png"));

            tiles[11] = new Tile();
            tiles[11].image = ImageIO.read(getClass().getResourceAsStream("/tiles/earth.png"));

            tiles[12] = new Tile();
            tiles[12].image = ImageIO.read(getClass().getResourceAsStream("/tiles/wall.png"));
            tiles[12].collision = true;

            tiles[13] = new Tile();
            tiles[13].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water.png"));
            tiles[13].collision = true;

            tiles[14] = new Tile();
            tiles[14].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sand.png"));

            tiles[15] = new Tile();
            tiles[15].image = ImageIO.read(getClass().getResourceAsStream("/tiles/tree.png"));
            tiles[15].collision = true;

            tiles[16] = new Tile();
            tiles[16].image = ImageIO.read(getClass().getResourceAsStream("/tiles/tree2.png"));
            tiles[16].collision = true;

            tiles[17] = new Tile();
            tiles[17].image = ImageIO.read(getClass().getResourceAsStream("/tiles/flower.png"));

            tiles[18] = new Tile();
            tiles[18].image = ImageIO.read(getClass().getResourceAsStream("/tiles/fence.png"));
            tiles[18].collision = true;

            tiles[19] = new Tile();
            tiles[19].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water_top.png"));
            tiles[19].collision = true;

            tiles[20] = new Tile();
            tiles[20].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water_bottom.png"));
            tiles[20].collision = true;

            tiles[21] = new Tile();
            tiles[21].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water_left.png"));
            tiles[21].collision = true;

            tiles[22] = new Tile();
            tiles[22].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water_right.png"));
            tiles[22].collision = true;

            tiles[23] = new Tile();
            tiles[23].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water_top_right.png"));
            tiles[23].collision = true;

            tiles[24] = new Tile();
            tiles[24].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water_top_left.png"));
            tiles[24].collision = true;

            tiles[25] = new Tile();
            tiles[25].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water_bottom_right.png"));
            tiles[25].collision = true;

            tiles[26] = new Tile();
            tiles[26].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water_bottom_left.png"));
            tiles[26].collision = true;

            tiles[27] = new Tile();
            tiles[27].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass_top_corner_left.png"));
            tiles[27].collision = true;

            tiles[28] = new Tile();
            tiles[28].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass_top_corner_right.png"));
            tiles[28].collision = true;

            tiles[29] = new Tile();
            tiles[29].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass_bottom_corner_left.png"));
            tiles[29].collision = true;

            tiles[30] = new Tile();
            tiles[30].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass_bottom_corner_right.png"));
            tiles[30].collision = true;

            tiles[31] = new Tile();
            tiles[31].image = ImageIO.read(getClass().getResourceAsStream("/tiles/oak.png"));
            tiles[31].collision = true;

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void loadMap(String filePath) {
        try {
            InputStream is = getClass().getResourceAsStream(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col=0;
            int row=0;

            while(col <gp.maxWorldCol && row <gp.maxWorldRow) {
                String line = br.readLine();

                while(col < gp.maxWorldCol ) {
                    String [] numbers = line.split(" ");
                    int num = Integer.parseInt(numbers[col]);

                    mapTileNum[col][row] = num;
                    col++;
                }
                if(col == gp.maxWorldCol) {
                    col = 0;
                    row++;
                }
            }
            br.close();

        } catch (Exception e) {

        }
    }






    public void draw(Graphics2D g2) {
        int worldCol= 0;
        int worldRow = 0;

        while(worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow) {

            int tileNum = mapTileNum[worldCol][worldRow];

            //
            int worldX= worldCol * gp.tileSize;
            int worldY= worldRow * gp.tileSize;
            int screenX = worldX - gp.player.worldX + gp.player.screenX;
            int screenY = worldY - gp.player.worldY + gp.player.screenY;
//if you dont see the tile you dont need to render(draw) it
            if(worldX + gp.tileSize> gp.player.worldX - gp.player.screenX &&
               worldX - gp.tileSize< gp.player.worldX + gp.player.screenX &&
               worldY + gp.tileSize> gp.player.worldY - gp.player.screenY &&
               worldY - gp.tileSize< gp.player.worldY + gp.player.screenY) {

                g2.drawImage(tiles[tileNum].image,screenX,screenY,gp.tileSize,gp.tileSize,null);
            }

            worldCol++;

            if(worldCol==gp.maxWorldCol) {
                worldCol=0;
                worldRow++;
            }
        }

    }

}
