public class pruebaClaseC {
    public static void main(String[] args) {
        SerialClient msc = new SerialClient();
        msc.open();
        try {
            while (true) {
                String mensajeR = msc.getMesg();
                if (mensajeR != null) {
                    System.out.println(mensajeR);
                }
            }
        } catch (Exception e) {

            e.printStackTrace();
        }

    }
    }
