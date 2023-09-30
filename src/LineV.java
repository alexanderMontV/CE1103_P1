public class LineV {
    private Boolean temp;
    private Boolean select;

    public LineV() {
        this.temp=false;
    }

    public LineV(Boolean seleccionado) {
        super(seleccionado);
    }

    @Override
    public String toString() {
        return "LV";
    }
}
