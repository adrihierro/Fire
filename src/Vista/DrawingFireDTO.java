package Vista;

public class DrawingFireDTO {
    private int fireWidth;
    private int fireHeight;
    private int[][] pixelTemperature;

    public DrawingFireDTO(int fireWidth, int fireHeight, int[][] pixelTemperature) {
        this.fireWidth = fireWidth;
        this.fireHeight = fireHeight;
        this.pixelTemperature = pixelTemperature;
    }

    public int getFireWidth() { return fireWidth; }
    public int getFireHeight() { return fireHeight; }
    public int[][] getPixelTemperature() { return pixelTemperature; }
}
