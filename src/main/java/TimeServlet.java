import java.io.IOException;
import java.time.LocalDateTime;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/time")

    public class TimeServlet extends HttpServlet {

    LocalDateTime time = LocalDateTime.now();
        @Override
        protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            resp.setContentType("text/html; charset=utf-8");
            resp.getWriter().write(String.valueOf(time));
            resp.getWriter().close();
        }
    }
