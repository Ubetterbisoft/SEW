public enum Gegenstand {
    AM("Angewandte Mathematik"),
    E1("Englisch"),
    D("Deutsch"),
    SYT("Systemtechnik");

    private String desc;
    private Gegenstand(String desc){
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
