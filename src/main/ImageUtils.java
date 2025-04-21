/* ak - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
package main;

import java.io.InputStream;

import javax.microedition.lcdui.Image;
import extra.ImageData;
import extra.IntArray;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Vector;
import javax.microedition.io.Connector;
import javax.microedition.io.file.FileConnection;
import javax.microedition.io.file.FileSystemRegistry;
import javax.microedition.lcdui.Graphics;

public final class ImageUtils {

    private static java.lang.Class a;

    public static javax.microedition.lcdui.Image createImage(java.lang.String fileName) {
        if (!fileName.endsWith(".png")) {
            fileName += ".png";
        }
        fileName = "/" + fileName;
        javax.microedition.lcdui.Image image = null;
        try {
            image = javax.microedition.lcdui.Image.createImage(fileName);
        } catch (java.lang.Exception exception) {
            exception.printStackTrace();
        }
        return image;
    }

    public static ImageData loadImageData(java.lang.String imageFileName) {
        if (!imageFileName.endsWith(".png")) {
            imageFileName += ".png";
        }
        imageFileName = "/" + imageFileName;
        ImageData resultingImageData = null;
        try {
            java.lang.Class var_class = a;
            if (var_class == null) {
                java.lang.Class var_class_1_;
                try {
                    var_class_1_ = java.lang.Class.forName("java.lang.Object");
                } catch (java.lang.ClassNotFoundException classnotfoundexception) {
                    java.lang.NoClassDefFoundError noclassdeffounderror = new java.lang.NoClassDefFoundError(classnotfoundexception.getMessage());
                    throw noclassdeffounderror;
                }
                var_class = a = var_class_1_;
            }
            java.io.InputStream inputstream = var_class.getResourceAsStream(imageFileName);
            resultingImageData = ImageData.createFromInputStream(inputstream);
            
        } catch (java.lang.Exception exception) {
            exception.printStackTrace();
        }
        return resultingImageData;
    }

    public static javax.microedition.lcdui.Image applyPalette(java.lang.String imageFile, java.lang.String paletteFile) {
        ImageData imgData1 = main.ImageUtils.loadImageData(imageFile);
        ImageData imgData2 = main.ImageUtils.loadImageData(paletteFile);
        
        // Debug
        if (dumpPalettesToFile) {
            dumpPaletteToFile(imageFile, imgData1);
        }
        
        IntArray originalPalette = imgData1.getPalette();
        IntArray replacingPalette = imgData2.getPalette();
        for (int i = 0; i < originalPalette.length(); i++) {
            originalPalette.set(i, replacingPalette.get(i));
        }
        imgData1.setPaletteData(originalPalette);
        
        // Debug
        if (dumpPalettesToFile) {
            dumpPaletteToFile(paletteFile, imgData1);
        }
        
        java.lang.System.gc();
        return imgData1.getImage();
    }

    public static javax.microedition.lcdui.Image loadImage(java.lang.String imageFileName) {
        javax.microedition.lcdui.Image image = main.ImageUtils.createImage(imageFileName);
        java.lang.System.gc();
        return image;
    }

    public static javax.microedition.lcdui.Image[] createImages(java.lang.String[] fileNames) {
        int numImages = fileNames.length;
        javax.microedition.lcdui.Image[] images;
        images = new javax.microedition.lcdui.Image[numImages];
        try {
            for (int i = 0; i < numImages; i++) {
                images[i] = main.ImageUtils.createImage(fileNames[i]);
            }
        } catch (java.lang.Exception exception) {
            exception.printStackTrace();
        }
        return images;
    }

    public static javax.microedition.lcdui.Image[] applyPalettesForImagesGroup(java.lang.String[] images, java.lang.String[] palettes) {
        int numImages = images.length;
        javax.microedition.lcdui.Image[] resultingImages;
        resultingImages = (new javax.microedition.lcdui.Image[numImages]);
        try {
            for (int i = 0; i < numImages; i++) {
                resultingImages[i] = main.ImageUtils.applyPalette(images[i], palettes[i]);
            }
        } catch (java.lang.Exception exception) {
            exception.printStackTrace();
        }
        return resultingImages;
    }

    public static void releaseImages(javax.microedition.lcdui.Image[] images) {
        if (images != null) {
            for (int i = 0; i < images.length; i++) {
                if (images[i] != null) {
                    images[i] = null;
                }
            }
        }
    }

    public static void releaseImagesArray(javax.microedition.lcdui.Image[][] images) {
        if (images != null) {
            for (int i = 0; i < images.length; i++) {
                if (images[i] != null) {
                    for (int j = 0; j < images[i].length; j++) {
                        if (images[i][j] != null) {
                            images[i][j] = null;
                        }
                    }
                    images[i] = null;
                }
            }
        }
    }

    public static int a(int i, int i_12_, int i_13_, int i_14_) {
        int i_15_;
        if (java.lang.Math.abs(i_15_ = i_12_ - i) < 1024) {
            return i_12_;
        }
        i_15_ /= i_13_;
        if (i_14_ != 0) {
            if (i_15_ > i_14_) {
                i_15_ = i_14_;
            } else if (i_15_ < -i_14_) {
                i_15_ = -i_14_;
            }
        }
        return i + i_15_;
    }

    private static int b(int i, int i_16_) {
        return (i >> 4) * (i_16_ >> 4) >> 4;
    }

    private static int c(int i, int i_17_) {
        if (i_17_ >> 7 == 0) {
            return 0;
        }
        return i / (i_17_ >> 7) << 5;
    }

    public static int a(int i, int i_18_) {
        boolean bool = ((i ^ i_18_) & ~0x7fffffff) != 0;
        int i_19_ = 0;
        i = i < 0 ? -i : i;
        i_18_ = i_18_ < 0 ? -i_18_ : i_18_;
        for (int i_20_ = 0; i_20_ < 3; i_20_++) {
            i_19_ += -(i_18_ & 0x1) & i;
            i_18_ >>= 1;
            i_19_ = (i_19_ >>= 1) + (-(i_18_ & 0x1) & i);
            i_18_ >>= 1;
            i_19_ = (i_19_ >>= 1) + (-(i_18_ & 0x1) & i);
            i_18_ >>= 1;
            i_19_ = (i_19_ >>= 1) + (-(i_18_ & 0x1) & i);
            i_18_ >>= 1;
            i_19_ >>= 1;
        }
        for (int i_21_ = 0; i_21_ < 6; i_21_++) {
            i_19_ += -(i_18_ & 0x1) & i;
            i_18_ >>= 1;
            i <<= 1;
            i_19_ += -(i_18_ & 0x1) & i;
            i_18_ >>= 1;
            i <<= 1;
            i_19_ += -(i_18_ & 0x1) & i;
            i_18_ >>= 1;
            i <<= 1;
        }
        i_19_ += -(i_18_ & 0x1) & i;
        if (bool) {
            return -i_19_;
        }
        return i_19_;
    }

    public static int b(int i, int i_22_, int i_23_, int i_24_) {
        i = java.lang.Math.abs(i - i_23_) >> 12;
        i_22_ = java.lang.Math.abs(i_22_ - i_24_) >> 12;
        return i * i + i_22_ * i_22_;
    }

    public static int a(int i, int i_25_, int i_26_, int i_27_, int i_28_,
            int i_29_, boolean bool) {
        int i_30_ = i;
        int i_31_ = i_25_;
        int i_32_ = i_26_;
        int i_33_ = i_27_;
        int i_34_ = i_28_;
        int i_35_ = i_29_;
        boolean bool_36_ = !bool;
        int i_37_ = i_35_;
        int i_38_ = i_34_;
        int i_39_ = i_33_;
        int i_40_ = i_32_;
        int i_41_ = i_31_;
        int i_42_;
        if ((i_42_ = i_30_) > i_40_) {
            int i_43_ = i_42_;
            i_42_ = i_40_;
            i_40_ = i_43_;
            i_43_ = i_41_;
            i_41_ = i_39_;
            i_39_ = i_43_;
        }
        int i_44_ = i_42_;
        int i_45_ = java.lang.Math.min(i_41_, i_39_);
        i_42_ = i_40_ - i_42_;
        int i_46_ = java.lang.Math.abs(i_39_ - i_41_);
        i_38_ -= i_44_;
        i_37_ -= i_45_;
        i_41_ -= i_45_;
        i_40_ -= i_44_;
        i_39_ -= i_45_;
        boolean bool_47_;
        if (i_38_ < 0 || i_38_ > i_42_ || i_37_ < 0 || i_37_ > i_46_) {
            bool_47_ = false;
        } else {
            i_42_ = i_38_ >> 8;
            i_38_ = i_37_ - i_41_ >> 8;
            i_40_ >>= 8;
            i_41_ = i_39_ - i_41_ >> 8;
            i_42_ = i_42_ * i_41_ - i_40_ * i_38_;
            bool_47_ = bool_36_ ? i_42_ <= 0 : i_42_ >= 0;
        }
        if (bool_47_) {
            i_26_ = java.lang.Math.abs(i_26_ - i);
            i_42_ = java.lang.Math.abs(i_27_ - i_25_);
            if (i_25_ <= i_27_) {
                i_25_ = main.ImageUtils.b(main.ImageUtils
                        .c(i_29_ - i_25_, i_42_),
                        i_26_);
            } else {
                i_25_ = main.ImageUtils.b(main.ImageUtils
                        .c(i_25_ - i_29_, i_42_),
                        i_26_);
            }
            return i + i_25_ - i_28_;
        }
        return 0;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    ///////////////////////////////////////////
    ///                DEBUG
    ///////////////////////////////////////////
    
    
    private static boolean dumpPalettesToFile = false;
    private static Vector dumpedFiles = new Vector(50);
    
    private static void dumpPaletteToFile(String fileName, ImageData img) {
        
        if (dumpedFiles.contains(fileName)) return; // already processed
        dumpedFiles.addElement(fileName);
        
        String dir = FileSystemRegistry.listRoots().nextElement().toString();
        
        // Create image
        Image image = img.getImage();
        
        byte[] bytes = ObjectArt.imageToByteArray(image);
        
        if (bytes != null) {
        
            try{
                // file for image
                FileConnection imageFileConnection = (FileConnection)Connector.open("file:///" + dir + fileName + ".bin");
                if (imageFileConnection.exists()){
                    imageFileConnection.delete();
                }
                imageFileConnection.create();
                OutputStream imageStream = imageFileConnection.openOutputStream();

                imageStream.write(bytes);

                imageStream.flush();
                imageStream.close();
            }catch(IOException e){
                e.printStackTrace();
            }
            
        }
    }
    
    
    
    
}
