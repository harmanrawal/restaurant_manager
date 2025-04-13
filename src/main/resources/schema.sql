CREATE TABLE restaurants (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    location VARCHAR(255) NOT NULL,
    open_time TIME NOT NULL,
    close_time TIME NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status VARCHAR(20) NOT NULL
);

CREATE TABLE tables (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    restaurant_id BIGINT NOT NULL,
    capacity INT NOT NULL,
    status VARCHAR(20) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (restaurant_id) REFERENCES restaurants(id)
);

CREATE TABLE menu_items (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    restaurant_id BIGINT NOT NULL,
    name VARCHAR(255) NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    description VARCHAR(500),
    availability BOOLEAN NOT NULL,
    category VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (restaurant_id) REFERENCES restaurants(id)
);

CREATE TABLE orders (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,         -- Primary key for the orders table
    restaurant_id BIGINT NOT NULL,                -- Foreign key to the restaurant
    table_id BIGINT NOT NULL,                     -- Foreign key to the table
    status VARCHAR(20) NOT NULL,                  -- Order status (e.g., Serving, Completed, Cancelled)
    bill_amount DECIMAL(10, 2) NOT NULL,          -- Total bill amount
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- Timestamp for when the order was created
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP -- Timestamp for last update
);

CREATE TABLE order_items (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,         -- Primary key for the order_items table
    order_id BIGINT NOT NULL,                     -- Foreign key referencing the orders table
    menu_item_id BIGINT NOT NULL,                 -- Foreign key to the menu item
    quantity INT NOT NULL,                        -- Quantity of the menu item in the order
    item_status VARCHAR(20) NOT NULL,             -- Status of the item (e.g., Preparing, Served, Cancelled)
    price DECIMAL(10, 2) NOT NULL,                -- Price of the menu item
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- Timestamp for when the item was added to the order
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, -- Last updated timestamp
    FOREIGN KEY (order_id) REFERENCES orders(id) ON DELETE CASCADE -- Ensure order deletion cascades to order_items
);
