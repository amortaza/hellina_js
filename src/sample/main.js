include("mouse");

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
