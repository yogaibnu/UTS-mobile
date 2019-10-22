create table DimSupplier (
 id int primary key identity ,
 AltKey varchar(50),
 Nama varchar(50),
 Alamat varchar (50),
 Kota varchar (50)
);

select * from DimSupplier;

create table LogData(
 id int primary key identity,
 Waktu datetime,
 Pesan varchar (50) 
);

select * from LogData;

insert into LogData(Waktu, Pesan)
	values (GETDATE(), 'Impor data sukses';

DROP Table LogData;