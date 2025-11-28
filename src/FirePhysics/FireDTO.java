package FirePhysics;

/**
 * DTO que encapsula los datos necesarios para el motor de física del fuego.
 */
public class FireDTO {
    private int fireWidth;
    private int fireHeight;
    private int[][] pixelTemperature;

    public FireDTO(int fireWidth, int fireHeight) {
        this.fireWidth = fireWidth;
        this.fireHeight = fireHeight;
        this.pixelTemperature = new int[fireHeight][fireWidth];
    }

    public int getFireWidth() {
        return fireWidth;
    }

    public int getFireHeight() {
        return fireHeight;
    }

    public int[][] getPixelTemperature() {
        return pixelTemperature;
    }
}
