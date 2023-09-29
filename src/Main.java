public class Main {
    public static void main(String[] args) {
        Matriz mat = new Matriz();
        mat.initMatrix();
        mat.printMat();
        mat.setBoxes();
        System.out.println(mat.actual().getElement());
        System.out.println("- - - - - - ");
        System.out.println("mover derecha y abajo (BX EXPECTED)");
        mat.moverDerecha();
        mat.moverAbajo();
        System.out.println(mat.actual().getElement());

        //System.out.println(mat.actual().getElement());
    }
}
