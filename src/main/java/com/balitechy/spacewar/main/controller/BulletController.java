package com.balitechy.spacewar.main.controller;

import java.awt.Graphics;
import java.util.LinkedList;

import com.balitechy.spacewar.main.Bullet;
import com.balitechy.spacewar.main.interfaces.BulletRenderer;


public class BulletController {
	private LinkedList<Bullet> bullets = new LinkedList<>();

	public void tick() {
		bullets.removeIf(bullet -> bullet.getY() < 0);

		bullets.forEach(Bullet::tick);
	}

	public void render(Graphics g, BulletRenderer bulletRenderer) {
		bullets.forEach(bullet -> bulletRenderer.render(g, bullet.getX(), bullet.getY()));
	}

	
	public void addBullet(Bullet bullet) {
		bullets.add(bullet);
	}
}
