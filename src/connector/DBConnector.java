package connector;

import java.sql.Connection;

public interface DBConnector {
    // 메소드의 선언만 들어간다.
    // 생성자도 못만들어준다.
    // 추상 클래스

    public Connection makeConnection();

}
