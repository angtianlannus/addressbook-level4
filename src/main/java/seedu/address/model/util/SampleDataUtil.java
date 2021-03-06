package seedu.address.model.util;

import java.util.HashSet;
import java.util.Set;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.AddressBook;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.lecturer.Lecturer;
import seedu.address.model.module.ClassType;
import seedu.address.model.module.Code;
import seedu.address.model.module.Group;
import seedu.address.model.module.Lesson;
import seedu.address.model.module.Location;
import seedu.address.model.module.TimeSlot;
import seedu.address.model.module.exceptions.DuplicateLessonException;

//@@author caoliangnus
/**
 * Contains utility methods for populating {@code AddressBook} with sample data.
 */
public class SampleDataUtil {
    public static Lesson[] getSampleLessons() {
        try {
            return new Lesson[]{
                new Lesson(new ClassType("LEC"), new Location("LT19"), new Group("1"),
                        new TimeSlot("FRI[1400-1600]"), new Code("CS2103T"), getLecturerSet("Damith")),
                new Lesson(new ClassType("TUT"), new Location("COM1-0207"), new Group("1"),
                        new TimeSlot("TUE[1000-1100]"), new Code("CS2103"), getLecturerSet("David")),
                new Lesson(new ClassType("LEC"), new Location("LT27"), new Group("1"),
                        new TimeSlot("WED[1200-1400]"), new Code("MA1101R"), getLecturerSet("Ma Siu Lun")),
                new Lesson(new ClassType("TUT"), new Location("LT27"), new Group("1"),
                        new TimeSlot("MON[0900-1000]"), new Code("MA1101A"), getLecturerSet("LI Sheng")),
                new Lesson(new ClassType("TUT"), new Location("LT27"), new Group("2"),
                        new TimeSlot("MON[1000-1100]"), new Code("MA1101B"), getLecturerSet("LI Sheng")),
                new Lesson(new ClassType("LEC"), new Location("LT27"), new Group("2"),
                        new TimeSlot("THU[1600-1800]"), new Code("MA1101C"), getLecturerSet("Smith")),

                new Lesson(new ClassType("LEC"), new Location("LT19"), new Group("71"),
                        new TimeSlot("WED[1400-1600]"), new Code("CS2103T"), getLecturerSet("Damith")),
                new Lesson(new ClassType("TUT"), new Location("COM1-0207"), new Group("71"),
                        new TimeSlot("TUE[1200-1300]"), new Code("CS2103"), getLecturerSet("David")),
                new Lesson(new ClassType("LEC"), new Location("LT27"), new Group("71"),
                        new TimeSlot("WED[1800-2000]"), new Code("MA1101R"), getLecturerSet("Ma Siu Lun")),
                new Lesson(new ClassType("TUT"), new Location("COM1-02-3"), new Group("71"),
                        new TimeSlot("MON[0800-0900]"), new Code("MA1101A"), getLecturerSet("LI Sheng")),
                new Lesson(new ClassType("TUT"), new Location("LT27"), new Group("72"),
                        new TimeSlot("MON[0800-0900]"), new Code("MA1101B"), getLecturerSet("LI Sheng")),
                new Lesson(new ClassType("LEC"), new Location("LT37"), new Group("72"),
                        new TimeSlot("THU[1600-1800]"), new Code("MA1101C"), getLecturerSet("Smith")),

                new Lesson(new ClassType("LEC"), new Location("LT19"), new Group("51"),
                        new TimeSlot("MON[1400-1600]"), new Code("CS2103T"), getLecturerSet("Damith")),
                new Lesson(new ClassType("TUT"), new Location("COM1-0207"), new Group("51"),
                        new TimeSlot("WED[1200-1300]"), new Code("CS2103"), getLecturerSet("David")),
                new Lesson(new ClassType("LEC"), new Location("LT27"), new Group("51"),
                        new TimeSlot("FRI[1800-2000]"), new Code("MA1101R"), getLecturerSet("Ma Siu Lun")),
                new Lesson(new ClassType("TUT"), new Location("COM1-02-3"), new Group("51"),
                        new TimeSlot("THU[0800-0900]"), new Code("MA1101A"), getLecturerSet("LI Sheng")),
                new Lesson(new ClassType("LEC"), new Location("LT27"), new Group("42"),
                        new TimeSlot("FRI[1000-1200]"), new Code("MA1101B"), getLecturerSet("LI Sheng")),
                new Lesson(new ClassType("LEC"), new Location("LT37"), new Group("22"),
                        new TimeSlot("FRI[1600-1800]"), new Code("MA1101C"), getLecturerSet("Smith")),

                new Lesson(new ClassType("LEC"), new Location("LT19"), new Group("11"),
                        new TimeSlot("MON[0800-1000]"), new Code("CS2103T"), getLecturerSet("Damith")),
                new Lesson(new ClassType("LEC"), new Location("LT33"), new Group("11"),
                        new TimeSlot("WED[1200-1400]"), new Code("CS2103"), getLecturerSet("David")),
                new Lesson(new ClassType("TUT"), new Location("LT27"), new Group("11"),
                        new TimeSlot("TUE[0900-1000]"), new Code("MA1101R"), getLecturerSet("Ma Siu Lun")),
                new Lesson(new ClassType("TUT"), new Location("COM1-02-3"), new Group("11"),
                        new TimeSlot("THU[1800-1900]"), new Code("MA1101A"), getLecturerSet("LI Sheng")),
                new Lesson(new ClassType("LEC"), new Location("LT17"), new Group("32"),
                        new TimeSlot("TUE[0800-1000]"), new Code("MA1101B"), getLecturerSet("LI Sheng")),
                new Lesson(new ClassType("LEC"), new Location("LT37"), new Group("12"),
                        new TimeSlot("TUE[1000-1200]"), new Code("MA1101C"), getLecturerSet("Smith")),

            };
        } catch (IllegalValueException e) {
            throw new AssertionError("sample data cannot be invalid", e);
        }
    }

    public static ReadOnlyAddressBook getSampleAddressBook() {
        try {
            AddressBook sampleAb = new AddressBook();
            for (Lesson sampleLesson : getSampleLessons()) {

                sampleAb.addLesson(sampleLesson);
            }
            return sampleAb;
        } catch (DuplicateLessonException e) {
            throw new AssertionError("sample data cannot contain duplicate lessons", e);
        }
    }

    /**
     * Returns a lecturer set containing the list of strings given.
     */
    public static Set<Lecturer> getLecturerSet(String... strings) throws IllegalValueException {
        HashSet<Lecturer> lecturers = new HashSet<>();
        for (String s : strings) {
            lecturers.add(new Lecturer(s));
        }

        return lecturers;
    }

}
