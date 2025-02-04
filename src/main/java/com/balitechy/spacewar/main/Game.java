package com.balitechy.spacewar.main;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;

import com.balitechy.spacewar.main.controller.BulletController;
import com.balitechy.spacewar.main.controller.InputHandler;
import com.balitechy.spacewar.main.factory.ColorVectorRendererFactory;
import com.balitechy.spacewar.main.factory.RendererFactory;
import com.balitechy.spacewar.main.factory.SpriteRendererFactory;
import com.balitechy.spacewar.main.factory.VectorRendererFactory;
import com.balitechy.spacewar.main.interfaces.BackgroundRenderer;
import com.balitechy.spacewar.main.interfaces.BulletRenderer;
import com.balitechy.spacewar.main.interfaces.PlayerRenderer;


import java.util.Scanner;


public class Game extends Canvas implements Runnable {
	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 320;
	public static final int HEIGHT = WIDTH / 12 * 9;
	public static final int SCALE = 2;
	public final String TITLE = "Space War 2D";

	private boolean running = false;
	private Thread thread;

	private Player player;
	private BulletController bullets;
	private RendererFactory rendererFactory;
	private PlayerRenderer playerRenderer;
	private BulletRenderer bulletRenderer;
	private BackgroundRenderer backgroundRenderer;


	public void init() {
		requestFocus();  
		addKeyListener(new InputHandler(this));  

		playerRenderer = rendererFactory.createPlayerRenderer();
		bulletRenderer = rendererFactory.createBulletRenderer();
		backgroundRenderer = rendererFactory.createBackgroundRenderer();

		player = new Player((WIDTH * SCALE - Player.WIDTH) / 2, HEIGHT * SCALE - 50, this);
		bullets = new BulletController();
	}

	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		switch (key) {
			case KeyEvent.VK_RIGHT: player.setVelX(5); break;
			case KeyEvent.VK_LEFT: player.setVelX(-5); break;
			case KeyEvent.VK_UP: player.setVelY(-5); break;
			case KeyEvent.VK_DOWN: player.setVelY(5); break;
			case KeyEvent.VK_SPACE: player.shoot(); break;  // Disparar
		}
	}

	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		switch (key) {
			case KeyEvent.VK_RIGHT: player.setVelX(0); break;
			case KeyEvent.VK_LEFT: player.setVelX(0); break;
			case KeyEvent.VK_UP: player.setVelY(0); break;
			case KeyEvent.VK_DOWN: player.setVelY(0); break;
		}
	}

	
	public void tick() {
		player.tick();  
		bullets.tick(); 
	}
	public void render() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);  
			return;
		}

		Graphics g = bs.getDrawGraphics();
		backgroundRenderer.render(g, this);  
		playerRenderer.render(g, player.getX(), player.getY());  
		bullets.render(g, bulletRenderer);  
		g.dispose();  
		bs.show();  
	}

	
	public BulletController getBullets() {
		return bullets;
	}

	public static void main(String[] args) {
		Game game = new Game();

		game.showMenu();

		game.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		JFrame frame = new JFrame(game.TITLE);
		frame.add(game);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		game.start();  
	}

	private void showMenu() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Hola profesor, bienvenido a Space War 2D mejorado en caso de encontrar algo ue no le parezca agradezco todo tipo de feedback :)");
		System.out.println("Selecciona el tipo de juego:");
		System.out.println("1- Fabrica Vector");
		System.out.println("2- Fabrica Sprite");
		System.out.println("3- Fabrica Vector de Colores");

		int choice = scanner.nextInt();

		switch (choice) {
			case 1:
				rendererFactory = new VectorRendererFactory();
				System.out.println("Selección Fabrica de Vectores.");
				break;
			case 2:
				rendererFactory = new SpriteRendererFactory();
				System.out.println("Selección Fabrica Sprite.");
				break;
			case 3:
				rendererFactory = new ColorVectorRendererFactory();
				System.out.println("Selección Fabrica de Vectores de Colores.");
				break;
			default:
				System.out.println("Selección no válida, se usará la fábrica de vectores por defecto.");
				rendererFactory = new VectorRendererFactory();
				break;
		}
	}

	
	private synchronized void start() {
		if (running) return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}


	@Override
	public void run() {
		init(); 
		long lastTime = System.nanoTime();
		final double ns = 1000000000 / 60.0;  
		double delta = 0;
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			if (delta >= 1) {
				tick();  
				render();  
				delta--;  
			}
		}
	}
}

