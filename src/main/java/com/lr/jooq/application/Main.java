package com.lr.jooq.application;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;


import com.lr.jooq.generated.pojo.Author;
import org.jooq.DSLContext;

import org.jooq.SQLDialect;




import static com.lr.jooq.generated.tables.Author.AUTHOR;
import static org.jooq.impl.DSL.using;

/**
 * @author liurui
 * @date 2020/3/26 3:45 下午
 */

public class Main {
    public static void main(String[] args) throws SQLException {
        // 用户名
        String userName = "root";
        // 密码
        String password = "root";
        // mysql连接url
        String url = "jdbc:mysql://localhost:3306/library?useUnicode=true&characterEncoding=UTF-8";

        // Connection is the only JDBC resource that we need
        // PreparedStatement and ResultSet are handled by jOOQ, internally
        Connection conn = null;
        try  {
            conn = DriverManager.getConnection(url, userName, password);
            DSLContext create = using(conn, SQLDialect.MYSQL);
            List<Author> authorList = create.selectFrom(AUTHOR).where(AUTHOR.ID.eq(1)).fetchInto(Author.class);

            authorList.forEach(System.out::println);
        }
        // For the sake of this tutorial, let's keep exception handling simple
        catch (Exception e) {
            assert conn != null;
            conn.close();
            e.printStackTrace();
        }
    }
}