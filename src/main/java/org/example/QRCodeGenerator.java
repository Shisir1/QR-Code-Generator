package org.example;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import java.io.File;
import java.io.IOException;

public class QRCodeGenerator {
    public static void main(String[] args){
        String data = "https://youtube.com/@gurkhastream";
        //output file path
        String filePath = "./assets/qrcode.png";

        try {
            generateQRCode(data,filePath);
            System.out.println("QR code generated successfully!");
        } catch (IOException | WriterException e){
            System.out.println("Error generating QR code : " + e.getMessage());
        }
    }

    private static void generateQRCode(String data, String filePath) throws IOException, WriterException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(data, BarcodeFormat.QR_CODE,200,200);

        File outputFile = new File(filePath);

        MatrixToImageWriter.writeToPath(bitMatrix, "PNG",outputFile.toPath());
    }
}
