package com.balitechy.spacewar.main.renderer;

import com.balitechy.spacewar.main.Player;
import com.balitechy.spacewar.main.interfaces.PlayerRenderer;

import java.awt.Color;
import java.awt.Graphics;


public class VectorPlayerRenderer implements PlayerRenderer {

    @Override
    public void render(Graphics g, double x, double y) {
        g.setColor(Color.WHITE);

        int[] xPoints = {(int) x, (int) (x + Player.WIDTH / 2), (int) (x + Player.WIDTH)};
        int[] yPoints = {(int) y, (int) (y - Player.HEIGHT), (int) y};

        g.fillPolygon(xPoints, yPoints, 3); 
    }
}
