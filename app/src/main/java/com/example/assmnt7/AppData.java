package com.example.assmnt7;

public class AppData {
    public String data;
    public String id;
    public String NAME;
    public String course;
    public String section;
    public String midterm;
    public String finals;
    public AppData()
    {
        this.data = "";
        this.id = "";
        this.NAME = "";
        this.course = "";
        this.section = "";
        this.midterm = "";
        this.finals = "";
    }
    public String getData() {
        return data; }
    public void setData(String id, String FNAME, String course, String section, String midterm, String finals)
    {
        StringBuffer tempData = new StringBuffer(this.data);
        tempData.append("ID: " + id + "\nName: " + FNAME + "\nCourse:" + course +"\nSection: "+ section +" \nMidterm: " + midterm + "\n Finals: " + finals + "\n \n");
        this.data = tempData.toString();
    }

    public void setId(String id)
    {

        this.id = id;
    }
    public void setNAME(String NAME)
    {

        this.NAME = NAME;
    }
    public void setCourse(String course)
    {

        this.course = course;
    }
    public void setSection(String section)
    {

        this.section = section;
    }
    public void setMidterm(String midterm)
    {

        this.midterm = midterm;
    }
    public void setFinals(String finals)
    {

        this.finals = finals;
    }
    public String getId()
    {

        return id;
    }
    public String getFNAME()
    {

        return NAME;
    }
    public String getCourse()
    {

        return course;
    }
    public String getSection()
    {

        return section;
    }
    public String getMidterm()
    {

        return midterm;
    }
    public String getFinals()
    {

        return finals;
    }
}
