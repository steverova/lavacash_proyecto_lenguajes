package com.lavacash.app.upload;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

public class Utils {

    public static String internalPath = "src\\main\\resources\\static\\recursos\\imagenes";
    public static String externalPath = "C:\\recursos\\imagenes";

    public static void copyDirectory() {

        File sourceDirectory = new File(internalPath);
        File destinationDirectory = new File(externalPath);
        try {
            FileUtils.copyDirectory(sourceDirectory, destinationDirectory);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createFolder() {
        
        File folder = new File(externalPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }

        File folder2 = new File(internalPath);
        if (!folder2.exists()) {
            folder2.mkdirs();
        }
        // <dependency>
        // <groupId>commons-io</groupId>
        // <artifactId>commons-io</artifactId>
        // <version>2.11.0</version>
        // </dependency>
    }

    public static String guardarImagen(MultipartFile imagen) {

        String imgName = "";

        UUID uuid = UUID.randomUUID();

        if (!imagen.isEmpty()) {
            try {
                byte[] byteimg = imagen.getBytes();
                File oldfile = new File(internalPath + "\\" + imgName);
                File newfile = new File(internalPath + "\\" + uuid.toString());
                oldfile.renameTo(newfile);
                Path fullRoute = Paths.get(internalPath + "\\" + newfile.getName()+".jpg");
                Files.write(fullRoute, byteimg);
                imgName = newfile.getName() + ".jpg";
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return imgName;
    }

    public static void delete(String name) {
        File file = new File(externalPath + "\\" + name);
        File file2 = new File(internalPath + "\\" + name);
        file.delete();
        file2.delete();
    }

    //==========================================================
//genera un codigo aleatorio para la recuperacion del email 
    public static String cadenaAleatoria() {
        // El banco de caracteres
        int longitud = 10;
        String banco = "1234567890abcdefghijklmnopqrstuvwxyz1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        // La cadena en donde iremos agregando un carácter aleatorio
        String cadena = "";
        for (int x = 0; x < longitud; x++) {
            int indiceAleatorio = numeroAleatorioEnRango(0, banco.length() - 1);
            char caracterAleatorio = banco.charAt(indiceAleatorio);
            cadena += caracterAleatorio;
        }
        return cadena;
    }

    public static int numeroAleatorioEnRango(int minimo, int maximo) {
        // nextInt regresa en rango pero con límite superior exclusivo, por eso sumamos 1
        return ThreadLocalRandom.current().nextInt(minimo, maximo + 1);
    }
}
