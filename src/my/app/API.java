package my.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

// Essa classe realiza toda a conexão com o PostgreSQL
public class API {

    private final String driver = "jdbc:postgresql://localhost:5432/";
    private String usuario;
    private String bd;
    private String senha;

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setBd(String bd) {
        this.bd = bd;
    }

    // Faz a validação do login com uma conexão ao PostgreSQL
    public boolean validarLogin() {
        try ( Connection conn = DriverManager.getConnection(driver + bd, usuario, senha)) {
            if (conn != null) {
                System.out.println("Connected to the database!");
                conn.close();
                return true;
            } else {
                System.out.println("Failed to make connection!");
                return false;
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s\n\n", e.getSQLState(), e.getMessage());
            return false;
        }
    }

    // Cria a tabela "materias" caso ela não exista
    public void criarTabela() {
        try ( Connection conn = DriverManager.getConnection(driver + bd, usuario, senha)) {
            if (conn != null) {
                System.out.println("Connected to the database!");
                String SQLCriarTabela;
                SQLCriarTabela = """
                                CREATE TABLE IF NOT EXISTS materias (
                                    id serial NOT NULL,
                                    nome varchar(100) NOT NULL,
                                    codigo varchar(7) NOT NULL,
                                    av1 varchar(4) NOT NULL,
                                    ava1 varchar(4) NOT NULL,
                                    av2 varchar(4) NOT NULL,
                                    ava2 varchar(4) NOT NULL,
                                    nf varchar(4) NOT NULL,
                                    CONSTRAINT materias_pkey PRIMARY KEY (id),
                                    CONSTRAINT "materias_codigo_key" UNIQUE (codigo),
                                    CONSTRAINT materias_nome_key UNIQUE (nome)
                                );
                                 """;
                Statement st = conn.createStatement();
                st.executeUpdate(SQLCriarTabela);
            } else {
                System.out.println("Failed to make connection!");
            }

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
    }

    // Pega os dados da tabela e envia para o Front-end
    public Object lerTabela() {
        List<Object[]> objList = new ArrayList<>();
        try ( Connection conn = DriverManager.getConnection(driver + bd, usuario, senha)) {
            if (conn != null) {
                System.out.println("Connected to the database!");
                String SQLLerDados = "SELECT * FROM materias";
                Statement st = conn.createStatement();
                ResultSet result = st.executeQuery(SQLLerDados);
                while (result.next()) {
                    Object obj2[] = {result.getInt(1), result.getString(2), result.getString(3),
                        result.getString(4), result.getString(5), result.getString(6),
                        result.getString(7), result.getString(8)};
                    objList.add(obj2);
                }
                Object[][] obj = new Object[objList.size()][];
                objList.toArray(obj);
                return obj;
            } else {
                System.out.println("Failed to make connection!");
                Object[] obj = {};
                return obj;
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
            Object[] obj = {};
            return obj;
        }
    }

    // Recebe um Object com as informações de uma matéria e adiciona à tabela
    public void adicionarMateria(Object[] obj) {
        try ( Connection conn = DriverManager.getConnection(driver + bd, usuario, senha)) {
            if (conn != null) {
                System.out.println("Connected to the database!");
                String SQLInserirDados;
                SQLInserirDados = "INSERT INTO materias (nome,codigo,av1,ava1,av2,ava2,nf) VALUES ('"
                        + obj[0].toString() + "','" + obj[1].toString() + "','" + obj[2].toString() + "','" + obj[3].toString()
                        + "','" + obj[4].toString() + "','" + obj[5].toString() + "','" + obj[6].toString() + "');";
                System.out.print(SQLInserirDados);
                Statement st = conn.createStatement();
                st.executeUpdate(SQLInserirDados);
                System.out.println("Inserted to the database!");
            } else {
                System.out.println("Failed to make connection!");
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
    }

    // Atualiza uma nota por vez
    public void atualizarNota(String id, String av, String nota) {
        try ( Connection conn = DriverManager.getConnection(driver + bd, usuario, senha)) {
            if (conn != null) {
                System.out.println("Connected to the database!");
                String SQLAtualizarDados = "UPDATE materias SET " + av + " = '" + nota + "' WHERE ID = " + id + ";";
                Statement st = conn.createStatement();
                st.executeUpdate(SQLAtualizarDados);
                System.out.println("Inserted to the database!");
            } else {
                System.out.println("Failed to make connection!");
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
    }

    // Calcula o Coeficiente de Rendimento
    public double calcularCR() {
        double cr = 0.0;
        double soma = 0, horas = 0;
        try ( Connection conn = DriverManager.getConnection(driver + bd, usuario, senha)) {
            if (conn != null) {
                System.out.println("Connected to the database!");
                String SQLLerDados = "SELECT * FROM materias";
                Statement st = conn.createStatement();
                ResultSet result = st.executeQuery(SQLLerDados);
                while (result.next()) {
                    String str = result.getString(8).replace(",", ".");
                    soma += Double.parseDouble(str) * 80;
                    horas += 80;
                }
                cr = soma / horas;
                System.out.println(cr);
                return cr;
            } else {
                System.out.println("Failed to make connection!");
                return cr;
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
            return cr;
        }
    }

    // Deleta a tabela
    public void deletarTabela() {
        try ( Connection conn = DriverManager.getConnection(driver + bd, usuario, senha)) {
            if (conn != null) {
                System.out.println("Connected to the database!");
                String SQLDeletarDados = "DROP TABLE materias;";
                Statement st = conn.createStatement();
                st.executeUpdate(SQLDeletarDados);
            } else {
                System.out.println("Failed to make connection!");
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
    }
}
