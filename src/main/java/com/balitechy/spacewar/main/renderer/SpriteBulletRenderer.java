package com.balitechy.spacewar.main.renderer;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.balitechy.spacewar.main.Bullet;
import com.balitechy.spacewar.main.SpritesImageLoader;
import com.balitechy.spacewar.main.interfaces.BulletRenderer;


public class SpriteBulletRenderer implements BulletRenderer {
    private BufferedImage image;

    public SpriteBulletRenderer() {
        SpritesImageLoader loader = new SpritesImageLoader("/sprites.png");
        try {
            loader.loadImage();
            image = loader.getImage(35, 52, Bullet.WIDTH, Bullet.HEIGHT);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   
    @Override
    public void render(Graphics g, double x, double y) {
        g.drawImage(image, (int) x, (int) y, null);
    }
}
