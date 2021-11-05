package com.face.entity;

public class DignoseDetail {
    private String ddId;
    private int collId;
    private int collRow;
    private String collArea;
    private String frontFileName;
    private String front1FileName;
    private String front2FileName;
    private String front3FileName;
    private String front1Position;
    private String front2Position;
    private String front3Position;
    private String back1FileName;
    private String back2FileName;
    private String back3FileName;
    private String status;
    private String finishTime;

    public DignoseDetail() {
    }

    public String getDdId() {
        return ddId;
    }

    public int getCollId() {
        return collId;
    }

    public int getCollRow() {
        return collRow;
    }

    public String getCollArea() {
        return collArea;
    }

    public String getFrontFileName() {
        return frontFileName;
    }

    public String getFront1FileName() {
        return front1FileName;
    }

    public String getFront2FileName() {
        return front2FileName;
    }

    public String getFront3FileName() {
        return front3FileName;
    }

    public String getFront1Position() {
        return front1Position;
    }

    public String getFront2Position() {
        return front2Position;
    }

    public String getFront3Position() {
        return front3Position;
    }

    public String getBack1FileName() {
        return back1FileName;
    }

    public String getBack2FileName() {
        return back2FileName;
    }

    public String getBack3FileName() {
        return back3FileName;
    }

    public String getStatus() {
        return status;
    }

    public String getFinishTime() {
        return finishTime;
    }

    public DignoseDetail(String ddId, int collId, int collRow, String collArea, String frontFileName, String front1FileName, String front2FileName, String front3FileName, String front1Position, String front2Position, String front3Position, String back1FileName, String back2FileName, String back3FileName, String status, String finishTime) {
        this.ddId = ddId;
        this.collId = collId;
        this.collRow = collRow;
        this.collArea = collArea;
        this.frontFileName = frontFileName;
        this.front1FileName = front1FileName;
        this.front2FileName = front2FileName;
        this.front3FileName = front3FileName;
        this.front1Position = front1Position;
        this.front2Position = front2Position;
        this.front3Position = front3Position;
        this.back1FileName = back1FileName;
        this.back2FileName = back2FileName;
        this.back3FileName = back3FileName;
        this.status = status;
        this.finishTime = finishTime;
    }
}
