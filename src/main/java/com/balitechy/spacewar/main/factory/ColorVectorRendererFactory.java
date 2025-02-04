package com.balitechy.spacewar.main.factory;

import com.balitechy.spacewar.main.interfaces.BackgroundRenderer;
import com.balitechy.spacewar.main.interfaces.BulletRenderer;
import com.balitechy.spacewar.main.interfaces.PlayerRenderer;
import com.balitechy.spacewar.main.renderer.ColorVectorBackgroundRenderer;
import com.balitechy.spacewar.main.renderer.ColorVectorBulletRenderer;
import com.balitechy.spacewar.main.renderer.ColorVectorPlayerRenderer;

public class ColorVectorRendererFactory implements RendererFactory {

    @Override
    public PlayerRenderer createPlayerRenderer() {
        return new ColorVectorPlayerRenderer();  
    }

    @Override
    public BulletRenderer createBulletRenderer() {
        return new ColorVectorBulletRenderer(); 
    }

 
    @Override
    public BackgroundRenderer createBackgroundRenderer() {
        return new ColorVectorBackgroundRenderer();  
    }
}
