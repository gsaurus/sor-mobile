/* ab - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
package main;

public final class InputController {

    // Good that I added those variables, 
    // was a pain to find and split flags from aparent random numbers all over the place
    // Action keys are used as bit masks. Each action is one bit
    public static final int ACTION_STAR = 1024;                 // 00000000010000000000
    public static final int ACTION_POUND = 2048;                // 00000000100000000000
    public static final int ACTION_UP = 8192;                   // 00000010000000000000
    public static final int ACTION_DOWN = 32768;                // 00001000000000000000
    public static final int ACTION_LEFT = 4096;                 // 00000001000000000000
    public static final int ACTION_RIGHT = 16384;               // 00000100000000000000
    public static final int ACTION_LEFT_SOFT_KEY = 131072;      // 01000000000000000000
    public static final int ACTION_RIGHT_SOFT_KEY = 262144;     // 10000000000000000000
    public static final int ACTION_OK = 65536;                  // 00010000000000000000
    
    public static final int ACTION_JUMP = 1;                    // 00000000000000000001
    public static final int ACTION_NUM1 = 2;                    // 00000000000000000010
    public static final int ACTION_NUM2 = ACTION_UP;
    public static final int ACTION_NUM3 = 8;                    // 00000000000000001000
    public static final int ACTION_NUM4 = ACTION_LEFT;
    public static final int ACTION_NUM5 = ACTION_OK;
    public static final int ACTION_NUM6 = ACTION_RIGHT;
    public static final int ACTION_NUM7 = 128;                  // 00000000000010000000
    public static final int ACTION_NUM8 = ACTION_DOWN;
    public static final int ACTION_NUM9 = 512;                  // 00000000001000000000
    
    // those are processed
    public static final int ACTION_ATTACK = 2097152;            // 1000000000000000000000
    public static final int ACTION_DEF_SPECIAL = 32;            // 0000000000000000100000
    
    public static final int ACTION_PICK_ITEM = 256;             // 0000000000000100000000
    public static final int ACTION_SOMETHING_2 = 64;            // 0000000000000001000000
    
    public static final int ACTION_PL2 = 4194304;               // 10000000000000000000000
    
    public static boolean useSor2Controlls;
    
    public static InputController pl1 = new InputController();
    public static InputController pl2 = new InputController();

    private int a = 0;
    private int b = 0;
    private int c = 0;
    private int d = 0;
    private int holdedIgnoringSpecials;
    private int pressedIgnoringSpecials;
    private int g;
    private int e = 0;
    private final int[] cachedActions = new int[4]; // probably a cache
    private int minTimeToAttack; // probably a counter
    private int timeBetweenUpUpForJump; // probably a counter
    private int timeBetweenOkOkForSpecial;
    private int timeToWalkHorizontally;
    private int timeToWalkVertically;
    private int walkRightTimer;
    private int walkLeftTimer;
    private int walkUpTimer;
    private int walkDownTimer;
    private int upUpJumpCounter;
    private int okOkSpecialCounter;
    private int lastDirection;
    private int holdedActions;
    private int pressedActions;

    
    public InputController()
    {
        useSor2Controlls = true;
        reinit();
    }
    
    public void reinit() {
        resetInput();
        minTimeToAttack = 5;
        timeBetweenUpUpForJump = 5;
        timeBetweenOkOkForSpecial = 5;
        timeToWalkHorizontally = 2;
        timeToWalkVertically = 1;
        walkRightTimer = 0;
        walkLeftTimer = 0;
        walkUpTimer = 0;
        walkDownTimer = 0;
        upUpJumpCounter = 0;
        okOkSpecialCounter = 0;
    }

    public void resetInput() {
        a = 0;
        b = 0;
        c = 0;
        d = 0;
        holdedIgnoringSpecials = 0;
        pressedIgnoringSpecials = 0;
        g = 0;
        e = 0;
        for (int i = 0; i < cachedActions.length; i++) {
            cachedActions[i] = 0;
        }
    }

    public void onKeyDown(int keyCode) {
        a |= keyCode;
    }

    public void onKeyUp(int keyCode) {
        a &= keyCode ^ 0xffffffff;
    }

    public void preUpdate() {
        d = (b ^ a) & (b | a) & b;
        c = (b ^ a) & a;
        holdedIgnoringSpecials = b = a;
        pressedIgnoringSpecials = c;
        g = d;
        e = pressedIgnoringSpecials & (cachedActions[0] | cachedActions[1] | cachedActions[2] | cachedActions[3]);
        cachedActions[3] = cachedActions[2];
        cachedActions[2] = cachedActions[1];
        cachedActions[1] = cachedActions[0];
        cachedActions[0] = pressedIgnoringSpecials;
    }

    
    public boolean pressedExceptSpecials(int actions) {
        if ((pressedIgnoringSpecials & actions) != 0) {
            return true;
        }
        return false;
    }

    private boolean i(int actions) {
        if ((g & actions) != 0) {
            return true;
        }
        return false;
    }

    public boolean holdedExceptSpecials(int actions) {
        if ((holdedIgnoringSpecials & actions) != 0) {
            return true;
        }
        return false;
    }

    public boolean e(int actions) {
        if ((e & actions) != 0) {
            return true;
        }
        return false;
    }

    public void setCharacterDirection(int direction) {
        lastDirection = direction;
    }

    public boolean pressed(int actions) {
        if ((pressedActions & actions) != 0) {
            return true;
        }
        return false;
    }

    public boolean holded(int actions) {
        if ((holdedActions & actions) != 0) {
            return true;
        }
        return false;
    }

    public void postUpdate() {
        if (upUpJumpCounter > 0) {
            upUpJumpCounter--;
        }

        if (okOkSpecialCounter > 0) {
            okOkSpecialCounter--;
        }
        holdedActions = holdedIgnoringSpecials; // redundant
        pressedActions = pressedIgnoringSpecials;
        if (!useSor2Controlls) {
            if (i(ACTION_RIGHT) && walkRightTimer <= minTimeToAttack && walkRightTimer > 0 && lastDirection == 0) {
                pressedActions |= ACTION_ATTACK;
            }
            if (i(ACTION_LEFT) && walkLeftTimer <= minTimeToAttack && walkLeftTimer > 0 && lastDirection == 1) {
                pressedActions |= ACTION_ATTACK;
            }
            if (pressedExceptSpecials(ACTION_UP)) {
                if (upUpJumpCounter == 0) {
                    upUpJumpCounter = timeBetweenUpUpForJump;
                } else {
                    upUpJumpCounter = 0;
                    pressedActions |= ACTION_JUMP;
                }
            }
            if (pressedExceptSpecials(ACTION_OK)) {
                if (okOkSpecialCounter == 0) {
                    okOkSpecialCounter = timeBetweenOkOkForSpecial;
                } else {
                    okOkSpecialCounter = 0;
                    pressedActions |= ACTION_DEF_SPECIAL;
                }
            }
            if (holdedExceptSpecials(ACTION_RIGHT)) {
                walkLeftTimer = 0;
                if (walkRightTimer < 255) {
                    walkRightTimer++;
                }
                if (walkRightTimer > timeToWalkHorizontally || lastDirection == 1) {
                    holdedActions |= ACTION_RIGHT;
                } else {
                    holdedActions &= ~ACTION_RIGHT;
                }
            } else {
                walkRightTimer = 0;
                holdedActions &= ~ACTION_RIGHT;
            }
            if (holdedExceptSpecials(ACTION_LEFT)
                    && !holdedExceptSpecials(ACTION_RIGHT)) {
                walkRightTimer = 0;
                if (walkLeftTimer < 255) {
                    walkLeftTimer++;
                }
                if (walkLeftTimer > timeToWalkHorizontally || lastDirection == 0) {
                    holdedActions |= ACTION_LEFT;
                } else {
                    holdedActions &= ~ACTION_LEFT;
                }
            } else {
                walkLeftTimer = 0;
                holdedActions &= ~ACTION_LEFT;
            }
            if (holdedExceptSpecials(ACTION_UP)) {
                if (walkUpTimer < 255) {
                    walkUpTimer++;
                }
                if (walkUpTimer > timeToWalkVertically) {
                    holdedActions |= ACTION_UP;
                } else {
                    holdedActions &= ~ACTION_UP;
                }
            } else {
                walkUpTimer = 0;
                holdedActions &= ~ACTION_UP;
            }
            if (holdedExceptSpecials(ACTION_DOWN)) {
                if (walkDownTimer < 255) {
                    walkDownTimer++;
                }
                if (walkDownTimer > timeToWalkVertically) {
                    holdedActions |= ACTION_DOWN;
                } else {
                    holdedActions &= ~ACTION_DOWN;
                }
            } else {
                walkDownTimer = 0;
                holdedActions &= ~ACTION_DOWN;
            }
        }
    }
    
    
    public static boolean pressedAnyOf(int actions) {
        return pl1.pressed(actions) || pl2.pressed(actions);
    }

    public static boolean holdedAnyOf(int actions) {
        return pl1.holded(actions) || pl2.holded(actions);
    }
    
    public static boolean pressedIgnoringSpecials(int actions) {
        return pl1.pressedExceptSpecials(actions) || pl2.pressedExceptSpecials(actions);
    }

    public static boolean holdedIgnoringSpecials(int actions){
        return pl1.holdedExceptSpecials(actions) || pl2.holdedExceptSpecials(actions);
    }
    
    public static void reset() {
        pl1.resetInput();
        pl2.resetInput();
    }
    
    public static void update()
    {
        pl1.preUpdate();
        pl1.postUpdate();
        pl2.preUpdate();
        pl2.postUpdate();
    }
    
    public static void reinitControls(){
        pl1.reinit();
        pl2.reinit();
    }
    
}
