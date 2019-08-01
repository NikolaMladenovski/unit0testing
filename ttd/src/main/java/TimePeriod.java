import java.sql.Time;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TimePeriod {

    private Date start;
    private Date end;

    public boolean overlapsWith(TimePeriod period) {
        // testAcontainsB()
        if ((this.start.before(period.start))
                && (this.end.after(period.end))) {
            return true;
        }
        // testBcontainsA()

        if ((this.start.after(period.start))
                && (this.end.before(period.end))) {
            return true;
        }
        // testBinteractA()
        if ((this.start.after(period.start))
                && (this.end.after(period.end))
                && (this.BinteractA(period))) {
            return true;
        }
        // testAinteractB()
        if ((this.start.before(period.start))
                && (this.end.before(period.end))
                && (this.AinteractB(period))) {
            return true;
        }
        // testAequalsB()
        if ((this.start.equals(period.start))
                && (this.end.equals(period.end))) {
            return true;
        }
        // testAendEqualToBstart()
        if (this.end.equals(period.start)) {
            return true;
        }

        return false;
    }

    public boolean BinteractA(TimePeriod period) {
        if (this.start.after(period.start) && this.start.before(period.end)) {
            return true;
        }
        return false;
    }

    public boolean AinteractB(TimePeriod period) {
        if (this.start.before(period.start) && this.end.after(period.start)) {
            return true;
        }
        return false;
    }

}
