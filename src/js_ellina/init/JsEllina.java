package js_ellina.init;

import com.github.amortaza.hellina.intf.IPlatform;
import com.github.amortaza.hellina.listener.IKeyListener;
import com.github.amortaza.hellina.listener.IMouseListener;
import com.github.amortaza.hellina.listener.ITickListener;
import com.github.amortaza.hellina.listener.IWindowListener;
import com.github.amortaza.hellina_j2d.Platform;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JsEllina {
    ScriptEngine engine;

    final IPlatform platform = new Platform();
    final JsCallbackInvoker callbackInvoker = new JsCallbackInvoker();

    public JsEllina(String pathToMain) throws IOException, ScriptException {
        File mainFile = new File(pathToMain);
        String scriptPath = mainFile.getParentFile().getAbsolutePath();

        engine = new ScriptEngineManager().getEngineByName( "javascript" );

        engine.put("sys_script_path", scriptPath);
        engine.put("sys_engine", engine);
        engine.put("sys_platform", platform);

        engine.eval( new InputStreamReader( getClass().getResourceAsStream( "../js/sys_common.js" ) ) );
        engine.eval( new InputStreamReader( getClass().getResourceAsStream( "../js/sys_class.js" ) ) );
        engine.eval( new FileReader( new File( scriptPath + "/" + mainFile.getName() ) ) );

        callbackInvoker.setInvocable( ( Invocable ) engine );
    }

    public void start() {
        platform.init(
                -1, -1, 1024, 768,
                new IWindowListener() {
                    public void onMove( int x, int y ) {
                        callbackInvoker.windowListener_onMove.invoke(x, y);
                    }

                    public void onSize( int width, int height ) {
                        callbackInvoker.windowListener_onSize.invoke(width, height);
                    }

                    public void onClosed() {
                        callbackInvoker.windowListener_onClosed.invoke();
                    }

                    public void onMinimize( boolean isMinimized ) {
                        callbackInvoker.windowListener_onMinimized.invoke(isMinimized);
                    }

                    public void onFocus( boolean isFocus ) {
                        callbackInvoker.windowListener_onFocus.invoke(isFocus);
                    }
                },

                new IMouseListener() {

                    public void onMove( int x, int y ) {
                        callbackInvoker.mouseListener_onMove.invoke( x, y );
                    }

                    // left button
                    public void onLeftDown( int x, int y ) {
                        callbackInvoker.mouseListener_onLeftDown.invoke( x, y );
                    }

                    public void onLeftUp( int x, int y ) {
                        callbackInvoker.mouseListener_onLeftUp.invoke( x, y );
                    }

                    // middle button
                    public void onMiddleDown( int x, int y ) {
                        callbackInvoker.mouseListener_onMiddleDown.invoke( x, y );
                    }

                    public void onMiddleUp( int x, int y ) {
                        callbackInvoker.mouseListener_onMiddleUp.invoke( x, y );
                    }

                    // right button
                    public void onRightDown( int x, int y ) {
                        callbackInvoker.mouseListener_onRightDown.invoke( x, y );
                    }

                    public void onRightUp( int x, int y ) {
                        callbackInvoker.mouseListener_onRightUp.invoke( x, y );
                    }

                    public void onScrollDown( int x, int y ) {
                        callbackInvoker.mouseListener_onScrollDown.invoke( x, y );
                    }

                    public void onScrollUp( int x, int y ) {
                        callbackInvoker.mouseListener_onScrollUp.invoke( x, y );
                    }
                },

                new IKeyListener() {
                    public void onKeyDown( int code, boolean altDown, boolean controlDown, boolean shiftDown ) {
                        callbackInvoker.keyListener_onKeyDown.invoke( code, altDown, controlDown, shiftDown );
                    }

                    public void onKeyUp( int code, boolean altDown, boolean controlDown, boolean shiftDown ) {
                        callbackInvoker.keyListener_onKeyUp.invoke( code, altDown, controlDown, shiftDown );
                    }
                },
                new ITickListener() {
                    public void afterInit( IPlatform platform ) {
                        callbackInvoker.sysListener_onAfterInit.invoke(platform);
                    }

                    public void onTick() {
                        callbackInvoker.sysListener_onTick.invoke();
                    }
                }
        );

        platform.startLooping();
    }
}
