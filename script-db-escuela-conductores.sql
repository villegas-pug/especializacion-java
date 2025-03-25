

-- 1. Crea `db`: bdescuelaconductores
IF NOT EXISTS(SELECT 1 FROM SYS.databases d WHERE d.name = 'bdescuelaconductores')
   CREATE DATABASE BD_SIRIM.dbo.bdescuelaconductores


USE bdescuelaconductores

-- 2. ...
/*
DROP TABLE Departamento
DROP TABLE Provincia
DROP TABLE Distrito
*/

SELECT * FROM BD_SIRIM.dbo.Departamento
SELECT * FROM BD_SIRIM.dbo.Estudiantes
SELECT * FROM BD_SIRIM.dbo.Matriculas
-- 3. ...

CREATE OR ALTER PROCEDURE usp_insertarDepartamento
    @nombre VARCHAR(100),
    @activo BIT
AS
BEGIN
    INSERT INTO Departamento(nombre, activo) VALUES (@nombre, @activo)
END

EXEC usp_insertarDepartamento 'Lima', 1

SELECT * FROM Departamento



