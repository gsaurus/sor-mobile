/* ao - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
package main;

import java.io.DataInputStream;
import java.io.IOException;

// Equal to SpriteLeaf1, except that it skips one byte when reading...
final class SpriteLeaf2 extends main.SpriteNode {

    public SpriteLeaf2(main.ObjectArt objArt) {
        super(objArt);
    }

    public final void load(java.io.DataInputStream datainputstream, main.SpritePiecesGroup piecesGroup) {
        try {
            super.load(datainputstream, piecesGroup);
            datainputstream.readByte(); // skip one byte
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public final void applyOffset(int dx, int dy) {
        this.finalOffsetX = dx + this.originalOffsetX;
        this.finalOffsetY = dy + this.originalOffsetY;
        main.SpritePiecesGroup.storeSprite(this);
        for (this.h = (byte) 0; this.h < this.subSprites.length; this.h++) {
            this.subSprites[this.h].applyOffset(dx, dy);
        }
    }

    public final void draw() {
        /* empty */
    }

    public final boolean a(main.IntPair offset) {
        offset.first = this.originalOffsetX;
        offset.second = this.originalOffsetY;
        for (this.h = (byte) 0; this.h < this.subSprites.length; this.h++) {
            if (this.subSprites[this.h].a(offset)) {
                return true;
            }
        }
        return false;
    }
}
