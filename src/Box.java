public class Box {
    private String label;
    private Boolean fill;
    private Line left;
    private Line right;
    private Line arriba;
    private Line abajo;

    public Box() {
        this.label = "";
        this.fill = false;
        this.left = null;
        this.right = null;
        this.arriba = null;
        this.abajo = null;
    }
    public void setUP(Line arriba){
        this.arriba = arriba;
    }
    public void setDW(Line abajo){
        this.abajo = abajo;
    }
    public void setLF(Line left){
        this.left = left;
    }
    public void setRG(Line right){
        this.right=right;
    }

    public void setName(String nombre){
        if (!this.fill){this.label=nombre;}
    }

    public boolean isFull(){
        return this.fill;
    }
    public boolean getSides(){
        if (this.left.getSelected() && this.right.getSelected() && this.arriba.getSelected() && this.abajo.getSelected()){
            this.fill=true;
            return true;
        }
        else{
            return false;
        }
    }
}
