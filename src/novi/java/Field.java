package novi.java;

public class Field {

    private char initialValue;
    private char value;

    public Field(char value) {
        this.value = value;
        initialValue = value;
    }

    public char getValue() {
        return value;
    }

    public void setValue(char value) {
        this.value = value;
    }

    public boolean isEmpty() {
        //boolean result = value == initialValue;
        return value == initialValue; //return result;
    }
}
