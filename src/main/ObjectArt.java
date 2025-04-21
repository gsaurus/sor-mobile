/* ad - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
package main;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.Vector;
import javax.microedition.io.Connector;
import javax.microedition.io.file.FileConnection;
import javax.microedition.io.file.FileSystemRegistry;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public final class ObjectArt {
    
    private static boolean drawnToDisk = false;    // Debug
    private static byte[][] dataCache;             // Debug
    private static int dataCacheSize = 0;          // Debug
    private static int outputFileNum = 0;   // Debug

    public static javax.microedition.lcdui.Graphics screenGraphics;
    private main.SpritePiecesGroup spritePiecesGroup = new main.SpritePiecesGroup(this);
    private short currAnimationId;
    private main.SpriteAnimation[] animations;
    private javax.microedition.lcdui.Image[] imagesArray;

    public final void setImagesArray(javax.microedition.lcdui.Image[] images) {
        this.imagesArray = images;
    }

    public final javax.microedition.lcdui.Image a(int objectId) {
        main.ObjectArt var_ad_0_ = this;
        int i_1_ = objectId;
        main.ObjectArt var_ad_2_;
        if ((var_ad_2_ = var_ad_0_).imagesArray[i_1_] == null) {
            for (i_1_ = 0; i_1_ < main.GameManager.charSpriteImages.length; i_1_++) {
                if (main.GameManager.charSpriteImages[i_1_] == var_ad_2_.imagesArray) {
                    if (i_1_ == 13 || i_1_ == 14) {
                        main.GameManager.releaseDataForCharacter(7);
                        main.GameManager.releaseDataForCharacter(6);
                        main.GameManager.releaseDataForCharacter(5);
                        main.GameManager.releaseDataForCharacter(9);
                        main.GameManager.releaseDataForCharacter(8);
                        java.lang.System.gc();
                    } else if (i_1_ == 12) {
                        main.GameManager.releaseDataForCharacter(9);
                        java.lang.System.gc();
                    }
                    for (int i_3_ = 0; i_3_ < var_ad_2_.imagesArray.length; i_3_++) {
                        var_ad_2_.imagesArray[i_3_] = main.ImageUtils.createImage(main.GameManager.characterArtFiles[i_1_][i_3_]);
                    }
                    break;
                }
            }
            for (i_1_ = 0; i_1_ < main.GameManager.I.length; i_1_++) {
                if (main.GameManager.I[i_1_] == var_ad_2_.imagesArray) {
                    if (i_1_ == 13 || i_1_ == 14) {
                        main.GameManager.releaseDataForCharacter(7);
                        main.GameManager.releaseDataForCharacter(6);
                        main.GameManager.releaseDataForCharacter(5);
                        main.GameManager.releaseDataForCharacter(9);
                        main.GameManager.releaseDataForCharacter(8);
                        java.lang.System.gc();
                    } else if (i_1_ == 12) {
                        main.GameManager.releaseDataForCharacter(9);
                        java.lang.System.gc();
                    }
                    for (int i_4_ = 0; i_4_ < var_ad_2_.imagesArray.length; i_4_++) {
                        var_ad_2_.imagesArray[i_4_]
                                = main.ImageUtils.applyPalette((main.GameManager.characterArtFiles[i_1_][i_4_]),
                                        (main.GameManager.characterPaletteBFiles[i_1_][i_4_]));
                    }
                    break;
                }
            }
            for (i_1_ = 0; i_1_ < main.GameManager.J.length; i_1_++) {
                if (main.GameManager.J[i_1_] == var_ad_2_.imagesArray) {
                    if (i_1_ == 13 || i_1_ == 14) {
                        main.GameManager.releaseDataForCharacter(7);
                        main.GameManager.releaseDataForCharacter(6);
                        main.GameManager.releaseDataForCharacter(5);
                        main.GameManager.releaseDataForCharacter(9);
                        main.GameManager.releaseDataForCharacter(8);
                        java.lang.System.gc();
                    } else if (i_1_ == 12) {
                        main.GameManager.releaseDataForCharacter(9);
                        java.lang.System.gc();
                    }
                    for (int i_5_ = 0; i_5_ < var_ad_2_.imagesArray.length; i_5_++) {
                        var_ad_2_.imagesArray[i_5_]
                                = main.ImageUtils.applyPalette((main.GameManager.characterArtFiles[i_1_][i_5_]),
                                        (main.GameManager.characterPaletteCFiles[i_1_][i_5_]));
                    }
                    break;
                }
            }
        }
        return this.imagesArray[objectId];
    }

    public final void setAnimationId(int spriteId) {
        this.currAnimationId = (short) spriteId;
    }

    public final void readFromInputStream(java.io.DataInputStream dis) {
        try {
            this.spritePiecesGroup.readFromInputStream(dis);
            int numSprites = dis.readByte();
            this.animations = new main.SpriteAnimation[numSprites];
            for (int i = 0; i < numSprites; i++) {
                main.SpriteAnimation anim = new main.SpriteAnimation();
                anim.load(dis, this.spritePiecesGroup,this);
                this.animations[i] = anim;
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public final int currentAnimTotalTime() {
        return this.animations[this.currAnimationId].totalTime();
    }

    public final void draw(int posX, int posY, int frameNum) {
        //posX = 100; // Debug
        //posZ = 100; // Debug
        //frameNum = 0; // Debug
        main.MainCanvas.setRegionRotation(0);
        main.SpritePiecesGroup.resetTotalNumSprites();
        this.animations[this.currAnimationId].applyOffset(posX, posY, frameNum);
        main.SpritePiecesGroup.drawAllActiveSprites();
        main.MainCanvas.setRegionRotation(0);
        
        //drawAllToDisk(); // Debug
    }
    

    
    public final void clearData() {
        if (this.spritePiecesGroup != null) {
            this.spritePiecesGroup.clearAllData();
            this.spritePiecesGroup = null;
        }
        if (this.animations != null) {
            for (int i = 0; i < this.animations.length; i++) {
                if (this.animations[i] != null) {
                    this.animations[i].b();
                    this.animations[i] = null;
                }
            }
            this.animations = null;
        }
    }

    public final void a(int i, int i_9_, main.IntPair var_an) {
        var_an.first = 0;
        var_an.second = 0;
        this.animations[this.currAnimationId].a(i, i_9_, var_an);
    }

    public final byte[] a(int i, int i_10_, int i_11_, int i_12_, int i_13_,
            main.ObjectArt var_ad_14_, int i_15_,
            int i_16_, int i_17_, int i_18_, int i_19_) {
        main.SpriteAnimation var_u = this.animations[i_11_];
        int i_20_ = i;
        int i_21_ = i_10_;
        int i_22_ = i_12_;
        byte i_23_ = (byte) i_13_;
        main.FrameData[] var_aws = var_ad_14_.a(i_17_, i_18_);
        int i_24_ = i_15_;
        int i_25_ = i_16_;
        byte i_26_ = (byte) i_19_;
        i_15_ = i_25_;
        int i_27_ = i_24_;
        main.FrameData[] var_aws_28_ = var_aws;
        byte i_29_ = i_23_;
        i_11_ = i_22_;
        i_10_ = i_21_;
        i = i_20_;
        main.SpriteAnimation var_u_30_ = var_u;
        if (var_aws_28_ == null) {
            return null;
        }
        main.FrameData[] var_aws_31_ = var_u_30_.getFrameDataArray(i_11_);
        byte[] is = new byte[var_aws_28_.length * var_aws_31_.length << 1];
        byte[] is_32_ = null;
        int i_33_ = 0;
        for (i_18_ = 0; i_18_ < var_aws_31_.length; i_18_++) {
            if (var_aws_31_[i_18_].getE() == i_29_) {
                for (i_19_ = 0; i_19_ < var_aws_28_.length; i_19_++) {
                    if (var_aws_28_[i_19_].getE() == i_26_
                            && var_aws_31_[i_18_].a(i, i_10_, i_27_, i_15_,
                                    var_aws_28_[i_19_])) {
                        is[i_33_++] = (byte) i_18_;
                        is[i_33_++] = (byte) i_19_;
                    }
                }
            }
        }
        if (i_33_ > 0) {
            is_32_ = new byte[i_33_];
            for (i_18_ = 0; i_18_ < i_33_; i_18_++) {
                is_32_[i_18_] = is[i_18_];
            }
        }
        return is_32_;
    }

    public final main.FrameData[] a(int i, int i_34_) {
        return this.animations[i].getFrameDataArray(i_34_);
    }
    
    
    
    
    
    
    
    
    
    
    
    ///////////////////////////////////////////////////////////////
    ///                           DEBUG
    ///////////////////////////////////////////////////////////////
    
    
    int getTotalAnimationsTime(){
        int total = 0;
        for (int i = 0 ; i < animations.length ; ++i){
            total += animations[i].getAnimationTime();
        }
        return total;
    }
    
    // DEBUG
    void drawAllToDisk()
    {
        if (drawnToDisk) return;
        
        drawnToDisk = true;
        Graphics oldGraphics = screenGraphics;
        dataCache = new byte[getTotalAnimationsTime()][];
        dataCacheSize = 0;
        try{
            for (int i = 0 ; i < animations.length ; ++i){
                setAnimationId(i);
                int totalTime = animations[i].getAnimationTime();
                for (int j = 0 ; j < totalTime ; ++j)
                {
                    // Create image
                    Image image = Image.createImage(500, 500);
                    screenGraphics = image.getGraphics();
                    
                    // Draw to it
                    try{
                        main.MainCanvas.setRegionRotation(0);
                        main.SpritePiecesGroup.resetTotalNumSprites();
                        animations[i].applyOffset(250, 250, j);
                        main.SpritePiecesGroup.drawAllActiveSprites();
                        main.MainCanvas.setRegionRotation(0);
                    }catch(Exception e){
                        // failed this sprite
                        e.printStackTrace();
                        //continue;
                    }
                    
                    // Dump image to byte array and filter duplicates
                    byte[] outBytes = imageToByteArray(image);
                    
                    if (outBytes != null){
                        
                        // Create file
                        //String dir = System.getProperty("fileconn.dir.photos");
                        String dir = FileSystemRegistry.listRoots().nextElement().toString();
                        FileConnection fileConnection = (FileConnection)Connector.open("file:///" + dir + outputFileNum + ".bin");
                        if (fileConnection.exists()){
                            fileConnection.delete();
                        }
                        fileConnection.create();
                        OutputStream outStream = fileConnection.openOutputStream();
                        
                        // write bytes to file
                        outStream.write(outBytes);
                        outStream.flush();
                        outStream.close();
                        
                        outputFileNum++;
                    }

                } // for each frame
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        // clear cache in the end
        dataCache = null;
        dataCacheSize = 0;
        screenGraphics = oldGraphics;
    }
    
    
    // Debug
    public static byte[] imageToByteArray(Image img){

        int[] imgRgbData = new int[img.getWidth() * img.getHeight()];
        try {
            img.getRGB(imgRgbData, 0, img.getWidth(), 0, 0, img.getWidth(), img.getHeight());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        int w = img.getWidth();
        int h = img.getHeight();
        
        // crop
        int top = h-1;
        for (int i = 0 ; i < imgRgbData.length ; ++i){
            if (imgRgbData[i] != -1){
                top = i/w;
                break;
            }
        }
        int bottom = 0;
        for (int i = imgRgbData.length-1 ; i > 0 ; --i){
            if (imgRgbData[i] != -1){
                bottom = i/w;
                break;
            }
        }
        // crop
        int left = w-1;
        boolean found = false;
        for (int x = 0 ; x < w && !found; ++x){
            for (int y = 0 ; y < h ; ++y){
                if (imgRgbData[y*w+x] != -1){
                    left = x;
                    found = true;
                    break;
                }
            }
        }
        int right = 0;
        found = false;
        for (int x = w-1 ; x > 0 && !found; --x){
            for (int y = 0 ; y < h ; ++y){
                if (imgRgbData[y*w+x] != -1){
                    right = x;
                    found = true;
                    break;
                }
            }
        }
        System.out.println("Finished loop with: " + left + ", " + right + ", " + top + ", " + bottom);
        if (left > right || top > bottom)
            return null; // invalid image
       
        w = right-left+1;
        h = bottom-top+1;
        
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ByteArrayOutputStream reversedBaos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(baos);
        DataOutputStream reversedDos = new DataOutputStream(reversedBaos);
        
        try{
            dos.writeInt(w);
            dos.writeInt(h);
            reversedDos.writeInt(w);
            reversedDos.writeInt(h);
            for (int y = top ; y <= bottom ; ++y){
                for (int x = left, x2 = right ; x <= right ; ++x, --x2){
                    dos.writeInt(imgRgbData[y*img.getWidth()+x]);
                    reversedDos.writeInt(imgRgbData[y*img.getWidth()+x2]);
                }
            }

            byte[] imageData = baos.toByteArray();
            byte[] reversedData = reversedBaos.toByteArray();
            reversedBaos.close();
            reversedDos.close();
            baos.close();
            dos.close();
            
            
            if (dataCache != null && (!addToCache(imageData) || !addToCache(reversedData))){
                // already exists
                return null;
            }
            
            
            return imageData;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Debug
    private static boolean addToCache(byte[] data){
        byte[] cacheData;
        boolean isEqual = true;
        for (int i = 0 ; i < dataCacheSize ; ++i){
            cacheData = dataCache[i];
            if (data.length == cacheData.length){
                for (int b = 0 ; b < data.length ; ++b){
                    if (data[b] != cacheData[b]){
                        isEqual = false;
                        break; // different
                    }
                }
                if (isEqual)
                    return false; // everything is equal
            }
        }
        dataCache[dataCacheSize] = data;
        ++dataCacheSize;
        return true;
    }
    
}
