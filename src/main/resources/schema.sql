CREATE TABLE restaurants (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    location VARCHAR(255) NOT NULL,
    open_time TIME NOT NULL,
    close_time TIME NOT NULL,
    status VARCHAR(20) NOT NULL
);

CREATE TABLE tables (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    restaurant_id BIGINT NOT NULL,
    capacity INT NOT NULL,
    status VARCHAR(20) NOT NULL,
    FOREIGN KEY (restaurant_id) REFERENCES restaurants(id)
);