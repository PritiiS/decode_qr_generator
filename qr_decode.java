package qr_project;
// zxing (zebra library) is a popular api that allows to process qr code

import com.google.zxing.BinaryBitmap;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.*;

public class qr_decode {
    public static void main(String[] args) {
        try {

//            manually changing file name
//            File file=new File("C:\\Users\\lenovo\\IdeaProjects\\img\\try2.png");

//            File file=new File("C:\\Users\\lenovo\\IdeaProjects\\JAVA\\src\\qr_project\\IMAGE\\try.png");
//            not read any image created through outside this library
//            Result r =new MultiFormatReader().decode(new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(ImageIO.read(file)))));
//
//            System.out.println(r.getText());


//           not manually selecting files using dialog box
            JFileChooser js=new JFileChooser();
            js.showOpenDialog(null);
            File file=js.getSelectedFile();
            if(file==null){
                throw new Exception("invalid file");
            }
            Result r =new MultiFormatReader().decode(new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(ImageIO.read(file)))));
//            JOptionPane.showMessageDialog(null,r.getText());
            JOptionPane.showMessageDialog(null,r.getText(),"qr-content",JOptionPane.INFORMATION_MESSAGE,new ImageIcon(file.getAbsolutePath()));
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
