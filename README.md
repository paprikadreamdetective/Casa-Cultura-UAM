# Sistema de Gestión de Talleres - Casa de la Cultura UAM Azcapotzalco 🎭

Este documento describe las interfaces del sistema para la gestión de talleres culturales en la Casa de la Cultura – UAM Azcapotzalco. Cada sección detalla la funcionalidad principal de las interfaces, diseñadas para administrar usuarios, asistentes e inscripciones de manera eficiente. 🚀
---
## 1. Login 🔐

La interfaz de inicio de sesión permite a los usuarios autenticarse para acceder al sistema.

![image](https://github.com/user-attachments/assets/1def7677-2367-47c2-85ce-6621b2e8a296)

Funcionalidades:
- 📥 Ingreso de credenciales (usuario y contraseña).
- ✅ Validación de acceso seguro.
- 🚪 Redirección al Dashboard tras autenticación exitosa.
- 🚫 Mensaje de error para credenciales incorrectas.

## 2. Dashboard (Menú Principal) 📊

El Dashboard es el menú principal que muestra un resumen del sistema y proporciona acceso a las demás funcionalidades.

![image](https://github.com/user-attachments/assets/fbdb5d3f-52d4-4e43-8e18-f7a3e3c84ca1)

Funcionalidades:
- 📈 Estadísticas de inscritos por taller (e.g., Danza, Teatro, Dibujo, Redacción, Lectura).
- 🧭 Navegación a las secciones de Gestión de Usuarios, Gestión de Asistentes, Gestión de Inscripciones y Información de Asistentes.
- 🎨 Diseño visual con gráficos o tablas para las estadísticas.
- 🔄 Opción para cerrar sesión.

## 3. Gestión de Usuarios 👥

La interfaz de Gestión de Usuarios permite administrar las cuentas de los administradores del sistema.

Funcionalidades:
- ➕ Registrar nuevos usuarios (e.g., nombre, usuario, contraseña).
- ✏️ Actualizar datos de usuarios existentes.
- 🗑️ Eliminar usuarios del sistema.
- 📋 Visualización de la lista de usuarios registrados.

## 4. Gestión de Asistentes 🧑‍🎓

La interfaz de Gestión de Asistentes se encarga de administrar la información de los asistentes a los talleres.

![image](https://github.com/user-attachments/assets/0b575939-860c-4056-866c-c273156a8d87)

Funcionalidades:
- ➕ Registrar Asistente: Captura de datos personales (e.g., nombre, apellido, matrícula).
![image](https://github.com/user-attachments/assets/ee1928a9-7ecd-436f-9a2e-e6a2d5b9960a)

- ✏️ Actualizar Asistente: Modificación de datos existentes de un asistente.
![image](https://github.com/user-attachments/assets/7d9f07fb-5efa-41d7-82d5-09fbacb7a5b1)

- 🗑️ Eliminar Asistente: Baja de un asistente del sistema.
![image](https://github.com/user-attachments/assets/0e820ffa-5345-4654-bc68-af06a17bdbdf)

## 5. Gestión de Inscripciones 📝

La interfaz de Gestión de Inscripciones permite inscribir asistentes a talleres y gestionar sus registros.

![image](https://github.com/user-attachments/assets/8a27fb8e-443f-4dfc-ac84-f273c71f4669)

Funcionalidades:
- ➕ Inscribir Asistente: Selección de taller (e.g., Danza, Teatro) y horario, con cálculo de costo total (incluye material extra opcional).
![image](https://github.com/user-attachments/assets/46937dc7-5427-495b-8ea8-de632ff964f7)

- 🗑️ Dar de Baja: Eliminación de la inscripción de un asistente a un taller específico.
![image](https://github.com/user-attachments/assets/848e0672-53fe-42b3-adab-012affb104c8)

- 🚫 Deshabilitación de talleres ya inscritos para evitar duplicados.
- 💸 Visualización del costo total por inscripción.
- 📋 Lista de inscripciones activas.

## 6. Información de Asistentes ℹ️

La interfaz de Información de Asistentes muestra los detalles completos de cada asistente y su participación en los talleres.

![image](https://github.com/user-attachments/assets/97c3b195-3668-41eb-b4e0-1d7ac704d5f7)

Funcionalidades:
- 🧑‍🎓 Visualización de datos personales (e.g., nombre, apellido, matrícula).
![image](https://github.com/user-attachments/assets/8968b13a-722e-4b65-88bd-784bd8b04d0b)

- 📋 Lista de talleres inscritos con detalles (e.g., nombre del taller, horario, material solicitado).
![image](https://github.com/user-attachments/assets/b670628b-2bc5-44fc-8252-03e31a087d49)

- 🔍 Búsqueda de asistentes por matrícula.
![image](https://github.com/user-attachments/assets/be018aee-5886-4c97-9030-b151f6e1da51)


# Nota: El sistema está diseñado con una interfaz intuitiva usando Java Swing, asegurando una experiencia fluida para los administradores. 🎉 ¡Listo para gestionar los talleres culturales con estilo!
