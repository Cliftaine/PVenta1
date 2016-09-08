CREATE DATABASE pVenta;
USE pVenta;

CREATE TABLE usuarios(
    
    usuario VARCHAR(25) NOT NULL,
    contraseña VARCHAR(25) NOT NULL,
    Nombre VARCHAR(25) NOT NULL,
    Apellido VARCHAR(25) NOT NULL,
    ID_r INT(10) NOT NULL,
    primary key(usuario),
	CONSTRAINT fk_gUsuarios FOREIGN KEY (ID_r) REFERENCES gUsuarios(ID_r)

);

CREATE TABLE gUsuarios(

    ID_r INT(10) NOT NULL AUTO_INCREMENT,
    rol VARCHAR(20) NOT NULL,
    PRIMARY KEY(ID_r)
    
);
#
#INSERT INTO gUsuarios values(null,'Vendedor');
INSERT INTO usuarios values('Admin','password','Daniel','Martinez',1); 
SELECT * FROM usuarios WHERE usuario = 'Admin';
SELECT * FROM usuarios;
#delete from usuarios where usuario = 'Us';
#drop table usuarios;

CREATE TABLE catProductos(
	
    strCodBarras VARCHAR(25) NOT NULL,
    strNombre VARCHAR(25) NOT NULL,
    strDescrip VARCHAR(25) NULL,
    strUnidad VARCHAR(25),
    intInicial INT(11),
    intEntrada INT(11),
    intSalida INT(11),
    intActual INT(11),
    decCosto DECIMAL(10,2) UNSIGNED NOT NULL,
    decPrecio DECIMAL(10,2) UNSIGNED NOT NULL,
    PRIMARY KEY(strCodBarras)
    
);

SELECT distinct(strUnidad) from catProductos;
SELECT *FROM catProductos;
DROP TABLE catProductos;
insert into catProductos values('123','test','no se','pza',10,0,0,10,11.5,12);
UPDATE catProductos SET strNombre ='testmil',strDescrip='testmiltambien',strNombre='miuni',intInicial=4,intEntrada=0,intSalida=0,decCosto=12,decPrecio=12 where strCodBarras='123';
DELETE FROM catProductos WHERE strCodBarras ='2'; 

CREATE TABLE catFolios(

	intFolioInv INT(10) NOT NULL,
	intFolioVen INT(10) NOT NULL
	#PRIMARY KEY(intFolioInv)
);



CREATE TABLE catInventarios(
	
	intInvFolio INT(10) NOT NULL,
	strInvMovimiento VARCHAR(10) NOT NULL,
	datInvFecha DATETIME NOT NULL,
	intInvCantidad INT(11) NOT NULL,
	strProductoCodigo varchar(15) NOT NULL,
	intVentaFolio INT(10) NOT NULL,
	txtInvDescripcion VARCHAR(30) NOT NULL
    #PRIMARY KEY(intInvFolio)
    
);
DROP TABLE catInventarios;
DROP TABLE catFolios;
SELECT *FROM catInventarios;
SELECT *FROM catFolios;
UPDATE catFolios SET intFolioInv = intFolioInv + 1 ;
INSERT INTO catFolios VALUES (1,1);
SELECT intFolioInv FROM catFolios;
SELECT intInvFolio AS Folio, strInvMovimiento AS Movimiento,datInvFecha AS Fecha, strProductoCodigo FROM catInventarios;
SELECT * FROM catInventarios WHERE intInvFolio=13;
CREATE TABLE catParametros(
	intAgrupProd TINYINT(1) UNSIGNED NOT NULL,
	intVeriExistencia TINYINT(1) UNSIGNED NOT NULL,
	strTicketInfoFinal VARCHAR(40) DEFAULT NULL
);

CREATE TABLE catVentas(
	intNuVenta INT(10) UNSIGNED NOT NULL,
    dateFechaVenta  DATETIME NOT NULL,
    intVentaProducto INT(10) UNSIGNED NOT NULL,
    decImporte DECIMAL(10,2) UNSIGNED NOT NULL,
    decUtilidad DECIMAL(10,2) UNSIGNED NOT NULL,
    strFormaPago VARCHAR(10) NOT NULL,
    strCancelada VARCHAR(40) DEFAULT NULL,
    strReferencia VARCHAR(20) DEFAULT NULL
);

SELECT *FROM catVentas;
DROP TABLE catVentas;
CREATE TABLE catVentasDetalle(
	intNuVenta INT(10) UNSIGNED NOT NULL,
    strCodBarras VARCHAR(25) NOT NULL,
    strNombre VARCHAR(25) NOT NULL,
    intVentaCantidad INT(10) UNSIGNED NOT NULL,
    decCosto DECIMAL(10,2) UNSIGNED NOT NULL,
    decPrecio DECIMAL(10,2) UNSIGNED NOT NULL,
    strEmpleVenta VARCHAR(40) NOT NULL,
    strEmpleCancel VARCHAR(40) DEFAULT NULL
);

DROP TABLE catVentasDetalle;

CREATE TABLE catEmpresa(
	strNombre VARCHAR(40) NOT NULL,
    strSucursal VARCHAR(40) NOT NULL,
    strDireccion VARCHAR(40) NOT NULL

);

SELECT * FROM catVentasDetalle;