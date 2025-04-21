/* q - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
package main;

public final class Point {

    public int x;
    public int z;
    public int y;

    public Point() {
        this.x = 0;
        this.z = 0;
        this.y = 0;
    }

    public Point(int x, int z, int y) {
        this.set(x, z, y);
    }

    public final void set(int x, int z, int y) {
        this.x = x;
        this.z = z;
        this.y = y;
    }

    public final void set(main.Point p) {
        this.x = p.x;
        this.z = p.z;
        this.y = p.y;
    }

    public final void add(main.Point p) {
        this.x += p.x;
        this.z += p.z;
        this.y += p.y;
    }
}
