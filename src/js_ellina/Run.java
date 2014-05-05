/*
Copyright 2014 Afshin Mortazavi-Nia

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/

package js_ellina;

import js_ellina.init.JsEllina;

import javax.script.ScriptException;
import java.io.IOException;

public class Run {
    public static void main( String[] args ) throws ScriptException, IOException, NoSuchMethodException {
        if (!processInput(args))
            return;

        JsEllina e = new JsEllina(args[0]);

        e.start();
    }

   private static boolean processInput( String[] args ) {
       if (args.length == 0) {
           System.out.println( "Usage: js_ellina.Run PATH_TO_SCRIPT (using forward slashes (/) - example, 'c:/temp/script'" );

           return false;
       }

       return true;
   }
}
