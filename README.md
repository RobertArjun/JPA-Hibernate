# JPA-Hibernate
JPA defines Java Persistence Query Language (JPQL) which is an object-oriented query language. The syntax of JPQL is similar to SQL but it operates against Java objects rather than directly with database tables.

##### JPA is a specification, and Hibernate is one of its implementations

## Hibernate Framework:
Hibernate is a popular Object Relational Mapping (ORM) framework that aims at simplifying database programming for developers.
Hibernate was developed before JPA. And after JPA becomes a standard, Hibernate restructures itself to become an implementation of JPA.
The Hibernate framework consists of several components: Hibernate ORM, Hibernate Search, Hibernate Validator, Hibernate CGM and Hibernate Tools.
In this tutorial, we use Hibernate ORM which is the core component of the Hibernate framework, for mapping Java model classes to tables in a relational database.

## JPA Configuration
XML configuration file for JPA called persistence.xml, in order to tell Hibernate how to connect to the database. This file must be present in the classpath, under the META-INF folder.
Under the src/main/resources folder, create a new folder named META-INF 

#### persistence.xml

		``` <persistence version="2.2"
			xmlns="http://xmlns.jcp.org/xml/ns/persistence"
			xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
			xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/persistence
			http://xmlns.jcp.org/xml/ns/persistence/persistence_2_2.xsd">
			<persistence-unit name="my-persistence-unit"> <!-- Define factory class declaration -->
				<description>JPA example</description>
				<provider>org.hibernate.jpa.HibernatePersistenceProvider</provider>
				<exclude-unlisted-classes>false</exclude-unlisted-classes>
				<properties>
					<property name="javax.persistence.jdbc.url"
						value="jdbc:mysql://localhost:3306/jpadb" />
					<property name="javax.persistence.jdbc.user" value="root" />
					<property name="javax.persistence.jdbc.password"
						value="root" />
					<property name="javax.persistence.jdbc.driver"
						value="com.mysql.cj.jdbc.Driver" />
				</properties>
			</persistence-unit>
		</persistence> ```

#### pom.xml

```
	<dependencies>
		<dependency>
			<groupId>org.hibernate</groupId>
			<artifactId>hibernate-core</artifactId>
			<version>5.4.29.Final</version>
		</dependency>
		<dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
			<version>8.0.23</version>
		</dependency>
		<!-- if we are use jdk >=12 then add the below dependency -->
		<dependency>
			<groupId>javax.xml.bind</groupId>
			<artifactId>jaxb-api</artifactId>
			<version>2.3.1</version>
		</dependency>
		<dependency>
			<groupId>com.sun.xml.bind</groupId>
			<artifactId>jaxb-core</artifactId>
			<version>3.0.0</version>
		</dependency>
		<dependency>
			<groupId>com.sun.xml.bind</groupId>
			<artifactId>jaxb-impl</artifactId>
			<version>3.0.0</version>
		</dependency>
	</dependencies>
  ```
  # Ex: 2 ID & generated value
 1. GenerationType.IDENTITY
	``` @GeneratedValue(strategy = GenerationType.IDENTITY) 
   	 if table column is Auto increment then Identity strategy will automatically create the the id so Auto increment should be enable in the table ```

2. GenerationType.TABLE
 	``` 
	2.1 @GeneratedValue(strategy = GenerationType.TABLE, generator = "key_generator")
	key_generator is a table name so this table should have two column name such as
	sequence_name and next_val so while executing the persist or save hibernate will automatically create the sequence
	```
  
	```
	2.2 @TableGenerator(name = "key_generator",
	table = "key_generator", pkColumnName = "key_name", pkColumnValue = "product_sequence", valueColumnName = "key_value")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "key_generator")
	TableGenerator annotation is used to create custom table and custom column name 
	```
	
  	```
	2.3 @TableGenerator(name = "key_generator",
	table = "key_generator", pkColumnName = "key_name", pkColumnValue = "product_sequence",
	valueColumnName = "key_value", allocationSize = 20)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "key_generator")
 	 allocationSize is ued for perfomance improvement 
	 ```
  
  3. GenerationType.Sequence is only support Orcle
  
  4. GenerationType.Auto // Don't use 
