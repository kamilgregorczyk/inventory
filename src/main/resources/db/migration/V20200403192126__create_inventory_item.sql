CREATE TABLE inventory_item
(
    id           BIGSERIAL PRIMARY KEY,
    name         VARCHAR(255) NOT NULL,
    description  VARCHAR(255) NULL,
    image_path   VARCHAR(255) NULL,
    created_date TIMESTAMP    NOT NULL,
    updated_date TIMESTAMP    NOT NULL

)