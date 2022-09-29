package com.qrcode.encodedecode.controller;

import com.qrcode.encodedecode.dto.QRCodeBuilderInfo;
import com.qrcode.encodedecode.service.QRCodeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/qr")
public class HomeController {

    @Autowired
    QRCodeGenerator qrCodeGenerator;

    @GetMapping("/")
    public String hello(){
        return "Hello from QR code generator.";
    }


    @PostMapping("/generate-qr")
    public String generateQRCode(@RequestBody QRCodeBuilderInfo body){
        String msg;
        try {
            msg = qrCodeGenerator.writeQRCode(body);
        }catch (Exception e){
            System.out.println("Exception occurred.");
            msg = "Error.";
        }
        return msg;
    }

    @GetMapping("/read-qr")
    public String readQEImage(String fileName){
        String msg;
        try {
            msg = qrCodeGenerator.readQRCode(fileName);
        }catch (Exception e){
            System.out.println("Exception occurred.");
            msg = "Error.";
        }
        return msg;
    }


}
