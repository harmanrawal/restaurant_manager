INSERT INTO restaurants (id, name, location, open_time, close_time, status)
VALUES (1, 'Gourmet Kitchen', 'Downtown City', '09:00', '23:00', 'OPEN');

INSERT INTO tables (restaurant_id, capacity, status)
VALUES (1, 4, 'FREE'),
       (1, 6, 'RESERVED');