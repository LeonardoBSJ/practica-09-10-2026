
import java.awt.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class jFrame_dibujorick extends JFrame {

    public jFrame_dibujorick() {
        setTitle("Dibujo de Rick");
        setSize(1000, 1200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        PanelDibujo panel = new PanelDibujo();
        panel.setBackground(Color.WHITE);
        add(panel);
    }

    private class PanelDibujo extends JPanel {

        String rutaimagen = "C:\\Users\\Lab_Eq_14\\Downloads\\images.jpg";

        Color colorPiel = new Color(228, 213, 200);
        Color colorPelo = new Color(173, 222, 230);
        Color colorCamisa = new Color(142, 214, 207);
        Color colorPantalon = new Color(133, 107, 68);
        Color colorBataInt = new Color(193, 220, 203);
        Color colorZapato = new Color(50, 50, 50);
        Color colorCinturon = new Color(75, 50, 20);
        Color colorHebilla = new Color(255, 220, 0);

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

            BufferedImage buff;
            try {
                buff = ImageIO.read(new File(rutaimagen));
                g2d.drawImage(buff, 0, 20,
                        (int) (buff.getWidth() * 2.3),
                        (int) (buff.getHeight() * 2.3),
                        null);
            } catch (IOException ex) {
                System.out.println("No se puede cargar la imagen");
            }

            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setStroke(new BasicStroke(3.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));

            dibujarPelo(g2d);
            dibujarBataInterior(g2d);
            dibujarPiernasYZapatos(g2d);
            dibujarTronco(g2d);
            dibujarBataExteriorYMangas(g2d);
            dibujarManos(g2d);
            dibujarCabeza(g2d);

            g2d.setFont(new Font("chiller", Font.ITALIC, 32));
            g2d.drawString("Leonardo Bolaños San Juan", 650, 65);

        }

        private void dibujarPelo(Graphics2D g2d) {
            // El cabello puntiagudo característico dibujado como un polígono detrás de la cabeza
            GeneralPath pelo = new GeneralPath();
            pelo.moveTo(320, 240); // Base izquierda
            pelo.lineTo(260, 260); // Pico inferior izq
            pelo.lineTo(280, 200);
            pelo.lineTo(220, 150); // Pico medio izq
            pelo.lineTo(290, 130);
            pelo.lineTo(270, 60);  // Pico alto izq
            pelo.lineTo(340, 90);
            pelo.lineTo(360, 20);  // Pico superior izq
            pelo.lineTo(410, 70);
            pelo.lineTo(470, 20);  // Pico superior der
            pelo.lineTo(470, 90);
            pelo.lineTo(540, 60);  // Pico alto der
            pelo.lineTo(510, 130);
            pelo.lineTo(580, 150); // Pico medio der
            pelo.lineTo(520, 200);
            pelo.lineTo(550, 260); // Pico inferior der
            pelo.lineTo(480, 240); // Base derecha
            pelo.closePath();

            g2d.setColor(colorPelo);
            g2d.fill(pelo);
            g2d.setColor(Color.BLACK);
            g2d.draw(pelo);
        }

        private void dibujarBataInterior(Graphics2D g2d) {
            // Fondo de la bata que se ve detrás de las piernas
            GeneralPath bataInt = new GeneralPath();
            bataInt.moveTo(350, 480);
            bataInt.lineTo(290, 720); // Extremo inferior izquierdo
            bataInt.lineTo(510, 720); // Extremo inferior derecho
            bataInt.lineTo(450, 480);
            bataInt.closePath();

            g2d.setColor(colorBataInt);
            g2d.fill(bataInt);
            g2d.setColor(Color.BLACK);
            g2d.draw(bataInt);
        }

        private void dibujarPiernasYZapatos(Graphics2D g2d) {
            // Pierna Izquierda
            g2d.setColor(colorPantalon);
            g2d.fillPolygon(new int[]{365, 390, 385, 370}, new int[]{495, 495, 820, 820}, 4);
            g2d.setColor(Color.BLACK);
            g2d.drawPolygon(new int[]{365, 390, 385, 370}, new int[]{495, 495, 820, 820}, 4);

            // Pierna Derecha
            g2d.setColor(colorPantalon);
            g2d.fillPolygon(new int[]{410, 435, 430, 415}, new int[]{495, 495, 820, 820}, 4);
            g2d.setColor(Color.BLACK);
            g2d.drawPolygon(new int[]{410, 435, 430, 415}, new int[]{495, 495, 820, 820}, 4);

            // Calcetines Blancos
            g2d.setColor(Color.WHITE);
            g2d.fillRect(370, 820, 15, 15);
            g2d.fillRect(415, 820, 15, 15);
            g2d.setColor(Color.BLACK);
            g2d.drawRect(370, 820, 15, 15);
            g2d.drawRect(415, 820, 15, 15);

            // Zapato Izquierdo
            GeneralPath zapatoIzq = new GeneralPath();
            zapatoIzq.moveTo(385, 835);
            zapatoIzq.lineTo(310, 860);
            zapatoIzq.lineTo(330, 880);
            zapatoIzq.lineTo(395, 880);
            zapatoIzq.closePath();
            g2d.setColor(colorZapato);
            g2d.fill(zapatoIzq);
            g2d.setColor(Color.BLACK);
            g2d.draw(zapatoIzq);

            // Zapato Derecho
            GeneralPath zapatoDer = new GeneralPath();
            zapatoDer.moveTo(415, 835);
            zapatoDer.lineTo(490, 860);
            zapatoDer.lineTo(470, 880);
            zapatoDer.lineTo(405, 880);
            zapatoDer.closePath();
            g2d.setColor(colorZapato);
            g2d.fill(zapatoDer);
            g2d.setColor(Color.BLACK);
            g2d.draw(zapatoDer);
        }

        private void dibujarTronco(Graphics2D g2d) {
            // Camisa color cian
            g2d.setColor(colorCamisa);
            g2d.fillRect(360, 270, 80, 210);
            g2d.setColor(Color.BLACK);
            g2d.drawLine(360, 270, 360, 480);
            g2d.drawLine(440, 270, 440, 480);

            // Cinturón
            g2d.setColor(colorCinturon);
            g2d.fillRect(360, 480, 80, 15);
            g2d.setColor(Color.BLACK);
            g2d.drawRect(360, 480, 80, 15);

            // Hebilla amarilla
            g2d.setColor(colorHebilla);
            g2d.fillRect(390, 478, 20, 19);
            g2d.setColor(Color.BLACK);
            g2d.drawRect(390, 478, 20, 19);
            g2d.fillRect(405, 483, 5, 9); // Detalle del pasador

        }

        private void dibujarBataExteriorYMangas(Graphics2D g2d) {
            g2d.setColor(Color.WHITE);

            // Solapa y faldón izquierdo de la bata
            GeneralPath bataIzq = new GeneralPath();
            bataIzq.moveTo(360, 270); // Cuello
            bataIzq.lineTo(320, 300); // Hombro
            bataIzq.lineTo(340, 450); // Axila
            bataIzq.lineTo(275, 730); // Punta inferior exterior
            bataIzq.lineTo(350, 710); // Punta inferior interior
            bataIzq.lineTo(370, 480); // Cintura
            bataIzq.lineTo(360, 380); // Solapa interior
            bataIzq.closePath();
            g2d.fill(bataIzq);
            g2d.setColor(Color.BLACK);
            g2d.draw(bataIzq);

            // Detalle doblez solapa izquierda
            g2d.drawLine(360, 270, 335, 380);
            g2d.drawLine(335, 380, 360, 380);

            // Solapa y faldón derecho de la bata
            g2d.setColor(Color.WHITE);
            GeneralPath bataDer = new GeneralPath();
            bataDer.moveTo(440, 270);
            bataDer.lineTo(480, 300);
            bataDer.lineTo(460, 450);
            bataDer.lineTo(525, 730);
            bataDer.lineTo(450, 710);
            bataDer.lineTo(430, 480);
            bataDer.lineTo(440, 380);
            bataDer.closePath();
            g2d.fill(bataDer);
            g2d.setColor(Color.BLACK);
            g2d.draw(bataDer);

            // Detalle doblez solapa derecha
            g2d.drawLine(440, 270, 465, 380);
            g2d.drawLine(465, 380, 440, 380);

            // Manga Izquierda
            g2d.setColor(Color.WHITE);
            GeneralPath mangaIzq = new GeneralPath();
            mangaIzq.moveTo(320, 300); // Hombro
            mangaIzq.lineTo(290, 560); // Puño exterior
            mangaIzq.lineTo(330, 560); // Puño interior
            mangaIzq.lineTo(340, 450); // Axila
            mangaIzq.closePath();
            g2d.fill(mangaIzq);
            g2d.setColor(Color.BLACK);
            g2d.draw(mangaIzq);

            // Manga Derecha
            g2d.setColor(Color.WHITE);
            GeneralPath mangaDer = new GeneralPath();
            mangaDer.moveTo(480, 300); // Hombro
            mangaDer.lineTo(510, 560); // Puño exterior
            mangaDer.lineTo(470, 560); // Puño interior
            mangaDer.lineTo(460, 450); // Axila
            mangaDer.closePath();
            g2d.fill(mangaDer);
            g2d.setColor(Color.BLACK);
            g2d.draw(mangaDer);
        }

        private void dibujarManos(Graphics2D g2d) {
            g2d.setColor(colorPiel);

            // Mano izquierda (caída)
            g2d.fillOval(295, 560, 30, 60);
            g2d.setColor(Color.BLACK);
            g2d.drawOval(295, 560, 30, 60);
            // Dedos izquierda
            g2d.drawLine(305, 600, 305, 620);
            g2d.drawLine(315, 595, 315, 615);

            // Mano derecha (caída)
            g2d.setColor(colorPiel);
            g2d.fillOval(475, 560, 30, 60);
            g2d.setColor(Color.BLACK);
            g2d.drawOval(475, 560, 30, 60);
            // Dedos derecha
            g2d.drawLine(485, 600, 485, 620);
            g2d.drawLine(495, 595, 495, 615);
        }

        private void dibujarCabeza(Graphics2D g2d) {
            // Cuello
            g2d.setColor(colorPiel);
            g2d.fillRect(380, 240, 40, 40);
            g2d.setColor(Color.BLACK);
            g2d.drawLine(380, 240, 380, 280);
            g2d.drawLine(420, 240, 420, 280);

            // Orejas
            g2d.setColor(colorPiel);
            g2d.fillOval(325, 175, 25, 35); // Oreja Izquierda
            g2d.fillOval(450, 175, 25, 35); // Oreja Derecha
            g2d.setColor(Color.BLACK);
            g2d.drawOval(325, 175, 25, 35);
            g2d.drawOval(450, 175, 25, 35);

            // Estructura principal de la cabeza (Óvalo tipo píldora)
            g2d.setColor(colorPiel);
            g2d.fillRoundRect(340, 90, 120, 170, 70, 70);
            g2d.setColor(Color.BLACK);
            g2d.drawRoundRect(340, 90, 120, 170, 70, 70);

            // Ojos grandes circulares
            g2d.setColor(Color.WHITE);
            g2d.fillOval(345, 135, 50, 50); // Ojo Izquierdo
            g2d.fillOval(405, 135, 50, 50); // Ojo Derecho
            g2d.setColor(Color.BLACK);
            g2d.drawOval(345, 135, 50, 50);
            g2d.drawOval(405, 135, 50, 50);

            // Pupilas (estilo asterisco rústico característico)
            dibujarPupila(g2d, 370, 160);
            dibujarPupila(g2d, 430, 160);

            // Bolsas de los ojos (ojeras)
            g2d.drawArc(350, 185, 40, 15, 180, 180);
            g2d.drawArc(410, 185, 40, 15, 180, 180);

            // Uniceja gruesa azul
            g2d.setColor(colorPelo);
            g2d.fillRoundRect(345, 125, 110, 12, 10, 10);
            g2d.setColor(Color.BLACK);
            g2d.drawRoundRect(345, 125, 110, 12, 10, 10);

            // Nariz larga inclinada hacia abajo
            g2d.drawArc(395, 165, 15, 35, 90, 180);

            // Boca (Expresión neutra/decaída)
            g2d.drawArc(365, 215, 70, 15, 20, 140);

            // Ligeras comisuras curvadas (baba verde no añadida para mantenerlo limpio, pero se puede agregar)
            g2d.drawArc(355, 212, 15, 10, 0, -180); // Izquierda
            g2d.drawArc(430, 212, 15, 10, 0, -180); // Derecha
        }

        // Método auxiliar para dibujar la pupila desordenada de Rick
        private void dibujarPupila(Graphics2D g, int x, int y) {
            g.setColor(Color.BLACK);
            g.drawLine(x - 3, y, x + 3, y);
            g.drawLine(x, y - 3, x, y + 3);
            g.drawLine(x - 2, y - 2, x + 2, y + 2);
            g.drawLine(x - 2, y + 2, x + 2, y - 2);
            g.fillOval(x - 1, y - 1, 3, 3); // Centro sólido
        }
    }
}
