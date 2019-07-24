package server.reaptheflag.reaptheflag.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Player {
    @NotNull
    private String id;
    private int score;
    @NotNull
    private String name;
    @Size(min = 1)
    private String password;
    private String currentDate;

    public String getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(String currentDate) {
        this.currentDate = currentDate;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
