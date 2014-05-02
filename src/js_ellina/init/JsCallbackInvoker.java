package js_ellina.init;

import javax.script.Invocable;

public class JsCallbackInvoker {
    public JsInvoker windowListener_onMove = new JsInvoker("WindowListener_onMove");
    public JsInvoker windowListener_onSize = new JsInvoker("WindowListener_onSize");
    public JsInvoker windowListener_onClosed = new JsInvoker("WindowListener_onClosed");
    public JsInvoker windowListener_onMinimized = new JsInvoker("WindowListener_onMinimized");
    public JsInvoker windowListener_onFocus = new JsInvoker("WindowListener_onFocus");

    public JsInvoker mouseListener_onMove = new JsInvoker("MouseListener_onMove");
    public JsInvoker mouseListener_onLeftDown = new JsInvoker("MouseListener_onLeftDown");
    public JsInvoker mouseListener_onLeftUp = new JsInvoker("MouseListener_onLeftUp");
    public JsInvoker mouseListener_onMiddleDown = new JsInvoker("MouseListener_onMiddleDown");
    public JsInvoker mouseListener_onMiddleUp = new JsInvoker("MouseListener_onMiddleUp");
    public JsInvoker mouseListener_onRightDown = new JsInvoker("MouseListener_onRightDown");
    public JsInvoker mouseListener_onRightUp = new JsInvoker("MouseListener_onRightUp");
    public JsInvoker mouseListener_onScrollDown = new JsInvoker("MouseListener_onScrollDown");
    public JsInvoker mouseListener_onScrollUp = new JsInvoker("MouseListener_onScrollUp");

    public JsInvoker keyListener_onKeyDown = new JsInvoker("KeyListener_onKeyDown");
    public JsInvoker keyListener_onKeyUp = new JsInvoker("KeyListener_onKeyUp");

    public JsInvoker sysListener_onTick = new JsInvoker("SysListener_onTick");
    public JsInvoker sysListener_onAfterInit = new JsInvoker("SysListener_onAfterInit");

    public void setInvocable( Invocable invocable ) {
        windowListener_onMove.setInvocable( invocable );
        windowListener_onSize.setInvocable( invocable );
        windowListener_onClosed.setInvocable( invocable );
        windowListener_onMinimized.setInvocable( invocable );
        windowListener_onFocus.setInvocable( invocable );

        mouseListener_onMove.setInvocable( invocable );
        mouseListener_onLeftDown.setInvocable( invocable );
        mouseListener_onLeftUp.setInvocable( invocable );
        mouseListener_onMiddleDown.setInvocable( invocable );
        mouseListener_onMiddleUp.setInvocable( invocable );
        mouseListener_onRightDown.setInvocable( invocable );
        mouseListener_onRightUp.setInvocable( invocable );
        mouseListener_onScrollDown.setInvocable( invocable );
        mouseListener_onScrollUp.setInvocable( invocable );

        keyListener_onKeyDown.setInvocable( invocable );
        keyListener_onKeyUp.setInvocable( invocable );

        sysListener_onTick.setInvocable( invocable );
        sysListener_onAfterInit.setInvocable( invocable );
    }
}
