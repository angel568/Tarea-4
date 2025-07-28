Gestión de Usuarios
Este es un sistema de gestión de usuarios desarrollado en Java Swing, que permite registrar, iniciar sesión, listar, actualizar y eliminar usuarios. Los datos se almacenan en una base de datos MySQL, garantizando persistencia y seguridad.

📌 Características
✅ Pantalla de inicio de sesión con validación y ocultación de contraseña.
✅ Pantalla de registro de usuarios con validaciones completas.
✅ Lista de usuarios registrados en una tabla (JTable).
✅ Botones para agregar, actualizar, eliminar y editar usuarios.
✅ Almacenamiento persistente en base de datos MySQL mediante JDBC.
✅ Cierre de sesión y retorno a pantalla de login.

📂 Estructura del Proyecto
/GestorUsuarios
│── src
│   ├── Main.java               # Punto de entrada del programa
│   ├── LoginScreen.java        # Interfaz de inicio de sesión
│   ├── RegisterScreen.java     # Interfaz de registro de usuarios
│   ├── EditUserScreen.java     # Interfaz para edición de usuarios existentes
│   ├── UserListScreen.java     # Interfaz que muestra la tabla de usuarios
│   ├── UserManager.java        # Manejo de usuarios con conexión a MySQL
│   ├── User.java               # Clase que representa un usuario
│   ├── ConexionDB.java         # Clase singleton para conexión a base de datos
│── README.md                   # Documentación del proyecto
│── .gitignore                   # Archivos a ignorar en Git

🔧 Requisitos
Java 8 o superior

MySQL instalado y configurado

MySQL Connector/J (JDBC) agregado al proyecto

IDE recomendado: IntelliJ IDEA o Eclipse

🚀 Cómo Ejecutar

1️⃣ Clona este repositorio o descarga los archivos:
git clone https://github.com/angel568/Tarea-4
cd Tarea-4-java

2️⃣ Configura la base de datos MySQL ejecutando el siguiente script SQL para crear la base y tabla:

CREATE DATABASE sistema_usuarios;

USE sistema_usuarios;

CREATE TABLE usuarios (
    username VARCHAR(50) PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    phone VARCHAR(20),
    email VARCHAR(100),
    password VARCHAR(100)
);

3️⃣ Modifica los datos de conexión en ConexionDB.java con tu usuario y contraseña MySQL.

4️⃣ Compila y ejecuta el proyecto.

javac -d bin src/*.java
java -cp bin Main

🖥️ Uso

Abre la aplicación.

Regístrate con un nuevo usuario (los datos se guardan en la base de datos).

Inicia sesión con el usuario creado.

Visualiza la lista de usuarios registrados con sus datos.

Puedes agregar nuevos usuarios, editar los existentes o eliminar usuarios.

Al editar un usuario, podrás modificar sus datos excepto el nombre de usuario.

Cierra sesión para volver a la pantalla de login.
