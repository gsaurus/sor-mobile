/* c - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
package main;

public final class Signal extends main.AbstractObject {

    private static final int[] W = {2500, 5000, 7500};
    private int X;

    static {
        (new int[][]{{40, 60, 70}, null})[1] = new int[]{40, 60, 70};
        (new int[][]{{50, 70, 90}, null})[1] = new int[]{50, 70, 90};
    }

    public Signal(main.ObjectArt var_ad, int i, int i_0_, int i_1_,
            int i_2_, int i_3_, int i_4_) {
        super(5, i, i_0_, i_1_, i_2_, i_3_, i_4_);
        this.stateFlags |= 0x8201;
        this.r = new main.eExtendsAr(0, var_ad, 17);
        this.collisionBox
                = new main.CollisionBox(this.position,
                        new main.Point(65536,
                                32768,
                                131072));
        this.X = 0;
        this.velocityX = getVelX(0);
        this.velocityZ = getVelZ(0);
        this.energy = W[this.difficultyAi];
        this.maxEnergy = this.energy;
        this.visualEnergy = main.GameManager.f(this.energy);
        this.name = "MOHICAN";
    }

    private void P() {
        main.AbstractObject target;
        if ((target = getPlayerTarget()) != null) {
            main.Signal.moveToTarget(this, target);
            if (this.Q % 20 == 0) {
                int distX = this.getDistanceX(target);
                int distZ = this.getDistanceZ(target);
                if (distX >= 122880 && distX <= 491520 && distZ < 20480
                        && main.GameManager.getRandomNumber(100) < 10*(1+GameManager.currentDifficulty)) {
                    this.setState(29);
                } else if (!this.isFacedToTarget(target)
                        && main.GameManager.getRandomNumber(100) < 80) {
                    this.velocityX = getVelX(1);
                    this.velocityZ = getVelZ(1);
                } else {
                    this.velocityX = getVelX(0);
                    this.velocityZ = getVelZ(0);
                }
            }
        }
    }

    public final void setState(int i) {
        java.lang.Object object = null;
        if (object != null) {
            /* empty */
        }
        if (!main.GameManager._a1()) {
            main.AbstractObject player = getPlayerTarget();
            this.state = i;
            this.w();
            switch (i) {
                case 3:
                    this.g.set(0, 0, this.g.y);
                    this.velocityX = getVelX(0);
                    this.velocityZ = getVelZ(0);
                    this.c(0);
                    break;
                case 5:
                    this.d(10);
                    break;
                case 14:
                    this.n = 32;
                    this.d(9);
                    break;
                case 12:
                case 13:
                    this.d(5);
                    break;
                case 15:
                    switch (this.y) {
                        default:
                            this.direction = this.C;
                            this.d(6);
                            break;
                        case 2:
                            this.F();
                            this.c(8);
                    }
                    break;
                case 24: {
                    this.g.set(0, 0, this.g.y);
                    this.x = 1;
                    main.Point[] var_qs;
                    (var_qs = new main.Point[4])[0]
                            = player.b(163840, 163840, 0);
                    var_qs[1] = player.b(-163840, 163840, 0);
                    var_qs[2] = player.b(163840, -163840, 0);
                    var_qs[3] = player.b(-163840, -163840, 0);
                    main.Point var_q = this.a(var_qs);
                    this.targetPosition.x = var_q.x + (8 - main.GameManager.getRandomNumber(16) << 12);
                    this.targetPosition.y = var_q.z + (8 - main.GameManager.getRandomNumber(16) << 12);
                    this.nextFrameToMove = 32;
                    this.X = 16;
                    this.c(0);
                    break;
                }
                case 27:
                    this.x = 1;
                    this.targetPosition.x = player.position.x;
                    if (this.position.z < player.position.z) {
                        this.targetPosition.y = player.position.z + (10 - main.GameManager.getRandomNumber(20)
                                << 12);
                    } else {
                        this.targetPosition.y = player.position.z - (10 - main.GameManager.getRandomNumber(20)
                                << 12);
                    }
                    this.nextFrameToMove = 32;
                    this.c(0);
                    break;
                case 29:
                case 30:
                    this.soundToPlayOnContact = 1;
                    this.x = 2;
                    this.direction = this.getDirectionTowardObject(player);
                    this.c(1);
                    break;
                case 25: {
                    this.x = 1;
                    main.Point var_q
                            = player.b(main.GameManager.getRandomNumber(16) - 50 << 12,
                                    24 - main.GameManager.getRandomNumber(48) << 12, 0);
                    this.targetPosition.x = var_q.x;
                    this.targetPosition.y = var_q.z;
                    this.nextFrameToMove = 60;
                    this.c(0);
                    break;
                }
                case 28:
                    this.x = 2;
                    this.targetPosition.x = player.position.x;
                    this.targetPosition.y = player.position.z;
                    this.nextFrameToMove = 32;
                    this.c(0);
                    break;
                case 32:
                    this.x = 6;
                    this.c(2);
                    break;
                case 31:
                    if (this.grabbedObject == null) {
                        this.setState(3);
                    } else {
                        this.grabbedObject.onAttackContact(this, 0, 10, this.direction, 0);
                        this.position.set(this.grabbedObject.position.x + (this.direction == 0 ? -147456 : 147456),
                                this.grabbedObject.position.z, this.position.y);
                        this.stateFlags |= 0x10;
                        this.g.x = 0;
                        this.g.z = 0;
                        this.grabbedObject.direction = this.direction == 0 ? 1 : 0;
                        this.grabbedObject.g.x = 0;
                        this.grabbedObject.g.z = 0;
                        this.c(3);
                    }
                    break;
                case 20:
                    this.d(7);
                    break;
                case 19:
                    this.d(13);
                    break;
                case 16:
                    this.d(15);
                    break;
                case 17:
                    this.d(11);
                    break;
                case 18:
                    this.E();
                    this.c(12);
                    break;
                case 22:
                    this.d(16);
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
            }
            this.h();
        }
    }

    public final void update() {
        super.update();
        main.AbstractObject target = getPlayerTarget();
        this.D = false;
        if (target == null && !this.j()) {
            this.q = 10;
        }
        if (31 <= this.state && this.state <= 32) {
            if (this.grabbedObject == null) {
                this.setState(3);
                this.q = 4;
            }
        } else {
            this.releaseGrabbedObj();
        }
        main.AbstractObject.j(this);
        if (this.state != 3 && this.q > 0) {
            this.setState(3);
        }
        while_6_:
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
                        } else if (this.currAnimFrame > 10) {
                            int i;
                            if ((i = main.GameManager.getRandomNumber(100)) > 66) {
                                this.setState(27);
                            } else if (i > 33) {
                                this.setState(25);
                            } else {
                                this.setState(3);
                            }
                        }
                        break while_6_;
                    case 24:
                        P();
                        if (this.position.x == this.targetPosition.x && this.position.z == this.targetPosition.y
                                || this.nextFrameToMove == 0) {
                            if (this.X > 0) {
                                this.X--;
                            }
                            if (this.X == 0) {
                                int i;
                                if ((i = main.GameManager.getRandomNumber(100)) > 66) {
                                    this.setState(27);
                                } else if (i > 33) {
                                    this.setState(25);
                                } else {
                                    this.setState(3);
                                }
                            }
                        }
                        break while_6_;
                    case 27:
                        P();
                        if (this.position.x == this.targetPosition.x && this.position.z == this.targetPosition.y
                                || this.nextFrameToMove == 0) {
                            int rand100 = main.GameManager.getRandomNumber(100);
                            if (2 == main.GameManager.currentDifficulty) {
                                if (rand100 <= 95) {
                                    if (rand100 > 90) {
                                        this.setState(25);
                                    } else if (rand100 > 80) {
                                        this.setState(27);
                                    } else {
                                        this.setState(28);
                                    }
                                    break while_6_;
                                }
                            }else if (1 == main.GameManager.currentDifficulty) {
                                if (rand100 <= 90) {
                                    if (rand100 > 70) {
                                        this.setState(25);
                                    } else if (rand100 > 60) {
                                        this.setState(27);
                                    } else {
                                        this.setState(28);
                                    }
                                    break while_6_;
                                }
                            }
                            else if (rand100 <= 75) {
                                if (rand100 > 50) {
                                    this.setState(25);
                                } else if (rand100 > 25) {
                                    this.setState(27);
                                } else {
                                    this.setState(28);
                                }
                                break while_6_;
                            }
                            break;
                        }
                        break while_6_;
                    case 25:
                        P();
                        if (main.ImageUtils.b(this.position.x, this.position.z,
                                target.position.x, target.position.z)
                                < 2500) {
                            if (this.position.z < target.position.z) {
                                this.position.z -= 13107;
                            } else {
                                this.position.z += 13107;
                            }
                        }
                        if (this.position.x == this.targetPosition.x && this.position.z == this.targetPosition.y
                                || this.nextFrameToMove == 0) {
                            int i = main.GameManager.getRandomNumber(100);
                            if (2 == main.GameManager.currentDifficulty) {
                                if (i <= 95) {
                                    if (i > 90) {
                                        this.setState(25);
                                    } else if (i > 80) {
                                        this.setState(27);
                                    } else {
                                        this.setState(28);
                                    }
                                    break while_6_;
                                }
                            }else if (1 == main.GameManager.currentDifficulty) {
                                if (i <= 90) {
                                    if (i > 80) {
                                        this.setState(25);
                                    } else if (i > 70) {
                                        this.setState(27);
                                    } else {
                                        this.setState(28);
                                    }
                                    break while_6_;
                                }
                            }
                            else if (i <= 75) {
                                if (i > 50) {
                                    this.setState(25);
                                } else if (i > 25) {
                                    this.setState(27);
                                } else {
                                    this.setState(28);
                                }
                                break while_6_;
                            }
                            break;
                        }
                        break while_6_;
                    case 28:
                        this.targetPosition.x = target.position.x;
                        this.targetPosition.y = target.position.z;
                        P();
                        if (main.ImageUtils.b(this.position.x, this.position.z,
                                target.position.x, target.position.z)
                                < 25) {
                            if (main.GameManager.getRandomNumber(100) < 70) {
                                if ((target = this.enemyCheckGrabPlayer(131072, 20480)) != null) {
                                    this.grabbedObject = target;
                                    this.setState(31);
                                } else {
                                    this.setState(3);
                                }
                            } else if (main.GameManager.getRandomNumber(100) < 50) {
                                this.setState(27);
                            } else {
                                this.setState(24);
                            }
                        } else if (this.nextFrameToMove == 0) {
                            if (main.GameManager.getRandomNumber(100) < 50) {
                                this.setState(27);
                            } else {
                                this.setState(24);
                            }
                        }
                        break while_6_;
                    case 32:
                        if (this.loopMovement) {
                            break;
                        }
                        break while_6_;
                    case 31:
                        this.grabbedObject.p = 2;
                        this.grabbedObject.position.set(this.position);
                        this.grabbedObject.direction = this.direction == 0 ? 1 : 0;
                        this.stateFlags |= 0x10;
                        if (this.currAnimFrame > 8) {
                            this.grabbedObject.onAttackContact(this, this.A, 6, this.direction, Q());
                            this.grabbedObject.p = 16;
                            this.setState(32);
                        }
                        break while_6_;
                    case 29:
                    case 30:
                        if (this.u > 3) {
                            this.g.x = this.direction == 0 ? 28672 : -28672;
                        }
                        if (this.u > 6) {
                            this.d(32, 0, 0);
                        }
                        if (this.loopMovement) {
                            if (this.state == 29) {
                                this.Q = 1;
                                this.setState(24);
                            } else {
                                break;
                            }
                        }
                        break while_6_;
                    default:
                        break while_6_;
                }
                this.setState(3);
            }
        } while (false);
        super.i();
        this.h();
    }

    public final void b() {
        main.ar.addElementToVector1(this.r);
    }

    private int Q() {
        int i = 0;
        switch (this.state) {
            case 29:
                i = 1100;
                break;
            case 31:
                i = 1500;
                break;
        }
        return i + (2 == main.GameManager.currentDifficulty ? 100 : 0);
    }

    public final void checkHammerSmash() {
        this.checkAttackObjects(Q(), 0);
    }

    public final void onAttackContact(main.AbstractObject var_af, int i, int i_6_,
            int i_7_, int i_8_) {
        int i_9_;
        if ((i_9_ = this.onBeingAttacked(var_af, i, i_6_, i_7_, i_8_)) > 0) {
            this.setState(i_9_);
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
            case 27:
            case 28:
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

    private int getVelX(int index) {
        int baseVel = index == 0 ? 8192 : 12288;
        if (4096 != main.GameManager.enemyVelocityFactor) {
            baseVel
                    = (int) ((long) baseVel * (long) main.GameManager.enemyVelocityFactor >> 12);
        }
        return baseVel += main.Signal.I();
    }

    private int getVelZ(int i) {
        int i_11_ = i == 0 ? 8192 : 12288;
        if (4096 != main.GameManager.enemyVelocityFactor) {
            i_11_
                    = (int) ((long) i_11_ * (long) main.GameManager.enemyVelocityFactor >> 12);
        }
        return i_11_ += main.Signal.I();
    }
}
