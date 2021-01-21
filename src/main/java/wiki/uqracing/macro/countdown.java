package wiki.uqracing.macro;

import com.atlassian.confluence.content.render.xhtml.ConversionContext;
import com.atlassian.confluence.macro.Macro;
import com.atlassian.confluence.macro.MacroExecutionException;

import java.util.Map;
import java.time.LocalDateTime;
import java.lang.Integer;
import java.time.temporal.ChronoUnit;

public class countdown implements Macro {

    public String execute(Map<String, String> map, String s, ConversionContext ConversionContext) throws MacroExecutionException {
        LocalDateTime targetDate = LocalDateTime.of(
            Integer.parseInt(map.get("Year")),
            Integer.parseInt(map.get("Month")),
            Integer.parseInt(map.get("Day")), 0, 0
        );

        String event;
        if (map.get("Event") != null) {
            event = map.get("Event");
        } else  {
            event = "";
        }

        if (LocalDateTime.now().isAfter(targetDate)) {
            return ("0 days until " + event);
        }
        
        long daysBetween = ChronoUnit.DAYS.between(LocalDateTime.now(), targetDate) + 1;

        if (daysBetween == 1) {
            return ("1 day until " + event);
        } else  {
            return (String.valueOf(daysBetween) + " days until " + event);
        }
    }

    public BodyType getBodyType() { return BodyType.NONE; }

    public OutputType getOutputType() { return OutputType.BLOCK; }
}