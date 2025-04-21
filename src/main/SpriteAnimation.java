/* u - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
package main;

import java.io.DataInputStream;
import java.io.IOException;

final class SpriteAnimation {

    private int currentFrame;
    private main.SpriteAnimationFrame[] nodes;

    public final void load(java.io.DataInputStream dis, main.SpritePiecesGroup piecesGroup, main.ObjectArt objArt) {
        try {
            int numNodes = dis.readByte();
            this.nodes = new main.SpriteAnimationFrame[numNodes];
            for (int i_0_ = 0; i_0_ < numNodes; i_0_++) {
                this.nodes[i_0_] = new main.SpriteAnimationFrame();
                this.nodes[i_0_].load(dis, piecesGroup, objArt);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public final int totalTime() {
        int total = 0;
        for (int i = 0; i < this.nodes.length; i++) {
            total += this.nodes[i].frameDuration;
        }
        return total;
    }

    public final void applyOffset(int x, int y, int time) {
        this.currentFrame = 0;
        for (;;) {
            if ((time -= this.nodes[this.currentFrame].frameDuration) < 0) {
                this.nodes[this.currentFrame].applyOffset(x, y);
                break;
            }
            this.currentFrame++;
        }
    }

    public final void b() {
        for (int i = 0; i < this.nodes.length; i++) {
            this.nodes[i].a();
        }
        this.nodes = null;
    }

    public final void a(int i, int i_4_, main.IntPair var_an) {
        this.currentFrame = 0;
        for (;;) {
            try{
                if ((i_4_ -= this.nodes[this.currentFrame].frameDuration) < 0) {
                    this.nodes[this.currentFrame].a(i, var_an);
                    break;
                }
            }catch (ArrayIndexOutOfBoundsException e){
                e.printStackTrace();
                break;
            }
            this.currentFrame++;
        }
    }

    public final main.FrameData[] getFrameDataArray(int i) {
        this.currentFrame = 0;
        for (;;) {
            if ((i -= this.nodes[this.currentFrame].frameDuration) < 0) {
                return this.nodes[this.currentFrame].getFrameDataArray();
            }
            this.currentFrame++;
        }
    }
    
    
    // Debug
    public int getNumFrames()
    {
        return nodes.length;
    }
    
    // Debug
    public int getAnimationTime()
    {
        int duration = 0;
        for (int i = 0 ; i < nodes.length ; ++i){
            duration += nodes[i].frameDuration;
        }
        return duration;
    }
    
}
