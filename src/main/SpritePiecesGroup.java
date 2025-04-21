/* l - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
package main;

import java.io.DataInputStream;
import java.io.IOException;

final class SpritePiecesGroup {

    // Those are the actual sprites
    private static final main.SpriteNode[][] allSprites = new main.SpriteNode[2][100]; // Only first element is used
    private static final short[] totalSprites = new short[2];                  // Only first element is used
    
    //private static final byte d = 0; unused field
    private static final main.SpritePiece emptySpritePiece = new main.SpritePiece(null);
    
    // The original pieces
    private main.SpritePiece[] spritePieces; // all sprite pieces stored here
    // The original art source
    public main.ObjectArt objectArt;

    public SpritePiecesGroup(main.ObjectArt objArt) {
        this.objectArt = objArt;
    }

    public final void readFromInputStream(java.io.DataInputStream datainputstream) {
        try {
            totalSprites[0] = (short) (0xff & datainputstream.readByte());
            this.spritePieces = new main.SpritePiece[totalSprites[0]];
            for (int i = 0; i < totalSprites[0]; i++) {
                switch (datainputstream.readByte()) {
                    case 0:
                        this.spritePieces[i] = new main.SpritePiece(this);       // it's a pointer to a Concrete Art Piece
                        break;
                    case 1:
                        this.spritePieces[i] = new main.SpritePieceBounds(this); // Concrete Art Piece
                        break;
                }
                this.spritePieces[i].readFromInputStream(datainputstream);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public final main.SpritePiece getSpritePiece(int i) {
        if (i < 0 || i >= this.spritePieces.length) {
            return emptySpritePiece;
        }
        return this.spritePieces[i];
    }

    public final void clearAllData() {
        if (this.spritePieces != null) {
            for (int i = 0; i < this.spritePieces.length; i++) {
                this.spritePieces[i] = null;
            }
        }
        this.spritePieces = null;
        this.objectArt = null;
    }

    public static void resetTotalNumSprites() {
        totalSprites[0] = (short) 0;
    }

    public static void storeSprite(main.SpriteNode sprite) {
        allSprites[0][totalSprites[0]] = sprite;
        totalSprites[0]++;
    }

    public static void drawAllActiveSprites() {
        for (int i = 0; i < totalSprites[0]; i++) {
            allSprites[0][i].draw();
        }
    }
}
