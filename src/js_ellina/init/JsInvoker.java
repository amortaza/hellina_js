package js_ellina.init;

import com.github.amortaza.hellina.intf.IPlatform;

import javax.script.Invocable;
import javax.script.ScriptException;

public class JsInvoker {
    private Invocable invocable;

    String functionName;
    Boolean functionExists;

    public JsInvoker( String functionName ) {
        this.functionName = functionName;
    }

    public void setInvocable( Invocable i ) {
        this.invocable = i;
    }

    public void invoke() {
        if (functionExists == null) {
            functionExists = true;

            Exception e = _invoke();

            if (e instanceof NoSuchMethodException)
                functionExists = false;
        }
        else if (functionExists)
            _invoke();
    }

    public void invoke(int p1, boolean p2, boolean p3, boolean p4 ) {
        if (functionExists == null) {
            functionExists = true;

            Exception e = _invoke(p1, p2, p3, p4);

            if (e instanceof NoSuchMethodException)
                functionExists = false;
        }
        else if (functionExists)
            _invoke();
    }

    public void invoke(int p1, int p2) {
        if (functionExists == null) {
            functionExists = true;

            Exception e = _invoke(p1, p2);

            if (e instanceof NoSuchMethodException)
                functionExists = false;
        }
        else if (functionExists)
            _invoke(p1, p2);
    }

    public void invoke(boolean p) {
        if (functionExists == null) {
            functionExists = true;

            Exception e = _invoke(p);

            if (e instanceof NoSuchMethodException)
                functionExists = false;
        }
        else if (functionExists)
            _invoke(p);
    }

    public void invoke(IPlatform platform) {
        if (functionExists == null) {
            functionExists = true;

            Exception e = _invoke(platform);

            if (e instanceof NoSuchMethodException)
                functionExists = false;
        }
        else if (functionExists)
            _invoke(platform);
    }

    Exception _invoke() {
        Exception ret = null;

        try {
            invocable.invokeFunction( functionName );
        }
        catch ( ScriptException e ) {
            e.printStackTrace();
            ret = e;
        }
        catch ( NoSuchMethodException e ) {
            ret = e;
        }

        return ret;
    }

    Exception _invoke( int p1, int p2 ) {
        Exception ret = null;

        try {
            invocable.invokeFunction( functionName, p1, p2 );
        }
        catch ( ScriptException e ) {
            e.printStackTrace();
            ret = e;
        }
        catch ( NoSuchMethodException e ) {
            ret = e;
        }

        return ret;
    }

    Exception _invoke( int p1, boolean p2, boolean p3, boolean p4 ) {
        Exception ret = null;

        try {
            invocable.invokeFunction( functionName, p1, p2, p3, p4 );
        }
        catch ( ScriptException e ) {
            e.printStackTrace();
            ret = e;
        }
        catch ( NoSuchMethodException e ) {
            ret = e;
        }

        return ret;
    }

    Exception _invoke( boolean p ) {
        Exception ret = null;

        try {
            invocable.invokeFunction( functionName, p );
        }
        catch ( ScriptException e ) {
            e.printStackTrace();
            ret = e;
        }
        catch ( NoSuchMethodException e ) {
            ret = e;
        }

        return ret;
    }

    Exception _invoke( IPlatform platform ) {
        Exception ret = null;

        try {
            invocable.invokeFunction( functionName, platform );
        }
        catch ( ScriptException e ) {
            e.printStackTrace();
            ret = e;
        }
        catch ( NoSuchMethodException e ) {
            ret = e;
        }

        return ret;
    }
}
