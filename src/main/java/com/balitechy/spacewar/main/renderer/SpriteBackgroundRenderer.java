package com.balitechy.spacewar.main.renderer;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import com.balitechy.spacewar.main.SpritesImageLoader;
import com.balitechy.spacewar.main.interfaces.BackgroundRenderer;


public class SpriteBackgroundRenderer implements BackgroundRenderer {
    private BufferedImage image;

  
    public SpriteBackgroundRenderer() {
        SpritesImageLoader loader = new SpritesImageLoader("/bg.png");
        try {
            loader.loadImage();
            image = loader.getImage(0, 0, 640, 480);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void render(Graphics g, Canvas c) {
        g.drawImage(image, 0, 0, c.getWidth(), c.getHeight(), c);
    }
}
