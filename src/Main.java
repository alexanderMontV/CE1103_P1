public class Main {
    public static void main(String[] args) {
        Matriz mat = new Matriz();
        mat.initMatrix();
        mat.printMat();
        System.out.println("_ _ _ _ _ _ _");
        mat.printMat();
        mat.setBoxes();
        //System.out.println(mat.actual().getElement());
    }


}
