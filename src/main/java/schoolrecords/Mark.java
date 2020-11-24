package schoolrecords;
public class Mark {
    private MarkType markType;
    private Subject subject;
    private Tutor tutor;

    public Mark(MarkType markType, Subject subject, Tutor tutor) {
        try {
            if (isEmpty(subject.getSubjectName()) || isEmpty(tutor.getName())) {
                throw new NullPointerException("Both subject and tutor must be provided!");
            }
            this.subject = subject;
            this.tutor = tutor;
        } catch (NullPointerException npe){
            throw new NullPointerException("Both subject and tutor must be provided!");
        }
        this.markType = markType;
    }

    private boolean isEmpty(String str){
        return (str == null || "".equals(str.trim()));
    }

    public Mark(String markType, Subject subject, Tutor tutor) {
        this.markType = MarkType.valueOf(markType);
        this.subject = subject;
        this.tutor = tutor;
    }

    @Override
    public String toString() {
        return String.format("%s(%d)", markType.getDescription(), markType.getValue());
    }

    public MarkType getMarkType() {
        return markType;
    }
    public Subject getSubject() {
        return subject;
    }
    public Tutor getTutor() {
        return tutor;
    }
}
