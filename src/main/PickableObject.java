/* x - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
package main;

public final class PickableObject extends main.AbstractObject {

    private static final int[] W = {81920, 94208, 81920, 81920};
    private static final int[] X;
    private static final int[] Y;
    private static final int[] Z;
    private static final int[] aa;
    private static final int[] ab;
    private static main.AbstractObject ac;
    private main.Point ad;
    private int ae;
    private int af;
    private boolean ag;
    private boolean ah;

    static {
        (new int[]{4096, 4096, 4096, 0})[3] = 4096;
        X = new int[]{10240, 10240, 4096, 10240};
        (new int[]{532, 532, 409, 0})[3] = 532;
        Y = new int[]{25, 25, 25, 25};
        Z = new int[]{23, 24, 27, 30};
        aa = new int[]{32768, 32768, 32768};
        ab = new int[]{20480, 32768, 32768};
    }

    public PickableObject(main.ObjectArt var_ad, int i, int i_0_, int i_1_,
            int i_2_, int i_3_, int i_4_, int i_5_) {
        super(i_0_, 0, i_1_, i_2_, i_3_, i_4_, i_5_);
        if (i_0_ == 20 || i_0_ == 23) {
            this.direction = 1;
        }
        this.stateFlags |= 0x801;
        this.r = new main.eExtendsAr(0, var_ad, i);
        this.velocityX = 32768;
        this.velocityZ = 8192;
        this.energy = 1;
        this.c(0);
        this.r.setC(this.s());
        this.maxEnergy = this.energy;
        this.visualEnergy = main.GameManager.f(this.energy);
        this.state = 4;
        switch (this.objectType) {
            case 18:
                this.soundToPlayOnContact = 60;
                this.x = 2;
                if (i_4_ == 0) {
                    this.g.x = aa[this.difficultyAi];
                } else {
                    this.g.x = -aa[this.difficultyAi];
                    break;
                }
                break;
            case 19:
                this.state = 3;
                this.name = "KILLER_WAGON";
                break;
            case 21:
                this.x = 1;
                this.name = "PEPPER";
                break;
            case 20:
                this.x = 12;
                this.name = "GUS";
                break;
            case 23:
                this.name = "FIRE_OF_BOMB";
        }
    }

    public PickableObject(main.ObjectArt var_ad, main.AbstractObject var_af,
            int distXToPl1, int distZToPl1, int i_7_, int i_8_) {
        super(var_af.objectType, var_af.difficultyAi, var_af.position.x, var_af.position.z, var_af.position.y,
                var_af.objectType == 17 ? var_af.direction : 1, 0);
        this.stateFlags |= 0x801;
        this.r = new main.eExtendsAr(0, var_ad, distZToPl1);
        this.velocityX = 32768;
        this.velocityZ = 8192;
        this.D = false;
        this.c(distXToPl1);
        this.energy = 1;
        this.maxEnergy = this.energy;
        this.visualEnergy = main.GameManager.f(this.energy);
        this.af = i_8_;
        this.name = var_af.name;
        this.state = 4;
        main.AbstractObject pl1 = main.GameManager.getPlayer1();
        if (pl1 == null) pl1 = GameManager.getPlayer2();
        distXToPl1 = 0;
        distZToPl1 = 0;
        if (pl1 != null) {
            distXToPl1 = this.getDistanceX(pl1);
            distZToPl1 = pl1.position.z - var_af.position.z;
        }
        switch (this.objectType) {
            case 0:
            case 8: {
                this.g.set(0, 0, 0);
                this.x = 1;
                main.Point var_q = this.position;
                var_q.x = var_q.x + (var_af.direction == 0 ? 122880 : -122880);
                this.position.y += 204800;
                this.state = i_7_;
                this.soundToPlayOnContact = 4;
                switch (i_7_) {
                    case 0:
                        this.x = 2;
                        this.g.x = var_af.direction == 0 ? 32768 : -32768;
                        break;
                    case 1:
                        this.g.y = 102400;
                        this.g.x = (pl1.position.x - this.position.x) / 12;
                        break;
                    case 2:
                        this.x = 2;
                        this.g.x = var_af.direction == 0 ? 49152 : -49152;
                        break;
                    case 3:
                        this.g.y = 102400;
                        this.g.x = (pl1.position.x - this.position.x) / 12;
                    /* fall through */
                    default:
                        break;
                }
                break;
            }
            case 10: {
                this.soundToPlayOnContact = 60;
                this.difficultyAi = i_7_;
                ac = var_af;
                main.Point var_q = this.position;
                var_q.x = var_q.x + (var_af.direction == 0 ? 204800 : -204800);
                this.position.y += 204800;
                this.x = 1;
                this.ae = var_af.direction;
                this.ad = new main.Point();
                if (2 == i_7_) {
                    this.g.x = var_af.direction == 0 ? W[i_7_] : -W[i_7_];
                    this.g.z = (int) (((long) distZToPl1 << 12)
                            / (((long) distXToPl1 << 12)
                            / (long) java.lang.Math
                            .abs(this.g.x)));
                    this.ad.x = -this.g.x / Y[i_7_];
                    this.ad.z = -this.g.z / Z[i_7_];
                } else {
                    this.g.x = var_af.direction == 0 ? W[i_7_] : -W[i_7_];
                    this.g.z = X[i_7_];
                    this.ad.x = -this.g.x / Y[i_7_];
                    this.ad.z = -this.g.z / Z[i_7_];
                    break;
                }
                break;
            }
            case 15: {
                this.soundToPlayOnContact = 4;
                this.x = 1;
                main.Point var_q = this.position;
                var_q.x = var_q.x + (var_af.direction == 0 ? 122880 : -122880);
                this.g.set(0, 0, 0);
                this.position.y += 204800;
                this.g.x = var_af.direction == 0 ? 32768 : -32768;
                switch (i_7_) {
                    case 0:
                        this.g.x = var_af.direction == 0 ? 32768 : -32768;
                        if (main.Harakiri.W[var_af.difficultyAi] / 3 << 1 < var_af.energy) {
                            this.g.z
                                    = (int) (((long) pl1.position.z - (long) this.position.z << 12)
                                    / (((long) pl1.position.x - (long) this.position.x
                                    << 12)
                                    / (long) this.g.x));
                        }
                        if (8192 < java.lang.Math.abs(this.g.z)) {
                            this.g.z = 8192 * (this.g.z < 0 ? -1 : 1);
                        }
                        break;
                    case 1:
                        this.g.x = var_af.direction == 0 ? 24576 : -24576;
                        this.g.z = 8192;
                        break;
                    case 2:
                        this.g.x = var_af.direction == 0 ? 24576 : -24576;
                        this.g.z = -8192;
                        break;
                    case 3:
                        this.position.z += 49152;
                        this.g.x = var_af.direction == 0 ? 32768 : -32768;
                        break;
                    case 4:
                        this.g.x = var_af.direction == 0 ? 16384 : -16384;
                        this.g.z = 16384;
                        break;
                    case 5:
                        this.g.x = var_af.direction == 0 ? 16384 : -16384;
                        this.g.z = -16384;
                        break;
                }
                this.g.x = this.g.x * 6144 >> 12;
                this.g.z = this.g.z * 6144 >> 12;
                break;
            }
            case 17:
                this.soundToPlayOnContact = 60;
                this.ag = false;
                this.x = 2;
                this.position.z = var_af.position.z;
                this.position.y = var_af.position.y + 163840;
                this.g.z = 1 - main.GameManager.getRandomNumber(3) << 12;
                switch (i_7_) {
                    case 0: {
                        int i_10_ = 204800;
                        this.position.x = var_af.position.x + (var_af.direction == 0 ? i_10_ : -i_10_);
                        this.position.y = var_af.position.y + 253952;
                        this.g.x = var_af.direction == 0 ? 40960 : -40960;
                        return;
                    }
                    case 1: {
                        int i_11_ = 163840;
                        this.position.x = var_af.position.x + (var_af.direction == 0 ? i_11_ : -i_11_);
                        this.g.x = var_af.direction == 0 ? 28672 : -28672;
                        this.g.z = 28672;
                        return;
                    }
                    case 2: {
                        int i_12_ = 32768;
                        this.position.x = var_af.position.x + (var_af.direction == 0 ? i_12_ : -32768);
                        this.g.z = 40960;
                        return;
                    }
                    case 3: {
                        main.Point2D var_m = new main.Point2D();
                        this.direction = 1;
                        this.g();
                        this.h();
                        this.r.a(2020793310, var_af.u, var_m);
                        this.c(27);
                        this.position.x = var_af.position.x + var_m.x;
                        this.position.z = var_af.position.z;
                        this.position.y = -var_m.y;
                        this.g.x = 10 - main.GameManager.getRandomNumber(21) << 12;
                        this.g.y = 10 + main.GameManager.getRandomNumber(11) << 12;
                        this.ag = true;
                        break;
                    }
                }
        }
    }

    public final void update() {
        main.AbstractObject player = getPlayerTarget();
        this.D = false;
        switch (this.objectType) {
            case 8:
                if (this.position.y <= 0) {
                    this.markToDie();
                } else if (!this.isInsideScreen(50, 0)) {
                    this.markToDie();
                }
                break;
            case 10:
                if (this.ae == 0) {
                    if (this.position.x < main.GameManager.h) {
                        this.markToDie();
                    }
                } else if (main.GameManager.g < this.position.x) {
                    this.markToDie();
                }
                break;
            case 15:
                switch_0_:
                switch (this.state) {
                    case 4:
                        switch (this.objectType) {
                            case 15:
                                if ((this.g.x <= 0
                                        || main.GameManager.h + 1310720 >= this.position.x)
                                        && (this.g.x >= 0
                                        || this.position.x >= main.GameManager.h)) {
                                    break;
                                }
                                this.markToDie();
                        }
                        break;
                    case 14:
                        switch (this.objectType) {
                            case 15:
                                this.p++;
                                if (this.position.y <= 0) {
                                    this.markToDie();
                                    break;
                                }
                                break switch_0_;
                        }
                }
                break;
            case 17:
                if (!this.isInsideScreen(50, 50)) {
                    this.markToDie();
                }
                break;
            case 18:
            case 19:
                switch (this.state) {
                    case 3:
                        this.p++;
                        this.o++;
                        this.r.a |= 0x1;
                        if (player != null && player.position.x < this.position.x) {
                            this.setState(4);
                        }
                        break;
                    case 4:
                        this.position.x += 24576;
                        if (this.direction == 0 && main.GameManager.screenLockX + 819200 < this.position.x
                                || (this.direction != 0
                                && this.position.x < main.GameManager.screenLockX - 819200)) {
                            this.markToDie();
                        }
                        break;
                    case 14:
                        if (!this.loopMovement) {
                            break;
                        }
                        this.markToDie();
                }
                break;
            case 21:
                if (this.loopMovement) {
                    int i = this.direction == 0 ? this.position.x + 491520 : this.position.x - 491520;
                    main.GameManager.spawnObject(109, i, this.position.z, this.position.y, this.direction, 0,
                            0);
                    this.markToDie();
                }
                break;
            case 20:
                if (this.loopMovement) {
                    this.markToDie();
                }
                break;
            case 23:
                this.r.d = 450;
                if (this.loopMovement) {
                    this.markToDie();
                }
                break;
        }
        this.i();
        this.h();
    }

    public final void checkHammerSmash() {
        if (this.o <= 0 && main.MainCanvas.mainState == 14) {
            int i = 81920;
            for (int i_13_ = 0; i_13_ < main.GameManager.collidableObjects.size();
                    i_13_++) {
                main.AbstractObject var_af
                        = ((main.AbstractObject) main.GameManager.collidableObjects.elementAt(i_13_));
                if (this != var_af) {
                    boolean bool = false;
                    switch (this.objectType) {
                        case 8:
                        case 10:
                        case 15:
                            if (this.state != 14) {
                                bool = ((var_af.stateFlags & 0x600) == 0
                                        && (var_af.stateFlags & 0x800) == 0);
                                break;
                            }
                            return;
                        case 17:
                            bool = var_af.objectType != 17;
                            break;
                        case 20:
                        case 21:
                        case 23:
                            bool = (var_af.stateFlags & 0x600) != 0;
                            break;
                        case 19:
                            bool = (var_af.stateFlags & 0x700) != 0;
                            break;
                    }
                    if (this.o > 0) {
                        bool = false;
                    }
                    if (bool && this.a(var_af, i)) {
                        if (this.objectType == 19) {
                            this.c(36, 0, 36);
                        } else if (this.objectType == 21) {
                            var_af.c(0, 0, 40);
                        } else {
                            this.c(0, 0, 8);
                        }
                        main.PickableObject.playSound(this.soundToPlayOnContact);
                        main.GameManager.a();
                        if (this.objectType != 21) {
                            main.AbstractObject var_af_14_ = var_af;
                            main.AbstractObject var_af_15_ = null;
                            int i_16_ = this.A;
                            int i_17_ = this.x;
                            int i_18_ = this.direction;
                            main.PickableObject var_x_19_ = this;
                            int i_20_ = 0;
                            switch (var_x_19_.objectType) {
                                case 8:
                                case 10:
                                case 15:
                                case 17:
                                    i_20_ = var_x_19_.af;
                                    break;
                                case 19:
                                    i_20_ = 1000;
                                    break;
                            }
                            var_af_14_.onAttackContact(var_af_15_, i_16_, i_17_, i_18_,
                                    i_20_);
                            var_af.p = 10;
                        } else {
                            short[] is;
                            int i_21_
                                    = ((is = this.r.c()[0].asShortArray())[0] * (this.direction == 0
                                    ? 1 : -1)
                                    << 12);
                            int i_22_ = -is[1] << 12;
                            main.GameManager.spawnObject(109, this.position.x + i_21_,
                                    this.position.z, i_22_, this.direction,
                                    0, 0);
                            this.markToDie();
                        }
                    }
                }
            }
            switch (this.objectType) {
                case 10:
                    if (this.a(ac, 81920)) {
                        this.e(0);
                        ac.onAttackContact(this, 0, 0, 0, 0);
                    }
            }
        }
    }

    public final void onAttackContact(main.AbstractObject var_af, int i, int i_23_,
            int i_24_, int i_25_) {
        if (this.energy > 0) {
            this.B = i;
            this.y = i_23_;
            this.C = i_24_ == 0 ? 1 : 0;
            this.q = 0;
            switch (this.objectType) {
                case 0:
                    break;
                case 8:
                    this.setState(14);
                    break;
                case 10:
                    if (var_af == ac) {
                        this.markToDie();
                    }
                    break;
                case 15:
                    this.setState(14);
                    break;
                case 19:
                    this.setState(14);
                    break;
            }
        }
    }

    public final void e() {
        this.energy = 0;
        switch (this.state) {
            case 15:
                if (this.y != 2) {
                    break;
                }
            /* fall through */
            case 14:
            case 17:
            case 18:
            case 19:
                return;
        }
        this.y = 2;
        this.setState(15);
    }

    public final void b() {
        if ((this.stateFlags & ~0x7fffffff) == 0) {
            main.ar.addElementToVector1(this.r);
        }
        if (this.ah) {
            this.markToDie();
        }
    }

    public final void clearData() {
        this.clearAbstractData();
    }

    public final boolean d() {
        return false;
    }

    protected final void i() {
        switch (this.objectType) {
            case 8:
                if (this.state == 1 || this.state == 3) {
                    super.i();
                } else {
                    this.position.x += this.g.x;
                    this.position.y += this.g.y;
                    if (this.g.y != 0 && (this.g.y -= 16384) < -131072) {
                        this.g.y = -131072;
                    }
                }
                break;
            case 10:
                this.position.x += this.g.x;
                this.position.z += this.g.z;
                this.g.x += this.ad.x;
                this.g.z += this.ad.z;
                break;
            case 15:
                this.position.x += this.g.x;
                this.position.z += this.g.z;
                this.position.y += this.g.y;
                if (this.g.y != 0 && (this.g.y -= 16384) < -131072) {
                    this.g.y = -131072;
                }
                break;
            case 17:
                if (this.currAnimFrame != 0) {
                    this.position.x += this.g.x;
                    this.position.z += this.g.z;
                    this.position.y += this.g.y;
                    if (this.position.y < 0) {
                        this.position.y = 0;
                        this.g.y = -(this.g.y / 2);
                        if (java.lang.Math.abs(this.g.y) < 8192) {
                            this.ah = true;
                        }
                    }
                    if (this.ag && this.ag && (this.g.y -= 16384) < -131072) {
                        this.g.y = -131072;
                    }
                }
                break;
            case 18:
            case 19:
                this.position.x += this.g.x;
                break;
        }
        int i = main.GameManager.f(this.energy);
        if (this.visualEnergy > i) {
            this.visualEnergy--;
        } else if (i < this.visualEnergy) {
            this.visualEnergy++;
        }
    }

    public final void setState(int i) {
        main.AbstractObject player = main.GameManager.getPlayer1();
        if (player == null) player = GameManager.getPlayer2();
        this.state = i;
        switch (this.objectType) {
            case 0:
                break;
            case 8:
                switch (i) {
                    case 0:
                        break;
                    case 14: {
                        this.x = 0;
                        main.Point var_q = this.g;
                        var_q.x = -var_q.x;
                        this.g.y = -1;
                    }
                    /* fall through */
                    default:
                        break;
                }
                break;
            case 15:
                switch (i) {
                    case 14: {
                        this.af = 0;
                        main.Point var_q = this.g;
                        var_q.x = -var_q.x;
                        this.g.y = 40960;
                        break;
                    }
                    default:
                        break;
                }
                break;
            case 19:
                switch (i) {
                    case 4:
                        this.r.a &= ~0x1;
                        this.x = 2;
                        this.position.x = this.direction == 0 ? this.position.x - 819200 : this.position.x + 819200;
                        this.position.z = player.position.z;
                        if (this.direction == 0) {
                            this.velocityX = ab[this.difficultyAi];
                        } else {
                            this.velocityX = -ab[this.difficultyAi];
                            return;
                        }
                        return;
                    case 14:
                        this.c(1);
                        break;
                }
        }
    }
}
