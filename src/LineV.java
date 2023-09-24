public class LineV {
    private Boolean temp;
    private Boolean select;

    public LineV() {
        this.temp=false;
    }
    public void setTemp(boolean status) { this.temp = status; }
    public void setSelect(boolean status) { this.select = status; }

    public boolean getSelected (){return this.select;}

    @Override
    public String toString() {
        return "LV";
    }
}
