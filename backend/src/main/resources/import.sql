INSERT INTO tb_user (nome_completo, email, cpf, telefone, senha) VALUES ('Alex Brown', 'alex@gmail.com', '111.111.111-11', '(16)99123-4567', '123');
INSERT INTO tb_user (nome_completo, email, cpf, telefone, senha) VALUES ('Maria Green', 'maria@gmail.com', '222.222.222-22', '(17)98147-8523', '123');

INSERT INTO tb_role (authority) VALUES ('ROLE_PROVIDER');
INSERT INTO tb_role (authority) VALUES ('ROLE_CUSTOMER');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);
