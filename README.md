# Gestión de Usuarios 

Este es un sistema de gestión de usuarios desarrollado en **Java Swing**, que permite **registrar, iniciar sesión, listar, actualizar y eliminar usuarios**. Los datos se almacenan en memoria (sin base de datos).

## 📌 Características
✅ Pantalla de inicio de sesión.  
✅ Pantalla de registro de usuarios.  
✅ Lista de usuarios registrados en una tabla (`JTable`).  
✅ Botones para agregar, actualizar y eliminar usuarios.  
✅ Almacenamiento en memoria sin uso de base de datos.  

## 📂 Estructura del Proyecto
/GestorUsuarios
│── src
│   ├── Main.java               # Punto de entrada del programa
│   ├── LoginScreen.java        # Interfaz de inicio de sesión
│   ├── RegisterScreen.java     # Interfaz de registro de usuarios
│   ├── UserListScreen.java     # Interfaz que muestra la tabla de usuarios
│   ├── UserManager.java        # Manejo de usuarios en memoria
│   ├── User.java               # Clase que representa un usuario
│── README.md                   # Documentación del proyecto
│── .gitignore                   # Archivos a ignorar en Git

🔧 Requisitos
Java 8 o superior

IDE recomendado: IntelliJ IDEA o Eclipse

🚀 Cómo Ejecutar
1️⃣ Clona este repositorio o descarga los archivos.
git clone https://github.com/angel568/Tarea-4
cd Tarea-4-java

2️⃣ Compila y ejecuta el proyecto.
Si usas línea de comandos:
javac -d bin src/*.java
java -cp bin Main

🖥️ Uso
Abre la aplicación.

Regístrate con un nuevo usuario.

Inicia sesión con el usuario creado.

Visualiza la lista de usuarios registrados.

Puedes agregar, actualizar o eliminar usuarios.

Cerrar sesión y volver al login.
