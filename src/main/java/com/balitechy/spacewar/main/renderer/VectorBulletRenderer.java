package com.balitechy.spacewar.main.renderer;

import com.balitechy.spacewar.main.Bullet;
import com.balitechy.spacewar.main.interfaces.BulletRenderer;

import java.awt.Color;
import java.awt.Graphics;

public class VectorBulletRenderer implements BulletRenderer {

    @Override
    public void render(Graphics g, double x, double y) {
        g.setColor(Color.WHITE);
        g.fillOval((int) x, (int) y, Bullet.WIDTH, Bullet.HEIGHT);
    }
}
