package paintgeometricshapes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 * Desenha formas 2.0 - Trabalho da disciplina de Programação III
 * @author Gustavo Simon
 */
public class PaintGeometricShapes extends JFrame {

    Container frameContainer;
    JPanel panelPaint;
    JPanel panelOptions;
    Integer x = 0, y = 0;
    Graphics2D g2d;
    String[] formasGeometricas = {"Círculo", "Quadrado", "Retângulo", "Triângulo"};
    String[] coresFormas = {"Amarelo", "Azul", "Preto", "Verde", "Vermelho"};
    JList formas = new JList(formasGeometricas);
    JList cores = new JList(coresFormas);

    /**
     * Configura a janela da aplicação
     */
    public void buildFrame() {
        setSize(800, 900);
        setResizable(false);
        setTitle("Desenhando Formas 2.0");
        frameContainer = this.getContentPane();
        panelPaint = new JPanel();
        panelOptions = new JPanel();
        panelPaint.setBackground(Color.WHITE);
        panelOptions.setLayout(new BoxLayout(panelOptions, BoxLayout.Y_AXIS));
        panelOptions.setBorder(new TitledBorder("Opções"));
        panelOptions.add(new JLabel("Forma"));
        panelOptions.add(formas);
        panelOptions.add(new JLabel("Cor"));
        panelOptions.add(cores);
        frameContainer.add(panelOptions, BorderLayout.WEST);
        frameContainer.add(panelPaint, BorderLayout.CENTER);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    /**
     * Aceita e trata os eventos da janela 
     */
    public void accept(){
        panelPaint.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
    // Cria o objeto que será desenhado na tela
                g2d = (Graphics2D) panelPaint.getGraphics();
                x = e.getX();
                y = e.getY();
    // Define a cor do objeto que será desenhado
                switch (cores.getSelectedIndex()) {
                    case 0:
                        g2d.setColor(Color.YELLOW);
                        break;
                    case 1:
                        g2d.setColor(Color.BLUE);
                        break;
                    case 2:
                        g2d.setColor(Color.BLACK);
                        break;
                    case 3:
                        g2d.setColor(Color.GREEN);
                        break;
                    case 4:
                        g2d.setColor(Color.RED);
                        break;
                    default:
                        g2d.setColor(Color.BLACK);
                        break;
                }
    // Desenha o objeto na tela
                switch (formas.getSelectedIndex()) {
                    case 0:
                        desenharCirculo(g2d, x, y);
                        break;
                    case 1:
                        desenharQuadrado(g2d, x, y);
                        break;
                    case 2:
                        desenharRetangulo(g2d, x, y);
                        break;
                    case 3:
                        desenharTriangulo(g2d, x, y);
                        break;
                    default:
                        desenharCirculo(g2d, x, y);
                        break;
                }
            }
        });
    }

    /**
     * Desenha um retângulo na janela
     * @param g2d
     * @param x
     * @param y
     */
    public void desenharRetangulo(Graphics2D g2d, Integer x, Integer y){
        g2d.fillRect((x - 50), (y - 35), 100, 70);
    }

    /**
     * Desenha um quadrado na janela
     * @param g2d
     * @param x
     * @param y
     */
    public void desenharQuadrado(Graphics2D g2d, Integer x, Integer y){
        g2d.fillRect((x - 50), (y - 50), 100, 100);
        
    }
    
    /**
     * Desenha um círculo na janela
     * @param g2d
     * @param x
     * @param y
     */    
    public void desenharCirculo(Graphics2D g2d, Integer x, Integer y){
        g2d.fillOval((x - 50), (y - 50), 100, 100);
    }
    
    /**
     * Desenha um triângulo na janela
     * @param g2d
     * @param x
     * @param y
     */
    public void desenharTriangulo(Graphics2D g2d, Integer x, Integer y) {
        Polygon poligono = new Polygon();
        poligono.addPoint(x - 40, y + 40);
        poligono.addPoint(x + 40, y + 40);
        poligono.addPoint(x, y - 40);
        g2d.drawPolygon(poligono);
        g2d.fill(poligono);
    }
    
    /**
     * Método principal da aplicação
     * @param args
     */
    public static void main(String[] args) {
        PaintGeometricShapes frame = new PaintGeometricShapes();
        frame.buildFrame();
        frame.accept();
        frame.setVisible(true);
    }
};