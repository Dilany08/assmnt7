package com.example.assmnt7;

public class AppData {
    public String data;
    public String id;
    public String fName;
    public String course;
    public String section;
    public String midterm;
    public String finals;
    public AppData()
    {
        this.data = "";
        this.id = "";
        this.fName = "";
        this.course = "";
        this.section = "";
        this.midterm = "";
        this.finals = "";
    }
    public String getData() {
        return data; }
    public void setData(String _id, String fName, String course, String section, String midterm, String finals)
    {
        StringBuffer tempData = new StringBuffer(this.data);
        tempData.append("ID:Name:Course:Section:Midterm:Finals" + _id + ":" + fName  + ":" + course  +
                ":" + section + ":" + midterm + ":" + finals + "\n");
        this.data = tempData.toString();
    }

    public void setId(String _id)
    {

        this.id = id;
    }
    public void setfName(String fName)
    {

        this.fName = fName;
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
    public String getfName()
    {

        return fName;
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
