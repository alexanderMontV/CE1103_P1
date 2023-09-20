public class pruebaClaseC {
    public static void main(String[] args) {
        SerialClient msc = new SerialClient();
        msc.open();
        Matriz mat = new Matriz();
        mat.initMatrix();
        try {
            while (true) {
                String mensajeR = msc.getMesg();
                if (mensajeR != null) {
                    System.out.println(mensajeR);
                    mat.printMat();
                }
            }
        } catch (Exception e) {

            e.printStackTrace();
        }

    }
    }
