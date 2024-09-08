CREATE TABLE test.t_inventory
(
	id bigint(20) NOT NULL AUTO_INCREMENT,
	sku_code varchar(255) DEFAULT NULL,
	quantity int(11) DEFAULT NULL,
	PRIMARY KEY(id)
);

INSERT INTO test.t_inventory (quantity, sku_code)
values 	(100, 'iphone_15'),
		(100, 'pixel_8'),
		(100, 'galaxy_24'),
		(100, 'oneplus_12');