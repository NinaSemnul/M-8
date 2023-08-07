import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;
import java.util.TimeZone;

@WebFilter(value = "/time?timezone")
public class TimezoneValidateFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req,
                            HttpServletResponse resp,
                            FilterChain chain) throws IOException, ServletException {

        String timeZoneParam = req.getParameter("timezone");
        if (isTimezoneTrue(timeZoneParam)) {
            chain.doFilter(req, resp);
        } else {
            resp.setStatus(400);
            resp.setContentType("application/json");
            resp.getWriter().write("Error in getting the current time in the time zone: " + timeZoneParam);
            resp.getWriter().close();
        }
    }

    private boolean isTimezoneTrue(String timezone) {
        return !Objects.equals(TimeZone.getTimeZone(timezone), "GMT");
    }
}

