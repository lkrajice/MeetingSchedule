package white_team.purkynova.com.meetingschedule.Event;

import android.content.Context;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.lang.String;
import java.util.Date;

import white_team.purkynova.com.meetingschedule.Model.EventTypeHelper;

/**
 * Class represents one Event
 *
 * @author Pavel Balusek
 * @author Lukáš Krajíček
 */
public class Event {
    private final Context context;

    private final int id;
    private final String name;
    private final String place;
    private final String description;
    private final String guarantor;
    private final String materialLink;
    private final Date since;
    private final Date till;
    private final int eventType;


    public Event(Context context, int id, String name, String since, String till, String eventType,
                 String description, String place, String guarantor, String materialLink) throws ParseException {
        this.id = id;
        this.name = name;
        this.place = place;
        this.description = description;
        this.guarantor = guarantor;
        this.eventType = EventTypeHelper.stringToInt(eventType);
        this.materialLink = materialLink;

        this.since = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm").parse(since);
        this.till = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm").parse(till);

        this.context = context;
    }

    /**
     * Check if event's type is lecture
     *
     * @return true if event's type is lecture, false otherwise
     */
    public Boolean isLecture() {
        return this.eventType == EventTypeHelper.TYPE_LECTURE_INDEX;
    }

    /**
     * Return time span of the event
     *
     * @return time span of the event in String
     */
    public String getTimeSpan() {
        DateFormat dateFormat = android.text.format.DateFormat.getTimeFormat(context);

        return dateFormat.format(this.since) + " - " + dateFormat.format(this.till);
    }

    /**
     * Get event type in String format
     *
     * @return event's type
     */
    public String getType() {
        return EventTypeHelper.intToString(this.eventType);
    }

    /**
     * Returns guaranter
     *
     * @return lecturer's name
     */
    public String getGuarantor() {
        return this.guarantor;
    }

    /**
     * Returns place of the event
     */
    public String getPlace(){
        return this.place;
    }

    /**
     * Returns description of the event
     */
    public String getDescription() {
        return this.description;
    }

	/**
	 * Return the name of event
	 */
	public String getName() {
		return this.name;
	}

    /**
     * Returns id
     */
	public int getId() {
	    return this.id;
    }

    public String getMaterialLink() {
	    return this.materialLink;
    }
}
