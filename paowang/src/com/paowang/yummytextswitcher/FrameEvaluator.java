package com.paowang.yummytextswitcher;

/**
 * Author UFreedom
 * 
 */
public interface FrameEvaluator {

    String getStartFrame(int input);

    String getMiddleFrame(float input);

    String getEndFrame(int input);
}
