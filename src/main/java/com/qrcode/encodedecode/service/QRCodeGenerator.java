package com.qrcode.encodedecode.service;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeWriter;
import com.qrcode.encodedecode.dto.QRCodeBuilderInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class QRCodeGenerator {

    @Value("${file.path}")
    String filePath;//Read OR Write location

    int width = 350;
    int height = 350;

    public String writeQRCode(QRCodeBuilderInfo requestBody) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yy_MM_dd_HH_mm_ss");
        Date date = new Date();
        //saving as png format
        String qrcode = filePath + requestBody.getName()+"_"+sdf.format(date)+ "_qr.png";

        QRCodeWriter writer = new QRCodeWriter();
        BitMatrix bitMatrix = writer.encode(
                requestBody.getName() + "\n" + requestBody.getPhone() + "\n"
                        + requestBody.getMail(),
                BarcodeFormat.QR_CODE, width, height);
        Path path = FileSystems.getDefault().getPath(qrcode);
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);//png format

        return "QRCode generated successfully, with name: "+requestBody.getName();
    }

    public String readQRCode(String imageName) throws Exception {
        //Accessing from the same Location
        BufferedImage bufferedImage = ImageIO.read(new File(filePath+imageName));
        LuminanceSource luminanceSource = new BufferedImageLuminanceSource(bufferedImage);
        BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(luminanceSource));
        Result result = new MultiFormatReader().decode(binaryBitmap);

        return result.getText();
    }

}
