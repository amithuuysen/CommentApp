# CommentApp

Project Execution:

Download and Install:
1) Download and Install Eclipse IDE for Enterprise java and web developers - https://www.eclipse.org/downloads/download.php?file=/oomph/epp/2021-12/R/eclipse-inst-jre-win64.exe
2) Download and Install MYSQL Workbench - https://dev.mysql.com/downloads/installer/
3) Installation reference video - https://www.youtube.com/watch?v=OM4aZJW_Ojs
4) Download and Install Apache Tomcat - https://tomcat.apache.org/download-80.cgi

Download Project:
1) Download and Unzip CommentApp Project
2) Open Eclipse IDE and File -> Open Projects from File System
2.1) Browse and select unzipped project (CommentApp)
3) Right Click on Project (CommentApp) -> Build Path -> Configure Build Path -> Click on libraires tab
3.1)Click on Module Path -> Add External JARs
3.2) Navigate to Tomatcat 8.5 unzipped path and select servlet-api.jar file
3.3) Again add another jar file by dowloading from this link (MYSQL Connector)
	(https://mvnrepository.com/artifact/mysql/mysql-connector-java/8.0.28)
3.4)scroll down and click on JAR file it will be dowloaded 2.8MB
Add server:
1) Click on File -> New -> Other -> Server -> Server -> click next -> 
1.1) select apache and then select Tomcat 8.5
1.2) Choose name for server and Navigate to Tomatcat 8.5 unzipped path and choose that folder and click on finish
2) Now Right Click on project(CommentApp) -> Run AS -> Run ON server
2.1)select existing server -> Find your selected server and finish

Now project will be executed succesfully...

	
