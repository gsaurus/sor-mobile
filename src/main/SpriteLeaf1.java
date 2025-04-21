/* as - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
package main;

import java.io.DataInputStream;

final class SpriteLeaf1 extends main.SpriteNode {

    public SpriteLeaf1(main.ObjectArt objArt) {
        super(objArt);
    }

    public final void load(java.io.DataInputStream datainputstream, main.SpritePiecesGroup piecesGroup) {
        super.load(datainputstream, piecesGroup);
    }

    public final void applyOffset(int dx, int dy) {
        this.finalOffsetX = dx + this.originalOffsetX;
        this.finalOffsetY = dy + this.originalOffsetY;
        main.SpritePiecesGroup.storeSprite(this);
        for (int i = 0; i < this.subSprites.length; i++) {
            this.subSprites[i].applyOffset(dx, dy);
        }
    }

    public final void draw() {
        this.spritePiece.draw(this.finalOffsetX, this.finalOffsetY);
    }
}
