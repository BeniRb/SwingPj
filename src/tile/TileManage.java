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
    Tile [] tiles;
    int  [][] mapTileNum;

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
        mapTileNum = new int[gp.maxScreenCol][gp.maxScreenRow];
        //initializing getTileImage
        getTileImage();
        //intializing loadMap method
        loadMap("/maps/map01.txt");
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


            tiles[10] = new Tile();
            tiles[10].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass.png"));

            tiles[11] = new Tile();
            tiles[11].image = ImageIO.read(getClass().getResourceAsStream("/tiles/earth.png"));

            tiles[12] = new Tile();
            tiles[12].image = ImageIO.read(getClass().getResourceAsStream("/tiles/wall.png"));

            tiles[13] = new Tile();
            tiles[13].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water.png"));

            tiles[14] = new Tile();
            tiles[14].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sand.png"));

            tiles[15] = new Tile();
            tiles[15].image = ImageIO.read(getClass().getResourceAsStream("/tiles/tree.png"));

            tiles[16] = new Tile();
            tiles[16].image = ImageIO.read(getClass().getResourceAsStream("/tiles/tree2.png"));

            tiles[17] = new Tile();
            tiles[17].image = ImageIO.read(getClass().getResourceAsStream("/tiles/flower.png"));

            tiles[18] = new Tile();
            tiles[18].image = ImageIO.read(getClass().getResourceAsStream("/tiles/fence.png"));

            tiles[19] = new Tile();
            tiles[19].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water_top.png"));

            tiles[20] = new Tile();
            tiles[20].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water_bottom.png"));

            tiles[21] = new Tile();
            tiles[21].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water_left.png"));

            tiles[22] = new Tile();
            tiles[22].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water_right.png"));

            tiles[23] = new Tile();
            tiles[23].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water_top_right.png"));

            tiles[24] = new Tile();
            tiles[24].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water_top_left.png"));

            tiles[25] = new Tile();
            tiles[25].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water_bottom_right.png"));

            tiles[26] = new Tile();
            tiles[26].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water_bottom_left.png"));

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

            while(col <gp.maxScreenCol && row <gp.maxScreenRow) {
                String line = br.readLine();

                while(col < gp.maxScreenCol ) {
                    String [] numbers = line.split(" ");
                    int num = Integer.parseInt(numbers[col]);

                    mapTileNum[col][row] = num;
                    col++;
                }
                if(col == gp.maxScreenCol) {
                    col = 0;
                    row++;
                }
            }
            br.close();

        } catch (Exception e) {

        }
    }






    public void draw(Graphics2D g2) {
        int col= 0;
        int row = 0;
        int x=0;
        int y=0;

        while(col<gp.maxScreenCol && row<gp.maxScreenRow) {

            int tileNum = mapTileNum[col][row];

            g2.drawImage(tiles[tileNum].image,x,y,gp.tileSize,gp.tileSize,null);
            col++;
            x+=gp.tileSize;
            if(col==gp.maxScreenCol) {
                col=0;
                x=0;
                row++;
                y+=gp.tileSize;
            }
        }

    }

}
