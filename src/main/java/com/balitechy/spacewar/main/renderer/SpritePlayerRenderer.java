package com.balitechy.spacewar.main.renderer;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.balitechy.spacewar.main.Player;
import com.balitechy.spacewar.main.SpritesImageLoader;
import com.balitechy.spacewar.main.interfaces.PlayerRenderer;


public class SpritePlayerRenderer implements PlayerRenderer {
    private BufferedImage image;

    public SpritePlayerRenderer() {
        SpritesImageLoader loader = new SpritesImageLoader("/sprites.png");
        try {
            loader.loadImage();
            image = loader.getImage(219, 304, Player.WIDTH, Player.HEIGHT);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   
    @Override
    public void render(Graphics g, double x, double y) {
        g.drawImage(image, (int) x, (int) y, null);
    }
}
