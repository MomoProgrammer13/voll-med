alter table consultas add motivoCancelamento varchar(1000);
update consultas set motivoCancelamento = null;