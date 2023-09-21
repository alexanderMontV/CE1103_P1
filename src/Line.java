public class Line {
    private Boolean temp;
    private Boolean select;

    public Line() {
        this.temp=false;
    }
    public void setTemp(boolean status) { this.temp = status; }
    public void setSelect(boolean status) { this.select = status; }

    public boolean getSelected (){return this.select;}

    @Override
    public String toString() {
        return "Objeto Clase Line{" +
                "temp=" + temp +
                ", select=" + select +
                '}';
    }
}
