package main.java.com.example.lineshift;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        port(getHerokuAssignedPort());

        post("/callback", (req, res) -> {
            String body = req.body();
            System.out.println("LINE Webhook: " + body);
            return "OK";
        });
    }

    static int getHerokuAssignedPort() {
        String port = System.getenv("PORT");
        if (port != null) {
            return Integer.parseInt(port);
        }
        return 4567; // ローカル用
    }
}
