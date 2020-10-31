# API JAVA CON SQL SERVER
Está es un API para realizar el CRUD de una tabla Libro.
## REQUISITOS
SQL SERVER,
JDBC SQL SERVER,
JDK,
JEE,
APACHE NETBEANS

## PROCEDIMIENTO
* Se debe crear la tabla en cualquier base de datos en SQL SERVER mediante el siguiente script: 
    	
        CREATE TABLE [dbo].[Libro](
    	[nombre] [varchar](150) NOT NULL,
    	[descripcion] [varchar](300) NULL,
    	[autor] [varchar](150) NULL,
    	[fecha] [date] NULL,
    	[ejemplares] [int] NULL,
    	[costo] [numeric](18, 4) NULL,
     	CONSTRAINT [PK_Libro] PRIMARY KEY CLUSTERED 
    	(
    	[nombre] ASC
    	)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
        ) ON [PRIMARY]

* Seguidamente se debe levantar el servidor de aplicaciones y configurar el Connection Pools y JDBC Resources con los datos de la base de datos respectivamente. Es importante verificar el PING de la conexión con la base.

* Finalmente el API con su método principal GET, se encontrará en el siguiente URL = http://localhost:8080/Libro/api/libros
