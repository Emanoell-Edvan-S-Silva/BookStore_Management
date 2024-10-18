CREATE TABLE users
(
    id           BIGINT       NOT NULL IDENTITY(1,1),
    created_at   DATETIME     NOT NULL,
    updated_at   DATETIME     NOT NULL,
    name         VARCHAR(100) NOT NULL,
    email        VARCHAR(100) NOT NULL,
    password     VARCHAR(100) NOT NULL,
    status       VARCHAR(50)  NOT NULL,

    CONSTRAINT users_id_pk PRIMARY KEY (id),
    CONSTRAINT users_status_check CHECK (status IN ('ACTIVE', 'AWAY', 'VACATION'))
);

CREATE TABLE user_roles_relationships
(
    id          BIGINT   NOT NULL IDENTITY(1,1),
    created_at  DATETIME NOT NULL,
    updated_at  DATETIME NOT NULL,
    user_id  BIGINT   NOT NULL,
    role_id     BIGINT   NOT NULL,

    CONSTRAINT user_roles_relationships_id_pk         PRIMARY KEY (id),
    CONSTRAINT user_roles_relationships_user_id_fk FOREIGN KEY (user_id) REFERENCES users(id),
    CONSTRAINT user_roles_relationships_role_id_fk    FOREIGN KEY (role_id) REFERENCES roles(id)
);


INSERT INTO users (created_at, updated_at, name, email, password, status)
VALUES
    (GETDATE(), GETDATE(), 'admin', 'admin@example.com', '$2a$10$hStY9c53tYl.dxqTEELrtOEtJUvGbeW2umUd3Ga6WdHrpHLPhBiN2', 'ACTIVE');

DECLARE @userId BIGINT;
SELECT @userId = id FROM users WHERE name = 'admin';

INSERT INTO user_roles_relationships (created_at, updated_at, user_id, role_id)
SELECT GETDATE(), GETDATE(), @userId, id
FROM roles;