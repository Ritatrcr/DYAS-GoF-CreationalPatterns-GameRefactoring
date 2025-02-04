package com.balitechy.spacewar.main.renderer;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

import com.balitechy.spacewar.main.interfaces.BackgroundRenderer;

public class ColorVectorBackgroundRenderer implements BackgroundRenderer {

    @Override
    public void render(Graphics g, Canvas c) {
        g.setColor(new Color(30, 30, 30));
        g.fillRect(0, 0, c.getWidth(), c.getHeight());

        g.setColor(Color.PINK);
        g.drawOval(10, 10, 200, 200);  
    }
}
