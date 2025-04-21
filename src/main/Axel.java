/* p - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
package main;

import javax.microedition.lcdui.Image;

public final class Axel extends main.AbstractObject {

    // custom
    private int altComboPress;

    
    private static final short[][] W;
    private boolean canPerformSpecial;
    private int comboState;
    private int nextState;
    private int comboResetTimer;
    private boolean ab;
    private int grabComboCount;
    private boolean grabAttack;
    private boolean slamFrontToBack;
    private boolean attackHoldingCondittion;
    private main.Point2D ag;
    private main.oExtendsAr ah;
    private javax.microedition.lcdui.Image[] ai = new javax.microedition.lcdui.Image[2];
    private final int aj;
    private boolean ak;
    private int attackMoveScore;
    
    private final InputController controller;
    private final int playerId;

    static {
        (new short[][]{
            {
                -1, -1},
                {189, 137, 16, 15, -5, -5, 0},
                {220, 140, 19, 7, 6, 0, 0},
                {222, 153, 33, 36, 15, -17, 0},
                null
            }
        )[4] = new short[]{245, 240, 8, 15, -2, 3, 0};
        
        W = new short[][]{
            {-1, -1},
            {189, 137, 16, 15, -5, -5, 0},
            {220, 140, 19, 7, 6, 0, 0},
            {222, 153, 33, 36, 15, -17, 0},
            {186, 324, 8, 15, -2, 3, 0}
        };
    }

    public Axel(main.ObjectArt var_ad, int i, int i_0_, int i_1_, int i_2_, int i_3_, int i_4_, InputController player, int playerId) {
        super(1, 0, i_0_, i_1_, i_2_, i_3_, i_4_);
        this.controller = player;
        this.playerId = playerId;
        this.stateFlags |= 0x8101;
        this.energy = 10000;
        this.maxEnergy = this.energy;
        this.visualEnergy = main.GameManager.f(this.energy);
        this.r = new main.eExtendsAr(0, var_ad, 32);
        this.collisionBox = new main.CollisionBox(this.position, new main.Point(65536, 32768, 131072) );
        this.u = 0;
        this.t = 0;
        altComboPress = 0;
        this.comboState = 0;
        this.nextState = 0;
        this.comboResetTimer = 0;
        this.ab = false;
        this.grabComboCount = 0;
        this.ag = new main.Point2D(0, 0);
        this.ai[0] = var_ad.a(3);
        this.ai[1] = main.MainCanvas.imageStatusAll;
        this.ah = new main.oExtendsAr(0, this.ai[0], W);
        this.ah.a(0);
        this.attackMoveScore = 0;
        if (main.GameManager.currentDifficulty == 0) {
            this.aj = 500;
        } else {
            this.aj = 1000;
        }
        this.name = "Axel";
    }
    
    
    public InputController getController(){
        return controller;
    }

    public final void setState(int newState) {
        if (this.state != 1 && this.state != 2 && this.state != 6) {
            this.state = newState;
            this.comboState = this.state;
            this.nextState = 0;
            this.ab = false;
            this.ag.set(0, 0);
            this.I.set(0, 0);
            this.attackMoveScore = 0;
            this.T = 500;
            this.w();
            this.canPerformSpecial = true;
            this.D = false;
            switch (newState) {
                case 1:
                    this.canPerformSpecial = false;
                    this.setupPlayerInitialPosition();
                    this.c(0);
                    break;
                case 2:
                    this.canPerformSpecial = false;
                    this.g.set(0, 0, 0);
                    this.c(0);
                    break;
                case 3:
                    this.g.set(0, 0, this.g.y);
                    this.x = 0;
                    this.y = 0;
                    this.A = 0;
                    this.G = false;
                    this.grabComboCount = 0;
                    vaultCount = 0;
                    this.releaseGrabbedObj();
                    this.c(1);
                    break;
                case 4:
                    this.releaseGrabbedObj();
                    this.x = 0;
                    this.y = 0;
                    this.grabComboCount = 0;
                    vaultCount = 0;
                    break;
                case 5:
                    this.canPerformSpecial = false;
                    this.d(24);
                    break;
                case 6:
                    this.canPerformSpecial = false;
                    this.d(27);
                    break;
                case 14:
                    this.canPerformSpecial = false;
                    this.n = 32;
                    main.Axel.playSound(47);
                    this.d(26);
                    break;
                case 12:
                    this.d(15);
                    break;
                case 13:
                    this.d(16);
                    break;
                case 15:
                    this.canPerformSpecial = false;
                    switch (this.y) {
                        default:
                            this.canPerformSpecial = true;
                            this.d(20);
                            break;
                        case 2:
                            this.F();
                            this.c(22);
                            break;
                        case 6:
                            this.d(18);
                    }
                    break;
                case 17:
                    this.canPerformSpecial = false;
                    this.d(17);
                    break;
                case 18:
                    this.canPerformSpecial = false;
                    this.E();
                    this.c(23);
                    break;
                case 19:
                    this.canPerformSpecial = false;
                    this.d(19);
                    break;
                case 39:
                    if (this.grabbedObject == null) {
                        this.setState(3);
                    } else {
                        this.a(true, 81920);
                        this.c(7);
                    }
                    break;
                case 40:
                    if (this.grabbedObject == null) {
                        this.setState(3);
                    } else {
                        this.a(false, 65536);
                        this.c(7);
                    }
                    break;
                case 41:
                case 42:
                    this.canPerformSpecial = false;
                    if (this.grabbedObject == null) {
                        this.setState(3);
                    } else {
                        this.G();
                        this.c(13);
                        main.Axel.playSound(41);
                    }
                    break;
                case 23:
                    this.attackMoveScore = 20;
                    this.T = 300;
                    this.x = 1;
                    this.comboResetTimer = 17;
                    this.c(2);
                    main.Axel.playSound(0);
                    break;
                case 24:
                    this.attackMoveScore = 20;
                    this.T = 600;
                    this.x = 1;
                    this.comboResetTimer = 17;
                    this.c(2);
                    break;
                case 25:
                    this.attackMoveScore = 30;
                    this.T = 700;
                    this.soundToPlayOnContact = 59;
                    this.x = 1;
                    this.comboResetTimer = 17;
                    this.c(3);
                    break;
                case 43:
                case 44:
                    this.attackMoveScore = 30;
                    this.T = 600;
                    this.soundToPlayOnContact = 59;
                    if (newState == 43) {
                        this.grabComboCount = 1;
                    } else {
                        this.grabComboCount = 2;
                    }
                    this.x = 4;
                    this.comboResetTimer = 10;
                    this.stateFlags |= 0x10;
                    this.c(8);
                    break;
                case 45:
                    if (this.grabbedObject != null) {
                        this.grabbedObject.p = 16;
                    }
                    this.attackMoveScore = 50;
                    this.T = 1800;
                    this.soundToPlayOnContact = 59;
                    this.x = 2;
                    this.comboResetTimer = 0;
                    this.grabComboCount = 0;
                    vaultCount = 0;
                    this.stateFlags |= 0x10000;
                    this.c(9);
                    break;
                case 32:
                    this.p = 8;
                    this.attackMoveScore = 50;
                    this.T = 800;
                    this.soundToPlayOnContact = 59;
                    this.x = 1;
                    this.comboResetTimer = 16;
                    this.c(9);
                    break;
                case 26:
                case 27:
                    this.attackMoveScore = 30;
                    this.T = this.state == 26 ? 800 : 500;
                    this.soundToPlayOnContact = 59;
                    this.x = 1;
                    this.comboResetTimer = 16;
                    this.c(4);
                    break;
                case 28:
                    this.attackMoveScore = 40;
                    this.T = main.GameManager.currentDifficulty == 0 ? 1600 : 1100;
                    this.soundToPlayOnContact = 60;
                    this.x = 2;
                    this.comboResetTimer = 16;
                    this.c(5);
                    break;
                case 29:
                    this.canPerformSpecial = false;
                    this.stateFlags |= 0x30000;
                    this.attackMoveScore = 50;
                    this.T = 800;
                    this.soundToPlayOnContact = 60;
                    this.x = 2;
                    this.comboResetTimer = 0;
                    this.c(6);
                    break;
                case 33: {
                    this.canPerformSpecial = false;
                    main.AbstractObject enemyInFront;
                    enemyInFront = main.Axel.getEnemyInFront(this, 1536, 262144, 81920);
                    if (enemyInFront == null) {
                        //this.setState(35);
                        this.setState(3); // new code: ignore throw if no object in front
                    } else {
                        this.grabbedObject = enemyInFront;
                        if (this.getDistanceX(enemyInFront) < 163840) {
                            this.setState(48);
                        } else {
                            this.setState(46);
                        }
                    }
                    break;
                }
                case 34:
                    this.canPerformSpecial = false;
                    this.ak = false;
                    this.releaseGrabbedObj();
                    this.T = 2000;
                    this.stateFlags |= 0x10;
                    this.g.x = 0;
                    this.g.z = 0;
                    this.c(10);
                    this.dropWeapon();
                    break;
                case 35:
                    this.stateFlags |= 0x10;
                    this.g.x = this.direction == 0 ? 4096 : -4096;
                    this.c(14);
                    break;
                case 48:
                    this.canPerformSpecial = false;
                    if (this.grabbedObject == null) {
                        this.setState(3);
                    } else {
                        this.attackMoveScore = 100;
                        this.T = main.GameManager.currentDifficulty == 0 ? 3500 : 2500;
                        this.grabbedObject.direction = this.direction;
                        this.G();
                        this.grabbedObject.onAttackContact(this, 0, 7, this.direction, this.T);
                        this.c(11);
                        main.Axel.playSound(41);
                    }
                    break;
                case 46:
                    this.canPerformSpecial = false;
                    this.stateFlags |= 0x10000;
                    if (this.grabbedObject == null) {
                        this.setState(3);
                    } else {
                        this.attackMoveScore = 100;
                        this.T = main.GameManager.currentDifficulty == 0 ? 3500 : 2500;
                        this.grabbedObject.position.set(this.position.x, this.position.z, this.position.y);
                        this.grabbedObject.direction = this.direction ^ 0x1;
                        this.G();
                        this.grabbedObject.onAttackContact(this, 0, 8, this.direction, this.T);
                        this.c(12);
                        main.Axel.playSound(41);
                    }
                    break;
                case 47:
                    this.canPerformSpecial = false;
                    this.x = 9;
                    this.grabbedObject.onAttackContact(this, 0, 9, this.direction, 0);
                    this.position.set(this.grabbedObject.position.x, this.grabbedObject.position.z, this.position.y);
                    this.grabbedObject.direction = this.direction ^ 0x1;
                    this.G();
                    this.c(7);
                    main.Axel.playSound(41);
                    break;
                case 36:
                    this.x = 2;
                    this.T = 1800;
                    this.attackMoveScore = 40;
                    this.soundToPlayOnContact = 4;
                    main.Axel.playSound(0);
                    this.c(29);
                    break;
                case 37:
                    this.x = 2;
                    this.attackMoveScore = 40;
                    this.T = 3000;
                    main.Axel.playSound(0);
                    this.c(30);
                    break;
                case 38:
                    this.comboCounter = 0;
                    this.attackMoveScore = 40;
                    // create pepper
                    main.GameManager.spawnObject(108, this.position.x, this.position.z, 0, this.direction, 0, 0);
                    main.Axel.playSound(0);
                    this.c(31);
                    break;
            }
            this.e(0);
            this.h();
        }
    }
    
    
    private void checkSor2AltCombo(){
        // check alt combos
        if (InputController.useSor2Controlls) {
            if (controller.holded(InputController.ACTION_UP) || InputController.pressedAnyOf(InputController.ACTION_UP))
                altComboPress = 1;
            else if (controller.holded(InputController.ACTION_DOWN) || InputController.pressedAnyOf(InputController.ACTION_DOWN))
                altComboPress = 2;
        }
    }

    public final void update() {
        
        if (39 > this.state || this.state > 48) {
            this.releaseGrabbedObj();
        }
        if (this.q > 0 && this.state != 3 && this.state != 2 && this.state != 1
                && this.state != 6) {
            this.setState(3);
        }
        if (this.direction == 0) {
            this.grabAttack = controller.pressedExceptSpecials(InputController.ACTION_RIGHT);
            this.attackHoldingCondittion =  controller.holdedExceptSpecials(InputController.ACTION_RIGHT);
            this.slamFrontToBack =  controller.pressedExceptSpecials(InputController.ACTION_LEFT);
        } else {
            this.grabAttack = controller.pressedExceptSpecials(InputController.ACTION_LEFT);
            this.attackHoldingCondittion = controller.holdedExceptSpecials(InputController.ACTION_LEFT);
            this.slamFrontToBack = controller.pressedExceptSpecials(InputController.ACTION_RIGHT);
        }
        
        if (InputController.useSor2Controlls)
        {
            this.attackHoldingCondittion = false;
            slamFrontToBack = controller.pressed(InputController.ACTION_ATTACK);
            if (state != 40){
                if (this.direction == 0){
                    slamFrontToBack &= controller.holded(InputController.ACTION_LEFT);
                }else {
                    slamFrontToBack &= controller.holded(InputController.ACTION_RIGHT);
                }
            }
        }
        
        if (this.ab) {
            if (this.slamFrontToBack) {
                this.comboState = 0;
                this.nextState = 0;
                this.comboResetTimer = 0;
            } else if (this.comboResetTimer > 0) {
                if (--this.comboResetTimer == 0) {
                    this.comboState = 0;
                } else {
                    switch (this.comboState) {
                        case 23: // first combo 
                            if (controller.pressed( // 2138112
                                    (InputController.useSor2Controlls ? 0 : InputController.ACTION_UP)
                                    | (InputController.useSor2Controlls ? 0 : InputController.ACTION_DOWN)
                                    | InputController.ACTION_ATTACK
                                )
                                || (!InputController.useSor2Controlls && (controller.holded(
                                        InputController.ACTION_UP
                                        | InputController.ACTION_DOWN
                                ) || this.attackHoldingCondittion))) {
                                this.nextState = 24;
                            }
                            altComboPress = 0;
                            break;
                        case 24: // second combo
                            
                            checkSor2AltCombo();
                            
                            if ((!InputController.useSor2Controlls || controller.pressed(InputController.ACTION_ATTACK))
                                     && (controller.holded(InputController.ACTION_UP) || controller.pressed(InputController.ACTION_UP) || altComboPress == 1)
                            ) {
                                this.nextState = 27;
                            } else  if ((!InputController.useSor2Controlls || controller.pressed(InputController.ACTION_ATTACK))
                                    && (controller.holded(InputController.ACTION_DOWN) || controller.pressed(InputController.ACTION_DOWN) || altComboPress == 2)
                            ) {
                                this.nextState = 33;
                            } else if (controller.pressed(InputController.ACTION_ATTACK) || this.attackHoldingCondittion) {
                                this.nextState = 25;
                            }
                            break;
                        case 25: // 3rd combo
                            if (controller.pressed(InputController.ACTION_ATTACK) || this.attackHoldingCondittion) {
                                this.nextState = 26;
                            }
                            altComboPress = 0;
                            break;
                        case 26: // 4th combo (first kick of combo-end)
                            
                            checkSor2AltCombo();
                            
                            if ((!InputController.useSor2Controlls || controller.pressed(InputController.ACTION_ATTACK))
                                    && (controller.holded(InputController.ACTION_UP) || controller.pressed(InputController.ACTION_UP) || altComboPress == 1)
                            ) {
                                this.nextState = 32;
                            } else if (controller.pressed(InputController.ACTION_ATTACK) || this.attackHoldingCondittion) {
                                this.nextState = 28;
                            }
                            break;
                        case 27:
                            if (controller.holded(InputController.ACTION_UP) || controller.pressed(InputController.ACTION_UP))
                            {
                                this.nextState = 32;
                            }
                            break;
                    }
                }
            }
        }
        switch (this.state) {
            case 0:
                if ((this.stateFlags & INVINCIBILITY_FLAG) != 0) {
                    this.stateFlags &= ~INVINCIBILITY_FLAG;
                    this.setState(1);
                    break;
                }
                this.setState(3);
            /* fall through */
            case 3: // Standing
                this.A = 0;
                this.B = 0;
                if (this.q > 0) {
                    this.q--;
                    break;
                }
                if (main.GameManager.k > 0) {
                    break;
                }
                if (this.nextState != 0) {
                    this.setState(this.nextState);
                    break;
                }
                if (this.comboCounter != 0
                    && ((!InputController.useSor2Controlls && controller.e(InputController.ACTION_DOWN))
                        || (InputController.useSor2Controlls && controller.holded(InputController.ACTION_JUMP) && controller.holded(InputController.ACTION_ATTACK))
                       )
                ) {
                    this.dropWeapon(); // drop weapon
                    break;
                }
                if (controller.pressed(InputController.ACTION_ATTACK)) {
                    // Attack
                    if (this.comboCounter == 0) {
                        this.setState(23); // normal combo
                    } else if (this.comboCounter == 1) {
                        this.setState(36); // weapon 1
                    } else if (this.comboCounter == 2) {
                        this.setState(37); // weapon 2
                    } else {
                        this.setState(38); // pepper
                    }
                    break;
                }
                if (controller.pressed(InputController.ACTION_JUMP) && !this.ab) {
                    this.setState(29); // Jump
                    break;
                }
                if (controller.holded(
                        InputController.ACTION_UP
                        | InputController.ACTION_DOWN
                        | InputController.ACTION_LEFT
                        | InputController.ACTION_RIGHT
                    ) // 61440
                ){ // any walk direction
                    this.state = 4; // Walk
                    this.c(0);
                }
                if (this.state != 4) { // if not walking, break here
                    break;
                }
            /* fall through */
            case 4: // Walking
                if (main.GameManager.k > 0) {
                    this.setState(3);
                } else if (this.position.y == 0) {
                    if (this.nextState != 0) {
                        this.setState(this.nextState);
                    } else {
                        // Set direction while walking
                        if (controller.holdedExceptSpecials(InputController.ACTION_RIGHT)) {
                            this.direction = 0;
                        } else if (controller.holdedExceptSpecials(InputController.ACTION_LEFT)) {
                            this.direction = 1;
                        }
                        // Normal combo while walking
                        if (controller.pressed(InputController.ACTION_ATTACK)) {
                            if (this.comboCounter == 0) {
                                this.setState(23);
                            } else if (this.comboCounter == 1) {
                                this.setState(36);
                            } else if (this.comboCounter == 2) {
                                this.setState(37);
                            } else {
                                this.setState(38);
                            }
                        } else if (controller.pressed(InputController.ACTION_JUMP)) {
                            this.setState(29); // jump
                        } else if (!controller.holded(
                                InputController.ACTION_UP
                                | InputController.ACTION_DOWN
                                | InputController.ACTION_LEFT
                                | InputController.ACTION_RIGHT
                            ) // 61440
                        ) { // If not holding directions
                            this.setState(3); // Standing
                        } else {
                            // Walking speed control
                            if (controller.holded(InputController.ACTION_RIGHT)) {
                                this.position.x += 21299; // Walk right speed
                                //this.position.x += 2500; // Debug
                                this.direction = 0;
                            } else if (controller.holded(InputController.ACTION_LEFT)) {
                                this.position.x += -21299; // Walk left speed
                                //this.position.x += -2500; // Debug
                                this.direction = 1;
                            }
                            if (controller.holded(InputController.ACTION_DOWN)) {
                                this.position.z += 11468; // Walk down speed
                                //this.position.z += 2000; // Debug
                            } else if (controller.holded(InputController.ACTION_UP)) {
                                this.position.z += -11468; // Walk up speed
                                //this.position.z += -2000; // Debug
                            }
                        }
                    }
                }
                break;
            case 1:
            case 2:
                controller.resetInput();
                if (this.checkAndUpdateIfReachedTargetPosition()) {
                    this.state = -1;
                    this.setState(3);
                }
                break;
            case 5:
                this.p = 10;
                if (this.loopMovement) {
                    this.canPerformSpecial = true;
                    this.n = 0;
                    this.setState(3);
                }
                break;
            case 6:
                if (this.currAnimFrame > 3) {
                    this.state = -1;
                    this.setState(3);
                }
                break;
            case 34:
                this.canPerformSpecial = false;
                if (this.u == 2) {
                    main.Axel.playSound(41);
                }
                if (this.u < 8) {
                    this.x = 2;
                    this.e(0);
                } else {
                    this.x = 2;
                    this.e(1);
                }
                if (this.u > 5 && this.u < 12) {
                    this.g.x = this.direction == 0 ? 40960 : -40960;
                    if (this.u > 8) {
                        this.d(0, 0, 0);
                    }
                } else {
                    this.g.x = 0;
                }
                if (this.loopMovement) {
                    this.g.x = 0;
                    this.setState(3);
                    this.q = 4;
                }
                break;
            case 35:
                if (this.loopMovement) {
                    this.setState(3);
                    this.q = 6;
                }
                break;
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28: {
                this.e(0);
                boolean bool = false;
                if (this.state == 26 && this.nextState != 0 && this.currAnimFrame == 4) {
                    bool = true;
                } else if (this.state == 27 && this.nextState == 32 && this.currAnimFrame == 4) {
                    bool = true;
                }
                if (this.loopMovement || bool) {
                    if (this.nextState != 0) {
                        this.setState(this.nextState);
                    } else {
                        if (this.state == 27) {
                            this.q = 6;
                        }
                        if (this.state == 28) {
                            this.q = 4;
                        }
                        this.setState(3);
                    }
                }
                break;
            }
            case 29:
                if (this.w <= 0) {
                    this.e(0);
                    if (this.u == 6) {
                        main.Axel.playSound(41);
                    }
                    if (this.currAnimFrame == 13) {
                        this.N = 6;
                        this.stateFlags &= ~0x10000;
                    }
                    if (this.currAnimFrame == 14) {
                        this.d(10, 0, -2);
                    }
                    if (this.u == 3) {
                        this.g.x = this.direction == 0 ? 24576 : -24576;
                    } else if (this.u > 15) {
                        this.g.x = 0;
                    }
                    if (this.loopMovement) {
                        this.setState(3);
                        this.g.x = 0;
                    }
                }
                break;
            case 43:
            case 44:
                if (this.checkIfReleaseGrab()) {
                    this.setState(3);
                } else {
                    this.ab = true;
                    this.o = 2;
                    this.grabbedObject.p = 2;
                    if (this.currAnimFrame == 2) {
                        this.grabbedObject.p = 0;
                        this.grabbedObject.onAttackContact(this, this.A, 4, this.direction, this.T);
                        main.Axel.addPlayerScore(playerId, this.attackMoveScore);
                        main.Axel.playSound(57);
                        main.Axel.k();
                        this.grabbedObject.c(0, 0, 36);
                    }
                    if (this.loopMovement) {
                        if (this.nextState != 0) {
                            this.setState(this.nextState);
                        } else {
                            this.setState(39);
                        }
                    }
                }
                break;
            case 32:
                this.e(0);
                this.g.x = this.g.x * 76 / 100;
                if (this.currAnimFrame == 3) {
                    this.g.x = this.direction == 0 ? 61440 : -61440;
                } else if (this.currAnimFrame == 4) {
                    main.Axel.playSound(41);
                } else if (this.currAnimFrame == 7) {
                    this.d(12, 0, 0);
                }
                if (this.currAnimFrame > 6) {
                    this.e(2);
                } else if (this.currAnimFrame > 2) {
                    this.x = 2;
                    this.T = 1000;
                    this.e(1);
                }
                if (this.loopMovement) {
                    this.g.x = 0;
                    this.setState(3);
                    this.q = 10;
                }
                break;
            case 45:
                if (this.checkIfReleaseGrab()) {
                    this.setState(3);
                    this.q = 4;
                } else {
                    if (this.currAnimFrame == 4) {
                        this.grabbedObject.onAttackContact(this, this.A, 2, this.direction, this.T);
                        main.Axel.addPlayerScore(playerId, this.attackMoveScore);
                        this.grabbedObject.D = true;
                        main.Axel.playSound(59);
                        this.grabbedObject.c(0, 0, 36);
                        main.Axel.k();
                    }
                    if (this.loopMovement) {
                        this.setState(3);
                        this.q = 8;
                    }
                }
                break;
            case 48:
                this.canPerformSpecial = false;
                if (main.GameManager.currentLevel == 6) {
                    this.H();
                }
                if (this.currAnimFrame == 6) {
                    main.GameManager.e();
                    main.Axel.addPlayerScore(playerId, this.attackMoveScore);
                }
                if (this.grabbedObject != null && this.grabbedObject.energy > 0) {
                    this.grabbedObject.position.set(this.position);
                }
                if (this.loopMovement) {
                    this.setState(3);
                }
                break;
            case 46:
                this.canPerformSpecial = false;
                if (this.currAnimFrame < 10 && this.grabbedObject != null) {
                    this.grabbedObject.position.set(this.position);
                }
                if (main.GameManager.currentLevel == 6) {
                    this.H();
                }
                if (this.currAnimFrame == 11) {
                    main.GameManager.e();
                    main.Axel.addPlayerScore(playerId, this.attackMoveScore);
                }
                if (this.loopMovement) {
                    this.releaseGrabbedObj();
                    this.setState(3);
                }
                break;
            case 39: // grab from front
                if (this.checkIfReleaseGrab()) {
                    this.setState(3);
                } else {
                    // Grabbing front code
                    this.o = 2;
                    this.grabbedObject.p = 2;
                    if (this.grabbedObject.objectType == 3) {
                        if (controller.pressed(InputController.ACTION_LEFT)) {
                            this.direction = 0;
                        } else if (controller.pressed(InputController.ACTION_RIGHT)) {
                            this.direction = 1;
                        }
                    }
                    this.a(true);
                    // Adam team throw
                    if (this.grabbedObject.objectType == 3) {
                        if (this.currAnimFrame > 3 && controller.pressed(
                                InputController.ACTION_JUMP
                                | InputController.ACTION_LEFT
                                | InputController.ACTION_RIGHT
                                | InputController.ACTION_ATTACK
                            ) // 2117633
                        ) {
                            this.setState(47); // team throw
                        }
                    } else if ((controller.pressed(InputController.ACTION_ATTACK) && (!InputController.useSor2Controlls || !slamFrontToBack))
                            || (!InputController.useSor2Controlls && (this.grabAttack || this.currAnimFrame > 3 && this.attackHoldingCondittion))
                    ) { // press attack
                        if (this.grabComboCount == 0) {
                            this.setState(43); // knee 1
                        } else if (this.grabComboCount == 1) {
                            this.setState(44); // knee 2
                        } else {
                            this.setState(45); // grab combo end
                        }
                    } else if (controller.pressed(
                            (InputController.useSor2Controlls ? 0 : InputController.ACTION_UP)
                            | InputController.ACTION_JUMP // custom code
                        )
                    ) { // press up
                        this.setState(41); // Vault from front
                        
                    } else if (this.slamFrontToBack) { // press back
                        if (this.grabbedObject.objectType <= 3)
                            this.setState(48); // slam front to back, normal version (use for partners cose they lack the other anim)
                        else this.setState(46); // slam front to back
                    } else if (controller.e(InputController.ACTION_DOWN)) { // press down
                        this.releaseGrabbedObj(); // release grabbed enemy
                        this.setState(3);
                        this.q = 9;
                    }
                }
                break;
            case 40: // grab from back
                if (this.checkIfReleaseGrab()) {
                    this.setState(3);
                } else {
                    this.o = 2;
                    this.grabbedObject.p = 2;
                    this.a(false);
                    if (this.slamFrontToBack) {
                        this.setState(48);
                    } else if (controller.pressed(
                            (InputController.useSor2Controlls ? 0 : InputController.ACTION_UP)
                            | InputController.ACTION_JUMP // custom code
                        )
                    ){
                        this.setState(42); // vault from back
                    } else if (controller.e(InputController.ACTION_DOWN)) {
                        this.releaseGrabbedObj();
                        this.setState(3);
                        this.q = 6;
                    }
                }
                break;
            case 41:
                if (this.checkIfReleaseGrab()) {
                    this.setState(3);
                } else {
                    this.a(true);
                    if (this.loopMovement) {
                        this.direction ^= 0x1;
                        ++vaultCount;
                        this.setState(40);
                    }
                }
                break;
            case 42:
                if (this.checkIfReleaseGrab()) {
                    this.setState(3);
                } else {
                    this.a(false);
                    if (this.loopMovement) {
                        this.direction ^= 0x1;
                        main.Point var_q = this.position;
                        var_q.x = var_q.x + (this.direction == 0 ? -81920 : 81920);
                        this.position.z = this.grabbedObject.position.z;
                        ++vaultCount;
                        this.setState(39);
                    }
                }
                break;
            case 12:
            case 13:
            case 17:
                this.L(this);
                break;
            case 14:
                this.canPerformSpecial = false;
                this.L(this);
                break;
            case 15:
                if (this.y == 2 && this.position.y == 0) {
                    if (this.currAnimFrame > 16) {
                        this.g.x = 0;
                    }
                    if (this.currAnimFrame == 13) {
                        main.Axel.k();
                        main.Axel.playSound(5);
                        this.g(-16);
                    }
                } else if (this.y == 6) {
                    if (this.currAnimFrame == 13 || this.currAnimFrame == 14) {
                        if ( (!InputController.useSor2Controlls && controller.pressedExceptSpecials(InputController.ACTION_UP))
                             || (InputController.useSor2Controlls && controller.holded(InputController.ACTION_JUMP) && controller.holded(InputController.ACTION_UP))
                           ) {
                            this.position.x += this.I.x;
                            this.setState(3);
                            this.q = 4;
                            break;
                        }
                    } else if (this.u == 16) {
                        this.applyDamage(this.damage);
                        main.Axel.k();
                        main.Axel.playSound(5);
                        this.g(java.lang.Math.abs(this.I.x) >> 12);
                    }
                }
                if (this.loopMovement) {
                    if (this.y == 6) {
                        this.position.x += this.I.x;
                    }
                    if (this.energy <= 0) {
                        this.setState(14);
                    } else if (this.y != 1) {
                        this.setState(5);
                    } else {
                        this.setState(3);
                    }
                }
                break;
            case 18:
                this.canPerformSpecial = false;
                if ((this.currAnimFrame == 7 || this.currAnimFrame == 8)
                        && controller.pressedExceptSpecials(InputController.ACTION_UP)) {
                    this.setState(3);
                } else {
                    this.L(this);
                }
                break;
            case 19:
                this.canPerformSpecial = false;
                this.L(this);
                break;
            case 47:
                if (this.currAnimFrame > 5) {
                    this.setState(3);
                    this.q = 4;
                }
                break;
            case 36:
            case 37:
            case 38:
                this.e(0);
                if (this.loopMovement) {
                    this.setState(3);
                    this.q = 4;
                }
                break;
        }
        if ((this.stateFlags & 0x400000) != 0) {
            this.canPerformSpecial = false;
        }
        if (main.MainCanvas.mainState != 14 && main.MainCanvas.mainState != 5) {
            this.canPerformSpecial = false;
        }
        if (this.canPerformSpecial && this.q < 2 && this.energy > this.aj && controller.pressed(InputController.ACTION_DEF_SPECIAL)) {
            this.setState(34); // Def Special
        }
        if (this.state == 4 || this.state == 3 || this.state == 23) {
            int i;
            if ((i = this.checkGrab(81920, 81920, 0)) == 1) { // Check grab, == 1 means grab from front, 2 means grab from back
                this.grabComboCount = 0;
                this.setState(39); // set grab from front animation
            } else if (i == 2) {
                this.grabComboCount = 0;
                this.setState(40); // set grab from back animation
            }
        }
        super.i();
        this.h();
    }

    public final void checkHammerSmash() {
        int i = 81920;
        if (this.state == 34) {
            i = 196608;
        }
        if (this.o == 0) {
            this.h();
            for (int i_6_ = 0; i_6_ < main.GameManager.collidableObjects.size();
                    i_6_++) {
                main.AbstractObject var_af;
                if (((var_af = ((main.AbstractObject) main.GameManager.collidableObjects.elementAt(i_6_))).stateFlags
                        & 0xe00) != 0
                        && this.a(var_af, i)) {
                    main.Axel.addPlayerScore(playerId, this.attackMoveScore);
                    if (this.state == 34) {
                        if (!this.ak) {
                            this.ak = true;
                            if (this.energy > this.aj) {
                                this.energy -= this.aj;
                            }
                        }
                        var_af.onAttackContact(this, this.A, this.x, this.getDirectionTowardObject(var_af), this.T);
                        var_af.c(0, 0, 48);
                        var_af.a(5, 5, 48, 1);
                        this.a(10, 5, 48, 0);
                        this.c(40, 0, 48);
                        main.GameManager.d();
                        this.ab = false;
                        this.w = 3;
                    } else {
                        var_af.onAttackContact(this, this.A, this.x, this.direction, this.T);
                        main.Axel.playSound(this.soundToPlayOnContact);
                        var_af.c(0, 0, 48);
                        main.Axel.k();
                        this.ab = true;
                        if (this.state != 36 && this.w == 0) {
                            this.w = 2;
                        }
                    }
                }
            }
        }
    }

    public final void onAttackContact(main.AbstractObject attacker, int int1, int int2, int int3, int int4) {
        if (int4 != 0) {
            this.dropWeapon();
        }
        if ((this.stateFlags & 0x10000) != 0 && this.currAnimFrame > 2 && this.currAnimFrame < 14) {
            int2 = 2;
        }
        int newState;
        if ((newState = this.onBeingAttacked(attacker, int1, int2, int3, int4)) > 0) {
            this.setState(newState);
        }
    }

    public final void e() {
        if (this.N() && this.state != 15) {
            if (this.y == 6) {
                this.position.x += this.I.x;
            }
            this.setState(15);
        }
    }

    public final void b() {
        main.ar.addElementToVector1(this.r);
        switch (this.t) {
            case 0:
            case 1:
            case 31:
                if (this.comboCounter != 0) {
                    this.r.a(2020793310, this.u, this.ag);
                    if (this.ah != null) {
                        if (this.comboCounter == 1) {
                            main.Axel var_p_11_;
                            (var_p_11_ = this).ah.a(var_p_11_.ai[0]);
                            var_p_11_.ah.b = var_p_11_.direction == 0 ? 0 : 65536;
                            if (var_p_11_.t == 1) {
                                var_p_11_.ah.a(1);
                            } else {
                                var_p_11_.ah.a(2);
                            }
                        } else if (this.comboCounter == 2) {
                            main.Axel var_p_12_;
                            (var_p_12_ = this).ah.a(var_p_12_.ai[0]);
                            var_p_12_.ah.a(3);
                            if (var_p_12_.t == 1) {
                                var_p_12_.ah.b = var_p_12_.direction == 0 ? 65536 : 0;
                            } else {
                                var_p_12_.ah.b = var_p_12_.direction == 0 ? 0 : 65536;
                            }
                        } else {
                            main.Axel var_p_13_;
                            (var_p_13_ = this).ah.a(var_p_13_.ai[1]);
                            var_p_13_.ah.a(4);
                            var_p_13_.ah.b = var_p_13_.direction == 0 ? 65536 : 0;
                        }
                        this.ah.a(this.position.x + this.ag.x, this.position.z + this.ag.y,
                                this.position.y);
                        this.ah.c = this.r.c;
                        main.ar.addElementToVector1(this.ah);
                    }
                }
                break;
            case 11:
            case 13:
            case 18:
                this.r.a(2020793310, this.u, this.I);
                break;
        }
    }

    public final void clearData() {
        this.clearAbstractData();
        if (this.ah != null) {
            this.ah = null;
        }
        this.ag = null;
        this.ai = null;
        this.I = null;
    }

    public final boolean d() {
        java.lang.Object object = null;
        if (object != null) {
            /* empty */
        }
        if (main.GameManager._a0()) {
            return false;
        }
        if (this.p > 0 || this.G) {
            return false;
        }
        switch (this.state) {
            case 3:
            case 4:
            case 23:
                return true;
            default:
                return false;
        }
    }
}
