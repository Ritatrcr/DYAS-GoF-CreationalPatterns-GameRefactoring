package com.balitechy.spacewar.main.implementacion;

import com.balitechy.spacewar.main.factory.ColorVectorRendererFactory;
import com.balitechy.spacewar.main.factory.RendererFactory;
import com.balitechy.spacewar.main.factory.SpriteRendererFactory;
import com.balitechy.spacewar.main.factory.VectorRendererFactory;


public class Implement {

    public static RendererFactory getRendererFactory(String style) {
        switch (style) {
            case "sprite":
                return new SpriteRendererFactory(); 
            case "vector":
                return new VectorRendererFactory(); 
            case "colorful-vector":
                return new ColorVectorRendererFactory(); 
            default:
                throw new IllegalArgumentException("Ingrese opción válida: " + style);
        }
    }
}
