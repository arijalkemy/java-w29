# Ejercicio consultas SQL Avanzadas

## Consigna

Teniendo las tablas de una base de datos de una empresa:

**Empleado**:

| cod_emp | nombre   | apellido   | puesto        | fecha_alta | salario | comisiones | depto_nro |
|---------|----------|------------|---------------|------------|---------|------------|-----------|
| E-0001  | César    | Piñero     | Vendedor      | 12/05/2018 | 80000   | 15000      | D-000-4   |
| E-0002  | Yosep    | Kowaleski  | Analista      | 14/07/2015 | 1400000 | 0          | D-000-2   |
| E-0003  | Mariela  | Barrios    | Director      | 05/06/2014 | 185000  | 0          | D-000-3   |
| E-0004  | Jonathan | Aguilera   | Vendedor      | 03/06/2015 | 85000   | 10000      | D-000-4   |
| E-0005  | Daniel   | Brezezicki | Vendedor      | 03/03/2018 | 83000   | 10000      | D-000-4   |
| E-0006  | Mito     | Barchuk    | Presidente    | 05/06/2014 | 190000  | 0          | D-000-3   |
| E-0007  | Emilio   | Galarza    | Desarrollador | 02/08/2014 | 60000   | 0          | D-000-1   |

**Departamento**:

|depto_nro| nombre_depto | localidad  |
|--|--------------|------------|
|D-000-1| Software     | Los Tigres |
|D-000-2| Sistemas     | Guadalupe  |
|D-000-3| Contabilidad | La Roca    |
|D-000-4| Ventas       | Plata      |

Se requiere obtener las siguientes consultas:

1. Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.

2. Visualizar los departamentos con más de cinco empleados.

3. Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.

4. Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.

5. Mostrar el nombre del empleado que tiene el salario más bajo.

6. Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.

## Resolución

- **Creación de base de datos**: [init.sql](init.sql)
- **Consultas**: [consultas.sql](consultas.sql)
