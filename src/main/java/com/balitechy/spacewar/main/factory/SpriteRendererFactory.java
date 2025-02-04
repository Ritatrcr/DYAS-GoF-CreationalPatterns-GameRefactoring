package com.balitechy.spacewar.main.factory;

import com.balitechy.spacewar.main.interfaces.BackgroundRenderer;
import com.balitechy.spacewar.main.interfaces.BulletRenderer;
import com.balitechy.spacewar.main.interfaces.PlayerRenderer;
import com.balitechy.spacewar.main.renderer.SpriteBackgroundRenderer;
import com.balitechy.spacewar.main.renderer.SpriteBulletRenderer;
import com.balitechy.spacewar.main.renderer.SpritePlayerRenderer;


public class SpriteRendererFactory implements RendererFactory {

    @Override
    public PlayerRenderer createPlayerRenderer() {
        return new SpritePlayerRenderer(); 
    }
    @Override
    public BulletRenderer createBulletRenderer() {
        return new SpriteBulletRenderer(); 
    }

    @Override
    public BackgroundRenderer createBackgroundRenderer() {
        return new SpriteBackgroundRenderer(); 
    }
}
