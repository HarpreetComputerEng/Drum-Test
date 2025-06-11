package domain;

public class ToxicDrum extends Drum {
    private String toxicity;

    public static final String CLASS_IA = "Extremely Hazardous";
    public static final String CLASS_IB = "Highly Hazardous";
    public static final String CLASS_II = "Moderately Hazardous";
    public static final String CLASS_III = "Slightly Hazardous";
 // Constructor chaining
    public ToxicDrum() {
        super();
        this.toxicity = CLASS_III;
    }
    

    public ToxicDrum(String toxicity) {
        this.toxicity = toxicity;
    }
    public ToxicDrum(float height, float diameter) {
        super(height, diameter);
        this.toxicity = CLASS_III;
    }

    public ToxicDrum(float height, float diameter, String contents) {
        super(height, diameter, contents);
        this.toxicity = CLASS_III;
    }

    public ToxicDrum(float height, float diameter, String contents, String toxicity) {
        super(height, diameter, contents);
        this.toxicity = toxicity;
    }
// getter and setter
    public  String getToxicity() {
        return toxicity;
    }

    public void setToxicity(String toxicity) {
        this.toxicity = toxicity;
    }

    @Override
    public String toString() {
        return String.format("Toxic Drum: ToxicDrum\nheight: %.1f diameter: %.1f contents: %s\ncapacity: %.3f toxicity: %s",
                getHeight(), getDiameter(), getContents(), calculateCapacity(), toxicity);
    }
// capacity calculator
    @Override
    public double calculateCapacity() {
        return Math.PI * Math.pow(getDiameter() / 2, 2) * getHeight()*0.75;
    }
}
