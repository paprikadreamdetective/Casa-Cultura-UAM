## ✅ Datos Completos (Antes de Fragmentar)

| idAlumno | alumnoNombre | alumnoApellidop | alumnoApellidom | alumnoTelefono | alumnoCorreo               | alumnoFechaNac | contactoE_idcontactoE | direccion_idDireccion | alumnoFechaInscripcion | tipoAlumno_idtipoAlumno | nivelAlumno_idnivelAlumno | sucursal_idSucursal |
|------------|--------------|-----------------|-----------------|----------------|-----------------------------|-----------------|------------------------|------------------------|--------------------------|--------------------------|--------------------------|---------------------|
| 1          | Juan         | Pérez           | Gómez           | 5512345678     | juan.perez@gmail.com       | 2002-03-15      | 101                    | 201                    | 2023-01-10              | 1                        | 3                        | 1                   |
| 2          | Maria        | Rodríguez       | López           | 5523456789     | maria.rodriguez@yahoo.com  | 2001-07-20      | 102                    | 202                    | 2022-09-05              | 2                        | 2                        | 1                   |
| 3          | Pedro        | Sánchez         | Morales         | 5534567890     | pedro.sanchez@outlook.com  | 2003-05-11      | 103                    | 203                    | 2021-03-12              | 1                        | 1                        | 2                   |
| 4          | Karla        | Jiménez         | Ruiz            | 5545678901     | karla.jimenez@gmail.com    | 2000-09-30      | 104                    | 204                    | 2020-11-25              | 3                        | 3                        | 1                   |
| 5          | Luis         | Torres          | García          | 5556789012     | luis.torres@live.com       | 2002-12-05      | 105                    | 205                    | 2023-02-14              | 2                        | 2                        | 3                   |
| 6          | Fernanda     | Castro          | Gómez           | 5567890123     | fernanda.castro@gmail.com  | 2001-01-22      | 106                    | 206                    | 2022-06-18              | 1                        | 1                        | 2                   |
| 7          | Carlos       | Martínez        | Herrera         | 5578901234     | carlos.martinez@yahoo.com  | 2004-08-10      | 107                    | 207                    | 2023-04-01              | 2                        | 3                        | 3                   |
| 8          | Daniela      | López           | Cruz            | 5589012345     | daniela.lopez@gmail.com    | 2003-11-11      | 108                    | 208                    | 2021-08-15              | 3                        | 2                        | 1                   |
| 9          | Jorge        | Ramírez         | Chávez          | 5590123456     | jorge.ramirez@outlook.com  | 2000-02-27      | 109                    | 209                    | 2020-09-30              | 1                        | 1                        | 2                   |
| 10         | Sofia        | Aguilar         | Torres          | 5501234567     | sofia.aguilar@gmail.com    | 2002-10-03      | 110                    | 210                    | 2022-12-01              | 2                        | 3                        | 3                   |

---

## 🟢 Fragmentación Vertical: Nodo de Datos Personales (PA)

| idAlumno | alumnoNombre | alumnoApellidop | alumnoApellidom | alumnoTelefono | alumnoCorreo               | alumnoFechaNac | contactoE_idcontactoE | direccion_idDireccion |
|------------|--------------|-----------------|-----------------|----------------|-----------------------------|-----------------|------------------------|------------------------|
| 1          | Juan         | Pérez           | Gómez           | 5512345678     | juan.perez@gmail.com       | 2002-03-15      | 101                    | 201                    |
| 2          | Maria        | Rodríguez       | López           | 5523456789     | maria.rodriguez@yahoo.com  | 2001-07-20      | 102                    | 202                    |
| 3          | Pedro        | Sánchez         | Morales         | 5534567890     | pedro.sanchez@outlook.com  | 2003-05-11      | 103                    | 203                    |
| 4          | Karla        | Jiménez         | Ruiz            | 5545678901     | karla.jimenez@gmail.com    | 2000-09-30      | 104                    | 204                    |
| 5          | Luis         | Torres          | García          | 5556789012     | luis.torres@live.com       | 2002-12-05      | 105                    | 205                    |
| 6          | Fernanda     | Castro          | Gómez           | 5567890123     | fernanda.castro@gmail.com  | 2001-01-22      | 106                    | 206                    |
| 7          | Carlos       | Martínez        | Herrera         | 5578901234     | carlos.martinez@yahoo.com  | 2004-08-10      | 107                    | 207                    |
| 8          | Daniela      | López           | Cruz            | 5589012345     | daniela.lopez@gmail.com    | 2003-11-11      | 108                    | 208                    |
| 9          | Jorge        | Ramírez         | Chávez          | 5590123456     | jorge.ramirez@outlook.com  | 2000-02-27      | 109                    | 209                    |
| 10         | Sofia        | Aguilar         | Torres          | 5501234567     | sofia.aguilar@gmail.com    | 2002-10-03      | 110                    | 210                    |

---

## 🟡 Fragmentación Vertical: Nodo de Datos Administrativos (aA)

| idAlumno | alumnoFechaInscripcion | tipoAlumno_idtipoAlumno | nivelAlumno_idnivelAlumno | sucursal_idSucursal |
|------------|--------------------------|--------------------------|----------------------------|---------------------|
| 1          | 2023-01-10              | 1                        | 3                        | 1                   |
| 2          | 2022-09-05              | 2                        | 2                        | 1                   |
| 3          | 2021-03-12              | 1                        | 1                        | 2                   |
| 4          | 2020-11-25              | 3                        | 3                        | 1                   |
| 5          | 2023-02-14              | 2                        | 2                        | 3                   |
| 6          | 2022-06-18              | 1                        | 1                        | 2                   |
| 7          | 2023-04-01              | 2                        | 3                        | 3                   |
| 8          | 2021-08-15              | 3                        | 2                        | 1                   |
| 9          | 2020-09-30              | 1                        | 1                        | 2                   |
| 10         | 2022-12-01              | 2                        | 3                        | 3                   |

## Fragmentacion Horizontal

| idSucursal | sucursalNombre          | sucursalDireccion                    | sucursalTelefono |
|-------------|--------------------------|-------------------------------------|-------------------|
| 1           | Centro Acuático CDMX     | Av. Insurgentes Sur 123, CDMX       | 5551234567        |
| 2           | Centro Deportivo Monterrey | Calle Constitución 456, Monterrey   | 8189876543        |
| 3           | Centro Recreativo Guadalajara | Av. Vallarta 789, Guadalajara     | 3331239876        |
| 4           | Centro Olímpico Mérida   | Calle 50 Norte 123, Mérida          | 9994567890        |
| 5           | Centro Acuático Tijuana  | Blvd. Agua Caliente 567, Tijuana    | 6647891234        |

🧑‍🎓 Fragmentación Horizontal Primaria de la Tabla Alumno
Cada fragmento (FA1, FA2, FA3, FA4, FA5) contiene los alumnos pertenecientes a la sucursal correspondiente.

| idAlumno | alumnoNombre | alumnoApellidop | alumnoApellidom | sucursal_idSucursal |
|------------|--------------|-----------------|-----------------|---------------------|
| 1          | Juan         | Pérez           | Gómez           | 1                   |
| 2          | Maria        | Rodríguez       | López           | 1                   |
| 4          | Karla        | Jiménez         | Ruiz            | 1                   |
| 8          | Daniela      | López           | Cruz            | 1                   |



| idAlumno | alumnoNombre | alumnoApellidop | alumnoApellidom | sucursal_idSucursal |
|------------|--------------|-----------------|-----------------|---------------------|
| 3          | Pedro        | Sánchez         | Morales         | 2                   |
| 6          | Fernanda     | Castro          | Gómez           | 2                   |
| 9          | Jorge        | Ramírez         | Chávez          | 2                   |


| idAlumno | alumnoNombre | alumnoApellidop | alumnoApellidom | sucursal_idSucursal |
|------------|--------------|-----------------|-----------------|---------------------|
| 5          | Luis         | Torres          | García          | 3                   |
| 7          | Carlos       | Martínez        | Herrera         | 3                   |
| 10         | Sofia        | Aguilar         | Torres          | 3                   |


