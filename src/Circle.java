public class Circle extends Seleccionable {

    private boolean tempSelect;

    public Circle() {
        this.tempSelect=false;
    }
    public void set(boolean status) { this.tempSelect = status; }


    @Override
    public String toString() {
        return "CR";
    }
}