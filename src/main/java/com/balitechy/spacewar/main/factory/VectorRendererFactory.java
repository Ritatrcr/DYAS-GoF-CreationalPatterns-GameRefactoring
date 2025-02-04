package com.balitechy.spacewar.main.factory;

import com.balitechy.spacewar.main.interfaces.BackgroundRenderer;
import com.balitechy.spacewar.main.interfaces.BulletRenderer;
import com.balitechy.spacewar.main.interfaces.PlayerRenderer;
import com.balitechy.spacewar.main.renderer.VectorBackgroundRenderer;
import com.balitechy.spacewar.main.renderer.VectorBulletRenderer;
import com.balitechy.spacewar.main.renderer.VectorPlayerRenderer;

public class VectorRendererFactory implements RendererFactory {

    @Override
    public PlayerRenderer createPlayerRenderer() {
        return new VectorPlayerRenderer();  // Renderizador vectorial para el jugador
    }

    @Override
    public BulletRenderer createBulletRenderer() {
        return new VectorBulletRenderer();  
    }

    @Override
    public BackgroundRenderer createBackgroundRenderer() {
        return new VectorBackgroundRenderer(); 
    }
}
