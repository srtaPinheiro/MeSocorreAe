package view.util;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Imagem {

    private static final int LARGURA = 115;
    private static final int ALTURA = 115;

    private byte[] imagem = null;

    public byte[] getImagem() {
        return imagem;
    }

    public Imagem(byte[] imagem) {
        this.imagem = imagem;
    }

    public Imagem(File file) {
        this.imagem = ImageToByte(file);
    }

    private byte[] ImageToByte(File file) {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            FileInputStream fis = new FileInputStream(file);
            byte[] buf = new byte[1024];
            try {
                //System.out.println(bos.size());
                for (int readNum; (readNum = fis.read(buf)) != -1;) {
                    bos.write(buf, 0, readNum);
                    //System.out.println("read " + readNum + " bytes,");
                }
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        byte[] bytes = bos.toByteArray();

        return bytes;
    }

    private ImageIcon ScaleImage(Dimension medida) {
        return new ImageIcon(new ImageIcon(imagem).getImage().getScaledInstance(medida.width, medida.height, java.awt.Image.SCALE_SMOOTH));
    }

    public ImageIcon getImageIcon() {
        try {
            BufferedImage bimg = ImageIO.read(new ByteArrayInputStream(imagem));

            // calculando aspect ratio
            float imageAspect = (float) bimg.getWidth() / (float) bimg.getHeight();
            float canvasAspect = (float) LARGURA / (float) ALTURA;

            int imgWidth = LARGURA;
            int imgHeight = ALTURA;
            if (imageAspect < canvasAspect) {
                // Se o aspect ratio da imagem for menor que o da tela então altera a largura
                float w = (float) ALTURA * imageAspect;
                imgWidth = (int) w;
            } else {
                // senão altera a altura
                float h = (float) LARGURA / imageAspect;
                imgHeight = (int) h;
            }
            Dimension dimensao = new Dimension(imgWidth, imgHeight);

            return ScaleImage(dimensao);

        } catch (IOException ex) {
            System.out.println("Erro ao carregar a imagem: "
                    + ex.getMessage() + ".");
            return null;
        }
    }
}