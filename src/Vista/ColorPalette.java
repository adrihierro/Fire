package Vista;

import java.awt.Color;

public class ColorPalette {

    private final Color[] palette;

    // Constructor por defecto con la paleta original
    public ColorPalette() {
        this.palette = new Color[] {
                new Color(7, 7, 7, 0),
                new Color(80, 20, 20, 150),
                new Color(180, 40, 20, 200),
                new Color(255, 100, 20, 220),
                new Color(255, 160, 40, 230),
                new Color(255, 210, 60, 240),
                new Color(255, 240, 120, 250),
                new Color(255, 255, 200, 255),
                new Color(255, 255, 255, 255)
        };
    }

    //transformar una temperatura numerica a color

    public Color getColor(int temp) {
        if (temp <= 0) return palette[0];

        // Normalizamos temp al rango [0, 1]
        float t = Math.min(1f, temp / 1000f);

        // Escalamos a la paleta
        int index = (int)(t * (palette.length - 1));
        float frac = t * (palette.length - 1) - index;

        // Si estamos en el último color, devolvemos directamente
        if (index >= palette.length - 1) return palette[palette.length - 1];

        // Interpolamos entre palette[index] y palette[index+1]
        return interpolation(palette[index], palette[index + 1], frac);
    }

    private Color interpolation(Color c1, Color c2, float t) {
        return new Color(
                (int)(c1.getRed()   + t * (c2.getRed()   - c1.getRed())),
                (int)(c1.getGreen() + t * (c2.getGreen() - c1.getGreen())),
                (int)(c1.getBlue()  + t * (c2.getBlue()  - c1.getBlue())),
                (int)(c1.getAlpha() + t * (c2.getAlpha() - c1.getAlpha()))
        );
    }
}
