package com.example.assmnt7;

public class AppData {
    public String data;
    public String id;
    public String FNAME;
    public String course;
    public String section;
    public String midterm;
    public String finals;
    public String fgrade;
    public AppData()
    {
        this.data = "";
        this.id = "";
        this.FNAME = "";
        this.course = "";
        this.section = "";
        this.midterm = "";
        this.finals = "";
        this.fgrade = "";
    }
    public String getData() {
        return data; }
    public void setData(String id, String FNAME, String course, String section, String midterm, String finals, String fgrade)
    {
        StringBuffer tempData = new StringBuffer(this.data);
        tempData.append("ID: " + id + "\nName: " + FNAME + "\nCourse:" + course +"\nSection: "+ section +" \nMidterm: " + midterm + "\n Finals: " + finals +"\nGrade: " + fgrade + "\n \n");
        this.data = tempData.toString();
    }

    public void setId(String id)
    {

        this.id = id;
    }
    public void setFNAME(String FNAME)
    {

        this.FNAME = FNAME;
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
    public void setFgrade(String fgrade)
    {
        this.fgrade = fgrade;
    }


    public String getId()
    {

        return id;
    }
    public String getNAME()
    {

        return FNAME;
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

    public String getFgrade()
    {
        return fgrade;
    }

}
