js_ellina
=========

Write Java desktop applications using Javascript with mouse, keyboard, and graphics capabilities.

*To get Started*

- Compile code
- Run `js_ellina.Run <path to dir with main.js in it>`
- Documentation is lacking - feel free to email me at davidnia1@gmail.com with questions or create an issue on github.
 

*Sample main.js*

	// you can include any js file
	include("mouse"); // to include mouse.js
	
	var x = 0;
	
	function SysListener_onTick() {
	    var d = sys_platform.getGraphicsDevice().getIDraw();
	
	    d.setColor( 0, 0, 0 );
	
	    d.fillRect( 0, 0, 1023, 767 );
	
		d.setColor( 1, 0, 0 );
		d.drawRect( x, 50, 100, 100 );
		d.swap();
	
		x++;
	
		if ( x > 900 )
			x = 0;
	}
