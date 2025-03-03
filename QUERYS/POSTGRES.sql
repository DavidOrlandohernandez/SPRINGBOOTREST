SELECT * FROM product;
SELECT * FROM customer;
SELECT * FROM sale;
SELECT * FROM sale_products_list;

SELECT S.id AS venta, S.date, C.name, C.address,PL.product_id, P.name
FROM customer AS C
INNER JOIN sale AS S ON C.id = S.customer_id
INNER JOIN sale_products_list AS PL ON S.id  = PL.sale_id
INNER JOIN product AS P ON P.id = PL.product_id 


SELECT * FROM get_sales_info();

CREATE OR REPLACE FUNCTION get_sales_info()
RETURNS TABLE (
    venta BIGINT,
    date date,
    customer_name VARCHAR,
    customer_address VARCHAR,
    product_id BIGINT,
    product_name VARCHAR
) AS $$
BEGIN
    RETURN QUERY
    SELECT 
        S.id AS venta, 
        S.date, 
        C.name AS customer_name, 
        C.address AS customer_address, 
        PL.product_id, 
        P.name AS product_name
    FROM customer AS C
    INNER JOIN sale AS S ON C.id = S.customer_id
    INNER JOIN sale_products_list AS PL ON S.id = PL.sale_id
    INNER JOIN product AS P ON P.id = PL.product_id;
END;
$$ LANGUAGE plpgsql;

-- Otorgar permiso de ejecución a un usuario específico
GRANT EXECUTE ON FUNCTION get_sales_info() TO postgres;
