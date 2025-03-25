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

| idAlumno | alumnoNombre | alumnoApellidop | alumnoApellidom | alumnoTelefono | alumnoCorreo               | alumnoFechaNac | contactoE_idcontactoE | direccion_idDireccion | alumnoFechaInscripcion | tipoAlumno_idtipoAlumno | nivelAlumno_idnivelAlumno | sucursal_idSucursal |
|------------|--------------|-----------------|-----------------|----------------|-----------------------------|-----------------|------------------------|------------------------|--------------------------|--------------------------|--------------------------|---------------------|
| 1          | Juan         | Pérez           | Gómez           | 5512345678     | juan.perez@gmail.com       | 2002-03-15      | 101                    | 201                    | 2023-01-10              | 1                        | 3                        | 1                   |
| 2          | Maria        | Rodríguez       | López           | 5523456789     | maria.rodriguez@yahoo.com  | 2001-07-20      | 102                    | 202                    | 2022-09-05              | 2                        | 2                        | 1                   |
| 4          | Karla        | Jiménez         | Ruiz            | 5545678901     | karla.jimenez@gmail.com    | 2000-09-30      | 104                    | 204                    | 2020-11-25              | 3                        | 3                        | 1                   |
| 8          | Daniela      | López           | Cruz            | 5589012345     | daniela.lopez@gmail.com    | 2003-11-11      | 108                    | 208                    | 2021-08-15              | 3                        | 2                        | 1                   |


| idAlumno | alumnoNombre | alumnoApellidop | alumnoApellidom | alumnoTelefono | alumnoCorreo               | alumnoFechaNac | contactoE_idcontactoE | direccion_idDireccion | alumnoFechaInscripcion | tipoAlumno_idtipoAlumno | nivelAlumno_idnivelAlumno | sucursal_idSucursal |
|------------|--------------|-----------------|-----------------|----------------|-----------------------------|-----------------|------------------------|------------------------|--------------------------|--------------------------|--------------------------|---------------------|
| 3          | Pedro        | Sánchez         | Morales         | 5534567890     | pedro.sanchez@outlook.com  | 2003-05-11      | 103                    | 203                    | 2021-03-12              | 1                        | 1                        | 2                   |
| 6          | Fernanda     | Castro          | Gómez           | 5567890123     | fernanda.castro@gmail.com  | 2001-01-22      | 106                    | 206                    | 2022-06-18              | 1                        | 1                        | 2                   |
| 9          | Jorge        | Ramírez         | Chávez          | 5590123456     | jorge.ramirez@outlook.com  | 2000-02-27      | 109                    | 209                    | 2020-09-30              | 1                        | 1                        | 2                   |





| idAlumno | alumnoNombre | alumnoApellidop | alumnoApellidom | alumnoTelefono | alumnoCorreo               | alumnoFechaNac | contactoE_idcontactoE | direccion_idDireccion | alumnoFechaInscripcion | tipoAlumno_idtipoAlumno | nivelAlumno_idnivelAlumno | sucursal_idSucursal |
|------------|--------------|-----------------|-----------------|----------------|-----------------------------|-----------------|------------------------|------------------------|--------------------------|--------------------------|--------------------------|---------------------|
| 5          | Luis         | Torres          | García          | 5556789012     | luis.torres@live.com       | 2002-12-05      | 105                    | 205                    | 2023-02-14              | 2                        | 2                        | 3                   |
| 7          | Carlos       | Martínez        | Herrera         | 5578901234     | carlos.martinez@yahoo.com  | 2004-08-10      | 107                    | 207                    | 2023-04-01              | 2                        | 3                        | 3                   |
| 10         | Sofia        | Aguilar         | Torres          | 5501234567     | sofia.aguilar@gmail.com    | 2002-10-03      | 110                    | 210                    | 2022-12-01              | 2                        | 3                        | 3                   |

# Fragmentacion Horizontal derivada

| idMensualidad | mensualidadFecha | tipoPago_idtipoPago | alumno_idAlumno | numRecibo | sucursal_idSucursal |
|----------------|------------------|----------------------|-----------------|-----------|---------------------|
| 1              | 2024-03-01       | 1                    | 1               | 1001      | 1                   |
| 2              | 2024-03-05       | 2                    | 2               | 1002      | 1                   |
| 3              | 2024-03-10       | 1                    | 4               | 1003      | 1                   |
| 4              | 2024-03-15       | 2                    | 8               | 1004      | 1                   |
| 5              | 2024-03-02       | 1                    | 3               | 1005      | 2                   |
| 6              | 2024-03-08       | 3                    | 6               | 1006      | 2                   |
| 7              | 2024-03-12       | 1                    | 9               | 1007      | 2                   |
| 8              | 2024-03-03       | 2                    | 5               | 1008      | 3                   |
| 9              | 2024-03-07       | 1                    | 7               | 1009      | 3                   |
| 10             | 2024-03-14       | 3                    | 10              | 1010      | 3                   |

# ✅ Fragmento PAGA = Pago ⋉ FA1

| idMensualidad | mensualidadFecha | tipoPago_idtipoPago | alumno_idAlumno | numRecibo | sucursal_idSucursal |
|----------------|------------------|----------------------|-----------------|-----------|---------------------|
| 1              | 2024-03-01       | 1                    | 1               | 1001      | 1                   |
| 2              | 2024-03-05       | 2                    | 2               | 1002      | 1                   |
| 3              | 2024-03-10       | 1                    | 4               | 1003      | 1                   |
| 4              | 2024-03-15       | 2                    | 8               | 1004      | 1                   |

# ✅ Fragmento PAGB = Pago ⋉ FA2

| idMensualidad | mensualidadFecha | tipoPago_idtipoPago | alumno_idAlumno | numRecibo | sucursal_idSucursal |
|----------------|------------------|----------------------|-----------------|-----------|---------------------|
| 5              | 2024-03-02       | 1                    | 3               | 1005      | 2                   |
| 6              | 2024-03-08       | 3                    | 6               | 1006      | 2                   |
| 7              | 2024-03-12       | 1                    | 9               | 1007      | 2                   |

# ✅ Fragmento PAGC = Pago ⋉ FA3

| idMensualidad | mensualidadFecha | tipoPago_idtipoPago | alumno_idAlumno | numRecibo | sucursal_idSucursal |
|----------------|------------------|----------------------|-----------------|-----------|---------------------|
| 8              | 2024-03-03       | 2                    | 5               | 1008      | 3                   |
| 9              | 2024-03-07       | 1                    | 7               | 1009      | 3                   |
| 10             | 2024-03-14       | 3                    | 10              | 1010      | 3                   |

# TABLA HORARIO

| idHorario | tipoHorario_idtipoHorario | diaHora_idDiaHora | sucursal_idSucursal |
|------------|---------------------------|--------------------|---------------------|
| 1          | 1                         | 101                | 1                   |
| 2          | 2                         | 102                | 1                   |
| 3          | 3                         | 103                | 1                   |
| 4          | 1                         | 104                | 1                   |
| 5          | 2                         | 105                | 2                   |
| 6          | 3                         | 106                | 2                   |
| 7          | 1                         | 107                | 2                   |
| 8          | 2                         | 108                | 3                   |
| 9          | 3                         | 109                | 3                   |
| 10         | 1                         | 110                | 3                   |


🧑‍🎓 Fragmentación Horizontal Derivada
Se genera la fragmentación horizontal derivada en base a los fragmentos de alumnos (FA1, FA2, FA3).
La notación es:

HORAA = Horario ⋉ FA1

HORAB = Horario ⋉ FA2

HORAC = Horario ⋉ FA3

✅ Fragmento HORAA = Horario ⋉ FA1

| idHorario | tipoHorario_idtipoHorario | diaHora_idDiaHora | sucursal_idSucursal |
|------------|---------------------------|--------------------|---------------------|
| 1          | 1                         | 101                | 1                   |
| 2          | 2                         | 102                | 1                   |
| 3          | 3                         | 103                | 1                   |
| 4          | 1                         | 104                | 1                   |

✅ Fragmento HORAB = Horario ⋉ FA2

| idHorario | tipoHorario_idtipoHorario | diaHora_idDiaHora | sucursal_idSucursal |
|------------|---------------------------|--------------------|---------------------|
| 5          | 2                         | 105                | 2                   |
| 6          | 3                         | 106                | 2                   |
| 7          | 1                         | 107                | 2                   |

✅ Fragmento HORAC = Horario ⋉ FA3

| idHorario | tipoHorario_idtipoHorario | diaHora_idDiaHora | sucursal_idSucursal |
|------------|---------------------------|--------------------|---------------------|
| 8          | 2                         | 108                | 3                   |
| 9          | 3                         | 109                | 3                   |
| 10         | 1                         | 110                | 3                   |

🔎 Conclusiones
HORAA contiene los horarios correspondientes a la Sucursal 1 (CDMX).

HORAB contiene los horarios de la Sucursal 2 (Monterrey).

HORAC agrupa los horarios de la Sucursal 3 (Guadalajara).

# DIAHORA

| idDiaHora | dia_idDia | diaHora_idHoraInicio | diaHora_idHoraFin |
|------------|-----------|----------------------|--------------------|
| 101        | 1         | 08:00                | 10:00              |
| 102        | 2         | 10:00                | 12:00              |
| 103        | 3         | 12:00                | 14:00              |
| 104        | 4         | 14:00                | 16:00              |
| 105        | 5         | 16:00                | 18:00              |
| 106        | 6         | 18:00                | 20:00              |
| 107        | 1         | 08:00                | 10:00              |
| 108        | 2         | 10:00                | 12:00              |
| 109        | 3         | 12:00                | 14:00              |
| 110        | 4         | 14:00                | 16:00              |


🧑‍🎓 Fragmentación Horizontal Derivada
Se genera la fragmentación horizontal derivada usando los fragmentos previos:

DHA = DiaHora ⋉ HORAA

DHB = DiaHora ⋉ HORAB

DHC = DiaHora ⋉ HORAC

✅ Fragmento DHA = DiaHora ⋉ HORAA

| idDiaHora | dia_idDia | diaHora_idHoraInicio | diaHora_idHoraFin |
|------------|-----------|----------------------|--------------------|
| 101        | 1         | 08:00                | 10:00              |
| 102        | 2         | 10:00                | 12:00              |
| 103        | 3         | 12:00                | 14:00              |
| 104        | 4         | 14:00                | 16:00              |

Fragmento DHA incluye los registros donde idDiaHora corresponde a los horarios de la Sucursal 1 (CDMX).

✅ Fragmento DHB = DiaHora ⋉ HORAB

| idDiaHora | dia_idDia | diaHora_idHoraInicio | diaHora_idHoraFin |
|------------|-----------|----------------------|--------------------|
| 105        | 5         | 16:00                | 18:00              |
| 106        | 6         | 18:00                | 20:00              |
| 107        | 1         | 08:00                | 10:00              |

Fragmento DHB contiene los horarios de la Sucursal 2 (Monterrey).

✅ Fragmento DHC = DiaHora ⋉ HORAC

| idDiaHora | dia_idDia | diaHora_idHoraInicio | diaHora_idHoraFin |
|------------|-----------|----------------------|--------------------|
| 108        | 2         | 10:00                | 12:00              |
| 109        | 3         | 12:00                | 14:00              |
| 110        | 4         | 14:00                | 16:00              |

Fragmento DHC incluye los registros de horarios de la Sucursal 3 (Guadalajara).

# TIPOPAGO

| idTipoPago | tipoPagoNombre | tipoPagoDescripcion         |
|-------------|----------------|-----------------------------|
| 1           | Efectivo       | Pago realizado en efectivo  |
| 2           | Tarjeta        | Pago con tarjeta bancaria   |
| 3           | Transferencia        | Pago mediante transferencia   |

✅ Fragmento TPA = TipoPago ⋉ PAGA

| idTipoPago | tipoPagoNombre | tipoPagoDescripcion         |
|-------------|----------------|-----------------------------|
| 1           | Efectivo       | Pago realizado en efectivo  |
| 2           | Tarjeta        | Pago con tarjeta bancaria   |

TPA incluye los tipos de pago asociados a los pagos de la Sucursal 1 (CDMX).

En este fragmento, hay registros de pagos en Efectivo y Tarjeta.

✅ Fragmento TPB = TipoPago ⋉ PAGB

| idTipoPago | tipoPagoNombre  | tipoPagoDescripcion           |
|-------------|-----------------|------------------------------|
| 1           | Efectivo        | Pago realizado en efectivo   |
| 3           | Transferencia   | Pago mediante transferencia  |

TPB incluye los tipos de pago asociados a los pagos de la Sucursal 2 (Monterrey).

Aquí se registran pagos en Efectivo y por Transferencia.

✅ Fragmento TPC = TipoPago ⋉ PAGC

| idTipoPago | tipoPagoNombre   | tipoPagoDescripcion           |
|-------------|------------------|------------------------------|
| 2           | Tarjeta           | Pago con tarjeta bancaria    |
| 3           | Transferencia     | Pago mediante transferencia  |

TPC contiene los tipos de pago relacionados con los pagos de la Sucursal 3 (Guadalajara).

Los registros de esta sucursal incluyen pagos con Tarjeta y Transferencia.

 ***a) Recolectar los datos iniciales***

Los datos fueron recolectados del siguiente enlace: https://www.stratosphereips.org/datasets-ctu13

## CTU-13 Dataset: Tipos de Archivos y Descarga

### 📂 **Tipos de Archivos**
Cada escenario del conjunto de datos CTU-13 incluye diferentes tipos de archivos procesados. Por razones de privacidad, no está disponible el archivo completo `.pcap` con todos los datos de tráfico. Sin embargo, se dispone de otros archivos útiles para el análisis:

- **Archivos .parquet**: Capturan exclusivamente el tráfico de botnets.
- **Archivos .binetflow**: Archivos NetFlow bidireccionales, generados con **Argus**, que contienen información del tráfico, incluyendo etiquetas, direcciones IP fuente y destino, así como los puertos asociados, tipo de botnet y tambien si es trafico malicioso o no.
- **Archivo Ejecutable Original**: Disponible para ciertos escenarios, útil para análisis adicionales.

---

### 📥 **Descarga del Conjunto de Datos**

- **Descarga Completa:** Puedes descargar todo el conjunto de datos como un archivo comprimido.
  - [CTU-13-Dataset.tar.bz2 (1.9GB)](URL_DE_DESCARGA_COMPLETA)

- **Descarga por Escenario:** También puedes descargar cada captura de manera individual. Los archivos `.binetflow` se encuentran en la carpeta `detailed-bidirectional-flow-labels`.

  - [CTU-Malware-Capture-Botnet-42](URL_42)
  - [CTU-Malware-Capture-Botnet-43](URL_43)
  - [CTU-Malware-Capture-Botnet-44](URL_44)
  - [CTU-Malware-Capture-Botnet-45](URL_45)
  - [CTU-Malware-Capture-Botnet-46](URL_46)
  - [CTU-Malware-Capture-Botnet-47](URL_47)
  - [CTU-Malware-Capture-Botnet-48](URL_48)
  - [CTU-Malware-Capture-Botnet-49](URL_49)
  - [CTU-Malware-Capture-Botnet-50](URL_50)
  - [CTU-Malware-Capture-Botnet-51](URL_51)
  - [CTU-Malware-Capture-Botnet-52](URL_52)
  - [CTU-Malware-Capture-Botnet-53](URL_53)
  - [CTU-Malware-Capture-Botnet-54](URL_54)

---

Para cualquier análisis adicional o consulta sobre los archivos `.binetflow`, asegurarse de verificar las etiquetas de flujo bidireccional disponibles en cada escenario.

# ***b) Descripcion de los datos***
