package com.balitechy.spacewar.main.factory;

import com.balitechy.spacewar.main.interfaces.BackgroundRenderer;
import com.balitechy.spacewar.main.interfaces.BulletRenderer;
import com.balitechy.spacewar.main.interfaces.PlayerRenderer;

public interface RendererFactory {

    PlayerRenderer createPlayerRenderer();

    BulletRenderer createBulletRenderer();

    BackgroundRenderer createBackgroundRenderer();
}
