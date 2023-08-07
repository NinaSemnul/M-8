import java.io.IOException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/time")
public class TimeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");
        String time = "";

        String timeZone = "UTC";
        String task = "Current time (UTC): ";

        if (req.getParameterMap().containsKey("timezone")) {
            timeZone = req.getParameter("timezone").replace(" ", "+");
            task = "Current time in time zone " + timeZone + ": ";
        }

        time = ZonedDateTime.now(ZoneId.of(timeZone)).format(DateTimeFormatter.ofPattern("yyyy-dd-MM HH:mm:ss"))
                + " " + timeZone;


        resp.getWriter().write(task + time);
        resp.getWriter().close();
    }
}


