package model;

public class Person {
    private Long personID;
    private String nachname;
    private String vorname;

    /**
     * wir erstellen ein neues Obj von Typ "Person"
     * @param personID
     * @param nachname
     * @param vorname
     */

    public Person(Long personID, String nachname, String vorname){
        this.vorname = vorname;
        this.nachname= nachname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public Long getPersonID() {
        return personID;
    }

    public void setPersonID(Long personID) {
        this.personID = personID;
    }

    @Override
    public String toString() {
        return "Person{" +
                "personID=" + personID +
                ", nachname='" + nachname + '\'' +
                ", vorname='" + vorname + '\'' +
                '}';
    }
}
