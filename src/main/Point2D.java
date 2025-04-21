/* m - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
package main;

public final class Point2D {

    public int x;
    public int y;

    public Point2D() {
        this.x = 0;
        this.y = 0;
    }

    public Point2D(int x, int y) {
        this.set(x, y);
    }

    public final void set(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
