package QR_code;

import com.google.zxing.*;
import com.google.zxing.client.j2se.*;
import com.google.zxing.common.*;
import com.google.zxing.qrcode.decoder.*;

import java.io.*;
import java.net.*;
import java.nio.file.*;
import java.util.*;

public class CreateQRCode {

    public static void main(String[] args) {
        /**
         * @param width defines the QR code picture width
         * @param height defines the QR code picture height
         * @param format defines the file format of the picture
         * @param content defines the content of the QR code
         */
        // Fig params
        int width = 300;
        int height = 300;

        String format = "png";
        String content = "";

        // QR params
        HashMap hints = new HashMap();
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
        hints.put(EncodeHintType.MARGIN, 2);

        try{
            BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height, hints);
            Path file = new File("./QRcode.png").toPath();
            MatrixToImageWriter.writeToPath(bitMatrix, format, file);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
