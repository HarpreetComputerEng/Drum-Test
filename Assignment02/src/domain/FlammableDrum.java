package domain;

public class FlammableDrum extends Drum {
    private float flashpoint;
// constructor chaining
    public FlammableDrum() {
        super();
        this.flashpoint = 0.0f;
    }

    public FlammableDrum(float height, float diameter) {
        super(height, diameter);
        this.flashpoint = 0.0f;
    }

    public FlammableDrum(float height, float diameter, String contents) {
        super(height, diameter, contents);
        this.flashpoint = 0.0f;
    }

    public FlammableDrum(float height, float diameter, String contents, float flashpoint) {
        super(height, diameter, contents);
        this.flashpoint = flashpoint;
    }
// getter and setter
    public float getFlashpoint() {
        return flashpoint;
    }

    public void setFlashpoint(float flashpoint) {
        this.flashpoint = flashpoint;
    }

    @Override
    public String toString() {
        return String.format("Flammable Drum: FlammableDrum\nheight: %.1f diameter: %.1f contents: %s\ncapacity: %.3f flashpoint: %.1f°C",
                getHeight(), getDiameter(), getContents(), calculateCapacity(), flashpoint);
    }
// calculate method for flammableDrum
    @Override
    public double calculateCapacity() {
        return Math.PI * Math.pow(getDiameter() / 2, 2) * getHeight();
    }
}
