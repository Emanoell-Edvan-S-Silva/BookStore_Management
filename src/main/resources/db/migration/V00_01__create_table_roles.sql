CREATE TABLE roles
(
    id         BIGINT       NOT NULL IDENTITY(1,1),
    created_at DATETIME     NOT NULL,
    updated_at DATETIME     NOT NULL,
    name       VARCHAR(100) NOT NULL,
    type       VARCHAR(50)  NOT NULL,

    CONSTRAINT roles_id_pk       PRIMARY KEY (id),
    CONSTRAINT roles_name_unique UNIQUE (name)
);

INSERT INTO roles (created_at, updated_at, name, type) VALUES
-- User Roles
(getdate(), getdate(), 'READ_USER_LIST', 'USER'),
(getdate(), getdate(), 'READ_USER_DETAILS', 'USER'),
(getdate(), getdate(), 'CREATE_USER', 'USER'),
(getdate(), getdate(), 'UPDATE_USER', 'USER'),
(getdate(), getdate(), 'DELETE_USER', 'USER'),

-- Publisher Roles
(getdate(), getdate(), 'READ_PUBLISHER_LIST', 'PUBLISHER'),
(getdate(), getdate(), 'READ_PUBLISHER_DETAILS', 'PUBLISHER'),
(getdate(), getdate(), 'CREATE_PUBLISHER', 'PUBLISHER'),
(getdate(), getdate(), 'UPDATE_PUBLISHER', 'PUBLISHER'),
(getdate(), getdate(), 'DELETE_PUBLISHER', 'PUBLISHER'),

-- Book Roles
(getdate(), getdate(), 'READ_BOOK_LIST', 'BOOK'),
(getdate(), getdate(), 'READ_BOOK_DETAILS', 'BOOK'),
(getdate(), getdate(), 'CREATE_BOOK', 'BOOK'),
(getdate(), getdate(), 'UPDATE_BOOK', 'BOOK'),
(getdate(), getdate(), 'DELETE_BOOK', 'BOOK'),

-- Renter Roles
(getdate(), getdate(), 'READ_RENTER_LIST', 'RENTER'),
(getdate(), getdate(), 'READ_RENTER_DETAILS', 'RENTER'),
(getdate(), getdate(), 'CREATE_RENTER', 'RENTER'),
(getdate(), getdate(), 'UPDATE_RENTER', 'RENTER'),
(getdate(), getdate(), 'DELETE_RENTER', 'RENTER'),

-- Rent Roles
(getdate(), getdate(), 'READ_RENT_LIST', 'RENT'),
(getdate(), getdate(), 'READ_RENT_DETAILS', 'RENT'),
(getdate(), getdate(), 'CREATE_RENT', 'RENT'),
(getdate(), getdate(), 'UPDATE_RENT', 'RENT'),
(getdate(), getdate(), 'DELETE_RENT', 'RENT');