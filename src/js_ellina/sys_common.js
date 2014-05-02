function include(filename) {
	sys_engine.eval( new Packages.java.io.FileReader( new Packages.java.io.File( "C:\\_nirvana\\js_ellina\\src\\sample\\" + filename + ".js" ) ) );
}