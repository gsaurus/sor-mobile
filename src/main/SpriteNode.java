/* g - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
package main;

import java.io.DataInputStream;
import java.io.IOException;

class SpriteNode {

    private main.ObjectArt originalObjectArt;
    public main.SpritePiece spritePiece;
    public main.SpriteNode[] subSprites;
    public int originalOffsetX;
    public int originalOffsetY;
    public int finalOffsetX;
    public int finalOffsetY;
    private short pieceIndex = -1;
    public byte g;
    public byte h;

    public SpriteNode(main.ObjectArt var_ad) {
        this.originalObjectArt = var_ad;
    }

    public void load(java.io.DataInputStream datainputstream, main.SpritePiecesGroup piecesGroup) {
        try {
            this.originalOffsetX = datainputstream.readShort();
            this.originalOffsetY = datainputstream.readShort();
            this.g = datainputstream.readByte();
            this.pieceIndex = (short) (0xff & datainputstream.readByte());
            this.spritePiece = piecesGroup.getSpritePiece(this.pieceIndex); // The single piece of this sprite object
            int numSubSprites = datainputstream.readByte();
            this.subSprites = new main.SpriteNode[numSubSprites];
            
            // SubSprites tree
            for (int i = 0; i < numSubSprites; i++) {
                switch (datainputstream.readByte()) {
                    case 3:
                        this.subSprites[i] = new main.SpriteNode(this.originalObjectArt);
                        break;
                    case 4:
                        this.subSprites[i] = new main.SpriteLeaf1(this.originalObjectArt);
                        break;
                    case 6:
                        this.subSprites[i] = new main.SpriteLeaf2(this.originalObjectArt);
                        break;
                }
                this.subSprites[i].load(datainputstream, piecesGroup);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void applyOffset(int i, int i_1_) {
        // Why doesn't it apply offset to itself and all children?
        /* empty */
    }

    public void draw() {
        // Why doesn't it draw self spritePiece and all children nodes?
        /* empty */
    }

    public final void clearAllData() {
        for (int i = 0; i < this.subSprites.length; i++) {
            this.subSprites[i].clearAllData();
            this.subSprites[i] = null;
        }
        this.spritePiece = null;
        this.subSprites = null;
        this.originalObjectArt = null;
    }

    public boolean a(main.IntPair offset) {
        for (this.h = 0; this.h < this.subSprites.length; this.h++) {
            if (this.subSprites[this.h].a(offset)) {
                return true;
            }
        }
        return false;
    }
}
