package domain;
/**
*
* Drum.java
* 
* @author Harpreet Singh
* @regNumber 041154501
* @sectionNum 332
* @assignment lab05
  */
/**
 * Abstract Drum class.
 */
public abstract class Drum {
    private float height;
    private float diameter;
    private String contents;
// constructor chaining
    public Drum() {
        this.height = 0.0f;
        this.diameter = 0.0f;
        this.contents = "UNKNOWN";
    }

    public Drum(float height, float diameter) {
        this.height = height;
        this.diameter = diameter;
        this.contents = "UNKNOWN";
    }

    public Drum(float height, float diameter, String contents) {
        this.height = height;
        this.diameter = diameter;
        this.contents = contents;
    }
// getter and setter
    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getDiameter() {
        return diameter;
    }

    public void setDiameter(float diameter) {
        this.diameter = diameter;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    @Override
    public String toString() {
        return "Drum [Height=" + height + ", Diameter=" + diameter + ", Contents=" + contents + "]";
    }
 // abstract method 
    public abstract double calculateCapacity();
}
