# webstart
Demo of a Java Webstart that provides access to a self-signed jar, called myApp
Tested in Windows 10 with Java 1.8 and Tomcat 9

1. Update the Java Home directory on build.bat
2. Customize the code of myApp - in this project just a splash screen with a logo
3. Go to webstart/keystore to generate your own keystore. Password must be "password"
4. Execute build.bat
5. Find the webstart.war at "webstart/webstart/build/libs"
6. Copy webstart.war to your Tomcat directory inside the directory "webapps"
7. Start Tomcat
9. Execute startMyApp.bat