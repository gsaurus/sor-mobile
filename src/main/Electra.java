/* aq - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
package main;

public final class Electra extends main.AbstractObject {

    private static final int[] energyByDifficulty = {2500, 5000, 7500};
    private boolean X;
    private static int Y;
    private static int Z;
    private static int aa;
    private static int ab;
    private static int ac;

    private static void P() {
        aa = 24 - main.GameManager.getRandomNumber(48) << 12;
        ab = 40 - main.GameManager.getRandomNumber(80) << 12;
    }

    public Electra(main.ObjectArt var_ad, int i, int i_0_, int i_1_,
            int i_2_, int i_3_, int i_4_) {
        super(7, i, i_0_, i_1_, i_2_, i_3_, i_4_);
        this.stateFlags |= 0x8201;
        this.r = new main.eExtendsAr(0, var_ad, 16);
        this.collisionBox
                = new main.CollisionBox(this.position,
                        new main.Point(131072,
                                131072,
                                131072));
        this.velocityX = main.Electra.Q();
        this.velocityZ = main.Electra.R();
        this.X = false;
        this.energy = energyByDifficulty[this.difficultyAi];
        main.Electra.P();
        ac = main.GameManager.getRandomNumber(14);
        this.maxEnergy = this.energy;
        this.visualEnergy = main.GameManager.f(this.energy);
        this.name = "QUEEN";
    }

    public final void setState(int i) {
        main.AbstractObject var_af = getPlayerTarget();
        this.state = i;
        this.o = 0;
        this.w();
        main.GameManager.getRandomNumber(100);
        switch (i) {
            case 3:
                this.g.set(0, 0, this.g.y);
                this.c(2);
                break;
            case 4:
                this.c(0);
                break;
            case 5:
                this.d(8);
                break;
            case 14:
                this.n = 32;
                this.d(7);
                break;
            case 12:
            case 13:
                this.d(3);
                break;
            case 15:
                switch (this.y) {
                    default:
                        this.direction = this.C;
                        this.d(4);
                        break;
                    case 2:
                        this.F();
                        this.c(6);
                }
                break;
            case 20:
                this.d(5);
                break;
            case 19:
                this.d(11);
                break;
            case 16:
                this.d(14);
                break;
            case 17:
                this.y = 9;
                this.d(9);
                break;
            case 18:
                this.E();
                this.c(10);
                break;
            case 22:
                this.d(15);
                break;
            case 7:
                main.AbstractObject.i(this);
                this.c(0);
                break;
            case 8:
                main.AbstractObject.h(this);
                this.c(0);
                break;
            case 9:
                main.AbstractObject.g(this);
                this.c(0);
                break;
            case 10:
                main.AbstractObject.f(this);
                this.c(0);
                break;
            case 11:
                main.AbstractObject.e(this);
                this.c(0);
                break;
            case 23:
                this.g.set(0, 0, this.g.y);
                this.c(2);
                break;
            case 24:
            case 26:
                main.Electra.P();
                if (this.state == Y && this.direction == Z) {
                    this.setState(25);
                } else {
                    this.c(0);
                }
                break;
            case 25:
                main.Electra.P();
                if (this.state == Y && this.direction == Z) {
                    this.setState(24);
                } else if (var_af == null) {
                    this.setState(3);
                } else {
                    main.Point var_q = var_af.b(-204800 + aa, ab, 0);
                    this.targetPosition.x = var_q.x;
                    this.targetPosition.y = var_q.z;
                    this.nextFrameToMove = 60;
                    this.c(0);
                }
                break;
            case 27:
                this.x = 2;
                this.d(12);
                break;
            case 28:
                this.c(2);
                break;
            case 29:
                if (var_af == null) {
                    this.setState(3);
                } else if (var_af.state == 15 || var_af.state == 5
                        || java.lang.Math
                        .abs(main.GameManager.screenLockX - this.position.x) > 409600) {
                    this.setState(28);
                } else {
                    this.x = 1;
                    this.X = false;
                    this.c(1);
                }
                break;
        }
        Y = this.state;
        Z = this.direction;
        this.h();
    }

    public final void update() {
        super.update();
        main.AbstractObject target = getPlayerTarget();
        this.D = false;
        if (this.state != 3 && this.q > 0) {
            this.setState(3);
        }
        if (target == null && !this.j()) {
            this.setState(3);
        }
        main.AbstractObject.j(this);
        while_4_:
        do {
            if (5 <= this.state && this.state <= 22) {
                this.a(this.state, V, target);
            } else {
                switch (this.state) {
                    case 0:
                        this.setState(3);
                    /* fall through */
                    case 3:
                        this.A = 0;
                        this.B = 0;
                        if (this.q > 0) {
                            this.q--;
                        } else if (target != null) {
                            this.setState(24);
                        } else {
                            this.q = 10;
                        }
                        break while_4_;
                    case 4:
                        this.A = 0;
                        this.B = 0;
                        break while_4_;
                    case 23:
                        if (this.currAnimFrame > 8) {
                            int rand100 = main.GameManager.getRandomNumber(100);
                            if (rand100 < 10 + (20 *(2-main.GameManager.currentDifficulty))) {
                                this.setState(25);
                            } else {
                                this.setState(26);
                            }
                        }
                        break while_4_;
                    case 24: {
                        this.velocityX = main.Electra.Q();
                        this.velocityZ = main.Electra.R();
                        if ((main.GameManager.i + ac) % 14 == 0) {
                            if (target.position.x < this.position.x) {
                                this.targetPosition.x = target.position.x + (212992 + aa);
                            } else {
                                this.targetPosition.x = target.position.x - (212992 + aa);
                            }
                        }
                        this.targetPosition.y = target.position.z + ab;
                        main.Electra.moveToTarget(this, target);
                        boolean bool;
                        if ((bool
                                = this.getDistanceX(target) < 204800 && this.getDistanceZ(target) < 20480)
                                || this.currAnimFrame > 48) {
                            int rand100 = main.GameManager.getRandomNumber(100);
                            if (2 == main.GameManager.currentDifficulty) {
                                if (rand100 <= 20) {
                                    if (rand100 > 8) {
                                        this.setState(25);
                                    } else {
                                        this.setState(26);
                                    }
                                    break while_4_;
                                }
                            } else if (1 == main.GameManager.currentDifficulty) {
                                if (rand100 <= 50) {
                                    if (rand100 > 20) {
                                        this.setState(25);
                                    } else {
                                        this.setState(26);
                                    }
                                    break while_4_;
                                }
                            }else if (rand100 <= 85) {
                                if (rand100 > 60) {
                                    this.setState(25);
                                } else {
                                    this.setState(26);
                                }
                                break while_4_;
                            }
                        } else {
                            this.R = 7;
                            break while_4_;
                        }
                        break;
                    }
                    case 26:
                        this.velocityX = main.Electra.Q();
                        this.velocityZ = main.Electra.R();
                        if ((main.GameManager.i + ac) % 14 == 0) {
                            if (target.position.x < this.position.x) {
                                this.targetPosition.x = target.position.x + (147456 + aa);
                            } else {
                                this.targetPosition.x = target.position.x - (147456 + aa);
                            }
                        }
                        this.targetPosition.y = target.position.z + ab;
                        main.Electra.moveToTarget(this, target);
                        if (this.getDistanceX(target) < 172032 || this.currAnimFrame > 64) {
                            this.setState(29);
                        }
                        break while_4_;
                    case 25:
                        this.velocityX = main.Electra.Q();
                        this.velocityZ = main.Electra.R();
                        if (main.ImageUtils.b(this.position.x, this.position.z,
                                target.position.x, target.position.z)
                                < 1600) {
                            if (this.position.z < target.position.z) {
                                this.position.z -= this.velocityZ + 4915;
                            } else {
                                this.position.z += this.velocityZ + 4915;
                            }
                        }
                        main.Electra.moveToTarget(this, target);
                        if (this.position.x == this.targetPosition.x && this.position.z == this.targetPosition.y
                                || this.nextFrameToMove == 0) {
                            int i;
                            if ((i = main.GameManager.getRandomNumber(100)) > 66) {
                                this.setState(3);
                            } else if (i > 33) {
                                this.setState(25);
                            } else {
                                this.setState(29);
                            }
                        } else {
                            this.R = 7;
                        }
                        break while_4_;
                    case 27:
                        if (this.getDistanceX(target) > 204800 || this.currAnimFrame > 64) {
                            this.setState(23);
                        }
                        break while_4_;
                    case 28:
                        if (target.state != 15 && target.state != 5 && this.currAnimFrame > 16) {
                            break;
                        }
                        break while_4_;
                    case 29:
                        if (6 == this.currAnimFrame) {
                            main.Electra.playSound(8);
                        }
                        if (this.loopMovement) {
                            if (this.X) {
                                this.setState(28);
                            } else {
                                break;
                            }
                        }
                        break while_4_;
                    default:
                        break while_4_;
                }
                this.setState(23);
            }
        } while (false);
        super.i();
        this.h();
    }

    public final void b() {
        main.ar.addElementToVector1(this.r);
    }

    public final void checkHammerSmash() {
        boolean bool = false;
        if (!this.X) {
            bool = this.checkAttackObjects(800 + (2 == main.GameManager.currentDifficulty ? 100 : 0), 0);
        }
        if (bool && this.state == 29) {
            this.X = true;
        }
    }

    public final void onAttackContact(main.AbstractObject var_af, int i, int i_5_,
            int i_6_, int i_7_) {
        int i_8_;
        if ((i_8_ = this.onBeingAttacked(var_af, i, i_5_, i_6_, i_7_)) > 0) {
            this.setState(i_8_);
        }
    }

    public final boolean d() {
        if (this.p > 0 || this.G) {
            return false;
        }
        switch (this.state) {
            case 15:
                if (this.y != 1) {
                    break;
                }
            /* fall through */
            case 3:
            case 4:
            case 9:
            case 10:
            case 11:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 28:
            case 29:
                return true;
        }
        return false;
    }

    public final void e() {
        if (this.N()) {
            this.y = 2;
            this.setState(15);
        }
    }

    public final void clearData() {
        this.clearAbstractData();
    }

    private static int Q() {
        int i = 8192;
        if (4096 != main.GameManager.enemyVelocityFactor) {
            i = (int) ((long) 8192 * (long) main.GameManager.enemyVelocityFactor >> 12);
        }
        return i;
    }

    private static int R() {
        int i = 8192;
        if (4096 != main.GameManager.enemyVelocityFactor) {
            i = (int) ((long) 8192 * (long) main.GameManager.enemyVelocityFactor >> 12);
        }
        return i;
    }
}
