INSERT INTO
    public.account (
    balance,
    is_deleted,
    "version",
    created_at,
    last_updated_at,
    created_by,
    deleted_by,
    id,
    updated_by,
    code,
    "name",
    "type"
)
VALUES
    (
        0.0,
        false,
        1,
        '2024-02-21 22:26:51.711394',
        NULL,
        'f80b9919-49d2-467f-aa46-481aaa463ce4',
        NULL,
        '0c1fe4b2-78c9-455d-ac8e-4e182e3faef1',
        NULL,
        'bancos',
        'Bancos',
        'FINANCIAL_ACCOUNT'
    ),
    (
        0.0,
        false,
        1,
        '2024-02-21 22:27:00.54744',
        NULL,
        'f80b9919-49d2-467f-aa46-481aaa463ce4',
        NULL,
        'a301079c-0406-4ab0-961f-9fd7dc5c7ca5',
        NULL,
        'entradas',
        'Entradas',
        'INCOME_ACCOUNT'
    ),
    (
        0.0,
        false,
        1,
        '2024-02-21 22:27:08.587005',
        NULL,
        'f80b9919-49d2-467f-aa46-481aaa463ce4',
        NULL,
        '8dac10f8-6578-41fa-91f1-bce7ee75f0d7',
        NULL,
        'saidas',
        'Saídas',
        'EXPENSE_ACCOUNT'
    ) ON CONFLICT DO NOTHING;

INSERT INTO
    public.company (
    is_deleted,
    "version",
    created_at,
    last_updated_at,
    created_by,
    deleted_by,
    id,
    updated_by,
    cnpj,
    "name"
)
VALUES
    (
        false,
        1,
        '2024-02-21 20:40:05.903225',
        NULL,
        NULL,
        NULL,
        'dc929025-6163-4b6d-8f66-5d972c3d2834',
        NULL,
        '12345678912',
        'Zamp'
    ) ON CONFLICT DO NOTHING;

INSERT INTO
    public.entries (
    "date",
    entry_value,
    is_deleted,
    "version",
    created_at,
    last_updated_at,
    classification_account_id,
    company_id,
    created_by,
    deleted_by,
    financial_account_id,
    id,
    updated_by,
    history,
    "type"
)
VALUES
    (
        '2024-02-21',
        1.0,
        false,
        1,
        '2024-02-21 22:27:19.570982',
        NULL,
        'a301079c-0406-4ab0-961f-9fd7dc5c7ca5',
        NULL,
        'f80b9919-49d2-467f-aa46-481aaa463ce4',
        NULL,
        '0c1fe4b2-78c9-455d-ac8e-4e182e3faef1',
        'c5693f02-003b-4693-81fa-d844d6fba57f',
        NULL,
        '',
        'IN'
    ),
    (
        '2024-02-21',
        12.0,
        false,
        1,
        '2024-02-21 22:27:21.631118',
        NULL,
        'a301079c-0406-4ab0-961f-9fd7dc5c7ca5',
        NULL,
        'f80b9919-49d2-467f-aa46-481aaa463ce4',
        NULL,
        '0c1fe4b2-78c9-455d-ac8e-4e182e3faef1',
        'c8ca8471-ff2e-4bc4-b313-126401fde568',
        NULL,
        '',
        'IN'
    ),
    (
        '2024-02-21',
        123.0,
        false,
        1,
        '2024-02-21 22:27:22.937803',
        NULL,
        'a301079c-0406-4ab0-961f-9fd7dc5c7ca5',
        NULL,
        'f80b9919-49d2-467f-aa46-481aaa463ce4',
        NULL,
        '0c1fe4b2-78c9-455d-ac8e-4e182e3faef1',
        'a2e198d3-41d6-451c-bee2-d3d63e8816ab',
        NULL,
        '',
        'IN'
    ),
    (
        '2024-02-21',
        5.0,
        false,
        1,
        '2024-02-21 22:27:37.032509',
        NULL,
        '8dac10f8-6578-41fa-91f1-bce7ee75f0d7',
        NULL,
        'f80b9919-49d2-467f-aa46-481aaa463ce4',
        NULL,
        '0c1fe4b2-78c9-455d-ac8e-4e182e3faef1',
        'ce38dc6a-3273-4553-97b5-72f1d0e050c4',
        NULL,
        '',
        'OUT'
    ),
    (
        '2024-02-21',
        32.0,
        false,
        1,
        '2024-02-21 22:27:41.900688',
        NULL,
        '8dac10f8-6578-41fa-91f1-bce7ee75f0d7',
        NULL,
        'f80b9919-49d2-467f-aa46-481aaa463ce4',
        NULL,
        '0c1fe4b2-78c9-455d-ac8e-4e182e3faef1',
        'e1f1682b-93c1-4c11-9c02-d1520b629fbf',
        NULL,
        '',
        'OUT'
    ) ON CONFLICT DO NOTHING;

INSERT INTO
    public.user_profile (
    is_deleted,
    "level",
    "version",
    created_at,
    last_updated_at,
    created_by,
    deleted_by,
    id,
    updated_by,
    "name"
)
VALUES
    (
        false,
        20,
        1,
        '2024-02-21 20:40:05.953133',
        NULL,
        NULL,
        NULL,
        'afc5c146-c501-4083-b2fa-95f6c2eb4e1e',
        NULL,
        'Administrador'
    ),
    (
        false,
        2,
        1,
        '2024-02-21 20:40:05.953446',
        NULL,
        NULL,
        NULL,
        '4168770a-bb10-4d32-bf93-2b3095b89cdf',
        NULL,
        'OutroAdministrador'
    ) ON CONFLICT DO NOTHING;

INSERT INTO
    public.user_profile_permission (user_profile_id, "permission")
VALUES
    ('afc5c146-c501-4083-b2fa-95f6c2eb4e1e', 'ALL'),
    (
        '4168770a-bb10-4d32-bf93-2b3095b89cdf',
        'COMPANIES_MENU'
    ) ON CONFLICT DO NOTHING;

INSERT INTO
    public.users (
    is_deleted,
    "version",
    created_at,
    last_updated_at,
    created_by,
    deleted_by,
    id,
    updated_by,
    email,
    "name",
    "password",
    situation
)
VALUES
    (
        false,
        1,
        '2024-02-21 20:40:05.406713',
        NULL,
        NULL,
        NULL,
        'f80b9919-49d2-467f-aa46-481aaa463ce4',
        NULL,
        'admin',
        'Gabriel',
        '$2a$10$UpapXNsV/qgwodGSQopZpe3gE83.ywxjJrUd8.aXUtf0QzSST.a1S',
        'ACTIVE'
    ),
    (
        false,
        1,
        '2024-02-21 20:40:05.496938',
        NULL,
        NULL,
        NULL,
        'b166b58a-20dc-4beb-8c1f-51f3fd1aaf92',
        NULL,
        'admin2',
        'Gabriel2',
        '$2a$10$XWwQtmC8rGXyKp9gNG6sSee0E.WLsScklXBTJDR8IEg4EAj10R9tu',
        'ACTIVE'
    ),
    (
        false,
        1,
        '2024-02-21 20:40:05.580566',
        NULL,
        NULL,
        NULL,
        'cc308a85-1d37-4eda-9fc8-21f0a79626e6',
        NULL,
        'a3dmin',
        'Juliana',
        '$2a$10$ikODIcqX4E5twH3Q1H/Lru/fpt/G9pKTVf98YyKU57muQYJiRiwG2',
        'ACTIVE'
    ),
    (
        false,
        1,
        '2024-02-21 20:40:05.664292',
        NULL,
        NULL,
        NULL,
        '41eabb03-ad4d-4591-832c-fa05fa094700',
        NULL,
        'emailTeste@gmail.com',
        'Teste',
        '$2a$10$7MxXcxl0bG9Ta7nF.ubTiOUN/PKqK6YQ/iTMZmKIM4VNI4BGB4epq',
        'ACTIVE'
    ) ON CONFLICT DO NOTHING;

INSERT INTO
    public.users_user_profiles (user_profiles_id, users_id)
VALUES
    (
        'afc5c146-c501-4083-b2fa-95f6c2eb4e1e',
        'f80b9919-49d2-467f-aa46-481aaa463ce4'
    ),
    (
        'afc5c146-c501-4083-b2fa-95f6c2eb4e1e',
        'b166b58a-20dc-4beb-8c1f-51f3fd1aaf92'
    ),
    (
        'afc5c146-c501-4083-b2fa-95f6c2eb4e1e',
        '41eabb03-ad4d-4591-832c-fa05fa094700'
    ) ON CONFLICT DO NOTHING;