package com.balitechy.spacewar.main;

public class Player {
	private double x, y;

	private double velX, velY;

	public static final int WIDTH = 56;
	public static final int HEIGHT = 28;

	private Game game;

	public Player(double x, double y, Game game) {
		this.x = x;
		this.y = y;
		this.game = game;
	}
	public void tick() {
		x += velX;
		y += velY;

		if (x < 0) x = 0;
		if (x > Game.WIDTH * Game.SCALE - WIDTH) x = Game.WIDTH * Game.SCALE - WIDTH;
		if (y < 0) y = 0;
		if (y > Game.HEIGHT * Game.SCALE - HEIGHT) y = Game.HEIGHT * Game.SCALE - HEIGHT;
	}

	
	public void shoot() {
		Bullet bullet = new Bullet(x + (WIDTH / 2) - 5, y - 18);

		game.getBullets().addBullet(bullet);
	}

	public double getX() { return x; }
	public double getY() { return y; }
	public void setVelX(double velX) { this.velX = velX; }
	public void setVelY(double velY) { this.velY = velY; }
}
