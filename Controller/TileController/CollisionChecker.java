package Controller.TileController;

import Model.GameModel.GameModel;
import Model.EntityModel.PlayerModel.*;

public class CollisionChecker {
    GameModel Mf;

    public CollisionChecker(GameModel Mf) {
        this.Mf = Mf;
    }

    public void checkTile(PlayerModel player) {
        int playerLeftX = player.getPlayerPositionX();
        int playerRightX = player.getPlayerPositionX() + player.soildArea.width /2;
        int playerTopY = player.getPlayerPositionY() ;
        int playerBottomY = player.getPlayerPositionY()+ (player.soildArea.y / 2) ;

        // xác định vị trí của các cạnh của vùng va chạm của người chơi.
        // int playerLeftX = player.getPlayerPositionX() + player.soildArea.x;
        // int playerRightX = player.getPlayerPositionX()  + player.soildArea.width;
        // int playerTopY = player.getPlayerPositionY() + player.soildArea.y;
        // int playerBottomY = player.getPlayerPositionY()  + player.soildArea.height;


        // xác định chỉ số cột và hàng của các ô tile mà người chơi đang tiếp xúc.
        int playerLeftCol = playerLeftX / PlayerModel.getDefaultSize();
        int playerRightCol = playerRightX / PlayerModel.getDefaultSize();
        int playerTopRow = playerTopY / PlayerModel.getDefaultSize();
        int playerBottomRow = playerBottomY / PlayerModel.getDefaultSize();

        int tileNum1, tileNum2;

        try {
            
            switch (player.direction) {
                case "up":
                    playerTopRow = (playerTopY - player.getSpeed()) / PlayerModel.getDefaultSize();
                    tileNum1 = Mf.tileManager.mapTileNum[playerLeftCol][playerTopRow];
                    tileNum2 = Mf.tileManager.mapTileNum[playerRightCol][playerTopRow];
                    if(Mf.tileManager.tile[tileNum1]. collision == true || Mf.tileManager.tile[tileNum2]. collision == true){
                        player.collisionOn = true;
                    }
                    break;
                case "down":
                playerBottomRow = (playerBottomY + player.getSpeed()) / PlayerModel.getDefaultSize();
                    tileNum1 = Mf.tileManager.mapTileNum[playerLeftCol][playerBottomRow];
                    tileNum2 = Mf.tileManager.mapTileNum[playerRightCol][playerBottomRow];
                    if(Mf.tileManager.tile[tileNum1]. collision == true || Mf.tileManager.tile[tileNum2]. collision == true){
                        player.collisionOn = true;
                    }
                break;
    
                case "left":
                playerLeftCol = (playerLeftX - player.getSpeed()) / PlayerModel.getDefaultSize();
                    tileNum1 = Mf.tileManager.mapTileNum[playerLeftCol][playerTopRow];
                    tileNum2 = Mf.tileManager.mapTileNum[playerLeftCol][playerBottomRow];
                    if(Mf.tileManager.tile[tileNum1]. collision == true || Mf.tileManager.tile[tileNum2]. collision == true){
                        player.collisionOn = true;
                    }
                break;
    
                case "right":
                playerRightCol = (playerRightX + player.getSpeed()) / PlayerModel.getDefaultSize();
                    tileNum1 = Mf.tileManager.mapTileNum[playerRightCol][playerTopRow];
                    tileNum2 = Mf.tileManager.mapTileNum[playerRightCol][playerBottomRow];
                    if(Mf.tileManager.tile[tileNum1]. collision == true || Mf.tileManager.tile[tileNum2]. collision == true){
                        player.collisionOn = true;
                    }
                break;
                        
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
