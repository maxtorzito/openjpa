openjpa
=======

JPA TESTS/BUGS AND OTHERS

FOR RUN THIS PROJECT, JUST DO THIS STEPS IN pom.xml project

1) Create the database/users table/inserts using the ddl-dml-db file for this. (MYSQL DATABASE)
2) mvn -DskipTests=true clean install (this will compile,enhance and generate metamodel)
3) mvn tomee:run  (the server will start and you can see INFO - Server startup in XXXX ms)
4) Acess the page using the browser and type http://localhost:8080/jpatest-1.0-SNAPSHOT/index.xhtml
5) You will see 3 buttons, the first 2 buttons will fail, the third button will work as expected.


Running the plugin will setup easily an Apache TomEE server with all the necessary for run this "demo" (it will drop the mysql jar to lib folder too)

**********The database parameter for connection are under jpatest/src/main/tomee/conf/tomee.xml you will see this at the bottom. You can change the username/password

<Resource id="ExampleDataSource" type="DataSource">
  JdbcDriver com.mysql.jdbc.Driver
  JdbcUrl jdbc:mysql://localhost:3306/jpa_test?zeroDateTimeBehavior=convertToNull&amp;rewriteBatchedStatements=true
  UserName developer
  Password developer
  JtaManaged true
</Resource>

The expected result is the first record of the table will update the description from "USER ONE" to "NEW NICKNAME USING FIND", this only happend when you click in the THIRD BUTTON.
Im not sure why the first 2 actions buttons failed, the only difference between the first 2 method's its that they use criterias and jpql for retrive the entity and the third method use the find entity manager method.


It is a maven project using apache tomee as "application server", it has a plugin for run the project easily.

Please let me know if you have some troubles for reproduce it as well if you could reproduce it.
