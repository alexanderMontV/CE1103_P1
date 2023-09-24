import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import java.awt.event.MouseEvent;

public class Interfaz extends JFrame {

    JLabel[][] dots = new JLabel[5][5];
    JLabel[][] herizontalLines = new JLabel[4][4];
    JLabel[][] verticallLines = new JLabel[5][5];

    public Interfaz(String title) {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(620, 640);
        setLocationRelativeTo(null);
        setVisible(true);
        setLayout(null);

        JPanel pantalla=new JPanel();
        pantalla.setLayout(null);
        pantalla.setSize(600,600);
        add(pantalla);
        for (int i = 0; i < dots.length; i++) {
            for (int j = 0; j < dots.length; j++) {
                dots[i][j] = new JLabel();
                dots[i][j].setBounds(20 + i * (20 + 50), 20 + j * (20 + 50), 20, 20);
                dots[i][j].setOpaque(true);
                dots[i][j].setBackground(Color.red);
                pantalla.add(dots[i][j]);
                pantalla.repaint();
            }
        }
        for (int i = 0; i < herizontalLines.length; i++) {
            for (int j = 0; j < herizontalLines[0].length; j++) {
                herizontalLines[i][j] = new JLabel();
                herizontalLines[i][j].setBounds(40 + j * (20 + 50), 20 + i * (20 + 50), 50, 20);
                herizontalLines[i][j].setOpaque(true);
                herizontalLines[i][j].setBackground(Color.green);
                herizontalLines[i][j].setVisible(false);
                pantalla.add(herizontalLines[i][j]);
                pantalla.repaint();
            }
        }
        for (int i = 0; i < verticallLines.length; i++) {
            for (int j = 0; j < verticallLines[0].length; j++) {
                verticallLines[i][j] = new JLabel();
                verticallLines[i][j].setBounds(20 + i * (20 + 50), 40 + j * (20 + 50), 20, 50);
                verticallLines[i][j].setOpaque(true);
                verticallLines[i][j].setBackground(Color.green);
                verticallLines[i][j].setVisible(false);
                pantalla.add(verticallLines[i][j]);
                pantalla.repaint();
            }
        }
        pantalla.addMouseListener(new MouseInputAdapter() {
            int count = 0;
            @Override
            public void mouseClicked(MouseEvent e) {
                int mX = e.getX();
                int mY = e.getY();
                System.out.println(mX);
                System.out.println(mY);
                boolean b = false;
                for (JLabel[] l : herizontalLines) {
                    for (JLabel l1 : l) {
                        b = checkBounds(l1, mX, mY);
                        if (b) {
                            l1.setVisible(true);
                            break;
                        }
                    }
                }
                if (!b) {
                    for (JLabel[] l : verticallLines) {
                        for (JLabel l1 : l) {
                            b = checkBounds(l1, mX, mY);
                            if (b) {
                                l1.setVisible(true);
                                break;
                            }
                        }
                    }
                }
                System.out.println(b + " metodo finalizado " + count);
                pantalla.revalidate();
                pantalla.repaint();
                count++;
            }
        });
        pantalla.revalidate();
        pantalla.repaint();
    }

    public boolean checkBounds(JLabel l, int x, int y) {
        return (x >= l.getX() && x <= l.getX() + l.getWidth()) && (y >= l.getY() && y <= l.getY() + l.getHeight());
    }

    public static void main(String[] args) {
        new Interfaz("Juego");
    }

}
