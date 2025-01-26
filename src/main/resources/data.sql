INSERT INTO restaurants (id, name, location, open_time, close_time, status)
VALUES (1, 'Gourmet Kitchen', 'Downtown City', '09:00', '23:00', 'OPEN');

INSERT INTO tables (restaurant_id, capacity, status)
VALUES (1, 4, 'FREE'),
       (1, 6, 'RESERVED');

INSERT INTO menu_items (restaurant_id, name, price, description, availability,category) VALUES
(1, 'Margherita Pizza', 12.99, 'Classic cheese pizza with a thin crust', true,'Continental'),
(1, 'Pepperoni Pizza', 15.99, 'Loaded with pepperoni and mozzarella cheese', true,'Continental')