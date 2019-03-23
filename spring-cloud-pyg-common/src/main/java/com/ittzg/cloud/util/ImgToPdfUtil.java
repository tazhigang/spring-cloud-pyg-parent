package com.ittzg.cloud.util;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @Author: ittzg
 * @CreateDate: 2019/2/27 21:32
 * @Description:
 * <dependency>
 *     <groupId>com.itextpdf</groupId>
 *     <artifactId>itext-pdfa</artifactId>
 *     <version>5.5.7</version>
 * </dependency>
 */
public class ImgToPdfUtil {
    public static boolean imgToPdf(String imgFilePath, String pdfFilePath) throws IOException {
        File file1 = new File(pdfFilePath);
        if(!file1.exists()) file1.delete();
        File file = new File(imgFilePath);
        if (file.exists()) {
            Document document = new Document();
            FileOutputStream fos = null;
            try {
                fos = new FileOutputStream(pdfFilePath);
                PdfWriter.getInstance(document, fos);
                // 设置文档的大小
                document.setPageSize(PageSize.A4);
                // 打开文档
                document.open();
                // 读取一个图片
                Image image = Image.getInstance(imgFilePath);
                float imageHeight = image.getScaledHeight();
                float imageWidth = image.getScaledWidth();
                float  a = document.getPageSize().getHeight()/imageHeight;
                float b = document.getPageSize().getWidth()/imageWidth;
                image.scalePercent((int)(100 * (a>b?b:a))-5);
                imageHeight = image.getScaledHeight();
                imageWidth = image.getScaledWidth();
                System.out.println("imageHeight->" + imageHeight);
                System.out.println("imageWidth->" + imageWidth);
                image.setAlignment(Image.ALIGN_CENTER);
                document.add(image);
            } catch (DocumentException de) {
                System.out.println(de.getMessage());
            } catch (IOException ioe) {
                System.out.println(ioe.getMessage());
            }
            document.close();
            fos.flush();
            fos.close();
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) throws IOException, DocumentException {

        imgToPdf("J:\\c05728956b93974393ab0813811a74d4.jpg", "J:\\aaaaaaaaa.pdf");
    }
}
