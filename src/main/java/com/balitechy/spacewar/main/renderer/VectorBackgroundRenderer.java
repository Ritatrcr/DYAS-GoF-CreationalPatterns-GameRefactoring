package com.balitechy.spacewar.main.renderer;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

import com.balitechy.spacewar.main.interfaces.BackgroundRenderer;


public class VectorBackgroundRenderer implements BackgroundRenderer {

    @Override
    public void render(Graphics g, Canvas c) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, c.getWidth(), c.getHeight());  

        g.setColor(Color.WHITE);
        g.drawOval(10, 10, 200, 200); 
    }
}
